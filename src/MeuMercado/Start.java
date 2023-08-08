/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mercado2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Vini
 */
public class Start {

    public static void main(String[] args) throws Exception {
        ControlaProduto controlaProdutos = new ControlaProduto();
        ControlaCompra controlaCompra = new ControlaCompra(controlaProdutos);

        Path path = Path.of("banco.txt");

        if (Files.exists(path)) {
            List<String> linhas = Files.readAllLines(path);

            for (String linha : linhas) {
                String pTemp[] = linha.split(" - ");

                ControlaProduto p = new ControlaProduto(Integer.parseInt(pTemp[0]), pTemp[1], Double.parseDouble(pTemp[2]));
                ControlaCompra c = new ControlaCompra(p);

            }
        }

        while (true) {
            int opcao = Entrada.leiaInt("""
                                        [1] – Cadastrar Produtos
                                        [2] – Listar produtos cadastrados
                                        [3] - Efetuar uma compra
                                        [4] - Listar as compras
                                        [5] - Listar compras de um dia
                                        [6] - Sair""");

            switch (opcao) {
                case 1 -> {
                    controlaProdutos.addProduto();
                }
                case 2 -> {
                    controlaProdutos.listarProdutos();
                }
                case 3 -> {
                    controlaCompra.adiconarCompra(controlaCompra.criarCompra());
                }
                case 4 -> {
                    {
                        ArrayList<Compra> compras = controlaCompra.getCompras();
                        String msg = "";
                        if (!compras.isEmpty()) {
                            for (Compra c : compras) {
                                msg += "\n-------------------------------------\n";
                                msg += c;
                                msg += "\n-------------------------------------\n";
                            }
                        } else {
                            msg += "Sem compras efetudas";
                        }
                        JOptionPane.showMessageDialog(null, msg);
                    }
                }
                case 5 -> {
                    {
                        ArrayList<Compra> compras = controlaCompra.getCompras(Entrada.leiaString("Qual é da data"));
                        if (!compras.isEmpty()) {
                            for (Compra c : compras) {
                                System.out.println("\n-------------------------------------\n");
                                System.out.println(c);
                                System.out.println("\n-------------------------------------\n");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,"Sem compras efetudas para a data digitada");
                        }
                    }
                }
                case 6 -> {
                    String clienteCompra = controlaCompra.formatarSalvar() ;

                    Files.write(Path.of("banco.txt"),
                            clienteCompra.getBytes(),
                            StandardOpenOption.CREATE,
                            StandardOpenOption.TRUNCATE_EXISTING);

                    System.out.println("bye bye");
                    System.exit(0);

                }
            }
        }
    }
}
