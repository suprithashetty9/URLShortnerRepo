package com.project.urlshortner;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.project.urlshortner.serviceimpl.UrlShortnerServiceImpl;


@SpringBootTest
class UrlShortnerApplicationTests {

	private UrlShortnerServiceImpl impl;
	
	  @Test
	  public void testToCheckURlException() {
		  impl.getUrlShortened(null, "");

	  }

	  @Test
	  public void testToCheckShortUrlPassed() throws Exception {
		  impl.findByshortenedUrl(null);
		  System.out.println("in test");
	  }

}
