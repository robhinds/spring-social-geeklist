package org.springframework.social.geeklist.api.impl;

import org.junit.Before;
import org.springframework.test.web.client.MockRestServiceServer;

public class BaseTemplateTest {

	protected GeekListTemplate geekList;
	protected MockRestServiceServer mockServer;

	public BaseTemplateTest() {
		super();
	}

	@Before
	public void setUp() {
		geekList = new GeekListTemplate("consumerKey", "consumerSecret", "accessToken", "accessTokenSecret");
		mockServer = MockRestServiceServer.createServer(geekList.getRestTemplate());
	}

}