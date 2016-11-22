package com.bvancleave.hearthstone.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Deck {
	
	@Id
	@Column(name = "deck_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long deckId;
	
	@NotNull
	private String name;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Classes archetype;
	
	@OneToMany(mappedBy="deck", cascade = CascadeType.ALL)
	private List<Card> cards;

	public Long getDeckId() {
		return deckId;
	}

	public void setDeckId(Long deckId) {
		this.deckId = deckId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Classes getArchetype() {
		return archetype;
	}

	public void setArchetype(Classes archetype) {
		this.archetype = archetype;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	@Override
	public String toString() {
		return "Deck [deckId=" + deckId + ", name=" + name + ", description=" + description + ", archetype=" + archetype
				+ ", cards=" + cards + "]";
	}
}
