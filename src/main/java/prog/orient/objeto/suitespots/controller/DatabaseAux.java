/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.orient.objeto.suitespots.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import prog.orient.objeto.suitespots.models.Cliente;
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

    // C - CREATE - OK

    public boolean createCliente(Cliente cliente) {
        boolean state = cliente.create(this.connection);
        if (state) {
            System.out.println("Cliente " + cliente.getNome() + " criado com sucesso!");
        } else {
            System.out.println("Cliente " + cliente.getNome() + " não foi criado!");
        }

        return state;
    }

    public boolean createQuarto(Quarto quarto) {
        boolean state = quarto.create(this.connection);
        if (state) {
            System.out.println("Quarto " + quarto.getNumero_quarto() + " criado com sucesso!");
        } else {
            System.out.println("Quarto " + quarto.getNumero_quarto() + " não foi criado!");
        }

        return state;
    }

    public boolean createReserva(Reserva reserva) {
        boolean state = reserva.create(this.connection);
        if (state) {
            System.out.println("Reserva " + reserva.getId() + " criada com sucesso!");
        } else {
            System.out.println("Reserva " + reserva.getId() + " não foi criada!");
        }

        return state;
    }

    // R - READ - OK

    public Cliente readCliente(Cliente cliente) {
        Cliente mCliente = cliente.read(this.connection);
        if (mCliente != null) {
            System.out.println("Cliente " + mCliente.getNome() + " encontrado!");
        } else {
            System.out.println("Cliente " + cliente.getId() + " não foi encontrado!");
        }

        return mCliente;
    }

    public Quarto readQuarto(Quarto quarto) {
        Quarto mQuarto = quarto.read(this.connection);
        if (mQuarto != null) {
            System.out.println("Quarto " + mQuarto.getNumero_quarto() + " encontrado!");
        } else {
            System.out.println("Quarto " + quarto.getNumero_quarto() + " não foi encontrado!");
        }

        return mQuarto;
    }

    public Reserva readReserva(Reserva reserva) {
        Reserva mReserva = reserva.read(this.connection);
        if (mReserva != null) {
            System.out.println("Reserva " + mReserva.getId() + " encontrada!");
        } else {
            System.out.println("Reserva " + reserva.getId() + " não foi encontrada!");
        }

        return mReserva;
    }

    // U - UPDATE - OK

    public boolean updateCliente(Cliente cliente) {
        boolean state = cliente.update(this.connection);
        if (state) {
            System.out.println("Cliente " + cliente.getNome() + " atualizado!");
        } else {
            System.out.println("Cliente " + cliente.getId() + " não foi atualizado!");
        }

        return state;
    }

    public boolean updateQuarto(Quarto quarto) {
        boolean state = quarto.update(this.connection);
        if (state) {
            System.out.println("Quarto " + quarto.getNumero_quarto() + " atualizado!");
        } else {
            System.out.println("Quarto " + quarto.getId() + " não foi atualizado!");
        }

        return state;
    }

    public boolean updateReserva(Reserva reserva) {
        boolean state = reserva.update(this.connection);
        if (state) {
            System.out.println("Reserva " + reserva.getId() + " atualizada!");
        } else {
            System.out.println("Reserva " + reserva.getId() + " não foi atualizada!");
        }

        return state;
    }

    // D - DELETE - OK

    public boolean deleteCliente(Cliente cliente) {
        boolean state = cliente.delete(this.connection);
        if (state) {
            System.out.println("Cliente " + cliente.getNome() + " deletado!");
        } else {
            System.out.println("Cliente " + cliente.getId() + " não foi deletado!");
        }

        return state;
    }

    public boolean deleteQuarto(Quarto quarto) {
        boolean state = quarto.delete(this.connection);
        if (state) {
            System.out.println("Quarto " + quarto.getNumero_quarto() + " deletado!");
        } else {
            System.out.println("Quarto " + quarto.getId() + " não foi deletado!");
        }

        return state;
    }

    public boolean deleteReserva(Reserva reserva) {
        boolean state = reserva.delete(this.connection);
        if (state) {
            System.out.println("Reserva " + reserva.getId() + " deletada!");
        } else {
            System.out.println("Reserva " + reserva.getId() + " não foi deletada!");
        }

        return state;
    }

    private void verifyTablesExists() {
        try (Statement stmt = this.connection.createStatement()) {

            for (String table : tables) {
                try (ResultSet resultSet = stmt.executeQuery("SHOW TABLES LIKE '" + table + "'");) {
                    if (!resultSet.next()) {
                        System.out.println("Table: " + table + " não existe!");
                        String query = getCreateTableQuery(table);
                        if (query != null && table != "pagamento") {
                            stmt.executeUpdate(query);
                        }
                    } else {
                        System.out.println("Table: " + table + " existe!");
                    }
                }
            }
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
                        "PRIMARY KEY (id_quarto)" +
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
                        "PRIMARY KEY (id_reserva)" +
                        ")";
            case "pagamento":
                return "";
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
