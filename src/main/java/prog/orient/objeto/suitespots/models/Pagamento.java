package prog.orient.objeto.suitespots.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Pagamento implements CRUDEntity {
    private int id;
    private int idReserva;
    private int idCliente;
    private double valorPagamento;
    private String formaPagamento;
    private Timestamp dataPagamento;

    private String createSqlQuery = "INSERT INTO pagamento (id_reserva, id_cliente, valor_pagamento, forma_pagamento) "
            + "VALUES (?, ?, ?, ?)";

    private String readSqlQuery = "SELECT * FROM pagamento WHERE id_pagamento = ?";

    private String updateSqlQuery = "UPDATE pagamento SET id_reserva = ?, id_cliente = ?, valor_pagamento = ?, forma_pagamento = ? WHERE id_pagamento = ?";

    private String deleteSqlQuery = "DELETE FROM pagamento WHERE id_pagamento = ?";

    public Pagamento(int id) {
        this.id = id;
    }

    public Pagamento(int id, int idReserva, int idCliente, double valorPagamento, String formaPagamento) {
        this.id = id;
        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.valorPagamento = valorPagamento;
        this.formaPagamento = formaPagamento;
    }

    private Pagamento(int id, int idReserva, int idCliente, double valorPagamento, String formaPagamento,
            Timestamp dataPagamento) {
        this.id = id;
        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.valorPagamento = valorPagamento;
        this.formaPagamento = formaPagamento;
        this.dataPagamento = dataPagamento;
    }

    public Pagamento copyWith(Integer id, Integer idReserva, Integer idCliente, Double valorPagamento,
            String formaPagamento,
            Timestamp dataPagamento) {
        Pagamento newPagamento = new Pagamento(id != null ? id : this.id,
                idReserva != null ? idReserva : this.idReserva, idCliente != null ? idCliente : this.idCliente,
                valorPagamento != null ? valorPagamento : this.valorPagamento,
                formaPagamento != null ? formaPagamento : this.formaPagamento,
                this.dataPagamento);
        return newPagamento;
    }

    @Override
    public boolean create(Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(createSqlQuery)) {
            pstmt.setInt(1, this.idReserva);
            pstmt.setInt(2, this.idCliente);
            pstmt.setDouble(3, this.valorPagamento);
            pstmt.setString(4, this.formaPagamento);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Pagamento " + this.getId() + " criado com sucesso!");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Pagamento " + this.getId() + " não foi criado!");
        return false;
    }

    @Override
    public Pagamento read(Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(readSqlQuery)) {
            pstmt.setInt(1, this.id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                this.id = rs.getInt("id_pagamento");
                this.idReserva = rs.getInt("id_reserva");
                this.idCliente = rs.getInt("id_cliente");
                this.valorPagamento = rs.getDouble("valor_pagamento");
                this.formaPagamento = rs.getString("forma_pagamento");
                this.dataPagamento = rs.getTimestamp("data_pagamento");

                System.out.println("Pagamento " + this.getId() + " encontrado!");
                return this;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Pagamento " + this.getId() + " não foi encontrado!");
        return null;
    }

    @Override
    public boolean update(Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(updateSqlQuery)) {
            pstmt.setInt(1, this.idReserva);
            pstmt.setInt(2, this.idCliente);
            pstmt.setDouble(3, this.valorPagamento);
            pstmt.setString(4, this.formaPagamento);
            pstmt.setInt(5, this.id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Pagamento " + this.getId() + " atualizado!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Pagamento " + this.getId() + " não foi atualizado!");
        return false;
    }

    @Override
    public boolean delete(Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(deleteSqlQuery)) {
            pstmt.setInt(1, this.id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Pagamento " + this.getId() + " deletado!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Pagamento " + this.getId() + " não foi deletado!");
        return false;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public boolean setIdReserva(int idReserva) {
        if (idReserva > 0 && idReserva <= 65535) {
            this.idReserva = idReserva;
            return true;
        }
        return false;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public boolean setIdCliente(int idCliente) {
        if (idCliente > 0 && idCliente <= 65535) {
            this.idCliente = idCliente;
            return true;
        }
        return false;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public boolean setValorPagamento(double valorPagamento) {
        if (valorPagamento >= 0.00) {
            this.valorPagamento = valorPagamento;
            return true;
        }
        return false;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public boolean setFormaPagamento(String formaPagamento) {
        if (formaPagamento.length() <= 15) {
            this.formaPagamento = formaPagamento;
            return true;
        }
        return false;
    }

    public Timestamp getDataPagamento() {
        return dataPagamento;
    }

    private boolean setDataPagamento(Timestamp dataPagamento) {
        this.dataPagamento = dataPagamento;
        return true;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "id=" + id + ", idReserva=" + idReserva + ", idCliente=" + idCliente
                + ", valorPagamento=" + valorPagamento + ", formaPagamento=" + formaPagamento
                + ", dataPagamento=" + dataPagamento + '}';
    }
}
