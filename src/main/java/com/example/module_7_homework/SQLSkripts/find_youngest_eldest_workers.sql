WITH RankedWorkers AS (SELECT NAME,
                              BIRTHDAY,
                              RANK() OVER (ORDER BY BIRTHDAY ASC)  AS YoungestRank,
                              RANK() OVER (ORDER BY BIRTHDAY DESC) AS OldestRank
                       FROM worker)
SELECT CASE WHEN YoungestRank = 1 THEN 'OLDEST' ELSE 'YOUNGEST' END AS TYPE,
       NAME,
       BIRTHDAY
FROM RankedWorkers
WHERE YoungestRank = 1
   OR OldestRank = 1;