package br.com.criptoverso.model;

import br.com.criptoverso.model.Endereco; //why did u import this?

public abstract class Usuario {
    private int cd_usuario;
    private String email;
    private String senha;
    private String nm_usuario;
    private int nr_telefone;
    private int nr_ddd;
    private Endereco endereco;

    public Usuario() {
    }

    public Usuario(int cd_usuario, String email, String senha, String nm_usuario, int nr_telefone, int nr_ddd, Endereco endereco) {
        this.cd_usuario = cd_usuario;
        this.email = email;
        this.senha = senha;
        this.nm_usuario = nm_usuario;
        this.nr_telefone = nr_telefone;
        this.nr_ddd = nr_ddd;
        this.endereco = endereco;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNm_usuario() {
        return nm_usuario;
    }

    public void setNm_usuario(String nm_usuario) {
        this.nm_usuario = nm_usuario;
    }

    public int getNr_telefone() {
        return nr_telefone;
    }

    public void setNr_telefone(int nr_telefone) {
        this.nr_telefone = nr_telefone;
    }

    public int getNr_ddd() {
        return nr_ddd;
    }

    public void setNr_ddd(int nr_ddd) {
        this.nr_ddd = nr_ddd;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public abstract String getResumo(Endereco endereco);
}
