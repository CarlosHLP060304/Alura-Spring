package br.com.alura.loja.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
		Produto produto = new Produto();
		Categoria categoria = new Categoria("Cel");
		produto.setNome("Xiaomi");
		produto.setDescricao("top dms");
		produto.setPreco(new BigDecimal("800000"));
		produto.setCategoria(categoria);
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		new CategoriaDao(em).cadastrar(categoria);
		new ProdutoDao(em).cadastrar(produto);
		em.getTransaction().commit();
		em.close();
	}
}
