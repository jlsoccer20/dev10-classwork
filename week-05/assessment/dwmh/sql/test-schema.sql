drop database if exists dwmh_test;
create database dwmh_test;
use dwmh_test;

create table state (
	state_id int primary key auto_increment,
    `name` varchar(50) not null unique,
    usps_code varchar(2) not null unique
);

create table `user` (
	user_id int primary key auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(512) not null unique,
    phone varchar(50) not null    
);

create table location (
	location_id int primary key auto_increment,
	user_id int not null,
    address varchar(100) not null,
    city varchar(100) not null,
	postal_code varchar(20) not null,
	state_id int not null,
    standard_rate decimal(8, 2) not null,
	weekend_rate decimal(8, 2) not null,
    constraint fk_location_user_id
        foreign key (user_id)
        references user(user_id),
    constraint fk_location_state_id
        foreign key (state_id)
        references state(state_id)            
);

create table reservation (
	reservation_id int primary key auto_increment,
	location_id int not null,
    guest_user_id int not null,
    start_date date not null,
    end_date date not null,
    total decimal(10, 2) not null,
    constraint fk_reservation_location_id
        foreign key (location_id)
        references location(location_id),
    constraint fk_reservation_guest_user_id
        foreign key (guest_user_id)
        references user(user_id)    
);

delimiter //
create procedure set_known_good_state()
begin
	-- delete starts with children	
    delete from reservation;
    alter table reservation auto_increment=1;
    delete from location;
    alter table location auto_increment=1;
    delete from state;
    alter table state auto_increment=1;
	delete from `user`;
    alter table `user` auto_increment=1;
    
    -- inserts start with parents
	insert into `user` (first_name, last_name, email, phone) values
		('First 1', 'Last 1', '1@example.com', '555-5551'),
        ('First 2', 'Last 2', '2@example.com', '555-5552'),
        ('First 3', 'Last 3', '3@example.com', '555-5553');
        
	insert into state(`name`, usps_code) values ('Minnesota', 'MN');
    
    -- user_id == host
    insert into location (user_id, address, city, state_id, postal_code, standard_rate, weekend_rate)
		values
        (1, 'Location 1', 'City 1', 1, '55551', 100.0, 125.0),
        (3, 'Location 2', 'City 2', 1, '55552', 100.0, 125.0);
        
	insert into reservation (guest_user_id, location_id, start_date, end_date, total)
		values
        (1, 1, '2023-01-01', '2023-01-05', 500.0),
        (2, 1, '2023-01-05', '2023-01-07', 500.0),
        (2, 2, '2023-01-01', '2023-01-05', 500.0);
end//
delimiter ;