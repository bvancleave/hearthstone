package com.bvancleave.hearthstone.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.Condition;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bvancleave.hearthstone.domain.Card;
import com.bvancleave.hearthstone.domain.json.CardDTO;
import com.bvancleave.hearthstone.services.CardService;

@RestController
public class CardController {
	private final String API_URL = "https://api.hearthstonejson.com/v1/14830/enUS/cards.json";
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	CardService cardService;
	
	@RequestMapping(value = "/cards", method=RequestMethod.GET)
	public List<CardDTO> getCards() {
		ResponseEntity<List<CardDTO>> cardResponse =
	        restTemplate.exchange(API_URL,
	                    HttpMethod.GET, 
	                    null, 
	                    new ParameterizedTypeReference<List<CardDTO>>(){});
		List<CardDTO> cards = cardResponse.getBody();
		
		mapper.getConfiguration()
			.setMatchingStrategy(MatchingStrategies.STANDARD)
			.setSourceNamingConvention(NamingConventions.NONE)
			.setDestinationNamingConvention(NamingConventions.NONE);
			
		PropertyMap<CardDTO, Card> cardMap = new PropertyMap<CardDTO, Card>() {
			@Override
			protected void configure() {
				Condition<String, Integer> notNull = new Condition<String, Integer>() {
					@Override
					public boolean applies(MappingContext<String, Integer> context) {
						return context.getSource() != null;
					}
				};
				
				Converter<String,Integer> c = new Converter<String, Integer>() {
					@Override
					public Integer convert(MappingContext<String, Integer> context) {
						return ( context.getSource() == null ? null : Integer.valueOf( context.getSource()));
					}		
				};
				
				skip().setCardId(null);
				map().setHearthstoneCardId(source.getId());
				when(notNull).using(c).map(source.getCost()).setMana(null);
			}
		};
		
		/*
		PropertyMap<Card, CardDTO> cardDTOMap = new PropertyMap<Card, CardDTO>() {
			protected void configure() {
				map().setId(source.getHearthstoneCardId());
				skip(source.getCardId());
			}
		};
*/
		mapper.createTypeMap(CardDTO.class, Card.class).addMappings(cardMap);
		//mapper.createTypeMap(Card.class, CardDTO.class).addMappings(cardDTOMap);
			
		List<Card> card = cards.stream()
			.map( c -> mapper.map(c, Card.class))
			.collect(Collectors.toList());
		
		card = cardService.save( card );
		
		return cards;
	}
	
}
