

SELECT MAX(MONTH_COUNT) AS MAX_DURATION
FROM (SELECT SUM(EXTRACT(DAY FROM AGE(project.FINISH_DATE, project.START_DATE))) AS MONTH_COUNT
      FROM client
               JOIN
           project ON client.ID = project.CLIENT_ID
      GROUP BY client.ID, client.NAME) AS subquery;



SELECT client.NAME                                             AS CLIENT_NAME,
       SUM(EXTRACT(DAY FROM AGE(p.FINISH_DATE, p.START_DATE))) AS TOTAL_DURATION
FROM client client
         JOIN project p ON client.ID = p.CLIENT_ID
GROUP BY client.ID, client.NAME;

SELECT client.NAME,
       SUM(EXTRACT(DAY FROM AGE(project.FINISH_DATE, project.START_DATE))) AS Mounth
FROM client
         JOIN
     project ON client.ID = project.CLIENT_ID
GROUP BY client.ID, client.NAME;


SELECT client.NAME, EXTRACT(DAY FROM AGE(project.FINISH_DATE, project.START_DATE)) AS MONTH_COUNT
FROM client
         JOIN project ON client.ID = project.CLIENT_ID;



SELECT MAX(MONTH_COUNT) AS MAX_DURATION
FROM (SELECT client.NAME,
             SUM(EXTRACT(DAY FROM AGE(project.FINISH_DATE, project.START_DATE))) AS MONTH_COUNT
      FROM client
               JOIN
           project ON client.ID = project.CLIENT_ID
      GROUP BY client.ID, client.NAME) AS subquery;

-- NAME	MONTH_COUNT
-- Project A	27
-- Project B	27


SELECT ID, CLIENT_ID, START_DATE, FINISH_DATE, FINISH_DATE - START_DATE AS DATE_DIFF
FROM project;



