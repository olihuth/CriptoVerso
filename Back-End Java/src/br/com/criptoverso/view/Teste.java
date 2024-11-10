package br.com.criptoverso.view;

import java.util.Scanner;
import java.util.UUID;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.com.criptoverso.model.*;

public class Teste {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL"; 
        String user = "RM550330";
        String password = "090205";
        
        PessoaFisica pf = new PessoaFisica();
        PessoaJuridica pj = new PessoaJuridica();
        ContaInvestimento ci = new ContaInvestimento();
        Ativo bitcoin = new Ativo(1,"Bitcoin","CriptoMoeda",312824.33);
        Ativo ethereum = new Ativo(2,"Ethereum","CriptoMoeda",13193.71);

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexão com Oracle estabelecida!");

            Scanner s = new Scanner(System.in);
            int choice;

            // Menu
            do {
                System.out.println("\nBem-vindo ao CriptoVerso!");
                System.out.println("Escolha uma opção: ");
                System.out.println("1 - Cadastrar Usuário");
                System.out.println("2 - Criar Conta de Investimento");
                System.out.println("3 - Consultar Conta de Investimento");
                System.out.println("4 - Comprar Ativo");
                System.out.println("5 - Depositar");
                System.out.println("6 - Listar Usuários");
                System.out.println("7 - Listar Contas");
                System.out.println("0 - Sair");

                choice = s.nextInt();
                s.nextLine();

                //Submenus
                switch (choice) {
                    case 1:
                        cadastrarUsuario(s, conn, pf, pj);
                        break;
                    case 2:
                        criarContaInvestimento(s, conn, pf, pj, ci);
                        break;
                    case 3:
                        consultarContaInvestimento(s, conn);
                        break;
                    case 4:
                        comprarAtivo(s, conn, ci, bitcoin, ethereum); //falta esse
                        break;
                    case 5:
                        depositar(s, conn, ci, pf, pj); // e esse
                        break;
                    case 6:
                        listarUsuarios(conn); // e esse
                        break;
                    case 7:
                        listarContas(conn); // e esse, e adicionar mais alguns
                        break;
                    case 0:
                        System.out.println("Obrigada por utilizar a CriptoVerso! Encerrando programa...");
                        break;
                    default:
                        System.out.println("Digite um valor válido.");
                }

            } while (choice != 0);
            try {
            	conn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void cadastrarUsuario(Scanner s, Connection conn, PessoaFisica pf, PessoaJuridica pj) {
    	
    	int tipoUsuario;
    	
    	//PessoaFisica pf = new PessoaFisica();
    	PessoaFisicaDAO pfDAO = new PessoaFisicaDAO(conn);
    	
    	//PessoaJuridica pj = new PessoaJuridica();
    	PessoaJuridicaDAO pjDAO = new PessoaJuridicaDAO(conn);
    	
        do{    
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Pessoa Física");
            System.out.println("2 - Pessoa Jurídica");
            System.out.println("0 - Sair");
            tipoUsuario = s.nextInt();
            s.nextLine();

            // CADASTRAR PESSOA FISICA
            if (tipoUsuario == 1){
                System.out.println("Digite o email: ");
                String email = s.nextLine();
                System.out.println("Digite seu Nome: ");
                String nome = s.nextLine();
                System.out.println("Digite a senha: ");
                String senha = s.nextLine();
                System.out.println("Digite o ddd: ");
                int ddd = s.nextInt();
                s.nextLine();
                System.out.println("Digite o telefone: ");
                String telefone = s.nextLine();
                System.out.println("Digite o CPF: ");
                String cpf = s.nextLine();
                System.out.println("Digite a data de nascimento: ");
                String dataNasc = s.nextLine();
                System.out.println("Digite o país do Usuário: ");
                String pais = s.nextLine();
                System.out.println("Digite o estado: ");
                String estado = s.nextLine();
                System.out.println("Digite a cidade: ");
                String cidade = s.nextLine();
                System.out.println("Digite o CEP: ");
                int cep = s.nextInt();
                s.nextLine();
                System.out.println("Digite a rua: ");
                String rua = s.nextLine();
                System.out.println("Digite o número do endereço: ");
                int numRua = s.nextInt();
                s.nextLine();

                Endereco enderecoUsuario = new Endereco(0, pais, estado, cidade, cep, rua, numRua);
                pf.setCd_usuario(1);
                pf.setEmail(email);
                pf.setSenha(senha);
                pf.setNm_usuario(nome);
                pf.setNr_ddd(ddd);
                pf.setNr_telefone(telefone);
                pf.setNr_cpf(cpf);
                pf.setDt_nascimento(dataNasc);
                pf.setEndereco(enderecoUsuario);
               
                try {
                	pfDAO.inserirPessoaFisica(pf);
                	System.out.println("Usuário criado com sucesso!");
                }catch (SQLException e) {
                    e.printStackTrace();
                }

                //System.out.println(pf.getResumo(enderecoUsuario)); DO THIS LATER


                // CADASTRAR PESSOA JURIDICA
            } else if(tipoUsuario == 2){
                System.out.println("Digite o email: ");
                String email = s.nextLine();
                System.out.println("Digite a razão social da empresa: ");
                String nome = s.nextLine();
                System.out.println("Digite a senha: ");
                String senha = s.nextLine();
                System.out.println("Digite o ddd: ");
                int ddd = s.nextInt();
                s.nextLine();
                System.out.println("Digite o telefone: ");
                String telefone = s.nextLine();
                System.out.println("Digite o país da empresa: ");
                String pais = s.nextLine();
                System.out.println("Digite o estado: ");
                String estado = s.nextLine();
                System.out.println("Digite a cidade: ");
                String cidade = s.nextLine();
                System.out.println("Digite o CEP: ");
                int cep = s.nextInt();
                s.nextLine();
                System.out.println("Digite a rua: ");
                String rua = s.nextLine();
                System.out.println("Digite o número do endereço: ");
                int numRua = s.nextInt();
                s.nextLine();
                System.out.println("Digite o CNPJ: ");
                String cnpj = s.nextLine();
                System.out.println("Digite o nome fantasia: ");
                String nmFantasia = s.nextLine();

                Endereco enderecoUsuario = new Endereco(0, pais, estado, cidade, cep, rua, numRua);

                pj.setCd_usuario(1);
                pj.setEmail(email);
                pj.setSenha(senha);
                pj.setNm_usuario(nome);
                pj.setNr_ddd(ddd);
                pj.setNr_telefone(telefone);
                pj.setNr_cnpj(cnpj);
                pj.setNm_fantasia(nmFantasia);
                pj.setEndereco(enderecoUsuario);
                
                try {
                	pjDAO.inserirPessoaJuridica(pj);
                	System.out.println("Usuário criado com sucesso!");
                }catch (SQLException e) {
                    e.printStackTrace();
                }

                //System.out.println(pj.getResumo(enderecoUsuario)); DO THIS LATER

            }

        }while(tipoUsuario != 0);
    }

    private static void criarContaInvestimento(Scanner s, Connection conn, PessoaFisica pf, PessoaJuridica pj, ContaInvestimento ci) {
    	
    	//ContaInvestimento ci = new ContaInvestimento();
    	CarteiraDAO ciDAO = new CarteiraDAO(conn);
    	CofreDAO cofreDAO = new CofreDAO(conn);
    	
    	if (pf.getNm_usuario() == null && pj.getNm_usuario() == null){ //Sem usuário criado
            System.out.println("Crie um usuário primeiro");
            return;
        } else if (pf.getNm_usuario() != null) { //Usuário PF criado
        System.out.println("Digite a data de abertura da conta: ");
        String data_abertura = s.nextLine();
        System.out.println("Digite em qual moeda será sua conta (USD, BRL, EUR): ");
        String tipo_moeda = s.nextLine();

        ci.setCd_conta(1);
        ci.setDt_abertura(data_abertura);
        ci.setTp_moeda(tipo_moeda);
        ci.setSaldo(0);
        ci.setUsuario(pf);
        } else { //Usuário PJ criado
        System.out.println("Digite a data de abertura da conta: ");
        String data_abertura = s.nextLine();
        System.out.println("Digite em qual moeda será sua conta (USD, BRL, EUR): ");
        String tipo_moeda = s.nextLine();

        ci.setDt_abertura(data_abertura);
        ci.setTp_moeda(tipo_moeda);
        ci.setSaldo(0);
        ci.setUsuario(pj);
        }
    	
    	try {
    		ciDAO.inserirCarteira(ci);
            String uuid = UUID.randomUUID().toString();
            ci.setCd_conta(ciDAO.getLastCd_Conta());	
            Cofre cofre = new Cofre(ci, uuid);
    		cofreDAO.inserirCofre(cofre);
            System.out.println("Conta criada com sucesso!!!\n");
            System.out.println("O ID de sua conta é " + ci.getCd_conta() + ". Lembre desse número.\n");
            System.out.println("Sua chave da conta é " + uuid + "\n");
            System.out.println("Não perca esta chave pois sem ela é impossível recuperar sua conta.\n");
            System.out.println("Esta chave é pessoal e intransferível. Não a compartilhe com ninguém.\n");
    	}catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void consultarContaInvestimento(Scanner s, Connection conn) {
    	
    	CarteiraDAO ciDAO = new CarteiraDAO(conn);
    	
    	System.out.println("Digite o ID da conta que deseja buscar: "); //ADD TRATATIVA PRA QND N ACHAR O ID
    	int idconta =  s.nextInt();
    	
    	try {
			ContaInvestimento ci = ciDAO.buscarCarteiraPorId(idconta);
			System.out.println(ci.getResumo()); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    private static void comprarAtivo(Scanner s, Connection conn, ContaInvestimento ci, Ativo bitcoin, Ativo ethereum) {
    	if (ci.getUsuario() == null){
            System.out.println("\n==========\nCrie uma Conta de Investimento primeiro!\n==========\n");
            return;
        } else {
            int escolhaAtivo;
            do {
                System.out.println("\nEscolha um Ativo que deseja comprar:");
                System.out.println("1");
                System.out.println(bitcoin.getResumo());
                System.out.println("2");
                System.out.println(ethereum.getResumo());
                System.out.println("0 - Sair");

                escolhaAtivo = s.nextInt();

                switch (escolhaAtivo){
                    case 1://Compra de Bitcoin
                        int quantidadeBitcoin;
                        System.out.println("Quantos Bitcoins você deseja comprar?");
                        quantidadeBitcoin = s.nextInt();
                        double valorTransacaoBTC = quantidadeBitcoin * bitcoin.getPreco();
                        if (valorTransacaoBTC > ci.getSaldo()){
                            System.out.println("Saldo insuficiente para completar a transação");
                        } else {
                            Transacao compraBitcoin = new Transacao(1,"06/09/2024","Compra de Ativo",quantidadeBitcoin,ci,bitcoin);
                            ci.setSaldo(ci.getSaldo()-valorTransacaoBTC);
                            System.out.println("Transação efetuada com sucesso!!!");
                            System.out.println(compraBitcoin.getResumo());

                        }
                    break;

                    case 2://Compra de Ethereum
                        int quantidadeEthereum;
                        System.out.println("Quantas unidades de Ethereum você deseja comprar?");
                        quantidadeEthereum = s.nextInt();
                        double valorTransacaoETH = quantidadeEthereum * ethereum.getPreco();
                        if (valorTransacaoETH > ci.getSaldo()){
                            System.out.println("Saldo insuficiente para completar a transação");
                        } else {
                            Transacao compraEthereum = new Transacao(1,"06/09/2024","Compra de Ativo",quantidadeEthereum,ci,ethereum);
                            ci.setSaldo(ci.getSaldo()-valorTransacaoETH);
                            System.out.println("Transação efetuada com sucesso!!!");
                            System.out.println(compraEthereum.getResumo());
                        }
                        break;
                }

            } while (escolhaAtivo != 0);

        }
    }

    private static void depositar(Scanner s, Connection conn, ContaInvestimento ci, PessoaFisica pf, PessoaJuridica pj) {
    	CarteiraDAO ciDAO = new CarteiraDAO(conn);
    	if (ci.getUsuario() == null){
            System.out.println("\n==========\nCrie uma Conta de Investimento primeiro!!\n==========\n");
            return;
        } else if (pf.getNm_usuario() != null || pj.getNm_usuario() != null) { 
            System.out.println("Digite o número da conta em que o valor será depositado: ");
            try {
				ci = ciDAO.buscarCarteiraPorId(s.nextInt());
				//boolean contaValida = ci.validaConta(s.nextInt());
	            if(ci != null){
	                    System.out.println("Digite o valor a ser depositado: ");
	                    ci.addSaldo(s.nextDouble());
	                    ciDAO.atualizarCarteira(ci);
	                    System.out.println("Depositado com sucesso!");
	                    System.out.println("Saldo atual da conta: " + ci.getSaldo());
	            } else {
	                    System.out.println("Número da conta não encontrado.");
	                    return;
	            }
            } catch (SQLException e) {
				e.printStackTrace();
			}
        }
    }

    private static void listarUsuarios(Connection conn) {
        try {
            PessoaFisicaDAO pfDao = new PessoaFisicaDAO(conn);
            PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO(conn);

            List<PessoaFisica> usuariosPF = pfDao.listarPessoasFisicas();
            List<PessoaJuridica> usuariosPJ = pjDao.listarPessoasJuridicas();

            System.out.println("Usuários Pessoas Físicas:");
            for (PessoaFisica usuario : usuariosPF) {
                System.out.println(usuario.getResumo(usuario.getEndereco()));
            }

            System.out.println("Usuários Pessoas Jurídicas:");
            for (PessoaJuridica usuario : usuariosPJ) {
                System.out.println(usuario.getResumo(usuario.getEndereco()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void listarContas(Connection conn) {
        try {
            CarteiraDAO contaDAO = new CarteiraDAO(conn);
            List<ContaInvestimento> contas = contaDAO.listarCarteiras();

            System.out.println("Contas de Investimento:");
            for (ContaInvestimento conta : contas) {
                System.out.println(conta.getResumo());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
