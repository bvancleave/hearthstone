package com.bvancleave.hearthstone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bvancleave.hearthstone.domain.Card;
import com.bvancleave.hearthstone.repositories.CardRepository;

@Service
public class CardService {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Transactional
	public List<Card> save( List<Card> entities ) {
		return (List<Card>) cardRepository.save( entities );
	}
}
