/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mercado2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vini
 */
public class Compra {

    private ArrayList<Produto> produtos = new ArrayList();
    private String data;
    private Usuario cliente;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void addProduto(Produto p) {
        this.produtos.add(p);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public double getValorTotal() {
        double resultado = 0;

        for (Produto produto : produtos) {
            resultado += produto.getValor();
        }

        return resultado;
    }

    @Override
    public String toString() {
        String result = "";

        result += data + " | " + cliente.getNome() + " | (" + cliente.getCpf() + ")\n";

        for (Produto produto : produtos) {
            result += "\t" + produto.toString() + "\n";
        }

        result += "TOTAL: " + getValorTotal();

        return result;
    }
}
