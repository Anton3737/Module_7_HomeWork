SELECT project.id                                                                              AS project,
       client.name,
       (EXTRACT(MONTH FROM AGE(project.finish_date, project.start_date)) * SUM(worker.salary)) AS price
FROM client
         JOIN
     project ON client.id = project.client_id
         JOIN
     project_worker ON project.id = project_worker.project_id
         JOIN
     worker ON project_worker.worker_id = worker.id
GROUP BY project.id, client.name, project.start_date, project.finish_date
ORDER BY price DESC;
