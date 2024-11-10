package br.com.criptoverso.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import br.com.criptoverso.model.PessoaJuridica;
//import br.com.criptoverso.model.Usuario;

public class PessoaJuridicaDAO {
    private Connection conn;

    // Construtor que recebe uma conexão
    public PessoaJuridicaDAO(Connection conn) {
        this.conn = conn;
    }

    // Método para inserir uma nova pessoa jurídica
    public void inserirPessoaJuridica(PessoaJuridica pj) throws SQLException {
    	String sql = "INSERT INTO T_USUARIO (nome, email, senha, telefone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pj.getNm_usuario());
            stmt.setString(2, pj.getEmail());
            stmt.setString(3, pj.getSenha());
            stmt.setString(4, pj.getNr_telefone());
            stmt.executeUpdate();
        }
        String sql2 = "INSERT INTO T_USUARIO_PJ (idusuario, nr_cnpj, nm_fantasia) VALUES (?, ?, ?)";
        try (PreparedStatement stmt2 = conn.prepareStatement(sql2)) {
            stmt2.setInt(1, getLastCd_Usuario());
            stmt2.setString(2, pj.getNr_cnpj());
            stmt2.setString(3, pj.getNm_fantasia());
            stmt2.executeUpdate();
        }
    }
    
    private int getLastCd_Usuario() throws SQLException {
    	String sql = "SELECT idusuario FROM T_USUARIO WHERE idusuario = (SELECT MAX(idusuario) FROM T_USUARIO)";
    	try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            //stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return  rs.getInt("idUsuario");
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        throw new SQLException();
    }

    // Método para atualizar uma pessoa jurídica
    public void atualizarPessoaJuridica(PessoaJuridica pj) throws SQLException {
        String sql = "UPDATE PessoaJuridica SET nome = ?, dataNasc = ?, cpfCnpj = ?, email = ?, senha = ?, telefone = ?, nr_cnpj = ?, nm_fantasia = ? WHERE idUsuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pj.getNm_usuario());
            stmt.setString(2, pj.getNr_cnpj());
            stmt.setString(3, pj.getEmail());
            stmt.setString(4, pj.getSenha());
            stmt.setString(5, pj.getNr_telefone());
            stmt.setString(7, pj.getNm_fantasia());
            stmt.setInt(8, pj.getCd_usuario());
            stmt.executeUpdate();
        }
    }

    // Método para excluir uma pessoa jurídica pelo ID
    public void excluirPessoaJuridica(int idUsuario) throws SQLException {
        String sql = "DELETE FROM PessoaJuridica WHERE idUsuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
        }
    }

    // Método para buscar uma pessoa jurídica pelo ID
    public PessoaJuridica buscarPessoaJuridicaPorId(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM PessoaJuridica WHERE idUsuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PessoaJuridica(
                            rs.getInt("idUsuario"),
                            rs.getString("email"),
                            rs.getString("senha"),
                            rs.getString("nome"),
                            rs.getString("telefone"),
                            rs.getString("nr_cnpj"),
                            rs.getString("nm_fantasia")
                    );
                }
            }
        }
        return null; // Retorna null se não encontrar a pessoa jurídica
    }

    // Método para listar todas as pessoas jurídicas
    public List<PessoaJuridica> listarPessoasJuridicas() throws SQLException {
        List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();
        String sql = "SELECT * FROM PessoaJuridica";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                PessoaJuridica pj = new PessoaJuridica(
                		rs.getInt("idUsuario"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("nr_cnpj"),
                        rs.getString("nm_fantasia")
                );
                pessoasJuridicas.add(pj);
            }
        }
        return pessoasJuridicas;
    }
}

