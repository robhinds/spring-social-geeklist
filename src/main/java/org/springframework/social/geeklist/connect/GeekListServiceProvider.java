package org.springframework.social.geeklist.connect;

import org.springframework.social.geeklist.api.GeekList;
import org.springframework.social.geeklist.api.impl.GeekListTemplate;
import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.oauth1.OAuth1Template;

/**
 * GeekList Service Provider implementation (based on OAuth1)
 * 
 * @author robert.hinds
 * 
 */
public class GeekListServiceProvider extends AbstractOAuth1ServiceProvider<GeekList> {

	public GeekListServiceProvider(String consumerKey, String consumerSecret) {
		super(consumerKey, consumerSecret, new OAuth1Template(consumerKey, consumerSecret, "http://sandbox-api.geekli.st/v1/oauth/request_token", "http://sandbox.geekli.st/oauth/authorize",
				"http://sandbox-api.geekli.st/v1/oauth/access_token"));
	}

	@Override
	public GeekList getApi(String accessToken, String secret) {
		return new GeekListTemplate(getConsumerKey(), getConsumerSecret(), accessToken, secret);
	}
}
