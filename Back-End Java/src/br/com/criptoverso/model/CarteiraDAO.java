package br.com.criptoverso.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarteiraDAO {
    private Connection conn;

    // Construtor que recebe a conexão
    public CarteiraDAO(Connection conn) {
        this.conn = conn;
    }

    // Método para inserir uma nova carteira
    public void inserirCarteira(ContaInvestimento carteira) throws SQLException {
        String sql = "INSERT INTO T_Carteira (saldo, idCliente) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, carteira.getSaldo());
            stmt.setInt(2, carteira.getUsuario().getCd_usuario());
            stmt.executeUpdate();
        }
    }

    // Método para atualizar uma carteira existente
    public void atualizarCarteira(ContaInvestimento carteira) throws SQLException {
        String sql = "UPDATE T_Carteira SET saldo = ?, idCliente = ? WHERE idCarteira = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, carteira.getSaldo());
            stmt.setInt(2, carteira.getUsuario().getCd_usuario());
            stmt.setInt(3, carteira.getCd_conta());
            stmt.executeUpdate();
        }
    }

    // Método para excluir uma carteira pelo ID
    public void excluirCarteira(int idCarteira) throws SQLException {
        String sql = "DELETE FROM T_Carteira WHERE idCarteira = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCarteira);
            stmt.executeUpdate();
        }
    }

    // Método para buscar uma carteira pelo ID
    public ContaInvestimento buscarCarteiraPorId(int idCarteira) throws SQLException {
        String sql = "SELECT * FROM T_Carteira WHERE idCarteira = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCarteira);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ContaInvestimento(
                            rs.getInt("idCarteira"),
                            rs.getDouble("saldo"),
                            rs.getInt("idCliente")
                    );
                }
            }
        }
        return null;  // Retorna null se não encontrar a carteira
    }

    // Método para listar todas as carteiras
    public List<ContaInvestimento> listarCarteiras() throws SQLException {
        List<ContaInvestimento> carteiras = new ArrayList<>();
        String sql = "SELECT * FROM T_Carteira";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	ContaInvestimento carteira = new ContaInvestimento(
                        rs.getInt("idCarteira"),
                        rs.getDouble("saldo"),
                        rs.getInt("idCliente")
                );
                carteiras.add(carteira);
            }
        }
        return carteiras;
    }
}
