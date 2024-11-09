package br.com.criptoverso.model;

public class Cofre {
    private int idCofre;
    private ContaInvestimento carteira;
    private int chaveCarteira;

    // Construtor completo
    public Cofre(int idCofre, ContaInvestimento carteira, int chaveCarteira) {
        this.idCofre = idCofre;
        this.carteira = carteira;
        this.chaveCarteira = chaveCarteira;
    }
    
    public Cofre(int idCofre, int carteira, int chaveCarteira) {
        this.idCofre = idCofre;
        carteira = this.carteira.getCd_conta();
        this.chaveCarteira = chaveCarteira;
    }

    // Construtor sem idCofre (para inserção)
    public Cofre(ContaInvestimento carteira, int chaveCarteira) {
        this.carteira = carteira;
        this.chaveCarteira = chaveCarteira;
    }

    // Getters e Setters
    public int getIdCofre() {
        return idCofre;
    }

    public void setIdCofre(int idCofre) {
        this.idCofre = idCofre;
    }

    public int getChaveCarteira() {
        return chaveCarteira;
    }

    public void setChaveCarteira(int chaveCarteira) {
        this.chaveCarteira = chaveCarteira;
    }

	public ContaInvestimento getCarteira() {
		return carteira;
	}

	public void setCarteira(ContaInvestimento carteira) {
		this.carteira = carteira;
	}
}
