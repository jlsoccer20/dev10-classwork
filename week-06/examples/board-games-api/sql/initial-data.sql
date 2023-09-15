use board_games;

insert into board_game (title, min_players, max_players, release_date, rating, in_collection, availability, msrp)
	value
    ('Monopoly', 2, 8,'1935-01-01', 4.4,1,'AVAILABLE_IN_RETAIL',24.99),
    ('Barrage', 1, 4,'2019-06-01',8.2,1,'AVAILABLE_IN_RETAIL',24.99),
    ('Castell', 2, 4,'2018-08-01',7.4,1,'AVAILABLE_IN_RETAIL',24.99),
    ('Distilled', 1, 5,'2023-07-01',8.0,1,'AVAILABLE_IN_RETAIL',24.99),
    ('Lunar Rush', 1, 4,'2023-10-20',8.5,1,'AVAILABLE_IN_RETAIL',24.99),
    ('Cyber Pet Quest',1,4,'2024-07-20',0.0,1,'UPCOMING',24.99);
