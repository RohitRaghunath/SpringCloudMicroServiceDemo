package com.rr;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest
class SpringCloudMicroService2ApplicationTests {
	
	@Autowired
	TestRestTemplate rest;

	@Test
	void contextLoads() {
		
		String deGreeting = this.rest.getForObject("/de", String.class);
		String enGreeting = this.rest.getForObject("/en", String.class);
		String esGreeting = this.rest.getForObject("/es", String.class);
		String defaultGreeting = this.rest.getForObject("/", String.class);
		assertEquals("Hallo", deGreeting);
		assertEquals("Hello", enGreeting);
		assertEquals("Hola", esGreeting);
		assertEquals("Hello", defaultGreeting);
	}

}
