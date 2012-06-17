package org.springframework.social.geeklist.connect;

import org.springframework.social.connect.support.OAuth1ConnectionFactory;
import org.springframework.social.geeklist.api.GeekList;

/**
 * GeekList ConnectionFactory implementation
 * 
 * @author robert.hinds
 * 
 */
public class GeekListConnectionFactory extends OAuth1ConnectionFactory<GeekList> {

	public GeekListConnectionFactory(String clientId, String clientSecret) {
		super("geeklist", new GeekListServiceProvider(clientId, clientSecret), new GeekListAdapter());
	}

}