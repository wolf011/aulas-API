package org.serratec.oficina;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TesteAutor {

    public static void main(String[] args) {
        Autor autor1 = new Autor("João", "22343536");
        Autor autor2 = new Autor("Maria", "22347886");

        List<Autor> autores = Arrays.asList(autor1, autor2);

//        Consumer<Autor> imprimir = (autor) -> autor.imprimir();

        //Lambda
        autores.forEach(a -> a.imprimir());

        System.out.println("##############################");

        //Method Reference
        autores.forEach(Autor::imprimir);

    }
}
