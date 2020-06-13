package com.project.urlshortner.model;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "url_details")
public class UrlShortner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "orignal_url")
	private String orginalUrl;

	@Column(name = "short_url")
	private String shortUrl;

	@Column(name = "last_hit")
	private Calendar lastHit;

	@Column(name = "ip_address")
	private String ipAddress;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "created_date")
	private Calendar createdDate;

	public UrlShortner() {

	}

	public UrlShortner(String orginalUrl, String shortUrl, Calendar lastHit, String ipAddress, int createdBy,
			Calendar createdDate) {
		this.orginalUrl = orginalUrl;
		this.shortUrl = shortUrl;
		this.lastHit = lastHit;
		this.ipAddress = ipAddress;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrginalUrl() {
		return orginalUrl;
	}

	public void setOrginalUrl(String orginalUrl) {
		this.orginalUrl = orginalUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public Calendar getLastHit() {
		return lastHit;
	}

	public void setLastHit(Calendar lastHit) {
		this.lastHit = lastHit;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "UrlShortner [id=" + id + ", orginalUrl=" + orginalUrl + ", shortUrl=" + shortUrl + ", lastHit="
				+ lastHit + ", ipAddress=" + ipAddress + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ "]";
	}



}
