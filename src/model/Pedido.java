package model;

import java.math.BigDecimal;
import java.util.Date;

public class Pedido {
    private int id;
    private Date data;
    private String clienteNome;
    private BigDecimal valorTotal;

    // ✅ Construtor sem argumentos (necessário para algumas ferramentas/frameworks)
    public Pedido() {}

    // ✅ Construtor com todos os atributos (usado no DAO)
    public Pedido(int id, Date data, String clienteNome, BigDecimal valorTotal) {
        this.id = id;
        this.data = data;
        this.clienteNome = clienteNome;
        this.valorTotal = valorTotal;
    }

    public int getId() { return id; }
    public Date getData() { return data; }
    public String getClienteNome() { return clienteNome; }
    public BigDecimal getValorTotal() { return valorTotal; }

    public void setId(int id) { this.id = id; }
    public void setData(Date data) { this.data = data; }
    public void setClienteNome(String clienteNome) { this.clienteNome = clienteNome; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }
}
