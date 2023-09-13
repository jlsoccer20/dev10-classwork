use dwmh;

select *
from user -- guests and hosts
inner join location on user.user_id = location.user_id; -- attach hosts to location of their property to be rented out