package com.project.urlshortner.serviceimpl;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.hash.Hashing;
import com.project.urlshortner.dao.URLShortnerRepository;
import com.project.urlshortner.model.UrlShortner;
import com.project.urlshortner.service.UrlShortnerService;

@Service
public class UrlShortnerServiceImpl implements UrlShortnerService {

	private URLShortnerRepository shortnerRepository;
	Logger logger = LoggerFactory.getLogger(UrlShortnerServiceImpl.class);

	@Autowired
	public UrlShortnerServiceImpl(URLShortnerRepository theUrlShortnerDao) {
		this.shortnerRepository = theUrlShortnerDao;
	}

	@Override
	public String getUrlShortened(String longURL, String ipAddress) {
		if (longURL == null || longURL.isEmpty()) {
			logger.error("Empty or null long URL " + longURL);
			throw new NullPointerException();
		}	
		UrlShortner theUrlShortner = new UrlShortner();
		String urlType = Hashing.murmur3_32().hashString(longURL, StandardCharsets.UTF_8).toString();
		theUrlShortner.setShortUrl(urlType);
		theUrlShortner.setOrginalUrl(longURL);
		theUrlShortner.setLastHit(Calendar.getInstance());
		theUrlShortner.setIpAddress(ipAddress);
		theUrlShortner.setCreatedBy(1);
		theUrlShortner.setCreatedDate(Calendar.getInstance());
		shortnerRepository.save(theUrlShortner);
		return urlType;
	}

	@Override
	public List<UrlShortner> findByShortenedUrl(String shortURLValue) throws Exception {
		if (shortURLValue == null || shortURLValue.isEmpty()) {
			logger.error("Empty or null long URL " + shortURLValue);
			throw new EntityNotFoundException("Value is null");
		}
		return shortnerRepository.findFirstByshortUrl(shortURLValue);
	}

	@Override
	public List<UrlShortner> getAllStatistics(String value) {
		return shortnerRepository.findByshortUrl(value);

	}
}
