package br.unicamp.ic.inf335.INF335_Trabalho_04.test;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.INF335_Trabalho_04.beans.AnuncioBean;
import br.unicamp.ic.inf335.INF335_Trabalho_04.beans.ProdutoBean;

class AnuncioBeanTest {

	private AnuncioBean anuncio;

    @BeforeEach
    public void setUp() {
        // Configura��o inicial para cada teste
        ProdutoBean produto = new ProdutoBean("001", "Produto 1", "Descri��o do Produto 1", 100.0, "SP"); // Exemplo de produto fict�cio
        ArrayList<URL> fotosUrl = new ArrayList<>();
        try {
            fotosUrl.add(new URL("https://example.com/foto1.jpg"));
            fotosUrl.add(new URL("https://example.com/foto2.jpg"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Double desconto = 0.1; // 10% de desconto

        anuncio = new AnuncioBean(produto, fotosUrl, desconto);
    }

    @Test
    @DisplayName("Valor Com Desconto")
    public void testGetValorComDesconto() {
        Double valorEsperado = 90.0; // Valor esperado ap�s aplicar 10% de desconto
        assertEquals(valorEsperado, anuncio.getValor());
    }

}
