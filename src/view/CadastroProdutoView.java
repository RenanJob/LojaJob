package view;

import dao.ProdutoDAO;
import model.Produto;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class CadastroProdutoView extends JPanel {
    private JTextField txtNome, txtPreco, txtQtd;
    private JButton btnSalvar;

    private ListaProdutosView listaProdutosView;  // referencia para atualizar a tabela

    public CadastroProdutoView(ListaProdutosView listaProdutosView) {
        this.listaProdutosView = listaProdutosView;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        txtNome = new JTextField(20);
        txtPreco = new JTextField(10);
        txtQtd = new JTextField(10);
        btnSalvar = new JButton("Salvar");

        btnSalvar.setBackground(new Color(0, 120, 215));
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnSalvar.addActionListener(e -> {
            try {
                String nome = txtNome.getText();
                BigDecimal preco = new BigDecimal(txtPreco.getText().replace(",", "."));
                int qtd = Integer.parseInt(txtQtd.getText());

                Produto p = new Produto();
                p.setNome(nome);
                p.setPreco(preco);
                p.setQuantidade(qtd);

                ProdutoDAO dao = new ProdutoDAO();
                dao.salvar(p);

                JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
                txtNome.setText("");
                txtPreco.setText("");
                txtQtd.setText("");

                listaProdutosView.carregarProdutos();  // ATUALIZA A TABELA
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage());
            }
        });

        add(new JLabel("Cadastro de Produto"));
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Preço:"));
        add(txtPreco);
        add(new JLabel("Quantidade:"));
        add(txtQtd);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(btnSalvar);
    }
}
