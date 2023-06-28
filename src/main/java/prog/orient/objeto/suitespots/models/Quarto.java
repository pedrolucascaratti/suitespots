package prog.orient.objeto.suitespots.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Quarto implements CRUDEntity {
    private int id;
    private Integer id_reserva;
    private int numero_quarto;
    private int capacidade;
    private double valor_diaria;
    private String tipo;
    private String caracteristica;
    private String observacao;

    private String createSqlQuery = "INSERT INTO quarto (id_reserva, numero_quarto, capacidade, valor_diaria, tipo, caracteristica, observacao) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    private String readSqlQuery = "SELECT * FROM quarto WHERE id_quarto = ?";

    private String updateSqlQuery = "UPDATE quarto SET id_reserva = ?, numero_quarto = ?, capacidade = ?, valor_diaria = ?, tipo = ?, caracteristica = ?, observacao = ? WHERE id_quarto = ?";

    private String deleteSqlQuery = "DELETE FROM quarto WHERE id_quarto = ?";

    public Quarto(int id) {
        this.id = id;
    }

    public Quarto(int id, int id_reserva, int numero_quarto, int capacidade, double valor_diaria, String tipo,
            String caracteristica, String observacao) {
        this.id = id;
        this.id_reserva = id_reserva;
        this.numero_quarto = numero_quarto;
        this.capacidade = capacidade;
        this.valor_diaria = valor_diaria;
        this.tipo = tipo;
        this.caracteristica = caracteristica;
        this.observacao = observacao;
    }

    @Override
    public boolean create(Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(createSqlQuery)) {
            pstmt.setInt(1, this.id_reserva); // id_reserva
            pstmt.setInt(2, this.numero_quarto); // numero_quarto
            pstmt.setInt(3, this.capacidade); // capacidade
            pstmt.setDouble(4, this.valor_diaria); // valor_diaria
            pstmt.setString(5, this.tipo); // tipo
            pstmt.setString(6, this.caracteristica); // caracteristica
            pstmt.setString(7, this.observacao); // observacao

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Quarto " + this.getNumero_quarto() + " foi criado com sucesso!");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Quarto " + this.getNumero_quarto() + " não foi criado!");
        return false;
    }

    @Override
    public Quarto read(Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(readSqlQuery)) {
            pstmt.setInt(1, this.id);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                this.id_reserva = rs.getInt("id_reserva");
                this.numero_quarto = rs.getInt("numero_quarto");
                this.capacidade = rs.getInt("capacidade");
                this.valor_diaria = rs.getDouble("valor_diaria");
                this.tipo = rs.getString("tipo");
                this.caracteristica = rs.getString("caracteristica");
                this.observacao = rs.getString("observacao");

                System.out.println("Quarto " + this.getNumero_quarto() + " encontrado!");
                return this;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Quarto " + this.getId() + " não foi encontrado!");
        return null;
    }

    @Override
    public boolean update(Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(updateSqlQuery)) {
            pstmt.setInt(1, this.id_reserva);
            pstmt.setInt(2, this.numero_quarto);
            pstmt.setInt(3, this.capacidade);
            pstmt.setDouble(4, this.valor_diaria);
            pstmt.setString(5, this.tipo);
            pstmt.setString(6, this.caracteristica);
            pstmt.setString(7, this.observacao);
            pstmt.setInt(8, this.id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Quarto " + this.getNumero_quarto() + " atualizado!");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Quarto " + this.getId() + " não foi atualizado!");
        return false;
    }

    @Override
    public boolean delete(Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(deleteSqlQuery)) {
            pstmt.setInt(1, this.id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Quarto " + this.getNumero_quarto() + " deletado!");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Quarto " + this.getId() + " não foi deletado!");
        return false;
    }

    public Quarto copyWith(Integer id_reserva, Integer numero_quarto, Integer capacidade,
            Double valor_diaria, String tipo,
            String caracteristica, String observacao) {
        return new Quarto(
                this.id,
                id_reserva != null ? id_reserva : this.id_reserva,
                numero_quarto != null ? numero_quarto : this.numero_quarto,
                capacidade != null ? capacidade : this.capacidade,
                valor_diaria != null ? valor_diaria : this.valor_diaria,
                tipo != null ? tipo : this.tipo,
                caracteristica != null ? caracteristica : this.caracteristica,
                observacao != null ? observacao : this.observacao);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public Integer getId_reserva() {
        return id_reserva;
    }

    public boolean setId_reserva(Integer id_reserva) {
        if (id_reserva == null || id_reserva >= 0 && id_reserva <= 65535) {
            this.id_reserva = id_reserva;
            return true;
        }
        return false;
    }

    public int getNumero_quarto() {
        return numero_quarto;
    }

    public boolean setNumero_quarto(int numero_quarto) {
        if (numero_quarto >= 0 && numero_quarto <= 9999) {
            this.numero_quarto = numero_quarto;
            return true;
        }
        return false;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean setCapacidade(int capacidade) {
        if (capacidade >= 0 && capacidade <= 99) {
            this.capacidade = capacidade;
            return true;
        }
        return false;
    }

    public double getValor_diaria() {
        return valor_diaria;
    }

    public boolean setValor_diaria(double valor_diaria) {
        if (String.valueOf(valor_diaria).length() <= 10 && valor_diaria > 0.00) {
            this.valor_diaria = valor_diaria;
            return true;
        }
        return false;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean setTipo(String tipo) {
        if (tipo == null || tipo.length() <= 20) {
            this.tipo = tipo;
            return true;
        }
        return false;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public boolean setCaracteristica(String caracteristica) {
        if (caracteristica == null || caracteristica.length() <= 20) {
            this.caracteristica = caracteristica;
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

    @Override
    public String toString() {
        return "Quarto [id=" + id + ", id_reserva=" + id_reserva + ", numero_quarto=" + numero_quarto + ", capacidade="
                + capacidade + ", decimal=" + valor_diaria + ", tipo=" + tipo + ", caracteristica=" + caracteristica
                + ", observacao=" + observacao + "]";
    }
}
