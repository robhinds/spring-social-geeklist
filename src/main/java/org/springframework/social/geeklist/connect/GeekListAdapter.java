package org.springframework.social.geeklist.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.geeklist.api.GeekList;
import org.springframework.social.geeklist.api.GeekListUser;

/**
 * GeekList API Adapter implementation
 * 
 * @author robert.hinds
 * 
 */
public class GeekListAdapter implements ApiAdapter<GeekList> {

	public boolean test(GeekList api) {
		try {
			if (null != api.userOperations().getAuthenticatedUser()) {
				return true;
			} else {
				return false;
			}
		} catch (ApiException e) {
			return false;
		}
	}

	public void setConnectionValues(GeekList api, ConnectionValues values) {
		GeekListUser user = api.userOperations().getAuthenticatedUser();
		values.setProviderUserId(user.getUserName());
		values.setProfileUrl(user.getUserProfileUrl());
		values.setDisplayName(user.getDisplayName());
	}

	public UserProfile fetchUserProfile(GeekList api) {
		GeekListUser user = api.userOperations().getAuthenticatedUser();
		return new UserProfileBuilder().setUsername(user.getUserName()).setName(user.getDisplayName()).build();
	}

	public void updateStatus(GeekList api, String message) {
		// NOOP
	}

}
