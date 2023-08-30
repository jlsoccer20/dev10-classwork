drop database if exists xmen;
create database xmen;
use xmen;

create table hero (
	hero_id int primary key auto_increment,
    `name` varchar(255) not null,
    `alter_ego` varchar(255)
);

create table issue (
	issue_id int primary key auto_increment,
    `number` int not null
);

create table hero_issue (
	hero_issue_id int primary key auto_increment,
    hero_id int not null,
    issue_id int not null,
    rendered_unconcious int default 0,
    captured int default 0,
    declared_dead int default 0,
    subject_to_torture int default 0,
    expresses_reluctance_to_fight int default 0,
    surrenders int default 0,
    special_notes varchar(255),
    constraint fk_hero_issue_hero_id
		foreign key (hero_id)
        references hero(hero_id),
    constraint fk_hero_issue_issue_id
		foreign key (issue_id)
        references issue(issue_id),
	constraint uq_hero_issue_hero_id_issue_id
		unique(hero_id, issue_id)
);
	
    
    

    