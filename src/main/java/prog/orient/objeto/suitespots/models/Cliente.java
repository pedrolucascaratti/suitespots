/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.orient.objeto.suitespots.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author pedro
 */
public class Cliente {
    private int id;
    private String nome;
    private String apelido;
    private String cpf;
    private String telefone;
    private char sexo;
    private String email;
    private int situacao;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String observacoes;

    private String createSqlQuery = "INSERT INTO cliente (nome, apelido, cpf, telefone, sexo, email, situacao, logradouro, numero, bairro, cidade, estado, observacoes) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private String readSqlQuery = "SELECT * FROM cliente WHERE id_cliente = ?";

    private String updateSqlQuery = "UPDATE cliente SET nome = ?, apelido = ?, cpf = ?, telefone = ?, sexo = ?, email = ?, situacao = ?, logradouro = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, observacoes = ? WHERE id_cliente = ?";

    private String deleteSqlQuery = "DELETE FROM cliente WHERE id_cliente = ?";

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(int id, String nome, String apelido, String cpf, String telefone, char sexo, String email,
            int situacao, String logradouro, int numero, String bairro, String cidade, String estado,
            String observacoes) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
        this.email = email;
        this.situacao = situacao;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.observacoes = observacoes;
    }

    public boolean create(Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(createSqlQuery)) {
            pstmt.setString(1, this.nome);
            pstmt.setString(2, this.apelido);
            pstmt.setString(3, this.cpf);
            pstmt.setString(4, this.telefone);
            pstmt.setString(5, String.valueOf(this.sexo));
            pstmt.setString(6, this.email);
            pstmt.setInt(7, this.situacao);
            pstmt.setString(8, this.logradouro);
            pstmt.setInt(9, this.numero);
            pstmt.setString(10, this.bairro);
            pstmt.setString(11, this.cidade);
            pstmt.setString(12, this.estado);
            pstmt.setString(13, this.observacoes);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean update(Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(updateSqlQuery)) {
            pstmt.setString(1, this.nome);
            pstmt.setString(2, this.apelido);
            pstmt.setString(3, this.cpf);
            pstmt.setString(4, this.telefone);
            pstmt.setString(5, String.valueOf(this.sexo));
            pstmt.setString(6, this.email);
            pstmt.setInt(7, this.situacao);
            pstmt.setString(8, this.logradouro);
            pstmt.setInt(9, this.numero);
            pstmt.setString(10, this.bairro);
            pstmt.setString(11, this.cidade);
            pstmt.setString(12, this.estado);
            pstmt.setString(13, this.observacoes);
            pstmt.setInt(14, this.id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Cliente read(Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(readSqlQuery)) {
            pstmt.setInt(1, this.id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                this.nome = rs.getString("nome");
                this.apelido = rs.getString("apelido");
                this.cpf = rs.getString("cpf");
                this.telefone = rs.getString("telefone");
                this.sexo = rs.getString("sexo").charAt(0);
                this.email = rs.getString("email");
                this.situacao = rs.getInt("situacao");
                this.logradouro = rs.getString("logradouro");
                this.numero = rs.getInt("numero");
                this.bairro = rs.getString("bairro");
                this.cidade = rs.getString("cidade");
                this.estado = rs.getString("estado");
                this.observacoes = rs.getString("observacoes");
            }
            return this;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean delete(Connection connection) {
        try (PreparedStatement pstmt = connection.prepareStatement(deleteSqlQuery)) {
            pstmt.setInt(1, this.id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Cliente copyWith(String nome, String apelido, String cpf, String telefone, Character sexo, String email,
            Integer situacao, String logradouro, Integer numero, String bairro, String cidade, String estado,
            String observacoes) {
        return new Cliente(
                this.id,
                nome != null ? nome : this.nome,
                apelido != null ? apelido : this.apelido,
                cpf != null ? cpf : this.cpf,
                telefone != null ? telefone : this.telefone,
                sexo != null ? sexo : this.sexo,
                email != null ? email : this.email,
                situacao != null ? situacao : this.situacao,
                logradouro != null ? logradouro : this.logradouro,
                numero != null ? numero : this.numero,
                bairro != null ? bairro : this.bairro,
                cidade != null ? cidade : this.cidade,
                estado != null ? estado : this.estado,
                observacoes != null ? observacoes : this.observacoes);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome) {
        if (nome.length() <= 40) {
            this.nome = nome;
            return true;
        }
        return false;
    }

    public String getApelido() {
        return apelido;
    }

    public boolean setApelido(String apelido) {
        if (apelido == null || apelido.length() <= 15) {
            this.apelido = apelido;
            return true;
        }
        return false;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean setCpf(String cpf) {
        if (cpf.length() <= 11) {
            this.cpf = cpf;
            return true;
        }
        return false;
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean setTelefone(String telefone) {
        if (telefone == null || telefone.length() <= 18) {
            this.telefone = telefone;
            return true;
        }
        return false;
    }

    public char getSexo() {
        return sexo;
    }

    public boolean setSexo(char sexo) {
        if (sexo == 'M' || sexo == 'F' || sexo == 'O') {
            this.sexo = sexo;
            return true;
        }
        return false;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (email == null || email.length() <= 60) {
            this.email = email;
            return true;
        }
        return false;
    }

    public int getSituacao() {
        return situacao;
    }

    public boolean setSituacao(int situacao) {
        if (situacao >= 0 && situacao <= 2) {
            this.situacao = situacao;
            return true;
        }
        return false;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public boolean setLogradouro(String logradouro) {
        if (logradouro.length() <= 25) {
            this.logradouro = logradouro;
            return true;
        }
        return false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean setNumero(int numero) {
        if (String.valueOf(numero).length() <= 8) {
            this.numero = numero;
            return true;
        }
        return false;
    }

    public String getBairro() {
        return bairro;
    }

    public boolean setBairro(String bairro) {
        if (bairro.length() <= 20) {
            this.bairro = bairro;
            return true;
        }
        return false;
    }

    public String getCidade() {
        return cidade;
    }

    public boolean setCidade(String cidade) {
        if (cidade.length() <= 30) {
            this.cidade = cidade;
            return true;
        }
        return false;
    }

    public String getEstado() {
        return estado;
    }

    public boolean setEstado(String estado) {
        if (estado.length() <= 2) {
            this.estado = estado;
            return true;
        }
        return false;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public boolean setObservacoes(String observacoes) {
        this.observacoes = observacoes;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", cpf=" + cpf + ", telefone="
                + telefone + ", sexo=" + sexo + ", email=" + email + ", situacao=" + situacao + ", logradouro="
                + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado
                + ", observacoes=" + observacoes + '}';
    }
}
