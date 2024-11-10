package br.com.criptoverso.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.Date;

//import br.com.criptoverso.model.PessoaFisica;
//import br.com.criptoverso.model.Usuario;

public class UsuarioDAO {
    private Connection conn;

    // Construtor que recebe uma conexão
    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    public int getCd_Usuario() throws SQLException {
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
