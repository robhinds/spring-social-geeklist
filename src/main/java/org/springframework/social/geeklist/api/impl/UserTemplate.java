package org.springframework.social.geeklist.api.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.social.geeklist.api.GeekListCard;
import org.springframework.social.geeklist.api.GeekListCardWrapper;
import org.springframework.social.geeklist.api.GeekListUser;
import org.springframework.social.geeklist.api.GeekListUserWrapper;
import org.springframework.social.geeklist.api.UserOperations;
import org.springframework.web.client.RestTemplate;

public class UserTemplate extends AbstractGeekListOperations implements UserOperations {

	private final RestTemplate restTemplate;

	public UserTemplate(RestTemplate restTemplate, boolean isAuthorised) {
		super(isAuthorised);
		this.restTemplate = restTemplate;
	}

	public GeekListUser getAuthenticatedUser() {
		GeekListUserWrapper user = restTemplate.getForObject(buildUrl("/user"), GeekListUserWrapper.class);
		return user.getUser();
	}

	@Cacheable(value = "geekListUser")
	public GeekListUser getUser(String userName) {
		GeekListUserWrapper user = restTemplate.getForObject(buildUrl("/users/" + userName), GeekListUserWrapper.class);
		return user.getUser();
	}

	public List<GeekListCard> getAuthenticatedUserCards() {
		GeekListCardWrapper data = restTemplate.getForObject(buildUrl("/user/cards"), GeekListCardWrapper.class);
		return data.getCards();
	}

	@Cacheable(value = "geekListCards")
	public List<GeekListCard> getUserCards(String userName) {
		GeekListCardWrapper data = restTemplate.getForObject(buildUrl("/users/" + userName + "/cards"), GeekListCardWrapper.class);
		return data.getCards();
	}
}