package com.bvancleave.hearthstone.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.bvancleave.hearthstone.interceptors.XUserAgentInterceptor;

@Configuration
public class MyWebAppConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
		restTemplate.setInterceptors(Collections.singletonList(new XUserAgentInterceptor()));
		return restTemplate;
	}

	private ClientHttpRequestFactory clientHttpRequestFactory() {
	    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
	    factory.setReadTimeout(2000);
	    factory.setConnectTimeout(2000);
	    return factory;
	} 
	
	
}
