package com.example.demo2.controladores;

import com.example.demo2.entidades.Estudante;
import com.example.demo2.excecoes.EstudanteNaoEncontradoException;
import com.example.demo2.repositorios.EstudanteRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/estudantes")
@Transactional
@CrossOrigin
public class EstudanteControlador {
    private final EstudanteRepositorio repositorio;

    public EstudanteControlador(EstudanteRepositorio umRepositorio){
        repositorio = umRepositorio;
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Estudante> getEstudantePorMatricula(@PathVariable String matricula){
        Estudante umEstudante = repositorio.buscarPorMatricula(matricula);
        if(umEstudante == null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(umEstudante);
        }
    }

    @GetMapping
    public List<Estudante> getEstudantes(){
        return repositorio.buscarTodos();
    }

    @GetMapping("testeCriacao")
    public void criar(){
        Estudante estd = new Estudante();
        estd.setMatricula("123");
        estd.setNome("John Doe");
        estd.setIdade(22);
        repositorio.cadastrar(estd);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@RequestBody Estudante umEstudante){
        repositorio.cadastrar(umEstudante);
    }

    @DeleteMapping("/{matricula}")
    public Estudante remover(@PathVariable String matricula){
        return repositorio.removerPorMatricula(matricula);
    }

    @PutMapping("/{matricula}")
    public void alterar(@PathVariable String matricula, @RequestBody Estudante umEstudante){
        Estudante estudante = repositorio.buscarPorMatricula(matricula);
        if(estudante == null){
            throw new EstudanteNaoEncontradoException("Id="+matricula);
        }
        repositorio.alterar(umEstudante);
    }

}
