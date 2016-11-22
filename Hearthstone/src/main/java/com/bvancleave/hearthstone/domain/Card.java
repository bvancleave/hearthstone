package com.bvancleave.hearthstone.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Card {
	
	@Id
	@Column(name = "card_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cardId;
	
	@NotNull
	private String hearthstoneCardId;
	
	@NotNull
	private String name;
	
	private Integer mana;
	private Integer attack;
	private Integer health;
	
	@Enumerated(EnumType.STRING)
	private Tribe tribe;
	
	@OneToMany( mappedBy="card", cascade = CascadeType.ALL)
	private List<Mechanics> mechanics;
	
	@Enumerated(EnumType.STRING)
	private Rarity rarity;
	
	@Enumerated(EnumType.STRING)
	private CardSet cardSet;
	
	private String text;
	
	@Enumerated(EnumType.STRING)
	private Type type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name="card_deck",
    joinColumns = @JoinColumn(name = "card_id", 
                              referencedColumnName = "card_id"), 
    inverseJoinColumns = @JoinColumn(name = "deck_id", 
                              referencedColumnName = "deck_id"))
	private Deck deck; 
	
	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public String getHearthstoneCardId() {
		return hearthstoneCardId;
	}

	public void setHearthstoneCardId(String hearthstoneCardId) {
		this.hearthstoneCardId = hearthstoneCardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMana() {
		return mana;
	}

	public void setMana(Integer mana) {
		this.mana = mana;
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}

	public List<Mechanics> getMechanics() {
		return mechanics;
	}

	public void setMechanics(List<Mechanics> mechanics) {
		this.mechanics = mechanics;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	public CardSet getCardSet() {
		return cardSet;
	}

	public void setCardSet(CardSet cardSet) {
		this.cardSet = cardSet;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Tribe getTribe() {
		return tribe;
	}

	public void setTribe(Tribe tribe) {
		this.tribe = tribe;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
