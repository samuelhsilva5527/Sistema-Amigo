package br.ufpb.dcx.samuel.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AmigoTest {
	
	Amigo amigo;
	private static String NOME_AMIGO = "José da Silva";
	private static String EMAIL_AMIGO = "jose@gmail.com";
	
	@BeforeEach
	void setUp() throws Exception {
		amigo = new Amigo(NOME_AMIGO, EMAIL_AMIGO);
	}

	@Test
	void testAmigo() {
		assertTrue(amigo.getNome().equals(NOME_AMIGO));
		assertEquals(EMAIL_AMIGO, amigo.getEmail());
	}

	@Test
	void testGetNome() {
		assertTrue(amigo.getNome().equals(NOME_AMIGO));
	}

	@Test
	void testSetNome() {
		amigo.setNome("MARIA");
		assertEquals("MARIA", amigo.getNome());
	}

	@Test
	void testGetEmail() {
		assertEquals(EMAIL_AMIGO, amigo.getEmail());
	}

	@Test
	void testSetEmail() {
		amigo.setEmail("seila@gmail.com");
		assertEquals("seila@gmail.com", amigo.getEmail());
	}

	@Test
	void testGetAndSetEmailAmigoSorteado() {
		assertNull(amigo.getEmailAmigoSorteado());
		amigo.setEmailAmigoSorteado("Maria@gmail.com");
		assertEquals("Maria@gmail.com", amigo.getEmailAmigoSorteado());
	}

}
