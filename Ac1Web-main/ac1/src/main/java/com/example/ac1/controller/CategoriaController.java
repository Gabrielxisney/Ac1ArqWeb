package com.example.ac1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac1.models.Categoria;
import com.example.ac1.repositories.CategoriaProdutoRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaProdutoRepository categoriaProdutoRepository;

    public CategoriaController(CategoriaProdutoRepository categoriaProdutoRepository) {
        this.categoriaProdutoRepository = categoriaProdutoRepository;
    }

    @GetMapping()
    public List<Categoria> mostrarTodos() {
        return categoriaProdutoRepository.selecionarTodos();
    }

    @PostMapping()
    public void inserir(@RequestBody Categoria categoria) {
        categoriaProdutoRepository.inserir(categoria);
    }
}
