public class SQL_OA {
//    -- write your code in PostgreSQL 9.4
//    SELECT x.id, x.title, x.sold_tickets
//    from
//            (
//                    SELECT m.id as id, m.title as title, COALESCE(r.sold_tickets, 0) as sold_tickets
//    FROM
//    movies m left join
//            (
//                    select reservations.movie_id, Sum(reservations.number_of_tickets) as sold_tickets
//    FROM reservations
//    GROUP BY reservations.movie_id
//) r
//    ON r.movie_id = m.id
//) x
//    Order BY x.sold_tickets DESC, x.id ASC
}
