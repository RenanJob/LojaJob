package view;

import dao.ClienteDAO;
import model.Cliente;

import javax.swing.*;
import java.awt.*;

public class CadastroClienteView extends JPanel {
    private JTextField txtNome, txtCpf, txtTel;
    private JButton btnSalvar;

    public CadastroClienteView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        txtNome = new JTextField(20);
        txtCpf = new JTextField(14);
        txtTel = new JTextField(20);
        btnSalvar = new JButton("Salvar");

        btnSalvar.setBackground(new Color(0, 120, 215));
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnSalvar.addActionListener(e -> {
            try {
                String nome = txtNome.getText();
                String cpf = txtCpf.getText();
                String tel = txtTel.getText();

                Cliente c = new Cliente();
                c.setNome(nome);
                c.setCpf(cpf);
                c.setTelefone(tel);

                ClienteDAO dao = new ClienteDAO();
                dao.salvar(c);

                JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!");
                txtNome.setText("");
                txtCpf.setText("");
                txtTel.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        add(new JLabel("Cadastro de Cliente"));
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("CPF:"));
        add(txtCpf);
        add(new JLabel("Telefone:"));
        add(txtTel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(btnSalvar);
    }
}
