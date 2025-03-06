package org.example.insert;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class insert1  {
   public static void inserir(Connection conexao, String nome,String descricao, int quantidade, double preco) throws SQLException {
       String sql = "INSERT produtos (nome, descricao, quantidade, preco)" + "VALUES (?, ?, ?,?)";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, nome);
            statement.setString(2, descricao);
            statement.setInt(3, quantidade);
            statement.setDouble(4, preco);

            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("PRODUTO INSERIDO COM SUCESSO");
            } else {
                System.out.println("ERRO AO INSERIR O PRODUTO");
            }
        }
    }
}
