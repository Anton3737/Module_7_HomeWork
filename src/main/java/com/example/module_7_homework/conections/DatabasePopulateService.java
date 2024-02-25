package com.example.module_7_homework.conections;

import com.example.module_7_homework.conections.Database;
import com.example.tables_DTO.Clients;
import com.example.tables_DTO.Worker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabasePopulateService {

    public static final String INSERT_WORKER = "INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES (?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?)";

    public static final String INSERT_CLIENT = "INSERT INTO client (NAME) VALUES (?)";

    public static final String INSERT_PROJECT = "INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?, ?, ?)";

    public static final String INSERT_PROJECT_WORKER = "INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (?, ?)";


    public static void insertDataToWorkerTable(String name, String birthday, String level, int salary) {
        Connection connection;
        PreparedStatement preparedStatement;

        String insertWorkersToTabe = INSERT_WORKER;

        try {
            connection = DriverManager.getConnection(Database.getConnectionDB(), Database.getUserDB(), Database.getPasswordDB());

            preparedStatement = connection.prepareStatement(insertWorkersToTabe);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, birthday);
            preparedStatement.setString(3, level);
            preparedStatement.setInt(4, salary);

            preparedStatement.executeUpdate();
            System.out.println("Data added !");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertDataToClientTable(String clientName) {
        Connection connection;
        PreparedStatement preparedStatement;

        String insertClientsToTabe = INSERT_CLIENT;

        try {
            connection = DriverManager.getConnection(Database.getConnectionDB(), Database.getUserDB(), Database.getPasswordDB());

            preparedStatement = connection.prepareStatement(insertClientsToTabe);

            preparedStatement.setString(1, clientName);

            preparedStatement.executeUpdate();
            System.out.println("Data added !");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertDataToProjectTable(int clientId, String startDate, String finishDate) {
        Connection connection;
        PreparedStatement preparedStatement;

        String insertProjectToTabel = INSERT_PROJECT;

        try {
            connection = DriverManager.getConnection(Database.getConnectionDB(), Database.getUserDB(), Database.getPasswordDB());

            preparedStatement = connection.prepareStatement(insertProjectToTabel);

            preparedStatement.setInt(1, clientId);
            preparedStatement.setDate(2, Date.valueOf(startDate));
            preparedStatement.setDate(3, Date.valueOf(finishDate));

            preparedStatement.executeUpdate();
            System.out.println("Data added !");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertDataToProjectWithWorkerTable(int projectId, int workerId) {
        Connection connection;
        PreparedStatement preparedStatement;

        String insertDataToProjectWithWorkerTable = INSERT_PROJECT_WORKER;

        try {
            connection = DriverManager.getConnection(Database.getConnectionDB(), Database.getUserDB(), Database.getPasswordDB());

            preparedStatement = connection.prepareStatement(insertDataToProjectWithWorkerTable);

            preparedStatement.setInt(1, projectId);
            preparedStatement.setInt(2, workerId);

            preparedStatement.executeUpdate();
            System.out.println("Data added !");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}