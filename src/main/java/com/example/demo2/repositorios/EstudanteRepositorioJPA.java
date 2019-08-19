package com.example.demo2.repositorios;

import com.example.demo2.entidades.Estudante;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EstudanteRepositorioJPA implements EstudanteRepositorio{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Estudante> buscarTodos(){
        TypedQuery<Estudante> typedQuery = em.createQuery(
                "select e from Estudante e", Estudante.class
        );
        return typedQuery.getResultList();
    }

    @Override
    public Estudante buscarPorMatricula(String umaMatricula){
        return em.find(Estudante.class, umaMatricula);
    }

    @Override
    public void cadastrar(Estudante umEstudante){
        em.persist(umEstudante);
    }

    @Override
    public Estudante removerPorMatricula(String umaMatricula){
        Estudante umEstudante = em.find(Estudante.class, umaMatricula);
        if (umEstudante != null){
            em.remove(umEstudante);
        }
        return umEstudante;
    }

    @Override
    public void alterar(Estudante umEstudante){
        em.merge(umEstudante); //Altera o objeto em memória
    }
}
