package com.bvancleave.hearthstone.domain.json;

import java.util.Arrays;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonComponent
public class CardDTO {
	
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	private String text;
	private String rarity;
	private String type;
	private String cost;
	private String attack;
	private String health;
	private Boolean collectible;
	private String set;
	private String faction;
	private String artist;
	private String flavor;
	private String[] mechanics;
	private String[] dust;
	
	public CardDTO() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getAttack() {
		return attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public Boolean getCollectible() {
		return collectible;
	}

	public void setCollectible(Boolean collectible) {
		this.collectible = collectible;
	}

	public String getSet() {
		return set;
	}

	public void setSet(String set) {
		this.set = set;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String[] getMechanics() {
		return mechanics;
	}

	public void setMechanics(String[] mechanics) {
		this.mechanics = mechanics;
	}

	public String[] getDust() {
		return dust;
	}

	public void setDust(String[] dust) {
		this.dust = dust;
	}

	@Override
	public String toString() {
		return "CardDTO [id=" + id + ", name=" + name + ", text=" + text + ", rarity=" + rarity + ", type=" + type
				+ ", cost=" + cost + ", attack=" + attack + ", health=" + health + ", collectible=" + collectible
				+ ", set=" + set + ", faction=" + faction + ", artist=" + artist + ", flavor=" + flavor + ", mechanics="
				+ Arrays.toString(mechanics) + ", dust=" + Arrays.toString(dust) + "]";
	}
}
