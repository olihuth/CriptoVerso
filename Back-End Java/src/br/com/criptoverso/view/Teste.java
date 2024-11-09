package br.com.criptoverso.view;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.com.criptoverso.model.*;

public class Teste {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL"; // Ajuste para sua instância Oracle
        String user = "RM550330";
        String password = "090205";

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

                switch (choice) {
                    case 1:
                        cadastrarUsuario(s, conn);
                        break;
                    case 2:
                        criarContaInvestimento(s, conn);
                        break;
                    case 3:
                        consultarContaInvestimento(s, conn);
                        break;
                    case 4:
                        comprarAtivo(s, conn);
                        break;
                    case 5:
                        depositar(s, conn);
                        break;
                    case 6:
                        listarUsuarios(conn);
                        break;
                    case 7:
                        listarContas(conn);
                        break;
                    case 0:
                        System.out.println("Obrigada por utilizar a CriptoVerso! Volte Sempre!");
                        break;
                    default:
                        System.out.println("Digite um valor válido.");
                }

            } while (choice != 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void cadastrarUsuario(Scanner s, Connection conn) {
        // Implementar lógica de cadastro de usuário
    }

    private static void criarContaInvestimento(Scanner s, Connection conn) {
        // Implementar lógica de criação de conta de investimento
    }

    private static void consultarContaInvestimento(Scanner s, Connection conn) {
        // Implementar lógica de consulta de conta de investimento
    }

    private static void comprarAtivo(Scanner s, Connection conn) {
        // Implementar lógica de compra de ativo
    }

    private static void depositar(Scanner s, Connection conn) {
        // Implementar lógica de depósito
    }

    private static void listarUsuarios(Connection conn) {
        try {
            PessoaFisicaDAO pfDao = new PessoaFisicaDAO(conn);
            PessoaJuridicaDAO pjDao = new PessoaJuridicaDAO(conn);

            List<PessoaFisica> usuariosPF = pfDao.listarUsuarios();
            List<PessoaJuridica> usuariosPJ = pjDao.listarUsuarios();

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
            ContaInvestimentoDAO contaDAO = new ContaInvestimentoDAO(conn);
            List<ContaInvestimento> contas = contaDAO.listarContas();

            System.out.println("Contas de Investimento:");
            for (ContaInvestimento conta : contas) {
                System.out.println(conta.getResumo());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
