package com.project.urlshortner.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.urlshortner.model.UrlShortner;

public interface URLShortnerRepository extends JpaRepository<UrlShortner, Integer>{
   public List<UrlShortner> findFirstByshortUrl(String shortURLValue);
   public List<UrlShortner> findByshortUrl(String value);
   @Query(value = "SELECT *,count(*) as hit FROM url_directory.url_details c where c.short_url=:value", nativeQuery = true)
   public List<UrlShortner> countByshortUrl(String value);

}
