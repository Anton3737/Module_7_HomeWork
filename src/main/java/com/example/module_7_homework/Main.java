package com.example.module_7_homework;


import com.example.table_Worker.ClientsDB;
import com.example.table_Worker.DatabaseQueryService;
import com.example.table_Worker.ProjectDB;
import com.example.table_Worker.WorkerDB;
import com.example.tables_DTO.Clients;
import com.example.tables_DTO.Project;
import com.example.tables_DTO.Worker;


import java.util.List;

public class Main {

    public static void main(String[] args) {

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
