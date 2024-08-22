//package com.oldbookstore.config;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//
//
//public class InterConfigInter implements WebMvcConfigurer {
//
//	@Autowired
//	AuthInterceptor auth;
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(auth).addPathPatterns("/pay/**", "/admin/**")
//				.excludePathPatterns("/assets/**");
//	}
//
//}
