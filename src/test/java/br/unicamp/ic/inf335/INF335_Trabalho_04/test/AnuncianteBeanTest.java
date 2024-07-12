package br.unicamp.ic.inf335.INF335_Trabalho_04.test;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.INF335_Trabalho_04.beans.AnuncianteBean;
import br.unicamp.ic.inf335.INF335_Trabalho_04.beans.AnuncioBean;
import br.unicamp.ic.inf335.INF335_Trabalho_04.beans.ProdutoBean;

class AnuncianteBeanTest {

	private AnuncianteBean anunciante;
	private String nome;
    private String CPF;
    private ArrayList<AnuncioBean> anuncios;

	@BeforeEach
    public void setUp() {
		
		// Configura��o inicial para cada teste
		
		// Inicializa��o do anunciante
		nome = "Jerry";
        CPF = "123.456.789-00";
        anuncios = new ArrayList<>();
               
        ProdutoBean produto1 = new ProdutoBean("001", "Produto 1", "Descri��o do Produto 1", 100.0, "SP");
        ArrayList<URL> fotosUrl1 = new ArrayList<>();
        try {
            fotosUrl1.add(new URL("https://example.com/foto1.jpg"));
            fotosUrl1.add(new URL("https://example.com/foto2.jpg"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Double desconto1 = 0.1;

        AnuncioBean anuncio1 = new AnuncioBean(produto1, fotosUrl1, desconto1);
		anuncios.add(anuncio1);

        ProdutoBean produto2 = new ProdutoBean("002", "Produto 2", "Descri��o do Produto 2", 200.0, "RJ");
        ArrayList<URL> fotosUrl2 = new ArrayList<>();
        try {
            fotosUrl2.add(new URL("https://example.com/foto3.jpg"));
            fotosUrl2.add(new URL("https://example.com/foto4.jpg"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Double desconto2 = 0.5;

        AnuncioBean anuncio2 = new AnuncioBean(produto2, fotosUrl2, desconto2);
        anuncios.add(anuncio2);
        
        anunciante = new AnuncianteBean(nome, CPF, anuncios);
    }

	@Test
	@DisplayName("Verifica��o dos resultados esperados")
    public void testConstrutorAnuncianteBean() {
        
        assertEquals(nome, anunciante.getNome());
        assertEquals(CPF, anunciante.getCPF());
        assertEquals(anuncios, anunciante.getAnuncios());
    }
	
	@Test
	@DisplayName("Adicionar Anuncio")
    public void testAddAnuncio() {
    	ProdutoBean produto3 = new ProdutoBean("002", "Produto 2", "Descri��o do Produto 2", 300.0, "MG");
        ArrayList<URL> fotosUrl3 = new ArrayList<>();
        try {
            fotosUrl3.add(new URL("https://example.com/foto5.jpg"));
            fotosUrl3.add(new URL("https://example.com/foto6.jpg"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Double desconto3 = 0.3;

        AnuncioBean anuncio3 = new AnuncioBean(produto3, fotosUrl3, desconto3);
        anunciante.addAnuncio(anuncio3);
        assertEquals(3, anunciante.getAnuncios().size());
        assertEquals(anuncio3, anunciante.getAnuncios().get(2));
    }

    @Test
    @DisplayName("Remover Anuncio")
    public void testRemoveAnuncio() {
        anunciante.removeAnuncio(0);
        assertEquals(1, anunciante.getAnuncios().size());
        assertEquals("Produto 2", anunciante.getAnuncios().get(0).getProduto().getNome());
    }
    
    @Test
    @DisplayName("Valor M�dio dos Anuncios quando est� vazio")
    public void testValorMedioVazio() {
    	
        anuncios = new ArrayList<>(); 
        anunciante = new AnuncianteBean("Jerry", "123.456.789-00", anuncios);
    	assertEquals(0.0, anunciante.valorMedioAnuncios());
    }
    
    @Test
    @DisplayName("Valor M�dio dos Anuncios")
    public void testValorMedioAnuncios() {
        assertEquals(95.0, anunciante.valorMedioAnuncios());
    }


}
