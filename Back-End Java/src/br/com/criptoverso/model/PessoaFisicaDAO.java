package br.com.criptoverso.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import br.com.criptoverso.model.PessoaFisica;
import br.com.criptoverso.model.Usuario;

public class PessoaFisicaDAO {
    private Connection conn;

    // Construtor que recebe uma conexão
    public PessoaFisicaDAO(Connection conn) {
        this.conn = conn;
    }

    // Método para inserir uma nova pessoa física
    public void inserirPessoaFisica(PessoaFisica pf) throws SQLException {
        String sql = "INSERT INTO PessoaFisica (nome, dataNasc, cpfCnpj, email, senha, telefone, nr_cpf, dt_nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pf.getNm_usuario());
            stmt.setString(2, pf.getDt_nascimento());
            stmt.setInt(3, pf.getNr_cpf());
            stmt.setString(4, pf.getEmail());
            stmt.setString(5, pf.getSenha());
            stmt.setString(6, pf.getNr_telefone());
            stmt.executeUpdate();
        }
    }

    // Método para atualizar uma pessoa física
    public void atualizarPessoaFisica(PessoaFisica pf) throws SQLException {
        String sql = "UPDATE PessoaFisica SET nome = ?, dataNasc = ?, cpfCnpj = ?, email = ?, senha = ?, telefone = ?, nr_cpf = ?, dt_nascimento = ? WHERE idUsuario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setString(1, pf.getNm_usuario());
            stmt.setString(2, pf.getDt_nascimento());
            stmt.setInt(3, pf.getNr_cpf());
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
                            rs.getInt("nr_cpf"),
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
                        rs.getInt("nr_cpf"),
                        rs.getString("dt_nascimento")
                );
                pessoasFisicas.add(pf);
            }
        }
        return pessoasFisicas;
    }
}
