package org.serratec.oficina;

public class TesteSoma {

    public static void main(String[] args) {
//    Calculo calculo = new Calculo() {
//        @Override
//        public int operacao(int a, int b) {
//            return a +b;
//        }
//    };

//    Calculo calculo = (a, b) -> a + b;

    Calculo calculo = Integer::sum;

    System.out.println(calculo.operacao(10,30));

    }
}
