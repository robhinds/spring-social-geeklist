/**
 * 
 */
package org.springframework.social.geeklist.api;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * A GeekList card wrapper - as the API returns data that is nested one level
 * down below data
 * 
 * @author robert.hinds
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeekListCardWrapper {

	@JsonProperty("data")
	private InnerWrapper inner;

	public List<GeekListCard> getCards() {
		return inner.cards;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public class InnerWrapper {
		@JsonProperty("cards")
		private List<GeekListCard> cards;

		public void setCards(List<GeekListCard> c) {
			cards = c;
		}
	}

}
