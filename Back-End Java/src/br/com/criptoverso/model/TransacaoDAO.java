package br.com.criptoverso.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {
    private Connection conn;

    // Construtor que recebe a conexão
    public TransacaoDAO(Connection conn) {
        this.conn = conn;
    }

    // Método para inserir uma nova transação
    public void inserirTransacao(Transacao transacao) throws SQLException {
        String sql = "INSERT INTO T_Transacao (idTransacaoCarteira, idCriptoativo, valor, tipo, dataHora, quantidade) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            //stmt.setInt(1, transacao.getIdTransacaoCarteira());
            stmt.setInt(1, transacao.getAtivo().getCd_ativo());
            stmt.setDouble(2, transacao.getValorTotal());
            stmt.setString(3, transacao.getTp_transacao());
            stmt.setString(4, transacao.getDt_transacao());
            stmt.setDouble(5, transacao.getQuantidade());
            stmt.executeUpdate();
        }
    }

    // Método para atualizar uma transação existente
    public void atualizarTransacao(Transacao transacao) throws SQLException {
        String sql = "UPDATE T_Transacao SET idTransacaoCarteira = ?, idCriptoativo = ?, valor = ?, tipo = ?, dataHora = ?, quantidade = ? WHERE idTransacao = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setInt(1, transacao.getAtivo().getCd_ativo());
            stmt.setDouble(2, transacao.getValorTotal());
            stmt.setString(3, transacao.getTp_transacao());
            stmt.setString(4, transacao.getDt_transacao());
            stmt.setDouble(5, transacao.getQuantidade());
            stmt.executeUpdate();
        }
    }

    // Método para excluir uma transação
    public void excluirTransacao(int idTransacao) throws SQLException {
        String sql = "DELETE FROM T_Transacao WHERE idTransacao = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTransacao);
            stmt.executeUpdate();
        }
    }

    // Método para buscar uma transação pelo ID
    public Transacao buscarTransacaoPorId(int idTransacao) throws SQLException {
        String sql = "SELECT * FROM T_Transacao WHERE idTransacao = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTransacao);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Transacao(
                            rs.getInt("idTransacao"),
                            rs.getString("dataHora"),
                            rs.getString("tipo"),
                            rs.getInt("quantidade")
                    );
                }
            }
        }
        return null;  // Retorna null se não encontrar a transação
    }

    // Método para listar todas as transações
    public List<Transacao> listarTransacoes() throws SQLException {
        List<Transacao> transacoes = new ArrayList<>();
        String sql = "SELECT * FROM T_Transacao";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Transacao transacao = new Transacao(
                		rs.getInt("idTransacao"),
                        rs.getString("dataHora"),
                        rs.getString("tipo"),
                        rs.getInt("quantidade")
                );
                transacoes.add(transacao);
            }
        }
        return transacoes;
    }
}
