SELECT * FROM cv.person;
select * from cv.edu;
select * from cv.wrk;
select * from cv.dty;
select * from cv.skl;

select concat('\n\n- ', (select group_concat(d.duty separator '\n- ') from dty d)) as duty_list;

use cv;
select name, email from person where id = 1;
select ach, org, yr from edu where persId = 1;

select role, org, era, duty 
from wrk w left outer join dty d 
on w.id = d.wrkId 
where persId = 1; -- GOOD WRK+DTY QUERY

select distinct w.role, w.org, w.era, 
(select concat('\n\n- ', (select group_concat(d.duty separator '\n- ') from dty d where d.wrkId = w.id))) as duty_list 
from wrk w left outer join dty d 
on w.id = d.wrkId 
where persId = 1; -- BEST WRK+DTY QUERY!

