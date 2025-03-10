package org.example;

import org.example.ConnectionFactory.ConnectionFactory;
import org.example.insert.insert1; // Importe Insert1
import org.example.select1.select1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Inserir produto");
            System.out.println("2 - Listar produtos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    inserirProduto(scanner);
                    break;
                case 2:
                    listarprodutos(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void inserirProduto(Scanner scanner) {
        try (Connection conexao = ConnectionFactory.getConnection()) {

            System.out.print("Nome do produto: ");
            String nome = scanner.nextLine();
            System.out.print("Descrição do produto: ");
            String descricao = scanner.nextLine();
            System.out.print("Preço do produto: ");
            double preco = scanner.nextDouble();
            System.out.print("Quantidade do produto: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            insert1.inserir(conexao, nome, descricao, quantidade, preco);

        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Insira um número.");
            e.printStackTrace();
        }
    }
    private static void listarprodutos(Scanner scanner) {
        try (Connection conexao  = ConnectionFactory.getConnection()) {
            select1.listar(conexao);
        }catch (SQLException e) {
            System.out.println("erro ao listar produtos" + e.getMessage());
            e.printStackTrace();
        }
    }
}