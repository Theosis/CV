use cv;

truncate table person;
truncate table edu;
truncate table wrk;
truncate table dty;
truncate table skl;

insert into person (name, email) values ("George Paley", "George@JDPaley.com");
set @person_id = last_insert_id();

insert into edu (persId, ach, org, yr) values (@person_id, "Counseling Psychology", "Holos", 2000);

insert into wrk (persId, role, org, era) values (@person_id, "CTO", "Genstar", "2008-2014");
set @wrk_id = last_insert_id();

insert into dty (wrkId, duty) values (@wrk_id, "Architect software stack.");

insert into skl (persId, skl, lvl) values (@person_id, "R&D", "Mentor");

-- ----------------------------------------------------------------
-- insert into person (name, email) values ("Jill", "Jill@dom.com");
-- insert into person (name, email) values ("Joe", "Joe@dom.com");

