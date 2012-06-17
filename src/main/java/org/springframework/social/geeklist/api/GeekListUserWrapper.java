/**
 * 
 */
package org.springframework.social.geeklist.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * A GeekList user wrapper - as teh API returns data that is nested one level
 * down below data
 * 
 * @author robert.hinds
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeekListUserWrapper {

	@JsonProperty("data")
	private GeekListUser user;

	public GeekListUser getUser() {
		return user;
	}

	public void setUser(GeekListUser user) {
		this.user = user;
	}

}
