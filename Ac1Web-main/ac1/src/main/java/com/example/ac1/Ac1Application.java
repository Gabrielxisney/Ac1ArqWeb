package com.example.ac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.Categoria;
import com.example.ac1.models.Produto;
import com.example.ac1.repositories.CategoriaProdutoRepository;
import com.example.ac1.repositories.ProductRespository;

@SpringBootApplication
public class Ac1Application {

	@Bean
	public CommandLineRunner init(@Autowired ProductRespository productRepository,
			@Autowired CategoriaProdutoRepository categoriaProductRepository) {
		return args -> {

			categoriaProductRepository.inserir(new Categoria(1, "Esportes", "Equipamentos esportivos"));
			categoriaProductRepository.inserir(new Categoria(2, "Informatica", "Equipamentos informaticos"));

			System.out.println("*** Listar todas as categorias ***");
			List<Categoria> listaCategorias = categoriaProductRepository.selecionarTodos();
			for (int i = 0; i < listaCategorias.size(); i++) {
				System.out.println("------------------------------------");
				System.out.print(listaCategorias.get(i).getId()  + " | ");
				System.out.print(listaCategorias.get(i).getNome() + " | ");
				System.out.println(listaCategorias.get(i).getDescricao() + " | ");
			}

			productRepository.inserir(new Produto(1, "Caneleira", 10, 0));
			productRepository.inserir(new Produto(2, "Bola de futebol", 5, 0));
			productRepository.inserir(new Produto(3, "Celular", 12, 1));
			productRepository.inserir(new Produto(4, "Tablet", 15, 1));

			System.out.println("*** Listar todas os produtos ***");
			List<Produto> listProdutos = productRepository.selecionarTodos();
			for (int i = 0; i < listProdutos.size(); i++) {
				System.out.println("------------------------------------");
				System.out.print(listProdutos.get(i).getId() + " | ");
				System.out.print(listProdutos.get(i).getNome()  + " | ");
				System.out.println(listProdutos.get(i).getQuantidade());
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

}
