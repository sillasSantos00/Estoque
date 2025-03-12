package org.example;

import org.example.ConnectionFactory.ConnectionFactory;
import org.example.delet.DeleteProduto;
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
         System.out.println("");
         System.out.println(" escolha uma opcao ");
         System.out.println("1 adicionar um produto");
         System.out.println("2 listar seu estoque");
         System.out.println("3 deletar porduto");
         System.out.println("4 sair");
         System.out.println("digite a opcao ");
         opcao = scanner.nextInt();
         scanner.nextLine();

         switch (opcao) {
             case 1:
                 inserirProduto(scanner);
                 break;
             case 2:
                 listarProdutos(scanner);
                 break;
             case 3:
                 DeleteProduto(scanner);
                 break;
             case 0:
                 System.out.println("saindo...");
                 break;
             default:
                 System.out.println("opcao invalida ");

         }
     }while (opcao != 0);
     Scanner close;
    }

    private static void inserirProduto  (Scanner scanner) {
        try (Connection conexao = ConnectionFactory.getConnection()) {
            System.out.println("qual o nome do produto");
            String nome = scanner.nextLine();
            System.out.println("descricao do produto ");
            String descricao = scanner.nextLine();
            System.out.println("quantidade de produtos");
            int quantidade = scanner.nextInt();
            System.out.println("preco do produto ");
            double preco = scanner.nextDouble();
            scanner.nextLine();

            insert1.inserir(conexao, nome, descricao, quantidade, preco);

        }catch (SQLException e) {
            System.out.println("erro ao inserir produto" + e.getMessage());
            e.printStackTrace();
        }catch (InputMismatchException e) {
            System.out.println("erro; entrada invalida, insira o numero");
            e.printStackTrace();
        }
    }
    private static void listarProdutos(Scanner scanner) {
        String senhacorreta = "1234";
        String senhadigitada;
        try (Connection conexao = ConnectionFactory.getConnection()) {

            System.out.println("digite a senha ");
            senhadigitada = scanner.nextLine();

            if (senhadigitada.equals(senhacorreta)) {
                System.out.println("acesso permitido");
            }else {
                System.out.println("acesso negado");
                return;
            }
          select1.listar(conexao);
        }catch (SQLException e) {
            System.out.println("erro ao listar o produto " + e.getMessage());
            e.getMessage();


        }
    }
    private static void DeleteProduto(Scanner scanner) {
        try(Connection conexao = ConnectionFactory.getConnection()) {
            System.out.println("digite o id do produto");
            int idproduto = scanner.nextInt();
            scanner.nextLine();


            DeleteProduto.deletarProduto(conexao, idproduto);

        }catch (SQLException e) {
            System.out.println("rro ao conectar ao banco de dados " + e.getMessage());
        }catch (InputMismatchException e) {
            System.out.println("erro ");
            scanner.nextLine();
        }
    }
}