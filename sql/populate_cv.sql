use cv;

truncate table person;
truncate table edu;
truncate table wrk;
truncate table dty;
truncate table skl;

insert into person (name, email) values ("George Paley", "George@JDPaley.com");
set @person_id = last_insert_id();

insert into edu (persId, ach, org, yr) values (@person_id, "Counseling Psychology", "Holos", 2000);
insert into edu (persId, ach, org, yr) values (@person_id, "MBA studies", "University of Palermo", 1989);
insert into edu (persId, ach, org, yr) values (@person_id, "Math + Comp.Sc studies", "Technion", 1987);

-- *** JOB 1 ***
insert into wrk (persId, role, org, era) values (@person_id, "CTO", "Genstar", "2008-2014");
set @wrk_id = last_insert_id();
insert into dty (wrkId, duty) values (@wrk_id, "Create and manage R&D program.");
insert into dty (wrkId, duty) values (@wrk_id, "Architect software stack.");
insert into dty (wrkId, duty) values (@wrk_id, "Develop domain-specific tools.");
insert into dty (wrkId, duty) values (@wrk_id, "Produce MVP.");
insert into dty (wrkId, duty) values (@wrk_id, "Productize tool and spin it off as new company.");

-- *** JOB 2 ***
insert into wrk (persId, role, org, era) values (@person_id, "Founder", "LoveHomePage.com", "2002-2007");
set @wrk_id = last_insert_id();
insert into dty (wrkId, duty) values (@wrk_id, "Architect, assemble and manage on-site HA servers, redundant data links.");
insert into dty (wrkId, duty) values (@wrk_id, "Develop using LAMP, Flash Comm Server.");
insert into dty (wrkId, duty) values (@wrk_id, "Secured media coverage (front-page local newspaper, articles on Baltimore Sun, etc.");

-- *** JOB 3 ***
insert into wrk (persId, role, org, era) values (@person_id, "Producer", "The Pet Psychic (prime-time TV show)", "2001-2002");
set @wrk_id = last_insert_id();
insert into dty (wrkId, duty) values (@wrk_id, "Concept development. Set design.");
insert into dty (wrkId, duty) values (@wrk_id, "On- and off-set production coordination.");

-- *** JOB 4 ***
insert into wrk (persId, role, org, era) values (@person_id, "CIO", "Patent and Trademark Office (Argentina)", "1996-1997 (contract)");
set @wrk_id = last_insert_id();
insert into dty (wrkId, duty) values (@wrk_id, "Informix DB / Sun Servers Agent Accts Security Reengineering"); 

-- *** JOB 5 ***
insert into wrk (persId, role, org, era) values (@person_id, "War Veteran", "South Atlantic", "1982-1983");
set @wrk_id = last_insert_id();

insert into skl (persId, skl, lvl) values (@person_id, "R&D", "Mentor"); 
insert into skl (persId, skl, lvl) values (@person_id, "Therapist", "Proficient"); 
insert into skl (persId, skl, lvl) values (@person_id, "Realtor", "Proficient"); 
insert into skl (persId, skl, lvl) values (@person_id, "Mortgage Broker", "Branch Owner"); 
insert into skl (persId, skl, lvl) values (@person_id, "Radio, TV, event production", "International"); 
insert into skl (persId, skl, lvl) values (@person_id, "Writer", "Computerworld"); 
