package br.com.criptoverso.model;

public class TransacaoCarteira {
    private int idTransacaoCarteira;
    private Transacao idTransacao;
    private ContaInvestimento idCarteira;
    private char tipoOrigemDestino;

    // Constructor
    public TransacaoCarteira(int idTransacaoCarteira, Transacao idTransacao, ContaInvestimento idCarteira, char tipoOrigemDestino) {
        this.idTransacaoCarteira = idTransacaoCarteira;
        this.idTransacao = idTransacao;
        this.idCarteira = idCarteira;
        this.tipoOrigemDestino = tipoOrigemDestino;
    }
    
    public TransacaoCarteira(int idTransacaoCarteira, int idTransacao, int idCarteira, char tipoOrigemDestino) {
        this.idTransacaoCarteira = idTransacaoCarteira;
        idTransacao = this.idTransacao.getCd_transacao();
        idCarteira = this.idCarteira.getCd_conta();
        this.tipoOrigemDestino = tipoOrigemDestino;
    }

    // Constructor for insertion without idTransacaoCarteira
    public TransacaoCarteira(Transacao idTransacao, ContaInvestimento idCarteira, char tipoOrigemDestino) {
        this.idTransacao = idTransacao;
        this.idCarteira = idCarteira;
        this.tipoOrigemDestino = tipoOrigemDestino;
    }

    // Getters and Setters
    public int getIdTransacaoCarteira() {
        return idTransacaoCarteira;
    }

    public void setIdTransacaoCarteira(int idTransacaoCarteira) {
        this.idTransacaoCarteira = idTransacaoCarteira;
    }

    public Transacao getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Transacao idTransacao) {
        this.idTransacao = idTransacao;
    }

    public ContaInvestimento getIdCarteira() {
        return idCarteira;
    }

    public void setIdCarteira(ContaInvestimento idCarteira) {
        this.idCarteira = idCarteira;
    }

    public char getTipoOrigemDestino() {
        return tipoOrigemDestino;
    }

    public void setTipoOrigemDestino(char tipoOrigemDestino) {
        this.tipoOrigemDestino = tipoOrigemDestino;
    }
}
