-- 코드를 입력하세요, 전화번호 출력 값 이상함, 
SELECT user_id, u.nickname as nickname, concat(u.city, ' ', u.street_address1, ' ', u.street_address2) as '전체주소', concat(left(u.tlno, 3), '-', mid(u.tlno, 4, 4), '-', mid(u.tlno, 8)) as '전화번호'
from USED_GOODS_BOARD b
join USED_GOODS_USER u on b.writer_id = u.user_id
group by b.writer_id
having count(*) >= 3
order by u.user_id desc;