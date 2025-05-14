package org.serratec.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class Teste {

    @GetMapping("/ola")
    public String hello() {
        return "Olá Mundo";
    }

    @GetMapping("/oi")
    public String oi() {
        return "Oi Mundo";
    }

    @GetMapping("/contar")
    public int contar() {
        int num = 0;
        // Contar de 0 a 9
        for (int i = 0 ; i < 10; i++) {
            num +=i;
        }
        return num;
    }
}
