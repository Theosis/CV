SELECT * FROM cv.person;
select * from edu;
select * from wrk;
select * from dty;
select * from skl;
SELECT a.ord_num,b.cust_name,a.cust_code,
c.agent_code,b.cust_city
FROM agents c,customer b,orders a
WHERE b.cust_city=c.working_area
AND a.cust_code=b.cust_code
AND a.agent_code=c.agent_code;