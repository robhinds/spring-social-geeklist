package org.springframework.social.geeklist.api.impl;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.RequestMatchers.method;
import static org.springframework.test.web.client.RequestMatchers.requestTo;
import static org.springframework.test.web.client.ResponseCreators.withResponse;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.geeklist.api.GeekListUser;
import org.springframework.test.web.client.MockRestServiceServer;

public class UserTemplateTest {

	private final String userString = "{\"status\": \"ok\",\"data\": {\"id\": \"a271659310088dc1a09fe0af9ddf6dd2d1987ddb99d2ca23af50a7fae55256d9\",\"name\": \"Jacob Chapel\",\"screen_name\": \"chapel\",\"avatar\": {\"small\": \"http://a1.twimg.com/profile_images/1340947562/me_badass_ava_normal.png\",\"large\": \"http://a1.twimg.com/profile_images/1340947562/me_badass_ava.png\"},\"blog_link\": \"http://lepahc.com\",\"company\": {\"title\": \"\",\"name\": \"Freelancer\"},\"location\": \"Spokane, WA\",\"bio\": \"Javascript and Node.js Evangelist\",\"social_links\": [\"http://twitter.com/jacobchapel\",\"http://lepahc.com\"],\"social\": {\"twitter_screen_name\": \"jacobchapel\",\"twitter_friends_count\": 82,\"twitter_followers_count\": 164},\"criteria\": {\"looking_for\": [\"interesting ideas\",\"fun times\"],\"available_for\": [\"node.js development\",\"front-end javascript\",\"unique ideas\",\"constructive critique\"]},\"stats\": {\"number_of_contributions\": 6,\"number_of_highfives\": 29,\"number_of_mentions\": 0,\"number_of_cards\": 3},\"is_beta\": true,\"created_at\": \"2011-09-14T02:08:42.978Z\",\"updated_at\": \"2011-12-17T00:45:37.833Z\",\"active_at\": \"2011-10-27T05:48:36.409Z\",\"trending_at\": \"2011-12-17T00:51:14.468Z\",\"trending_hist\": []}}";
	private final String cardString = "{\"status\": \"ok\",\"data\": {\"total_cards\": 1,\"cards\": [{author_id: \"a271659310088dc1a09fe0af9ddf6dd2d1987ddb99d2ca23af50a7fae55256d9\",created_at: \"2011-09-14T04:46:30.384Z\",happened_at: \"2011-09-06T00:00:00.000Z\",happened_at_type: \"custom\",headline: \"I placed 23rd out of >180 at Nodeknockout 2011\",is_active: true,permalink: \"/chapel/i-placed-23rd-out-of-180-at-nodeknockout-2011\",slug: \"i-placed-23rd-out-of-180-at-nodeknockout-2011\",tasks: [ ],updated_at: \"2011-11-28T23:05:42.180Z\",stats: {number_of_views: 55,views: 64,highfives: 3},short_code: {gklst_url: \"http://gkl.st/XuQdJ\",id: \"32002d0dea77d1e55dcdb17b93456b789f0726b659e2d605bd6047db6c046865\"},id: \"32002d0dea77d1e55dcdb17b93456b7807b3c1b0695e177228f4fa12f227119b\"}]}}";

	private GeekListTemplate geekList;
	private MockRestServiceServer mockServer;
	private HttpHeaders responseHeaders;

	@Before
	public void setup() {
		geekList = new GeekListTemplate("consumerKey", "consumerSecret", "accessToken", "accessTokenSecret");
		mockServer = MockRestServiceServer.createServer(geekList.getRestTemplate());
		responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
	}

	@Test
	public void testGetUser() throws Exception {
		mockServer.expect(requestTo("http://sandbox-api.geekli.st/v1/users/chapel")).andExpect(method(GET)).andRespond(withResponse(userString, responseHeaders));

		GeekListUser geek = geekList.userOperations().getUser("chapel");

		assertEquals("chapel", geek.getUserName());
		assertEquals("Javascript and Node.js Evangelist", geek.getBio());
		assertEquals("Jacob Chapel", geek.getDisplayName());
		assertEquals("Spokane, WA", geek.getLocation());
		assertEquals("a271659310088dc1a09fe0af9ddf6dd2d1987ddb99d2ca23af50a7fae55256d9", geek.getUserId());
		assertEquals("http://geekli.st/chapel", geek.getUserProfileUrl());
	}

}
