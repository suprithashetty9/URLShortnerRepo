package com.project.urlshortner.service;

import java.util.List;

import com.project.urlshortner.model.UrlShortner;

public interface UrlShortnerService {
	public String getUrlShortened(String longURL, String ipAddress);
	
	public List<UrlShortner> findByshortenedUrl(String shortenedUrl) throws Exception;

	public List<UrlShortner> getAllStatistics(String value);

}
