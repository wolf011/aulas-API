package org.serratec.oficina;

public class Poupanca implements Conta{

    @Override
    public void transacao() {

    }

    @Override
    public void investimento() {
        Conta.super.investimento();
    }
}
