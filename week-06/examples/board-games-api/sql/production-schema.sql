drop database if exists board_games;
create database board_games;
use board_games;

create table board_game (
	board_game_id int primary key auto_increment,
	title varchar(100) not null,
    min_players int not null,
    max_players int not null,
    release_date date not null,
    rating decimal(3,1) not null,
    in_collection boolean not null,
    availability varchar(50) not null,
    msrp decimal(8,2) not null
);

