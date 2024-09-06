package br.com.criptoverso.view;

import java.util.Scanner;

import br.com.criptoverso.model.*;

public class Teste {

    // static int choice;

    public static void main(String[] args) {
        //Cadastrar usuario
        //Criar conta
        //Consultar saldo
        //Comprar ativo

        //Ativos disponíveis
        Ativo bitcoin = new Ativo(1,"Bitcoin",312824.33);
        Ativo etherium = new Ativo(2,"Ethereum",13193.71);



        Scanner s = new Scanner(System.in);
        int choice;

        //Testes
        Endereco enderecoTeste = new Endereco(0,"Brasil","SP","São Paulo",533892,"Avenida Paulista",4000);
        PessoaFisica pfTeste = new PessoaFisica(0, "oli.huth@gmail.com", "sejfjf", "Testador", 980037464, 11, enderecoTeste, 55555555, "01/01/2000");

        PessoaFisica pf = new PessoaFisica();
        PessoaJuridica pj = new PessoaJuridica();
        ContaInvestimento ci = new ContaInvestimento();


        
        do{
            System.out.println("Bem vindo!");
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Criar Conta de Investimento");

            choice = s.nextInt();
            s.nextLine();


            switch(choice){
                case 1:
                    int tipoUsuario;
                    do{    
                        System.out.println("Escolha uma opção: ");
                        System.out.println("1 - Pessoa Física");
                        System.out.println("2 - Pessoa Jurídica");
                        System.out.println("0 - Sair");
                        tipoUsuario = s.nextInt();
                        s.nextLine();

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

                            System.out.println(pf.getResumo(enderecoUsuario));

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

                            System.out.println(pj.getResumo(enderecoUsuario));

                        }

                    }while(tipoUsuario != 0);


                break;
                case 2:

                    System.out.println("Digite a data de abertura da conta: ");
                    String data_abertura = s.nextLine();
                    System.out.println("Digite em qual moeda será sua conta (USD, BRL, EUR): ");
                    String tipo_moeda = s.nextLine();

                    ci.setCd_conta(1);
                    ci.setDt_abertura(data_abertura);
                    ci.setTp_moeda(tipo_moeda);
                    ci.setSaldo(0);
                    ci.setUsuario(pfTeste);

                    System.out.println("Conta criada com sucesso!!!");

                break;
                case 3:

                break;
            }

        } while (choice != 0);

        s.close();

    }

}
