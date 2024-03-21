package com.example.ac1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProductRespository {
    @Autowired
    private EntityManager entityManager;

    @Transactional

    public Produto inserir(Produto produto) {
        entityManager.merge(produto);
        return produto;
    }

    public List<Produto> selecionarTodos() {
        return entityManager.createQuery("Select p from Produto p", Produto.class).getResultList();
    }

    public Produto selecionarPorId(Produto produto) {
        String jpql = "Select p from Produto p where p.id ==  :id";
        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);

        return query.getResultList().get(0);
    }

    public void excluir(int id) {
        String jpql = "Delete p from Produto p where p.id == :id ";

        entityManager.createQuery(jpql, Produto.class);
    }

    public Produto editaProduto(Produto produto) {
        String jpql = "Update p from Produto p where p.id == :id set p.prod_name = :nome, p.prod_qtd = :quantidade";
        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);

        return query.getResultList().get(0);
    }
}
