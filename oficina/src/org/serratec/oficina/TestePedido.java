package org.serratec.oficina;

public class TestePedido {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        pedido.finalizarPedido();

        Pedido pedido2 = new Pedido() {
            @Override
            public void finalizarPedido() {
                System.out.println("Pedido encerrado!");
            }
        };
        pedido2.finalizarPedido();

        Pedido pedido3 = new Pedido() {
            @Override
            public void finalizarPedido() {
                System.out.println("Pedido acabado!");
            }
        };
        pedido3.finalizarPedido();
    }
}
