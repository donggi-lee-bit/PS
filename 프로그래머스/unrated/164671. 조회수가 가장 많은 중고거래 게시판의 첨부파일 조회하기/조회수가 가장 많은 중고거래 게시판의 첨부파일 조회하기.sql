select concat('/home/grep/src', '/', b.board_id, '/', f.file_id, f.file_name, f.file_ext) as file_path
from (select *
     from used_goods_board
    order by views desc
    limit 1) b
join used_goods_file f on b.board_id = f.board_id
order by f.file_id desc;