package br.com.criptoverso.model;

public class ContaInvestimento {
    private int cd_conta;
    private String dt_abertura;
    private double saldo;
    private String tp_moeda;
    private Usuario usuario;

    public ContaInvestimento() {
    }

    public ContaInvestimento(int cd_conta, String dt_abertura, String tp_moeda, Usuario usuario) {
        this.cd_conta = cd_conta;
        this.dt_abertura = dt_abertura;
        saldo = 0;
        this.tp_moeda = tp_moeda;
        this.usuario = usuario;
    }

    public int getCd_conta() {
        return cd_conta;
    }

    public void setCd_conta(int cd_conta) {
        this.cd_conta = cd_conta;
    }

    public String getDt_abertura() {
        return dt_abertura;
    }

    public void setDt_abertura(String dt_abertura) {
        this.dt_abertura = dt_abertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTp_moeda() {
        return tp_moeda;
    }

    public void setTp_moeda(String tp_moeda) {
        this.tp_moeda = tp_moeda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



}
