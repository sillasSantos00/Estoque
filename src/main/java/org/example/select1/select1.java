package org.example.select1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class select1 {
    public static void listar(Connection conexao) {
        String sql = "SELECT * FROM produtos"; // Ajuste conforme o nome da sua tabela

        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Produtos cadastrados:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                double preco = rs.getDouble("preco");
                int quantidade = rs.getInt("quantidade");

                System.out.printf("ID: %d | Nome: %s | Descrição: %s | Preço: %.2f | Quantidade: %d%n",
                        id, nome, descricao, preco, quantidade);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
