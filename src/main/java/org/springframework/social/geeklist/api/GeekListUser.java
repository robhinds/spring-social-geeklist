/**
 * 
 */
package org.springframework.social.geeklist.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * A GeekList user
 * 
 * @author robert.hinds
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeekListUser {

	@JsonProperty("id")
	private String userId;

	@JsonProperty("name")
	private String displayName;

	@JsonProperty("screen_name")
	private String userName;

	@JsonProperty
	private String location;

	@JsonProperty
	private String bio;

	@JsonProperty
	private GeekListUserStats stats;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public GeekListUserStats getStats() {
		return stats;
	}

	public void setStats(GeekListUserStats stats) {
		this.stats = stats;
	}

	public String getUserProfileUrl() {
		return "http://geekli.st/" + getUserName();
	}

}
