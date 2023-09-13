use dwmh;

select reservation_id, start_date, end_date, total, first_name, last_name, email, phone -- information for reservation and guests
from (select reservation.reservation_id, reservation.start_date, reservation.end_date, reservation.total, reservation.guest_user_id 
	  from (select location_id, address, city, postal_code
			from user -- guests and hosts
			inner join location on user.user_id = location.user_id 
            where email = "rklimpt1@paginegialle.it") as host -- attach hosts to location of their property to be rented out
	  inner join reservation on host.location_id = reservation.location_id) as reservations -- attaching a reservation with guest for a host
inner join user on reservations.guest_user_id = user.user_id; -- attaches guest info to reservation