package com.example.table_Worker;

import com.example.module_7_homework.conections.Database;
import com.example.tables_DTO.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDB {

    public List<Project> getAllProject() {
        Connection connection;
        Statement statement;
        List<Project> projects = new ArrayList();

        try {
            connection = DriverManager.getConnection(Database.getConnectionDB(), Database.getUserDB(), Database.getPasswordDB());
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM project");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int client_id = resultSet.getInt(2);
                Date startDate = resultSet.getDate(3);
                Date finishDate = resultSet.getDate(4);
                Project projectsObj = new Project(id, client_id, startDate, finishDate);
                projects.add(projectsObj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return projects;
    }
}
