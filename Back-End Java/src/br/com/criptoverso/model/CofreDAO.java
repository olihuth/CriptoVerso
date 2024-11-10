package br.com.criptoverso.model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CofreDAO {
    private Connection conn;

    // Construtor que recebe a conexão
    public CofreDAO(Connection conn) {
        this.conn = conn;
    }

    // Método para inserir um novo cofre
    public void inserirCofre(Cofre cofre) throws SQLException {
        String sql = "INSERT INTO T_Cofre (idCarteira, chaveCarteira) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cofre.getCarteira().getCd_conta());
            stmt.setString(2, cofre.getChaveCarteira());
            stmt.executeUpdate();
        }
    }

    // Método para atualizar um cofre existente
    public void atualizarCofre(Cofre cofre) throws SQLException {
        String sql = "UPDATE T_Cofre SET idCarteira = ?, chaveCarteira = ? WHERE idCofre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cofre.getCarteira().getCd_conta());
            stmt.setString(2, cofre.getChaveCarteira());
            stmt.setInt(3, cofre.getIdCofre());
            stmt.executeUpdate();
        }
    }

    // Método para excluir um cofre pelo ID
    public void excluirCofre(int idCofre) throws SQLException {
        String sql = "DELETE FROM T_Cofre WHERE idCofre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCofre);
            stmt.executeUpdate();
        }
    }

    // Método para buscar um cofre pelo ID
    public Cofre buscarCofrePorId(int idCofre) throws SQLException {
        String sql = "SELECT * FROM T_Cofre WHERE idCofre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCofre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cofre(
                        rs.getInt("idCofre"),
                        rs.getInt("carteira"),
                        rs.getString("chaveCarteira")
                    );
                }
            }
        }
        return null; // Retorna null se não encontrar o cofre
    }

    // Método para listar todos os cofres
    public List<Cofre> listarCofres() throws SQLException {
        List<Cofre> cofres = new ArrayList<>();
        String sql = "SELECT * FROM T_Cofre";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cofre cofre = new Cofre(
                    rs.getInt("idCofre"),
                    rs.getInt("carteira"),
                    rs.getString("chaveCarteira")
                );
                cofres.add(cofre);
            }
        }
        return cofres;
    }
}
