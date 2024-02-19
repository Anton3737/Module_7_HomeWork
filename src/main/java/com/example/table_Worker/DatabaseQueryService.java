package com.example.table_Worker;

import com.example.module_7_homework.conections.Database;
import com.example.tables_DTO.Project;
import com.example.tables_DTO.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    /**
     * Всі необхідні DTO або Описові класи які описутють поля таблиці з БД ДЗ 4 MegaSoft зніходяться
     * за даним посмланням src/main/java/tables_DTO/*
     * <p>
     * Клас підключення до БД знаходиться за посиланням src/main/java/com/example/module6_jdbc/conections/Database.java
     * <p>
     * Всі скріпти через JDBC для стврення та ініціалізації даних SQL знаходяться за посиланням src/main/java/table_Worker/*
     * <p>
     * SQL запити з ДЗ4 знаходяться за посиланням src/main/java/com/example/module6_jdbc/SQLSkripts/*
     * <p>
     * В даному класі DatabaseQueryService знаходяться методи для відпрацювання кожного із
     * скриптів для вибірки даних src/main/java/com/example/module6_jdbc/SQLSkripts/*
     */

    public static List<Project> getLongestProject() {
        Connection connection;
        Statement statement;
        List<Project> projectList = new ArrayList();
        try {
            connection = DriverManager.getConnection(Database.getConnectionDB(), Database.getUserDB(), Database.getPasswordDB());
            statement = connection.createStatement();
            String longestProject = "SELECT client.NAME                                                         AS NAME,\n" +
                    "       SUM(EXTRACT(DAY FROM AGE(project.FINISH_DATE, project.START_DATE))) AS MONTH_COUNT\n" +
                    "FROM client client\n" +
                    "         JOIN project project ON client.ID = project.CLIENT_ID\n" +
                    "GROUP BY client.ID, client.NAME\n" +
                    "ORDER BY MONTH_COUNT DESC\n" +
                    "LIMIT 1;";
            ResultSet resultSet = statement.executeQuery(longestProject);

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                String month_count = resultSet.getString("MONTH_COUNT");

                System.out.println("Project name " + name + ", " + "Month count " + month_count);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return projectList;
    }


    public static List<Project> getCountProjectsOnClients() {
        Connection connection;
        Statement statement;
        List<Project> projectList = new ArrayList();
        try {
            connection = DriverManager.getConnection(Database.getConnectionDB(), Database.getUserDB(), Database.getPasswordDB());
            statement = connection.createStatement();
            String longestProject = "SELECT client.NAME       AS NAME,\n" +
                    "       COUNT(project.ID) AS PROJECT_COUNT\n" +
                    "FROM client client\n" +
                    "         LEFT JOIN\n" +
                    "     project project ON client.ID = project.CLIENT_ID\n" +
                    "GROUP BY client.ID, client.NAME\n" +
                    "ORDER BY PROJECT_COUNT DESC\n" +
                    "LIMIT 1;";
            ResultSet resultSet = statement.executeQuery(longestProject);

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                String project_count = resultSet.getString("PROJECT_COUNT");

                System.out.println("Project name " + name + ", " + "Projects count " + project_count);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return projectList;
    }


    public static List<Worker> getMaxSalaryWorkers() {
        Connection connection;
        Statement statement;
        List<Worker> workers = new ArrayList();
        try {
            connection = DriverManager.getConnection(Database.getConnectionDB(), Database.getUserDB(), Database.getPasswordDB());
            statement = connection.createStatement();
            String maxSalaryQuery = "SELECT NAME, SALARY FROM worker WHERE SALARY = (SELECT MAX(SALARY) FROM worker)";
            ResultSet resultSet = statement.executeQuery(maxSalaryQuery);

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int salary = resultSet.getInt("SALARY");
                System.out.println("Name: " + name + ", Salary: " + salary);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return workers;
    }


    public static List<Project> getSummaryOfProjects() {
        Connection connection;
        Statement statement;
        List<Project> projectPriceList = new ArrayList();
        try {
            connection = DriverManager.getConnection(Database.getConnectionDB(), Database.getUserDB(), Database.getPasswordDB());
            statement = connection.createStatement();
            String selectSumForProjects = "SELECT project.id AS project, " +
                    "client.name, " +
                    "(EXTRACT(MONTH FROM AGE(project.finish_date, project.start_date)) * SUM(worker.salary)) AS price " +
                    "FROM client " +
                    "JOIN project ON client.id = project.client_id " +
                    "JOIN project_worker ON project.id = project_worker.project_id " +
                    "JOIN worker ON project_worker.worker_id = worker.id " +
                    "GROUP BY project.id, client.name, project.start_date, project.finish_date " +
                    "ORDER BY price DESC";
            ResultSet resultSet = statement.executeQuery(selectSumForProjects);

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int project_price = resultSet.getInt("price");

                System.out.println("Project name " + name + ", " + "Projects count " + project_price);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projectPriceList;
    }


    public static List<Worker> getWorkersWhoAreOldestAndYoungest() {
        Connection connection;
        Statement statement;
        List<Worker> workers = new ArrayList();
        try {
            connection = DriverManager.getConnection(Database.getConnectionDB(), Database.getUserDB(), Database.getPasswordDB());
            statement = connection.createStatement();
            String youngestAndOlderWorkers = "WITH RankedWorkers AS (SELECT NAME, BIRTHDAY, " +
                    "RANK() OVER (ORDER BY BIRTHDAY ASC) AS YoungestRank, " +
                    "RANK() OVER (ORDER BY BIRTHDAY DESC) AS OldestRank " +
                    "FROM worker) " +
                    "SELECT CASE WHEN YoungestRank = 1 THEN 'OLDEST' ELSE 'YOUNGEST' END AS TYPE, " +
                    "NAME, BIRTHDAY " +
                    "FROM RankedWorkers " +
                    "WHERE YoungestRank = 1 OR OldestRank = 1";
            ResultSet resultSet = statement.executeQuery(youngestAndOlderWorkers);

            while (resultSet.next()) {

                String type = resultSet.getString("TYPE");
                String name = resultSet.getString("NAME");
                Date birthday = Date.valueOf(resultSet.getString("BIRTHDAY"));

                Worker worker = new Worker(name, birthday, type);
                workers.add(worker);

                System.out.println("Type: " + type + ", Name: " + name + ", Birthday: " + birthday);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return workers;
    }
}
