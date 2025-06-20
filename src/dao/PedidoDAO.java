package dao;

import database.Conexao;
import model.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    public List<Pedido> listarTodos() {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT p.id, p.data, c.nome AS cliente, p.valor_total FROM pedidos p JOIN clientes c ON p.cliente_id = c.id";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pedido p = new Pedido(rs.getInt("id"), rs.getDate("data"), rs.getString("cliente"), rs.getBigDecimal("valor_total"));
                lista.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void excluir(int id) {
        try (Connection conn = Conexao.conectar()) {
            String sql = "DELETE FROM pedidos WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}