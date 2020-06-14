package com.project.urlshortner.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.validator.routines.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.urlshortner.dto.ShortUrlDTO;
import com.project.urlshortner.model.UrlShortner;
import com.project.urlshortner.service.UrlShortnerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

@RestController
public class ApiRestController {

	private UrlShortnerService urlShortnerService;
	Logger logger = LoggerFactory.getLogger(ApiRestController.class);

	@Autowired
	public ApiRestController(UrlShortnerService theUrlShortnerService) {
		urlShortnerService = theUrlShortnerService;
	}

	/**
	 * this method takes in long URL and converts into short URL, further storing it
	 * into persistent storage with IP address. Validates for null, empty or invalid
	 * URLs and allows only HTTP and HTTPS URL.
	 * 
	 * @param url The long URL sent in the body to be converted to short URL.
	 * @return The HttpStatus and short version of long URL.
	 */
	@PostMapping(value = "/urlShortner")
	@ApiOperation(value = "Generates a Short URL", notes = "An Api for URL shortner and to redirect to original URL")
	public ResponseEntity<String> getUrlShortened(
			@RequestBody @ApiParam(required = true, name = "LongURL", value = "A Long URL that need to be shortened ") ShortUrlDTO shortUrlDTO,
			HttpServletRequest request, BindingResult bindingResult) {
		String longURL = shortUrlDTO.getUrl();
		UrlValidator urlValidator = new UrlValidator(new String[] { "http", "https" });
		String ipAddress = request.getRemoteAddr();
		if (urlValidator.isValid(longURL)) {
			String shortUrl = urlShortnerService.getUrlShortened(longURL, ipAddress);
			return new ResponseEntity<>("http://localhost:8084/assessment/urlShortner/"+shortUrl, HttpStatus.OK);
		} else {
			logger.error("Inside method getURlShorted Error" + longURL);
			return new ResponseEntity<>("Invalid URL", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Implements forwarding of the short URLs to the original one.
	 * 
	 * @param shortenedUrl The short URL value which helps directing to original URL.
	 * @return The original URL.
	 * @throws Exception checks for null or empty short URL string passed.
	 */
	@GetMapping("urlShortner/{shortURLValue}")
	public String getOriginalUrl(@PathVariable String shortURLValue) throws Exception {
		List<UrlShortner> longURL = urlShortnerService.findByShortenedUrl(shortURLValue);
		logger.info("longURL" + longURL);
		return longURL.get(0).getOrginalUrl();
	}

	/**
	 * Helps to view what URL has been hit at what time and other statistics.
	 * 
	 * @return the JSON format URL details.
	 */
	@GetMapping("urlShortner/urlStatistics/{value}")
	public List<UrlShortner> getAllStatistics(@PathVariable String value) {
		return urlShortnerService.getAllStatistics(value);

	}

}