package br.com.criptoverso.model;

public class ContaInvestimento {
    private int cd_conta;
    private String dt_abertura;
    private double saldo;
    private String tp_moeda;
    private Usuario usuario;
    private int id_usuario;

    public ContaInvestimento() {
    }

    public ContaInvestimento(int cd_conta, String dt_abertura, double saldo, String tp_moeda, Usuario usuario) {
        this.cd_conta = cd_conta;
        this.dt_abertura = dt_abertura;
        this.saldo = saldo;
        this.tp_moeda = tp_moeda;
        this.usuario = usuario;
    }
    
    public ContaInvestimento(int cd_conta, double saldo, int usuario) {
        this.cd_conta = cd_conta;
        this.saldo = saldo;
        //usuario = this.usuario.getCd_usuario();
        this.setId_usuarioCi(usuario);
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

    public String getResumo() {
        //return "\nCódigo da conta: " + this.getCd_conta() + "\nProprietário da conta: " + this.getUsuario().getNm_usuario() + "\nData da Abertura da Conta: " + this.getDt_abertura() + "\nSaldo: " + this.getSaldo() + "\n" + this.getTp_moeda() + "\n";
    	return "\nCódigo da conta: " + this.getCd_conta() + "\nSaldo: " + this.getSaldo();
    }

    public boolean validaConta(int cd_conta) {
        if(getCd_conta() == cd_conta){
            return true;
        } else return false;
    }

    public void addSaldo(double deposito) {
        double novoSaldo = getSaldo() + deposito;
        setSaldo(novoSaldo);
    }

	public int getId_usuarioCi() {
		return id_usuario;
	}

	public void setId_usuarioCi(int id_usuario) {
		this.id_usuario = id_usuario;
	}

}
