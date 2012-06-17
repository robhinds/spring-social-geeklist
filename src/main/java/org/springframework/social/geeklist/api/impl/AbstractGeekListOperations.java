package org.springframework.social.geeklist.api.impl;


/**
 * Based on {@link AbstractTwitterOperations}
 * 
 * @author robert.hinds
 * 
 */
public class AbstractGeekListOperations {

	protected final boolean authorized;

	private static final String BASE_API_URL = "http://sandbox-api.geekli.st/v1";

	public AbstractGeekListOperations(boolean authorized) {
		this.authorized = authorized;
	}

	protected String buildUrl(String string) {
		return BASE_API_URL + string;
	}
}