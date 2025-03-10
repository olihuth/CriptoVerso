package br.com.criptoverso.model;

public class PessoaJuridica extends Usuario{
    private String nr_cnpj;
    private String nm_fantasia;

    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(int cd_usuario, String email, String senha, String nm_usuario, String nr_telefone, int nr_ddd, Endereco endereco, String nr_cnpj, String nm_fantasia) {
        super(cd_usuario, email, senha, nm_usuario, nr_telefone, nr_ddd, endereco);
        this.nr_cnpj = nr_cnpj;
        this.nm_fantasia = nm_fantasia;
    }
    
    public PessoaJuridica(int cd_usuario, String email, String senha, String nm_usuario, String nr_telefone, String nr_cnpj, String nm_fantasia) {
        super(cd_usuario, email, senha, nm_usuario, nr_telefone);
        this.nr_cnpj = nr_cnpj;
        this.nm_fantasia = nm_fantasia;
    }

    public String getNr_cnpj() {
        return nr_cnpj;
    }

    public void setNr_cnpj(String nr_cnpj) {
        this.nr_cnpj = nr_cnpj;
    }

    public String getNm_fantasia() {
        return nm_fantasia;
    }

    public void setNm_fantasia(String nm_fantasia) {
        this.nm_fantasia = nm_fantasia;
    }

    @Override
    public String getResumo(Endereco endereco){
        return "\nID: " + this.getCd_usuario() + "\nNome: " + this.getNm_usuario() + "\nNome Fantasia: " + this.getNm_fantasia() + "\nE-mail: " + this.getEmail() + "\nCNPJ: " + this.getNr_cnpj() + "\nSenha: " + this.getSenha() + "\nTelefone: (" + this.getNr_ddd() + ")" + this.getNr_telefone() + "\n" + endereco.getEnderecoCompleto() + "\n";
    }
}
