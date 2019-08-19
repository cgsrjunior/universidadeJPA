package com.example.demo2.entidades;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "Estudante")
public class Estudante {
    @Id
    private String matricula;
    @Column(nullable = false)
    @Positive(message = "Idade deve ser maior que zero")
    private int idade;
    @Column(nullable = false)
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 50, message = "Nome deve ter entre 5 e 50 chars")
    private String nome;
    @ElementCollection
    private Collection<String> telefones;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Curso> cursos;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "[nome = " + getNome() + ", idade = " + getIdade() + ", matricula = " + getMatricula() + "]";
    }

    public Collection<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Collection<String> telefones) {
        this.telefones = telefones;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }
}
