package com.example.table_Worker;


import com.example.module_7_homework.conections.Database;
import com.example.tables_DTO.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerDB {

    public List<Worker> getAllWorker() {
        Connection connection;
        PreparedStatement preparedStatement;
        List<Worker> workers = new ArrayList();
        try {
            connection = DriverManager.getConnection(Database.getConnectionDB(), Database.getUserDB(), Database.getPasswordDB());
            preparedStatement = connection.prepareStatement("SELECT * FROM worker");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                Date birthday = resultSet.getDate(3);
                String level = resultSet.getString("level");
                int salary = resultSet.getInt(5);
                Worker workersObj = new Worker(id, name, birthday, level, salary);
                workers.add(workersObj);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return workers;
    }
}
