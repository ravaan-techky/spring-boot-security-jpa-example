package com.ravaan.techky.spring.config;

import java.util.Locale;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * The Class ResourceBundleConfiguration.
 */
@Configuration
public class ResourceBundleConfiguration {
	
	/**
	 * Gets the locale resolver.
	 *
	 * @return the locale resolver
	 */
	public LocaleResolver getLocaleResolver() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}
	
	/**
	 * Gets the resource bundle message source.
	 *
	 * @return the resource bundle message source
	 */
	public ResourceBundleMessageSource getResourceBundleMessageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("messages");
		return resourceBundleMessageSource;
	}
}
