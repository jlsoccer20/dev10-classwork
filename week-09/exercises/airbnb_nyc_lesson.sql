use airbnb_nyc;

select count(listing_id) -- counts non-null listing_ids
from listing;

select count(last_review)
from listing;

select count(*)
from listing;

select avg(price)
from listing
where neighbourhood_group = 'Manhattan'
and price > 0;

select 
    avg(price * minimum_nights) avg_min_price
from listing
where neighbourhood = 'Harlem'
and price > 0;

select 
    max(last_review)
from listing
where neighbourhood = 'Williamsburg';

select 
    count(listing_id) listing_count,
    min(price) min_price,
    max(price) max_price,
    avg(price) avg_price,
    std(price) price_std,
    sum(reviews_per_month) total_reviews
from listing
where neighbourhood = 'Williamsburg';

select
    neighbourhood,
    avg(price) avg_price
from listing
group by neighbourhood;

select
    neighbourhood,
    room_type,
    avg(price) avg_price
from listing
group by neighbourhood, room_type
order by neighbourhood, room_type;

select
    neighbourhood,
    room_type,
    min(price) min_price,
    max(price) max_price,
    count(listing_id) listing_count,
    avg(price) avg_price
from listing
group by neighbourhood, room_type
order by avg(price) asc;

select
    neighbourhood,
    room_type,
    min(price) min_price,
    max(price) max_price,
    count(listing_id) listing_count,
    avg(price) avg_price
from listing
group by neighbourhood, room_type
having avg(price) between 45.00 and 65.00
order by avg(price) asc;

select
    neighbourhood_group,
    neighbourhood,
    room_type,
    min(price) min_price,                              -- 3
    max(price) max_price,
    count(listing_id) listing_count,
    avg(price) avg_price
from listing                                           -- 1
where availability_365 > 0                             -- 2
    and price > 0
group by neighbourhood_group, neighbourhood, room_type -- 3
having avg(price) between 45.00 and 65.00              -- 4
    and count(listing_id) > 1
order by avg(price) asc                                -- 5
limit 5;                                               -- 6

select count(number_of_reviews)
from listing;




