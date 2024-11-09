package br.com.criptoverso.model;

public class Transacao {
    private int cd_transacao;
    private String dt_transacao;
    private String tp_transacao;
    private int quantidade;
    private ContaInvestimento conta_investimento;
    private Ativo ativo;

    public Transacao() {
    }

    public Transacao(int cd_transacao, String dt_transacao, String tp_transacao, int quantidade, ContaInvestimento conta_investimento, Ativo ativo) {
        this.cd_transacao = cd_transacao;
        this.dt_transacao = dt_transacao;
        this.tp_transacao = tp_transacao;
        this.quantidade = quantidade;
        this.conta_investimento = conta_investimento;
        this.ativo = ativo;
    }
    
    public Transacao(int cd_transacao, String dt_transacao, String tp_transacao, int quantidade) {
        this.cd_transacao = cd_transacao;
        this.dt_transacao = dt_transacao;
        this.tp_transacao = tp_transacao;
        this.quantidade = quantidade;
    }

    public int getCd_transacao() {
        return cd_transacao;
    }

    public void setCd_transacao(int cd_transacao) {
        this.cd_transacao = cd_transacao;
    }

    public String getDt_transacao() {
        return dt_transacao;
    }

    public void setDt_transacao(String dt_transacao) {
        this.dt_transacao = dt_transacao;
    }

    public String getTp_transacao() {
        return tp_transacao;
    }

    public void setTp_transacao(String tp_transacao) {
        this.tp_transacao = tp_transacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ContaInvestimento getConta_investimento() {
        return conta_investimento;
    }

    public void setConta_investimento(ContaInvestimento conta_investimento) {
        this.conta_investimento = conta_investimento;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }
    
    public double getValorTotal() {
    	return getQuantidade() * getAtivo().getPreco();
    }

    public String getResumo() {
        double valorTotal = this.getQuantidade() * this.getAtivo().getPreco();
        return "\nCódigo da Transação: " + this.getCd_transacao() +
        "\nCódigo da conta: " + this.getConta_investimento().getCd_conta() +
         "\nProprietário da conta: " + this.getConta_investimento().getUsuario().getNm_usuario() + 
         "\nData da Transação: " + this.getDt_transacao() + 
         "\nTipo da Transação: " + this.getTp_transacao() + 
         "\nDescrição do Ativo: " + this.getAtivo().getNm_ativo() +
         "\nQuantidade de Ativos: " + this.getQuantidade() + 
         "\nValor total: " + valorTotal +
         "\n";
    }
}
