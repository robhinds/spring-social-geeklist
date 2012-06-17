package org.springframework.social.geeklist.api;

import org.springframework.social.ApiBinding;
import org.springframework.web.client.RestOperations;

/**
 * Specifies core operations available on GeekList. Currently a limited subset
 * to just {@link GeekListUser} operations, but should be extended to handle the
 * full API
 * 
 * @author robert.hinds
 * 
 */
public interface GeekList extends ApiBinding {

	/**
	 * Used to expose the GeekList API relating to Users.
	 * 
	 * @return user operations
	 */
	UserOperations userOperations();

	/**
	 * Returns the underlying {@link RestOperations} to be used for any aspects
	 * of the GeekList API that are not yet supported by this binding
	 */
	RestOperations restOperations();
}
