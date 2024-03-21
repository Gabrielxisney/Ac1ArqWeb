package com.example.ac1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private int id;

    @Column(length = 200, nullable = false, name = "prod_nome")
    private String nome;

    @Column(length = 200, nullable = false, name = "prod_qtd")
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Produto() {
    }

    public Produto(int id, String nome, int quantidade, int categoriaId) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
