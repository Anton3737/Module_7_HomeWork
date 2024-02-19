package com.example.module_7_homework;

import com.example.module_7_homework.conections.Database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {


    private static String readInsertFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String sqlQuery = "";
            while ((sqlQuery = bufferedReader.readLine()) != null) {
                stringBuilder.append(sqlQuery).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stringBuilder.toString();
    }


    private static void insertDateOnTable(String query) {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            int count = 0;
            while (resultSet.next()) {
                System.out.println("Insert date on table = " + count);
                count++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        insertDateOnTable(readInsertFile("src/Main/java/com/example/module6_jdbc/SQLSkripts/populate_db.sql"));
    }
}
