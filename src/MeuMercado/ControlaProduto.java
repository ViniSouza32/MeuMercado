/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mercado2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Vini
 */
public class ControlaProduto {
    Produto produto;
    private ArrayList<Produto> produtos = new ArrayList();
    private ArrayList<Usuario> usuarios = new ArrayList();
    
    public ControlaProduto() {
        
    }
    
    public ControlaProduto(int codigo, String nome, double valor) {
        produto.setCodigo(codigo);
        produto.setNome(nome);
        produto.setValor(valor);
    } 

    public void addProduto() {
        Produto p = new Produto();
        p.setCodigo(produtos.size() + 1);
        p.setNome(Entrada.leiaString("Insira o nome do produto"));
        p.setValor(Entrada.leiaDouble("Insira o valor do produto"));

        this.addProduto(p);
    }
    
    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    
    public void addProduto(Produto p) {
        produtos.add(p);
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public Produto getProduto(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }

        return null;
    }

    public String getProdutosFormatados() {
        String resultado = "";

        for (Produto p : produtos) {
            resultado += p.toString() + "\n";
        }

        return resultado;
    }

    public boolean validaProduto(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return true;
            }
        }

        return false;
    }

    public void listarProdutos() {
        JOptionPane.showMessageDialog(null,getProdutosFormatados());
    }
}
