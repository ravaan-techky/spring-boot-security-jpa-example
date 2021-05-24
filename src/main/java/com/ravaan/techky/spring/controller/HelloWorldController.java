package com.ravaan.techky.spring.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

// TODO: Auto-generated Javadoc
/**
 * The Class HelloWorldController.
 */
@RestController("/")
public class HelloWorldController {

	/** The message source. */
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * Hello world.
	 *
	 * @return the string
	 */
	@GetMapping("hello")
	public String helloWorld() {
		return "Hello World";
	}
		
	/**
	 * Hello world internalization.
	 *
	 * @param locale the locale
	 * @return the string
	 */
	@GetMapping("hello-internalization")
	public String helloWorldInternalization(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("hello.message", null, locale);
	}
}
