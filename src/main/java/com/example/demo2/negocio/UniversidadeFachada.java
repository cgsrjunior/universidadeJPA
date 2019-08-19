package com.example.demo2.negocio;
import com.example.demo2.entidades.Curso;
import com.example.demo2.entidades.Estudante;
import com.example.demo2.excecoes.CursoNaoEncontradoException;
import com.example.demo2.excecoes.EstudanteNaoEncontradoException;
import com.example.demo2.repositorios.CursoRepositorio;
import com.example.demo2.repositorios.EstudanteRepositorio;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UniversidadeFachada {
    private EstudanteRepositorio estudantesRepo;
    private CursoRepositorio cursosRepo;
    public UniversidadeFachada(EstudanteRepositorio estudantesRepo, CursoRepositorio cursosRepo) {
        this.estudantesRepo = estudantesRepo;
        this.cursosRepo = cursosRepo;
    }
    public void matricular(String matriculaEstudante, String codigoCurso){
        Estudante estudante = estudantesRepo.buscarPorMatricula(matriculaEstudante);
        if (estudante == null) {
            throw new EstudanteNaoEncontradoException("No de matrícula inválido");
        }
        Curso curso = cursosRepo.buscarPorCodigo(codigoCurso);
        if (curso == null) {
            throw new CursoNaoEncontradoException("Código de curso inválido");
        }
        estudante.getCursos().add(curso);
    }
}