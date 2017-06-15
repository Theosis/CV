SELECT * FROM cv.person;
select * from cv.edu;
select * from cv.wrk;
select * from cv.dty;
select * from cv.skl;

use cv;
SELECT p.name, e.ach, w.role, d.duty, s.skl 
FROM person p, edu e, wrk w, dty d, skl s 
WHERE e.persId = p.id 
AND w.persId = p.id AND d.wrkId = w.id 
AND s.persId = p.id;
