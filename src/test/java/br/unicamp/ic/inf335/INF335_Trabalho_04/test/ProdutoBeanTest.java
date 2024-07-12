package br.unicamp.ic.inf335.INF335_Trabalho_04.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.INF335_Trabalho_04.beans.ProdutoBean;

class ProdutoBeanTest {

	 private ProdutoBean produto1;
	    private ProdutoBean produto2;

	    @BeforeEach
	    public void setUp() {
	        produto1 = new ProdutoBean("001", "Produto 1", "Descri��o do Produto 1", 100.0, "SP");
	        produto2 = new ProdutoBean("002", "Produto 2", "Descri��o do Produto 2", 150.0, "RJ");
	    }

	    @Test
	    public void testGettersAndSetters() {
	        assertEquals("001", produto1.getCodigo());
	        assertEquals("Produto 1", produto1.getNome());
	        assertEquals("Descri��o do Produto 1", produto1.getDescricao());
	        assertEquals(100.0, produto1.getValor());
	        assertEquals("SP", produto1.getEstado());
	        
	        assertEquals("002", produto2.getCodigo());
	        assertEquals("Produto 2", produto2.getNome());
	        assertEquals("Descri��o do Produto 2", produto2.getDescricao());
	        assertEquals(150.0, produto2.getValor());
	        assertEquals("RJ", produto2.getEstado());
	    }

	    @Test
	    @DisplayName("Ordenar")
	    public void testCompareTo() {
	        // produto1 tem valor 100.0, produto2 tem valor 150.0
	        assertTrue(produto1.compareTo(produto2) < 0); // produto1 deve ser menor que produto2
	        assertTrue(produto2.compareTo(produto1) > 0); // produto2 deve ser maior que produto1

	        ProdutoBean produto3 = new ProdutoBean("003", "Produto 3", "Descri��o do Produto 3", 100.0, "MG");
	        assertEquals(0, produto1.compareTo(produto3)); // produto1 e produto3 devem ser iguais em valor
	    }

}
