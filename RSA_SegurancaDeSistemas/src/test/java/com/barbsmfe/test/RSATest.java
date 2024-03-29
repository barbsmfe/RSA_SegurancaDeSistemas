/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.barbsmfe.test;

import org.junit.Test;

import com.barbsmfe.domain.RSA;

import static org.junit.Assert.*;

import java.math.BigInteger;

public class RSATest {
	
	private RSA rsa;

	@Test
	public void testarSeNumeroGeradoEPrimo() {
		rsa = new RSA();

		BigInteger numeroPrimo = rsa.encontrarPrimo();
		
		assertTrue(numeroPrimo.isProbablePrime(1));
	}
	
	@Test
	public void testarSeMensagemFoiDecifradaCorretamente() {
		rsa = new RSA();
		
		BigInteger primeiroNumeroPrimo = rsa.encontrarPrimo();
		BigInteger segundoNumeroPrimo = rsa.encontrarPrimo();
		BigInteger chavePublica_N = rsa.gerarPrimeiraParteChavePublicaN(primeiroNumeroPrimo, segundoNumeroPrimo);
		BigInteger chavePublica_Phi = rsa.gerarSegundaParteChavePublicaPhi(primeiroNumeroPrimo, segundoNumeroPrimo);
		BigInteger expoente = rsa.calcularExpoente(chavePublica_Phi);
		BigInteger chavePrivada = rsa.gerarChavePrivada(expoente, chavePublica_Phi);
		
		String mensagem = "Hello, I am just a student trying to graduate, send help I am not ok";
		BigInteger mensagemCifrada = rsa.cifrarMensagem(mensagem, expoente, chavePublica_N);
		
		String mensagemDecifrada = rsa.decifrarMensagem(mensagemCifrada, chavePrivada, chavePublica_N);
		
		assertEquals(mensagem, mensagemDecifrada);
	}
}
