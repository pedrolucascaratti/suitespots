/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.orient.objeto.suitespots.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import prog.orient.objeto.suitespots.models.Cliente;
import prog.orient.objeto.suitespots.models.Pagamento;
import prog.orient.objeto.suitespots.models.Quarto;
import prog.orient.objeto.suitespots.models.Reserva;

/**
 *
 * @author pedro
 */
public class DatabaseAux {
    private Connection connection;
    private String[] tables = { "cliente", "quarto", "reserva", "pagamento" };

    public DatabaseAux() {
        try {
            this.connection = DatabaseConnection.getConnection();
            verifyTablesExists();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    private void verifyTablesExists() {
        try (Statement stmt = this.connection.createStatement()) {
            for (String table : tables) {
                String consultQuery = "SHOW TABLES LIKE '" + table + "'";
                ResultSet resultSet = stmt.executeQuery(consultQuery);
                if (!resultSet.next()) {
                    System.out.println("Table: " + table + " não existe!");
                    String query = getCreateTableQuery(table);
                    if (query != null) {
                        stmt.execute(query);
                        resultSet = stmt.executeQuery(consultQuery);
                        if (resultSet.next()) {
                            System.out.println("Table: " + table + " criada com sucesso!");
                        } else {
                            System.out.println("Table: " + table + " não foi criada!");
                        }
                    }
                } else {
                    System.out.println("Table: " + table + " existe!");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String getCreateTableQuery(String table) {
        switch (table) {
            case "cliente":
                return "CREATE TABLE IF NOT EXISTS cliente (" +
                        "id_cliente SMALLINT unsigned NOT NULL AUTO_INCREMENT," +
                        "nome VARCHAR(40) NOT NULL," +
                        "apelido VARCHAR(15) DEFAULT NULL," +
                        "cpf VARCHAR(11) NOT NULL UNIQUE," +
                        "telefone VARCHAR(18)," +
                        "sexo CHAR(1) NOT NULL," +
                        "email VARCHAR(60)," +
                        "situacao INT(1) unsigned NOT NULL DEFAULT '1'," +
                        "logradouro VARCHAR(25) NOT NULL," +
                        "numero INT(8) unsigned NOT NULL," +
                        "bairro VARCHAR(20) NOT NULL," +
                        "cidade VARCHAR(30) NOT NULL," +
                        "estado VARCHAR(2) NOT NULL," +
                        "observacoes TEXT DEFAULT NULL," +
                        " PRIMARY KEY (id_cliente)" +
                        ")";
            case "quarto":
                return "CREATE TABLE IF NOT EXISTS quarto (" +
                        "id_quarto SMALLINT unsigned NOT NULL AUTO_INCREMENT," +
                        "id_reserva SMALLINT unsigned," +
                        "numero_quarto SMALLINT(4) unsigned NOT NULL," +
                        "capacidade SMALLINT(2) unsigned NOT NULL," +
                        "valor_diaria DECIMAL(10,2) unsigned NOT NULL," +
                        "tipo VARCHAR(20)," +
                        "caracteristica VARCHAR(20)," +
                        "observacao TEXT(150)," +
                        " PRIMARY KEY (id_quarto)" +
                        ")";
            case "reserva":
                return "CREATE TABLE reserva (" +
                        "id_reserva SMALLINT unsigned NOT NULL AUTO_INCREMENT," +
                        "id_cliente SMALLINT unsigned NOT NULL," +
                        "data_reserva DATETIME DEFAULT CURRENT_TIMESTAMP," +
                        "data_entrada DATETIME," +
                        "data_saida DATETIME," +
                        "id_quarto SMALLINT unsigned NOT NULL," +
                        "qnt_diarias TINYINT(2) unsigned NOT NULL," +
                        "valor_total DECIMAL(10,2) unsigned NOT NULL," +
                        "ocupantes TINYINT unsigned NOT NULL," +
                        "valor_adicional DECIMAL(10,2) unsigned DEFAULT '0.00'," +
                        "valor_desconto DECIMAL(10,2) unsigned DEFAULT '0.00'," +
                        "valor_diaria DECIMAL(10,2) unsigned NOT NULL," +
                        "observacao TEXT," +
                        " PRIMARY KEY (id_reserva)," +
                        " FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)," +
                        " FOREIGN KEY (id_quarto) REFERENCES quarto(id_quarto)" +
                        ")";
            case "pagamento":
                return "CREATE TABLE pagamento (" +
                        "id_pagamento SMALLINT unsigned NOT NULL AUTO_INCREMENT," +
                        "id_reserva SMALLINT unsigned NOT NULL," +
                        "id_cliente SMALLINT unsigned NOT NULL," +
                        "valor_pagamento DECIMAL unsigned NOT NULL," +
                        "forma_pagamento VARCHAR(15) NOT NULL," +
                        "data_pagamento DATETIME DEFAULT CURRENT_TIMESTAMP," +
                        "PRIMARY KEY (id_pagamento)," +
                        "FOREIGN KEY (id_reserva) REFERENCES reserva(id_reserva)," +
                        "FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)" +
                        ");";
            default:
                return null;
        }
    }

    public void dispose() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
