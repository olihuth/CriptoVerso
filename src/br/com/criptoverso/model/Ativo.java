package br.com.criptoverso.model;

public class Ativo {
    private int cd_ativo;
    private String nm_ativo;
    private double preco;

    public Ativo() {
    }

    // Cadastrar Ativo
    public Ativo(int cd_ativo, String nm_ativo, double preco) {
        this.cd_ativo = cd_ativo;
        this.nm_ativo = nm_ativo;
        this.preco = preco;
    }

    public int getCd_ativo() {
        return cd_ativo;
    }

    public void setCd_ativo(int cd_ativo) {
        this.cd_ativo = cd_ativo;
    }

    public String getNm_ativo() {
        return nm_ativo;
    }

    public void setNm_ativo(String nm_ativo) {
        this.nm_ativo = nm_ativo;
    }

    public double getPreco() {
        return preco;
    }

    //Alterar Preço
    public void setPreco(double preco) {
        this.preco = preco;
    }


}
