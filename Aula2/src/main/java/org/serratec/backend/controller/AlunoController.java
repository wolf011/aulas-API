package org.serratec.backend.controller;

import org.serratec.backend.entity.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private static List<Aluno> alunos = new ArrayList();

    static {
        alunos.add(new Aluno(123L, "Adriano", "Adriano@gmail.com"));
        alunos.add(new Aluno(321L, "Mariana", "Mariana@gmail.com"));
        alunos.add(new Aluno(345L, "Gerson", "Gerson@gmail.com"));
        alunos.add(new Aluno(545L, "Marcelo", "Marcelo@gmail.com"));
    }

    @GetMapping("/listar")
    public List<Aluno> listar() {
        return alunos;
    }

    @GetMapping("/{matricula}")
    public Aluno buscar(@PathVariable Long matricula) {
        for (Aluno aluno : alunos) {
            return aluno.getMatricula().equals(matricula)?aluno:null;
        }
        return null;
    }

    @PostMapping
    public Aluno inserir(@RequestBody Aluno aluno) {
        alunos.add(aluno);
        return aluno;
    }

    @PostMapping("/inserirvarios")
    public List<Aluno> inserirVarios(@RequestBody List<Aluno> alunes) {
            alunos.addAll(alunes);
            return alunos;
    }

    @DeleteMapping("/{matricula}")
    public void apagar(@PathVariable Long matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                alunos.remove(aluno);
                return;
            }
        }
    }

    @PutMapping("/{matricula}")
    public Aluno alterar(@PathVariable Long matricula, @RequestBody Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                aluno.setMatricula(matricula);
                alunos.set(alunos.indexOf(a), aluno);
                return aluno;
            }
        }
        return null;
    }

}
