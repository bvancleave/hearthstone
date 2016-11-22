package com.bvancleave.hearthstone.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mechanics {
	
	@Id
	@Column(name = "mechanics_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long mechanicsId;
	
	@Enumerated(EnumType.STRING)
	private MechanicType name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="card_id",referencedColumnName="card_id")
	private Card card;  
	  
	public Long getMechanicsId() {
		return mechanicsId;
	}

	public void setMechanicsId(Long mechanicsId) {
		this.mechanicsId = mechanicsId;
	}

	public MechanicType getName() {
		return name;
	}

	public void setName(MechanicType name) {
		this.name = name;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
}
