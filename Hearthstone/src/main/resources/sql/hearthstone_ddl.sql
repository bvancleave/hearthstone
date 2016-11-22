create database hs;

use hs;

create table deck (
	deck_id int not null auto_increment,
    name varchar(255) not null,
    description text,
    archetype enum('DRUID', 'HUNTER', 'MAGE','PALADIN','PRIEST','ROGUE', 'SHAMAN', 'WARLOCK', 'WARRIOR' ),
    primary key (deck_id)
);

alter table card modify column mana int;

create table card (
	card_id int not null auto_increment,
    hearthstone_card_id varchar(255) not null unique,
    name varchar(255) not null,
    mana int,
    attack int,
    health int,
	type enum( 'SPELL', 'MINION', 'HERO', 'HERO_POWER' ),
    tribe enum('BEAST','DEMON','DRAGON','MURLOC','MECH', 'NONE') default 'NONE',
    rarity enum('COMMON', 'RARE', 'EPIC', 'LEGENDARY', 'FREE' ),
    card_set enum('CORE', 'GVG', 'NAXX', 'TGT', 'BRM', 'LOE', 'WOG', 'KARA', 'TB', 'HERO_SKINS'),
    text text,
    primary key (card_id)    
);

alter table card add index card_hearthstone_card_id_unq (hearthstone_card_id);

create table card_deck (
	card_deck_id int not null auto_increment,
    card_id int not null,
    foreign key (card_id)
		references card (card_id)
        on delete cascade,
	deck_id int not null,
	foreign key (deck_id)
		references deck (deck_id)
        on delete cascade,
	primary key (card_deck_id)
);

create table mechanics (
	mechanics_id int not null auto_increment,
    name enum('BATTLECRY', 'TAUNT', 'JOUST', 'CHARGE', 'DISCOVER') not null,
    primary key (mechanics_id)
);

create table card_mechanics (
	card_mechanics_id int not null auto_increment,
    card_id int not null,
    mechanics_id int not null,
    primary key (card_mechanics_id),
    index fk_card_idx (card_id),
    foreign key (card_id)
		references card (card_id)
        on delete cascade,
	index fk_mechanics_idx (mechanics_id),
    foreign key (mechanics_id)
		references mechanics (mechanics_id)
        on delete cascade
);

