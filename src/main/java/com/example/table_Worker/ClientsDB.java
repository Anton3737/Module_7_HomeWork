package com.example.table_Worker;

import com.example.module_7_homework.conections.Database;
import com.example.tables_DTO.Clients;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsDB {

    public List<Clients> getAllClients() {
        Connection connection;
        Statement statement;
        List<Clients> clients = new ArrayList();

        try {
            connection = DriverManager.getConnection(Database.getConnectionDB(), Database.getUserDB(), Database.getPasswordDB());
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM client");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                Clients clientsObj = new Clients(id, name);
                clients.add(clientsObj);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clients;
    }
}
