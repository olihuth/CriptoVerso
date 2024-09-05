package br.com.criptoverso.view;

import java.util.Scanner;

import br.com.criptoverso.model.Endereco;
import br.com.criptoverso.model.PessoaFisica;
import br.com.criptoverso.model.PessoaJuridica;
import br.com.criptoverso.model.Usuario;

public class Teste {

    // static int choice;

    public static void main(String[] args) {
        //Cadastrar usuario
        //Criar conta
        //Comprar bitcoin
        //Consultar saldo


        Scanner s = new Scanner(System.in);
        int choice;


        
        do{
            System.out.println("Bem vindo!");
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Cadastrar Usuario");

            choice = s.nextInt();

            switch(choice){
                case 1:
                    int tipoUsuario;
                    do{    
                        System.out.println("Escolha uma opção: ");
                        System.out.println("1 - Pessoa Física");
                        System.out.println("2 - Pessoa Jurídica");
                        System.out.println("0 - Sair");
                        tipoUsuario = s.nextInt();

                        if (tipoUsuario == 1){
                            System.out.println("Digite o email: ");
                            String email = s.next();
                            System.out.println("Digite a senha: ");
                            String senha = s.next();
                            System.out.println("Digite o nome do Usuário: ");
                            String nome = s.next();
                            System.out.println("Digite o telefone: ");
                            int telefone = s.nextInt();
                            System.out.println("Digite o ddd: ");
                            int ddd = s.nextInt();
                            System.out.println("Digite o CPF: ");
                            int cpf = s.nextInt();
                            System.out.println("Digite a data de nascimento: ");
                            String dataNasc = s.next();
                            System.out.println("Digite o país do Usuário: ");
                            String pais = s.next();
                            System.out.println("Digite o estado: ");
                            String estado = s.next();
                            System.out.println("Digite a cidade: ");
                            String cidade = s.next();
                            System.out.println("Digite o CEP: ");
                            int cep = s.nextInt();
                            System.out.println("Digite a rua: ");
                            String rua = s.next();
                            System.out.println("Digite o número da casa: ");
                            int numRua = s.nextInt();
        
                            Endereco enderecoUsuario = new Endereco(0, pais, estado, cidade, cep, rua, numRua);
                            PessoaFisica usuarioPF = new PessoaFisica(0, email, senha, nome, telefone, ddd, enderecoUsuario, cpf, dataNasc);

                        } else if(tipoUsuario == 2){
                            System.out.println("Digite o email: ");
                            String email = s.next();
                            System.out.println("Digite a senha: ");
                            String senha = s.next();
                            System.out.println("Digite o nome do Usuário: ");
                            String nome = s.next();
                            System.out.println("Digite o telefone: ");
                            int telefone = s.nextInt();
                            System.out.println("Digite o ddd: ");
                            int ddd = s.nextInt();
                            System.out.println("Digite o país do Usuário: ");
                            String pais = s.next();
                            System.out.println("Digite o estado: ");
                            String estado = s.next();
                            System.out.println("Digite a cidade: ");
                            String cidade = s.next();
                            System.out.println("Digite o CEP: ");
                            int cep = s.nextInt();
                            System.out.println("Digite a rua: ");
                            String rua = s.next();
                            System.out.println("Digite o número da casa: ");
                            int numRua = s.nextInt();
                            System.out.println("Digite o CNPJ: ");
                            int cnpj = s.nextInt();
                            System.out.println("Digite o nome fantasia: ");
                            String nmFantasia = s.next();
        
                            Endereco enderecoUsuario = new Endereco(0, pais, estado, cidade, cep, rua, numRua);
                            PessoaJuridica usuarioPJ = new PessoaJuridica(0, email, senha, nome, telefone, ddd, enderecoUsuario, cnpj, nmFantasia);

                        } // else if(tipoUsuario != 0){
                        //     System.out.println("Digite um valor válido.");
                        // }

                    }while(tipoUsuario != 0);


                    // Usuario(int cd_usuario, int email, String senha, String nm_usuario, int nr_telefone,
                    //  int nr_ddd, Endereco endereco)
                    // Endereco(int cd_endereco, String nm_pais, String nm_estado, 
                    // String nm_cidade, int nr_cep, String nm_rua, int nr_rua) {
                break;
            }

        } while (choice != 0);

        // do {
        //     System.out.println("Press Y to get out of the loop");
        //     type = s.nextInt();
        // } while (type != 0);

        s.close();

    }

}
