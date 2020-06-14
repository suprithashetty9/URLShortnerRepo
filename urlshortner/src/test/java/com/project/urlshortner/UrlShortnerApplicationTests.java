package com.project.urlshortner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.project.urlshortner.dao.URLShortnerRepository;
import com.project.urlshortner.model.UrlShortner;
import com.project.urlshortner.serviceimpl.UrlShortnerServiceImpl;

@SpringBootTest
class UrlShortnerApplicationTests {

	private MockMvc mockMvc;
	
	private UrlShortnerServiceImpl impl;

	@MockBean
	private URLShortnerRepository repository;
	
//	@Test
//	public void testToCheckStatistics() throws Exception {
//		UrlShortner urlShortner = new UrlShortner("http://kodejava.org/how-do-i-persist-entity-to-database-in-jpa/", "d86677b5", Calendar.getInstance(), "12", 0, Calendar.getInstance());
//		when(repository.save(urlShortner).thenReturn(urlShortner);
//		assertEquals(urlShortner, impl.getUrlShortened("http://kodejava.org/how-do-i-persist-entity-to-database-in-jpa/", "12"));
//	}

}
