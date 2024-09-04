package br.com.criptoverso.model;

public class Endereco {
    private int cd_endereco;
    private String nm_pais;
    private String nm_estado;
    private String nm_cidade;
    private int nr_cep;
    private String nm_rua;
    private int nr_rua;

    public Endereco() {
    }

    public Endereco(int cd_endereco, String nm_pais, String nm_estado, String nm_cidade, int nr_cep, String nm_rua, int nr_rua) {
        this.cd_endereco = cd_endereco;
        this.nm_pais = nm_pais;
        this.nm_estado = nm_estado;
        this.nm_cidade = nm_cidade;
        this.nr_cep = nr_cep;
        this.nm_rua = nm_rua;
        this.nr_rua = nr_rua;
    }

    public int getCd_endereco() {
        return cd_endereco;
    }

    public void setCd_endereco(int cd_endereco) {
        this.cd_endereco = cd_endereco;
    }

    public String getNm_pais() {
        return nm_pais;
    }

    public void setNm_pais(String nm_pais) {
        this.nm_pais = nm_pais;
    }

    public String getNm_estado() {
        return nm_estado;
    }

    public void setNm_estado(String nm_estado) {
        this.nm_estado = nm_estado;
    }

    public String getNm_cidade() {
        return nm_cidade;
    }

    public void setNm_cidade(String nm_cidade) {
        this.nm_cidade = nm_cidade;
    }

    public int getNr_cep() {
        return nr_cep;
    }

    public void setNr_cep(int nr_cep) {
        this.nr_cep = nr_cep;
    }

    public String getNm_rua() {
        return nm_rua;
    }

    public void setNm_rua(String nm_rua) {
        this.nm_rua = nm_rua;
    }

    public int getNr_rua() {
        return nr_rua;
    }

    public void setNr_rua(int nr_rua) {
        this.nr_rua = nr_rua;
    }

    public String getEnderecoCompleto(){
        return "País: " + this.getNm_pais() + "\nEstado: " + this.getNm_estado() + "\nCidade: " + this.getNm_cidade() + "\nCEP: " + this.getNr_cep() + "\nEndereco: " + this.getNm_rua() + " " + this.getNr_rua();
    }
}
