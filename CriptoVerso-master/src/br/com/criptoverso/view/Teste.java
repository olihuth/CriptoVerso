package br.com.criptoverso.view;

import java.util.Scanner;

import br.com.criptoverso.model.*;

public class Teste {

    // static int choice;

    public static void main(String[] args) {
        //Cadastrar usuario OK
        //Criar conta OK
        //Consultar saldo OK
        //Comprar ativo OK
        //Depositar Ok

        //Ativos disponíveis 
        Ativo bitcoin = new Ativo(1,"Bitcoin",312824.33);
        Ativo ethereum = new Ativo(2,"Ethereum",13193.71);


        Scanner s = new Scanner(System.in);
        int choice;

        //Testes
        //Endereco enderecoTeste = new Endereco(0,"Brasil","SP","São Paulo",533892,"Avenida Paulista",4000);
        //PessoaFisica pfTeste = new PessoaFisica(0, "teste.cripto@gmail.com", "sejfjf", "Testador", 980037464, 11, enderecoTeste, 55555555, "01/01/2000");
        //ContaInvestimento ciTeste = new ContaInvestimento(0,"06/09/2024",400000.00,"BRL",pfTeste);

        PessoaFisica pf = new PessoaFisica();
        PessoaJuridica pj = new PessoaJuridica();
        ContaInvestimento ci = new ContaInvestimento();


        // MENU
        do{
            System.out.println("\nBem vindo ao CriptoVerso!");
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Criar Conta de Investimento");
            System.out.println("3 - Consultar Conta de Investimento");
            System.out.println("4 - Comprar Ativo");
            System.out.println("5 - Depositar");
            System.out.println("0 - Sair");
            System.out.println("\n");

            choice = s.nextInt();
            s.nextLine();


            switch(choice){
                // CADASTRAR USUARIO
                case 1:
                    int tipoUsuario;
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
                            System.out.println("Digite o telefone: ");
                            int telefone = s.nextInt();
                            //s.nextLine();
                            System.out.println("Digite o CPF: ");
                            int cpf = s.nextInt();
                            s.nextLine();
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

                            System.out.println("Usuário criado com sucesso!");

                            System.out.println(pf.getResumo(enderecoUsuario));


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
                            System.out.println("Digite o telefone: ");
                            int telefone = s.nextInt();
                            s.nextLine();
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
                            System.out.println("Digite o CNPJ: ");
                            int cnpj = s.nextInt();
                            s.nextLine();
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

                            System.out.println("Usuário criado com sucesso!");

                            System.out.println(pj.getResumo(enderecoUsuario));

                        }

                    }while(tipoUsuario != 0);

                break;
                case 2:
                // CRIAR CONTA DE INVESTIMENTO
                    if (pf.getNm_usuario() == null && pj.getNm_usuario() == null){ //Sem usuário criado
                        System.out.println("Crie um usuário primeiro");
                        break;
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

                    ci.setCd_conta(1);
                    ci.setDt_abertura(data_abertura);
                    ci.setTp_moeda(tipo_moeda);
                    ci.setSaldo(0);
                    ci.setUsuario(pj);
                    }

                    System.out.println("Conta criada com sucesso!!!");

                break;

                case 3:
                // CONSULTAR CONTA DE INVESTIMENTO
                    if (ci.getUsuario() == null){//alterar para verificação ci
                        System.out.println("\n==========\nCrie uma Conta de Investimento primeiro!!\n==========\n");
                        break;
                    } else {
                        System.out.println(ci.getResumo());
                    }
                break;

                case 4:
                //COMPRAR ATIVO
                    if (ci.getUsuario() == null){//alterar para verificação ci
                        System.out.println("\n==========\nCrie uma Conta de Investimento primeiro!!\n==========\n");
                        break;
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
                break;
                    // DEPOSITAR
                case 5:
                    if (ci.getUsuario() == null){//alterar para verificação ci
                        System.out.println("\n==========\nCrie uma Conta de Investimento primeiro!!\n==========\n");
                        break;
                    } else if (pf.getNm_usuario() != null || pj.getNm_usuario() != null) { 
                        System.out.println("Digite o número da conta em que o valor será depositado: ");
                        boolean contaValida = ci.validaConta(s.nextInt());
                        if(contaValida){
                                System.out.println("Digite o valor a ser depositado: ");
                                ci.addSaldo(s.nextDouble());
                                System.out.println("Depositado com sucesso!");
                                System.out.println("Saldo atual da conta: " + ci.getSaldo());
                        } else {
                                System.out.println("Número da conta não encontrado.");
                                break;
                        }
                    }
                break;

                default: System.out.println("Digite um valor válido.");
            }

        } while (choice != 0);
        System.out.println("Obrigada por utilizar a CriptoVerso! Volte Sempre!");
        System.out.println("Programa encerrado com sucesso.");

        s.close();

    }

}
