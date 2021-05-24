package com.ravaan.techky.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravaan.techky.spring.dto.Name;
import com.ravaan.techky.spring.dto.UserVersion1;
import com.ravaan.techky.spring.dto.UserVersion2;

/**
 * The Class UserSecurityController.
 */
@RestController
public class UserSecurityController {

	/**
	 * Gets the URI user api version 1.
	 *
	 * @return the URI user api version 1
	 */
	@GetMapping("/user/api/v1.0")
	public UserVersion1 getURIUserApiVersion1() {
		return new UserVersion1("John Smith");
	}

	/**
	 * Gets the URI user api version 2.
	 *
	 * @return the URI user api version 2
	 */
	@GetMapping("/user/api/v2.0")
	public UserVersion2 getURIUserApiVersion2() {
		return new UserVersion2(new Name("John", "Smith"));
	}

	/**
	 * Gets the request param user api version 1.
	 *
	 * @return the request param user api version 1
	 */
	@GetMapping(value = "/user/param", params = { "version=1.0" })
	public UserVersion1 getRequestParamUserApiVersion1() {
		return new UserVersion1("John Smith");
	}

	/**
	 * Gets the request param user api version 2.
	 *
	 * @return the request param user api version 2
	 */
	@GetMapping(value = "/user/param", params = { "version=2.0" })
	public UserVersion2 getRequestParamUserApiVersion2() {
		return new UserVersion2(new Name("John", "Smith"));
	}

	/**
	 * Gets the header param user api version 1.
	 *
	 * @return the header param user api version 1
	 */
	@GetMapping(value = "/user/header", headers = { "X_API_VERSION=1.0" })
	public UserVersion1 getHeaderParamUserApiVersion1() {
		return new UserVersion1("John Smith");
	}

	/**
	 * Gets the header param user api version 2.
	 *
	 * @return the header param user api version 2
	 */
	@GetMapping(value = "/user/header", headers = { "X_API_VERSION=2.0" })
	public UserVersion2 getHeaderParamUserApiVersion2() {
		return new UserVersion2(new Name("John", "Smith"));
	}

	/**
	 * Gets the produces user api version 1.
	 *
	 * @return the produces user api version 1
	 */
	@GetMapping(value = "user/produces", produces = { "application/com.sanbhu.app_V1.0+json" })
	public UserVersion1 getProducesUserApiVersion1() {
		return new UserVersion1("John Smith");
	}

	/**
	 * Gets the produces user api version 2.
	 *
	 * @return the produces user api version 2
	 */
	@GetMapping(value = "user/produces", produces = { "application/com.sanbhu.app_V2.0+json" })
	public UserVersion2 getProducesUserApiVersion2() {
		return new UserVersion2(new Name("John", "Smith"));
	}
}
