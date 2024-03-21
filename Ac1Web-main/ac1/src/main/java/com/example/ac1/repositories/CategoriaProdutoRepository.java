package com.example.ac1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional

    public Categoria inserir(Categoria categoria) {
        entityManager.merge(categoria);
        return categoria;
    }

    public List<Categoria> selecionarTodos() {
        return entityManager.createQuery("Select p from Categoria p", Categoria.class).getResultList();
    }

    public Categoria selecionarPorId(Categoria categoria) {
        String jpql = "Select p from Categoria p where p.id ==  :id";
        TypedQuery<Categoria> query = entityManager.createQuery(jpql, Categoria.class);

        return query.getResultList().get(0);
    }

    public void excluir(int id) {
        String jpql = "Delete p from Categoria p where p.id == :id ";

        entityManager.createQuery(jpql, Categoria.class);
    }

    public Categoria editaCategoria(Categoria categoria) {
        String jpql = "Update p from Categoria p where p.id == :id set p.prod_name = :nome, p.prod_qtd = :quantidade";
        TypedQuery<Categoria> query = entityManager.createQuery(jpql, Categoria.class);

        return query.getResultList().get(0);
    }
}
