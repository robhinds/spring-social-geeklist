package org.springframework.social.geeklist.api.impl;

import org.springframework.social.geeklist.api.GeekList;
import org.springframework.social.geeklist.api.UserOperations;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.web.client.RestOperations;

public class GeekListTemplate extends AbstractOAuth1ApiBinding implements GeekList {

	private UserOperations userOperations;

	public GeekListTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
		super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		initSubApis();
	}

	public GeekListTemplate() {
		super();
		initSubApis();
	}

	private void initSubApis() {
		userOperations = new UserTemplate(getRestTemplate(), isAuthorized());
	}

	public UserOperations userOperations() {
		return userOperations;
	}

	public RestOperations restOperations() {
		return getRestTemplate();
	}

}
