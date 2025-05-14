package org.serratec.backend.revisao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ExemploControlador {

    @GetMapping
    public String teste(@RequestParam String nome) {
        return nome.toUpperCase();
    }

    @GetMapping("/teste")
    public Integer teste2(@RequestParam Integer a,@RequestParam Integer b,@RequestParam Integer c) {
        return a+b+c;
    }
}
