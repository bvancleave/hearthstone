package com.bvancleave.hearthstone.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bvancleave.hearthstone.domain.Card;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {}