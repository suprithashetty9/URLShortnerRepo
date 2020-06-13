package com.project.urlshortner.dto;

public class ShortUrlDTO {
	private String url;
	
	public ShortUrlDTO() {
		
	}
	public ShortUrlDTO(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ShortUrlDTO [url=" + url + "]";
	}

}
