package org.serratec.oficina;

import javax.swing.*;

public class TesteConta {
    public static void main(String[] args) {
        Conta conta = new Conta () {

            @Override
            public void transacao() {
                System.out.println("Transação anonima efetuada");
            }
        };
        conta.transacao();

        Conta conta2 = ()-> System.out.println(("Transação efetuada"));
        conta2.transacao();
        conta2.investimento();

        JButton button = new JButton();
        button.addActionListener(e-> System.out.println(e));

    }
}
