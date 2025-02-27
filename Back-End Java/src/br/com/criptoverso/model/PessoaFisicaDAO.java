package br.com.criptoverso.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.Date;

//import br.com.criptoverso.model.PessoaFisica;
//import br.com.criptoverso.model.Usuario;

public class PessoaFisicaDAO {
    private Connection conn;

    // Construtor que recebe uma conexão
    public PessoaFisicaDAO(Connection conn) {
        this.conn = conn;
    }

    // Método para inserir uma nova pessoa física
    public void inserirPessoaFisica(PessoaFisica pf) throws SQLException {
        String sql = "INSERT INTO T_USUARIO (nome, email, senha, telefone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pf.getNm_usuario());
            stmt.setString(2, pf.getEmail());
            stmt.setString(3, pf.getSenha());
            stmt.setString(4, pf.getNr_telefone());
            stmt.executeUpdate();
        }
        String sql2 = "INSERT INTO T_USUARIO_PF (idusuario, nr_cpf, dt_nascimento) VALUES (?, ?, TO_DATE(?, 'DD-MM-YYYY'))";
        try (PreparedStatement stmt2 = conn.prepareStatement(sql2)) {
        	stmt2.setInt(1, getLastCd_Usuario());     
            stmt2.setString(2, pf.getNr_cpf());
            stmt2.setString(3, pf.getDt_nascimento());
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

	// Método para atualizar uma pessoa física
    public void atualizarPessoaFisica(PessoaFisica pf) throws SQLException {
        String sql = "UPDATE PessoaFisica SET nome = ?, dataNasc = ?, cpfCnpj = ?, email = ?, senha = ?, telefone = ?, nr_cpf = ?, dt_nascimento = ? WHERE idUsuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setString(1, pf.getNm_usuario());
            stmt.setString(2, pf.getDt_nascimento());
            stmt.setString(3, pf.getNr_cpf());
            stmt.setString(4, pf.getEmail());
            stmt.setString(5, pf.getSenha());
            stmt.setString(6, pf.getNr_telefone());
            stmt.executeUpdate();
        }
    }

    // Método para excluir uma pessoa física pelo ID
    public void excluirPessoaFisica(int idUsuario) throws SQLException {
        String sql = "DELETE FROM PessoaFisica WHERE idUsuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
        }
    }

    // Método para buscar uma pessoa física pelo ID
    public PessoaFisica buscarPessoaFisicaPorId(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM PessoaFisica WHERE idUsuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PessoaFisica(
                            rs.getInt("idUsuario"),
                            rs.getString("email"),
                            rs.getString("senha"),
                            rs.getString("nome"),
                            rs.getString("telefone"),
                            rs.getString("nr_cpf"),
                            rs.getString("dt_nascimento")
                    );
                }
            }
        }
        return null; // Retorna null se não encontrar a pessoa física
    }

    // Método para listar todas as pessoas físicas
    public List<PessoaFisica> listarPessoasFisicas() throws SQLException {
        List<PessoaFisica> pessoasFisicas = new ArrayList<>();
        String sql = "SELECT * FROM PessoaFisica";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                PessoaFisica pf = new PessoaFisica(
                		rs.getInt("idUsuario"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("nr_cpf"),
                        rs.getString("dt_nascimento")
                );
                pessoasFisicas.add(pf);
            }
        }
        return pessoasFisicas;
    }
}
