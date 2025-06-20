package view;

import dao.ProdutoDAO;
import model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

public class ListaProdutosView extends JPanel {
    private JTable tabela;
    private DefaultTableModel modelo;

    public ListaProdutosView() {
        setLayout(new BorderLayout());

        String[] colunas = {"Nome", "Preço", "Quantidade"};
        modelo = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);

        carregarProdutos();
    }

    public void carregarProdutos() {
        modelo.setRowCount(0); // limpa a tabela

        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> lista = dao.listarTodos();

        for (Produto p : lista) {
            modelo.addRow(new Object[]{
                p.getNome(),
                "R$ " + p.getPreco().setScale(2, BigDecimal.ROUND_HALF_UP),
                p.getQuantidade()
            });
        }
    }
}
