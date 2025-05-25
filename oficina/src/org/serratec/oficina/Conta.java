package org.serratec.oficina;

public interface Conta {
    public void transacao();

    //Métodos default (Contém implementação)

    //Não preciso mais sobrescrever(override)
    default void investimento () {
        System.out.println("Investimento efetuado!");
    }
}
