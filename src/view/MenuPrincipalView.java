package view;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipalView extends JFrame {
    CardLayout cardLayout = new CardLayout();
    JPanel contentPanel = new JPanel(cardLayout);

    private ListaProdutosView listaProdutosView;
    private CadastroProdutoView cadastroProdutoView;

    public MenuPrincipalView() {
        setTitle("LOJA JOB - Sistema");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu lateral
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(new Color(245, 245, 245));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblLogo = new JLabel("LOJA JOB");
        lblLogo.setFont(new Font("Arial", Font.BOLD, 16));
        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnInicio = new JButton("Início");
        JButton btnProdutos = new JButton("Produtos");
        JButton btnClientes = new JButton("Clientes");
        JButton btnPedidos = new JButton("Pedidos");

        btnInicio.addActionListener(e -> cardLayout.show(contentPanel, "inicio"));
        btnProdutos.addActionListener(e -> cardLayout.show(contentPanel, "produtos"));
        btnClientes.addActionListener(e -> cardLayout.show(contentPanel, "clientes"));
        btnPedidos.addActionListener(e -> cardLayout.show(contentPanel, "pedidos"));

        menuPanel.add(lblLogo);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        menuPanel.add(btnInicio);
        menuPanel.add(btnProdutos);
        menuPanel.add(btnClientes);
        menuPanel.add(btnPedidos);

        // Instancia as views que precisam de referência
        listaProdutosView = new ListaProdutosView();
        cadastroProdutoView = new CadastroProdutoView(listaProdutosView);

        contentPanel.add(new JLabel("LOJA JOB", SwingConstants.CENTER), "inicio");
        contentPanel.add(cadastroProdutoView, "produtos");
        contentPanel.add(new CadastroClienteView(), "clientes");
        contentPanel.add(new ListaPedidosView(), "pedidos");
        contentPanel.add(listaProdutosView, "listaProdutos");  // opcional, só se quiser mostrar numa aba separada

        getContentPane().add(menuPanel, BorderLayout.WEST);
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
