/**
 * 
 */
package org.springframework.social.geeklist.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * A GeekList user stats object - represents just numbers about high fives,
 * cards, mentions and contributions
 * 
 * @author robert.hinds
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeekListUserStats {

	@JsonProperty("number_of_contributions")
	private int contributions;

	@JsonProperty("number_of_highfives")
	private int highFives;

	@JsonProperty("number_of_mentions")
	private int mentions;

	@JsonProperty("number_of_cards")
	private int cards;

	public int getContributions() {
		return contributions;
	}

	public void setContributions(int contributions) {
		this.contributions = contributions;
	}

	public int getHighFives() {
		return highFives;
	}

	public void setHighFives(int highFives) {
		this.highFives = highFives;
	}

	public int getMentions() {
		return mentions;
	}

	public void setMentions(int mentions) {
		this.mentions = mentions;
	}

	public int getCards() {
		return cards;
	}

	public void setCards(int cards) {
		this.cards = cards;
	}

}
