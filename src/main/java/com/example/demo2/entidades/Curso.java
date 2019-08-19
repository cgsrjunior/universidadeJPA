package com.example.demo2.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    private String codigo;
    @Column(nullable = false)
    private String nome;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean equals(Object obj){
        Curso outro = (Curso)obj;
        return super.equals(obj)
                && this.codigo.equals(outro.codigo)
                && this.nome.equals(outro.nome);
    }


}
