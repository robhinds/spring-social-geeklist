/**
 * 
 */
package org.springframework.social.geeklist.api;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * A GeekList card
 * 
 * @author robert.hinds
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeekListCard {

	@JsonProperty("created_at")
	private Date dateCreated;

	@JsonProperty
	private String headline;

	@JsonProperty("is_active")
	private boolean active;

	@JsonProperty("short_code")
	private ShortCode shortCode;

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUrl() {
		return shortCode.getUrl();
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public class ShortCode {
		@JsonProperty("gklst_url")
		private String url;

		public String getUrl() {
			return url;
		}

		public void setUrl(String u) {
			url = u;
		}
	}
}
