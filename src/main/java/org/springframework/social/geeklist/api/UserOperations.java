package org.springframework.social.geeklist.api;

import java.util.List;

public interface UserOperations {

	/**
	 * Get the user profile details for the current user (the authenticated
	 * user)
	 * 
	 * @return the users profile data
	 */
	GeekListUser getAuthenticatedUser();

	GeekListUser getUser(String userName);

	/**
	 * Get the GeekList Card details for the current user (the authenticated
	 * user)
	 * 
	 * @return the users cards
	 */
	List<GeekListCard> getAuthenticatedUserCards();

	List<GeekListCard> getUserCards(String userName);
}
