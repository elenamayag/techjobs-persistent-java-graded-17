-- Part 1
		-- int id
        -- varchar employer
        -- varchar name
        -- varchar skills

-- Part 2
select name from employer
where location = "St. Louis City";
-- Part 3
drop table job;
-- Part 4
select * from skill
inner join job_skills on skill.id = job_skills.skills_id
order by name asc;