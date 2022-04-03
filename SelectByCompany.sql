select
p.name as person_ame,
c.name as company_ame
from person as p
 left join company as c
 on p.company_id = c.id
where c.id <> 5;

select
c.name as company_name,
count(p.name) as person_amount
from  company as c 
 left join person as p
 on c.id = p.company_id
group by
 c.name
order by
 person_amount desc
limit 1; 
 

 
