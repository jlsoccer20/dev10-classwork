use dwmh;

select * from reservation r
inner join location l on r.location_id = l.location_id
inner join state s on l.state_id = s.state_id
inner join `user` h on l.user_id = h.user_id
inner join `user` g on r.guest_user_id = g.user_id
where h.email = ``;