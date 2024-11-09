package br.com.criptoverso.model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CriptoativoDAO {
    private Connection conn;

    // Construtor que recebe a conexão
    public CriptoativoDAO(Connection conn) {
        this.conn = conn;
    }

    // Método para inserir um novo criptoativo
    public void inserirCriptoativo(Ativo criptoativo) throws SQLException {
        String sql = "INSERT INTO T_Criptoativo (nome, tipo, valorAtual) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, criptoativo.getNm_ativo());
            stmt.setString(2, criptoativo.getTipo_ativo());
            stmt.setDouble(3, criptoativo.getPreco());
            stmt.executeUpdate();
        }
    }

    // Método para atualizar um criptoativo existente
    public void atualizarCriptoativo(Ativo criptoativo) throws SQLException {
        String sql = "UPDATE T_Criptoativo SET nome = ?, tipo = ?, valorAtual = ? WHERE idCriptoativo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, criptoativo.getNm_ativo());
            stmt.setString(2, criptoativo.getTipo_ativo());
            stmt.setDouble(3, criptoativo.getPreco());
            stmt.setInt(4, criptoativo.getCd_ativo());
            stmt.executeUpdate();
        }
    }

    // Método para excluir um criptoativo pelo ID
    public void excluirCriptoativo(int idCriptoativo) throws SQLException {
        String sql = "DELETE FROM T_Criptoativo WHERE idCriptoativo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCriptoativo);
            stmt.executeUpdate();
        }
    }

    // Método para buscar um criptoativo pelo ID
    public Ativo buscarCriptoativoPorId(int idCriptoativo) throws SQLException {
        String sql = "SELECT * FROM T_Criptoativo WHERE idCriptoativo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCriptoativo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Ativo(
                            rs.getInt("idCriptoativo"),
                            rs.getString("nome"),
                            rs.getString("tipo"),
                            rs.getDouble("valorAtual")
                    );
                }
            }
        }
        return null;  // Retorna null se não encontrar o criptoativo
    }

    // Método para listar todos os criptoativos
    public List<Ativo> listarCriptoativos() throws SQLException {
        List<Ativo> criptoativos = new ArrayList<>();
        String sql = "SELECT * FROM T_Criptoativo";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Ativo criptoativo = new Ativo(
                        rs.getInt("idCriptoativo"),
                        rs.getString("nome"),
                        rs.getString("tipo"),
                        rs.getDouble("valorAtual")
                );
                criptoativos.add(criptoativo);
            }
        }
        return criptoativos;
    }
}
