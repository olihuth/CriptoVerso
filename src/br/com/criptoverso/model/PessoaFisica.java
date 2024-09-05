package br.com.criptoverso.model;

public class PessoaFisica extends Usuario{
    private int nr_cpf;
    private String dt_nascimento;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(int cd_usuario, String email, String senha, String nm_usuario, int nr_telefone, int nr_ddd, Endereco endereco, int nr_cpf, String dt_nascimento) {
        super(cd_usuario, email, senha, nm_usuario, nr_telefone, nr_ddd, endereco);
        this.nr_cpf = nr_cpf;
        this.dt_nascimento = dt_nascimento;
    }

    public int getNr_cpf() {
        return nr_cpf;
    }

    public void setNr_cpf(int nr_cpf) {
        this.nr_cpf = nr_cpf;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    @Override
    public String getResumo(){
        return "ID: " + this.getCd_usuario() + "\nNome: " + this.getNm_usuario() + "\nE-mail: " + this.getEmail() + "\nData de nascimento: " + this.getDt_nascimento() + "\nCPF: " + this.getNr_cpf() + "\nSenha: " + this.getSenha() + "\nTelefone: (" + this.getNr_ddd() + ")" + this.getNr_telefone() + "\n" + this.getEndereco();
    }
}
