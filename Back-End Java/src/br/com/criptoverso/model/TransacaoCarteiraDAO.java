package br.com.criptoverso.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoCarteiraDAO {
    private Connection conn;

    // Constructor to pass the database connection
    public TransacaoCarteiraDAO(Connection conn) {
        this.conn = conn;
    }

    // Insert a new TransacaoCarteira
    public void inserirTransacaoCarteira(TransacaoCarteira transacaoCarteira) throws SQLException {
        String sql = "INSERT INTO T_TransacaoCarteira (idTransacao, idCarteira, tipoOrigemDestino) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, transacaoCarteira.getIdTransacao().getCd_transacao());
            stmt.setInt(2, transacaoCarteira.getIdCarteira().getCd_conta());
            stmt.setString(3, String.valueOf(transacaoCarteira.getTipoOrigemDestino()));
            stmt.executeUpdate();
        }
    }

    // Update a TransacaoCarteira
    public void atualizarTransacaoCarteira(TransacaoCarteira transacaoCarteira) throws SQLException {
        String sql = "UPDATE T_TransacaoCarteira SET idTransacao = ?, idCarteira = ?, tipoOrigemDestino = ? WHERE idTransacaoCarteira = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, transacaoCarteira.getIdTransacao().getCd_transacao());
            stmt.setInt(2, transacaoCarteira.getIdCarteira().getCd_conta());
            stmt.setString(3, String.valueOf(transacaoCarteira.getTipoOrigemDestino()));
            stmt.setInt(4, transacaoCarteira.getIdTransacaoCarteira());
            stmt.executeUpdate();
        }
    }

    // Delete a TransacaoCarteira by ID
    public void excluirTransacaoCarteira(int idTransacaoCarteira) throws SQLException {
        String sql = "DELETE FROM T_TransacaoCarteira WHERE idTransacaoCarteira = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTransacaoCarteira);
            stmt.executeUpdate();
        }
    }

    // Retrieve a TransacaoCarteira by ID
    public TransacaoCarteira buscarTransacaoCarteiraPorId(int idTransacaoCarteira) throws SQLException {
        String sql = "SELECT * FROM T_TransacaoCarteira WHERE idTransacaoCarteira = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTransacaoCarteira);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new TransacaoCarteira(
                        rs.getInt("idTransacaoCarteira"),
                        rs.getInt("idTransacao"),
                        rs.getInt("idCarteira"),
                        rs.getString("tipoOrigemDestino").charAt(0)
                    );
                }
            }
        }
        return null;
    }

    // List all TransacaoCarteira entries
    public List<TransacaoCarteira> listarTransacaoCarteiras() throws SQLException {
        List<TransacaoCarteira> transacaoCarteiras = new ArrayList<>();
        String sql = "SELECT * FROM T_TransacaoCarteira";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                TransacaoCarteira transacaoCarteira = new TransacaoCarteira(
                    rs.getInt("idTransacaoCarteira"),
                    rs.getInt("idTransacao"),
                    rs.getInt("idCarteira"),
                    rs.getString("tipoOrigemDestino").charAt(0)
                );
                transacaoCarteiras.add(transacaoCarteira);
            }
        }
        return transacaoCarteiras;
    }
}
