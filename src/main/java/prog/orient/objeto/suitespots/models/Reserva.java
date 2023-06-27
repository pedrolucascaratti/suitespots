package prog.orient.objeto.suitespots.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class Reserva {
    private int id;
    private int id_cliente;
    private Timestamp data_reserva;
    private Timestamp data_entrada;
    private Timestamp data_saida;
    private int id_quarto;
    private int qnt_diarias;
    private double valor_total;
    private int ocupantes;
    private Double valor_adicional;
    private Double valor_desconto;
    private Double valor_diaria;
    private String observacao;

    private String createSqlQuery = "INSERT INTO reserva (id_cliente, data_reserva, data_entrada, data_saida, id_quarto, qnt_diarias, valor_total, ocupantes, valor_adicional, valor_desconto, valor_diaria, observacao) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private String readSqlQuery = "SELECT * FROM reserva WHERE id_reserva = ?";

    private String updateSqlQuery = "UPDATE reserva SET id_cliente = ?, data_entrada = ?, data_saida = ?, id_quarto = ?, qnt_diarias = ?, valor_total = ?, ocupantes = ?, valor_adicional = ?, valor_desconto = ?, valor_diaria = ?, observacao = ? WHERE id_reserva = ?";

    private String deleteSqlQuery = "DELETE FROM reserva WHERE id_reserva = ?";

    public Reserva(int id) {
        this.id = id;
    }

    public Reserva(int id, int id_cliente, Timestamp data_reserva, Timestamp data_entrada, Timestamp data_saida,
            int id_quarto, int qnt_diarias, double valor_total, int ocupantes, Double valor_adicional,
            Double valor_desconto, double valor_diaria, String observacao) {
        this.id_cliente = id_cliente;
        this.id = id;
        this.data_reserva = data_reserva;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.id_quarto = id_quarto;
        this.qnt_diarias = qnt_diarias;
        this.valor_total = valor_total;
        this.ocupantes = ocupantes;
        this.valor_adicional = valor_adicional;
        this.valor_desconto = valor_desconto;
        this.valor_diaria = valor_diaria;
        this.observacao = observacao;
        this.somaValorTotal();
    }

    public boolean create(Connection connection) {
        this.somaValorTotal();
        try (PreparedStatement pstmt = connection.prepareStatement(createSqlQuery)) {
            pstmt.setInt(1, this.id_cliente); // id_cliente
            pstmt.setTimestamp(2, this.data_reserva); // data_reserva
            pstmt.setTimestamp(3, this.data_entrada); // data_entrada
            pstmt.setTimestamp(4, this.data_saida); // data_saida
            pstmt.setInt(5, this.id_quarto); // id_quarto
            pstmt.setInt(6, this.qnt_diarias); // qnt_diarias
            pstmt.setDouble(7, this.valor_total); // valor_total
            pstmt.setInt(8, this.ocupantes); // ocupantes
            pstmt.setDouble(9, this.valor_adicional); // valor_adicional
            pstmt.setDouble(10, this.valor_desconto); // valor_desconto
            pstmt.setDouble(11, this.valor_diaria); // valor_desconto
            pstmt.setString(12, this.observacao); // observacao

            int rows = pstmt.executeUpdate();

            return rows > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Reserva read(Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(readSqlQuery)) {
            pstmt.setInt(1, this.id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                setId(rs.getInt("id_reserva"));
                setId_cliente(rs.getInt("id_cliente"));
                setData_reserva(rs.getTimestamp("data_reserva"));
                setData_entrada(rs.getTimestamp("data_entrada"));
                setData_saida(rs.getTimestamp("data_saida"));
                setId_quarto(rs.getInt("id_quarto"));
                setQnt_diarias(rs.getInt("qnt_diarias"));
                setValor_total(rs.getDouble("valor_total"));
                setOcupantes(rs.getInt("ocupantes"));
                setValor_adicional(rs.getDouble("valor_adicional"));
                setValor_desconto(rs.getDouble("valor_desconto"));
                setValor_diaria(rs.getDouble("valor_diaria"));
                setObservacao(rs.getString("observacao"));
                this.somaValorTotal();
                return this;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean update(Connection connection) {
        this.somaValorTotal();
        try (PreparedStatement pstmt = connection.prepareStatement(updateSqlQuery)) {
            pstmt.setInt(1, this.id_cliente);
            pstmt.setTimestamp(2, new java.sql.Timestamp(this.data_entrada.getTime()));
            pstmt.setTimestamp(3, new java.sql.Timestamp(this.data_saida.getTime()));
            pstmt.setInt(4, this.id_quarto);
            pstmt.setInt(5, this.qnt_diarias);
            pstmt.setDouble(6, this.valor_total);
            pstmt.setInt(7, this.ocupantes);
            pstmt.setDouble(8, this.valor_adicional);
            pstmt.setDouble(9, this.valor_desconto);
            pstmt.setDouble(10, this.valor_diaria);
            pstmt.setString(11, this.observacao);
            pstmt.setInt(12, this.id);

            int rows = pstmt.executeUpdate();

            return rows > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean delete(Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(deleteSqlQuery)) {
            pstmt.setInt(1, this.id);

            int rows = pstmt.executeUpdate();

            return rows > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Reserva copyWith(Integer id_cliente, Timestamp data_entrada, Timestamp data_saida,
            Integer id_quarto, Integer qnt_diarias, Double valor_total, Integer ocupantes, Double valor_adicional,
            Double valor_desconto, Double valor_diaria, String observacao) {
        Reserva res = new Reserva(
                this.id,
                id_cliente != null ? id_cliente : this.id_cliente,
                this.data_reserva,
                data_entrada != null ? data_entrada : this.data_entrada,
                data_saida != null ? data_saida : this.data_saida,
                id_quarto != null ? id_quarto : this.id_quarto,
                qnt_diarias != null ? qnt_diarias : this.qnt_diarias,
                valor_total != null ? valor_total : this.valor_total,
                ocupantes != null ? ocupantes : this.ocupantes,
                valor_adicional != null ? valor_adicional : this.valor_adicional,
                valor_desconto != null ? valor_desconto : this.valor_desconto,
                valor_diaria != null ? valor_diaria : this.valor_diaria,
                observacao != null ? observacao : this.observacao);
        res.somaValorTotal();
        return res;
    }

    public int getId() {
        return id;
    }

    private void setId(int id_reserva) {
        this.id = id_reserva;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public boolean setId_cliente(int id_cliente) {
        if (String.valueOf(id_cliente).length() <= 5 && id_cliente > 0) {
            this.id_cliente = id_cliente;
            return true;
        }
        return false;
    }

    public Timestamp getData_reserva() {
        return data_reserva;
    }

    private void setData_reserva(Timestamp data_reserva) {
        this.data_reserva = data_reserva;
    }

    public Timestamp getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Timestamp data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Timestamp getData_saida() {
        return data_saida;
    }

    public void setData_saida(Timestamp data_saida) {
        this.data_saida = data_saida;
    }

    public int getId_quarto() {
        return id_quarto;
    }

    public boolean setId_quarto(int id_quarto) {
        if (String.valueOf(id_quarto).length() <= 5 && id_quarto > 0) {
            this.id_quarto = id_quarto;
            return true;
        }
        return false;
    }

    public int getQnt_diarias() {
        return qnt_diarias;
    }

    public boolean setQnt_diarias(int qnt_diarias) {
        if (qnt_diarias >= 0 && qnt_diarias <= 99) {
            this.qnt_diarias = qnt_diarias;
            return true;
        }
        return false;
    }

    public double getValor_total() {
        return valor_total;
    }

    private boolean setValor_total(double valor_total) {
        if (valor_total >= 0.00) {
            this.valor_total = valor_total;
            return true;
        }
        return false;
    }

    public void somaValorTotal() {
        this.valor_total = (this.qnt_diarias > 0 && this.valor_diaria != null)
                ? this.valor_total += this.qnt_diarias * this.valor_diaria
                : this.valor_total;
        this.valor_total = (this.valor_adicional != null) ? this.valor_total += this.valor_adicional : this.valor_total;
        this.valor_total = (this.valor_desconto != null) ? this.valor_total -= this.valor_desconto : this.valor_total;
    }

    public int getOcupantes() {
        return ocupantes;
    }

    public boolean setOcupantes(int ocupantes) {
        if (ocupantes >= 0 && ocupantes <= 255) {
            this.ocupantes = ocupantes;
            return true;
        }
        return false;
    }

    public double getValor_adicional() {
        return valor_adicional;
    }

    public boolean setValor_adicional(Double valor_adicional) {
        if (valor_adicional >= 0.00 || valor_adicional == null) {
            this.valor_adicional = valor_adicional;
            return true;
        }
        return false;
    }

    public double getValor_desconto() {
        return valor_desconto;
    }

    public boolean setValor_desconto(Double valor_desconto) {
        if (valor_desconto >= 0.00 || valor_desconto == null) {
            this.valor_desconto = valor_desconto;
            return true;
        }
        return false;
    }

    public Double getValor_diaria() {
        return valor_diaria;
    }

    public boolean setValor_diaria(Double valor_diaria) {
        if (valor_diaria >= 0.00) {
            this.valor_diaria = valor_diaria;
            return true;
        }
        return false;
    }

    public String getObservacao() {
        return observacao;
    }

    public boolean setObservacao(String observacao) {
        this.observacao = observacao;
        return true;
    }
}
