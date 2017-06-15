use cv;

select concat('\n=============================================================  \n'
, p.name, '\n', p.email, '\n\n') as pers_info 
from person p 
where id = 1; -- PERSONAL INFO
 

select concat('Education  \n', 
(select group_concat(e.ach, ',  \n', e.org, ', ', e.yr, '  \n\n' separator '') 
from edu e 
where persId = 1)) as edu_info ; -- EDUCATION INFO


select distinct w.role, w.org, w.era, 
(select concat('\n\n- ', (select group_concat(d.duty separator '\n- ') from dty d where d.wrkId = w.id))) as duty_list 
from wrk w left outer join dty d 
on w.id = d.wrkId 
where persId = 1; -- BEST WORK + DUTIES QUERY!


select concat('Skills\n', 
(select group_concat(s.skl, ', ', s.lvl, '\n' separator '') 
from skl s 
where s.persId = 1) ) as skl_list; -- SKILLS INFO
