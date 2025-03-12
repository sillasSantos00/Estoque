package org.example.delet; // Ajuste para o pacote correto

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteProduto {
    public static void deletarProduto(Connection conexao, int idProduto) {
        String sql = "DELETE FROM produtos WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idProduto);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Produto deletado com sucesso!");
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o produto: " + e.getMessage());
        }
    }
}
