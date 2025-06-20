package view;

import dao.PedidoDAO;
import model.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class ListaPedidosView extends JPanel {
    private JTable tabela;
    private DefaultTableModel modelo;

    public ListaPedidosView() {
        setLayout(new BorderLayout());

        // Cabeçalhos da tabela
        String[] colunas = {"ID", "Data", "Cliente", "Valor Total"};
        modelo = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modelo);

        carregarPedidos();

        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);

        // Botão excluir
        JButton btnExcluir = new JButton("Excluir Pedido Selecionado");
        btnExcluir.setBackground(Color.BLUE);
        btnExcluir.setForeground(Color.WHITE);
        btnExcluir.setFocusPainted(false);

        btnExcluir.addActionListener(e -> excluirPedido());

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnExcluir);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void carregarPedidos() {
        modelo.setRowCount(0); // limpa a tabela
        List<Pedido> pedidos = new PedidoDAO().listarTodos();
        for (Pedido p : pedidos) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getData(),
                p.getClienteNome(),
                "R$ " + p.getValorTotal()
            });
        }
    }

    private void excluirPedido() {
        int linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int id = Integer.parseInt(tabela.getValueAt(linhaSelecionada, 0).toString());

            int confirmacao = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja excluir este pedido?", "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                new PedidoDAO().excluir(id);
                carregarPedidos();
                JOptionPane.showMessageDialog(this, "Pedido excluído com sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um pedido para excluir.");
        }
    }
}
