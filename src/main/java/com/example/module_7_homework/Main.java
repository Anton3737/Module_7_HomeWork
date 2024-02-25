package com.example.module_7_homework;


import com.example.table_Worker.ClientsDB;
import com.example.table_Worker.DatabaseQueryService;
import com.example.table_Worker.ProjectDB;
import com.example.table_Worker.WorkerDB;
import com.example.tables_DTO.Clients;
import com.example.tables_DTO.Project;
import com.example.tables_DTO.Worker;


import java.util.List;

import static com.example.module_7_homework.conections.DatabaseInitService.*;
import static com.example.module_7_homework.conections.DatabasePopulateService.*;

public class Main {

    public static void main(String[] args) {


        // Створення таблиць
        createTablesMethod(CREATE_TABLE_WORKER);
        createTablesMethod(CREATE_TABLE_CLIENT);
        createTablesMethod(CREATE_TABLE_PROJECT);
        createTablesMethod(CREATE_TABLE_PROJECTWORKER);

        // Додавання даних
        insertDataToWorkerTable("Anton", "1994-03-20", "intern", 900);
        insertDataToWorkerTable("Іван Петренко", "1990-05-15", "Middle", 80000);
        insertDataToWorkerTable("Олена Коваленко", "1985-09-22", "Senior", 95000);
        insertDataToWorkerTable("Марія Лисенко", "1993-11-10", "Trainee", 60000);
        insertDataToWorkerTable("Богдан Шевченко", "1982-03-30", "Junior", 75000);
        insertDataToWorkerTable("Єва Біла", "1995-07-08", "Senior", 90000);
        insertDataToWorkerTable("Олександр Бровко", "1988-01-18", "Senior", 100000);
        insertDataToWorkerTable("Лаура Дейвіс", "1991-12-05", "Trainee", 55000);
        insertDataToWorkerTable("Марк Тейлор", "1987-06-25", "Junior", 72000);
        insertDataToWorkerTable("Софія Вільсон", "1994-04-14", "Middle", 88000);
        insertDataToWorkerTable("Райан Кларк", "1984-08-17", "Senior", 98000);


        insertDataToClientTable("Apple");
        insertDataToClientTable("Google");
        insertDataToClientTable("Microsoft");
        insertDataToClientTable("OnlyFans");
        insertDataToClientTable("Amazon");

        insertDataToProjectTable(1, "2012-01-15", "2019-10-15");
        insertDataToProjectTable(2, "2013-02-28", "2020-06-20");
        insertDataToProjectTable(3, "2019-06-18", "2023-11-10");
        insertDataToProjectTable(4, "2019-10-23", "2022-09-15");
        insertDataToProjectTable(1, "2013-02-20", "2015-02-11");
        insertDataToProjectTable(5, "2014-07-10", "2015-02-28");
        insertDataToProjectTable(2, "2014-09-28", "2015-01-10");
        insertDataToProjectTable(4, "2015-03-20", "2016-10-07");
        insertDataToProjectTable(3, "2015-06-28", "2017-12-10");
        insertDataToProjectTable(5, "2016-06-20", "2017-12-15");
        insertDataToProjectTable(1, "2017-02-15", "2019-12-15");
        insertDataToProjectTable(3, "2018-08-28", "2020-02-10");
        insertDataToProjectTable(5, "2020-08-20", "2020-02-15");
        insertDataToProjectTable(2, "2012-02-28", "2021-03-10");
        insertDataToProjectTable(1, "2012-01-20", "2014-03-11");
        insertDataToProjectTable(4, "2013-12-23", "2017-11-15");
        insertDataToProjectTable(2, "2014-12-28", "2020-08-20");
        insertDataToProjectTable(4, "2016-04-20", "2017-11-07");
        insertDataToProjectTable(5, "2014-09-10", "2015-04-30");
        insertDataToProjectTable(3, "2013-06-19", "2017-11-10");

        insertDataToProjectWithWorkerTable(1, 1);
        insertDataToProjectWithWorkerTable(1, 3);
        insertDataToProjectWithWorkerTable(1, 5);
        insertDataToProjectWithWorkerTable(2, 4);
        insertDataToProjectWithWorkerTable(2, 6);
        insertDataToProjectWithWorkerTable(2, 8);
        insertDataToProjectWithWorkerTable(3, 2);
        insertDataToProjectWithWorkerTable(3, 7);
        insertDataToProjectWithWorkerTable(3, 9);
        insertDataToProjectWithWorkerTable(4, 10);
        insertDataToProjectWithWorkerTable(4, 1);
        insertDataToProjectWithWorkerTable(4, 5);
        insertDataToProjectWithWorkerTable(5, 9);
        insertDataToProjectWithWorkerTable(5, 3);
        insertDataToProjectWithWorkerTable(5, 6);

        // Витяг даних
        ClientsDB clientsDB = new ClientsDB();
        ProjectDB projectDB = new ProjectDB();
        WorkerDB workerDB = new WorkerDB();
        DatabaseQueryService databaseQueryServiceWithoutReader = new DatabaseQueryService();


        System.out.println("\n\n Отримання найдовшого по тривалості проекту");
        List<Project> projectsLongList = databaseQueryServiceWithoutReader.getLongestProject();
        for (Project projectsListing : projectsLongList) {
            System.out.println(projectsListing);
        }

        System.out.println("\n\n Отримання компанії у якої найбільше проектів");
        List<Project> projectsListForEachClient = databaseQueryServiceWithoutReader.getCountProjectsOnClients();
        for (Project projectsCounter : projectsListForEachClient) {
            System.out.println(projectsCounter);
        }

        System.out.println("\n\n Отримання працівника з найбільшою заробітньою платою");
        List<Worker> workerList = databaseQueryServiceWithoutReader.getMaxSalaryWorkers();
        for (Worker workersSalary : workerList) {
            System.out.println(workersSalary);
        }

        System.out.println("\n\n Отримання ціни проекту вихідячи з затрат на ЗП та Час тривалості проектів для компанії");
        List<Project> projectsBudgetForEach = databaseQueryServiceWithoutReader.getSummaryOfProjects();
        for (Project projectsDebet : projectsBudgetForEach) {
            System.out.println(projectsDebet);
        }

        System.out.println("\n\n Отримання наймолодшого та найстаршого працівника");
        List<Worker> workersAges = databaseQueryServiceWithoutReader.getWorkersWhoAreOldestAndYoungest();
        for (Worker workersYoungAndOld : workersAges) {
            System.out.println(workersYoungAndOld);
        }

        System.out.println("\n\n Отримання всіх клієнтів переданих до БД");
        List<Clients> allClients = clientsDB.getAllClients();
        for (Clients client : allClients) {
            System.out.println(client.toString());
        }

        System.out.println("\n\n Отримання всіх проeктів переданих до БД");
        List<Project> projectList = projectDB.getAllProject();
        for (Project projects : projectList) {
            System.out.println(projects.toString());
        }


        System.out.println("\n\n Отримання всіх клієнтів переданих до БД");
        List<Worker> allWorkers = workerDB.getAllWorker();
        for (Worker worker : allWorkers) {
            System.out.println(worker.toString());
        }
    }

}
