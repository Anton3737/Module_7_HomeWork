SELECT client.NAME                                                         AS NAME,
       SUM(EXTRACT(DAY FROM AGE(project.FINISH_DATE, project.START_DATE))) AS MONTH_COUNT
FROM client client
         JOIN project project ON client.ID = project.CLIENT_ID
GROUP BY client.ID, client.NAME
ORDER BY MONTH_COUNT DESC
LIMIT 1;
