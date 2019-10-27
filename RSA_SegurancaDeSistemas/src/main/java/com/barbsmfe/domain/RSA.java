package com.barbsmfe.domain;

import java.math.BigInteger;
import java.util.Random;

public class RSA {

	private final static int TAMANHO_DE_BITS = 1024;

	public BigInteger encontrarPrimo() {
		return BigInteger.probablePrime(TAMANHO_DE_BITS, new Random());
	}

	public BigInteger gerarPrimeiraParteChavePublicaN(BigInteger primeiroNumeroPrimo, BigInteger segundoNumeroPrimo) {
		return primeiroNumeroPrimo.multiply(segundoNumeroPrimo).abs();
	}

	public BigInteger gerarSegundaParteChavePublicaPhi(BigInteger primeiroNumeroPrimo, BigInteger segundoNumeroPrimo) {
		return primeiroNumeroPrimo.subtract(BigInteger.ONE).multiply((segundoNumeroPrimo.subtract(BigInteger.ONE)))
				.abs();
	}

	public BigInteger gerarChavePrivada(BigInteger expoente, BigInteger phi) {
		return expoente.modInverse(phi).abs();
	}

	public BigInteger calcularExpoente(BigInteger phi) {
		BigInteger expoente;
		Random novoNumeroAleatorio = new Random();
		expoente = BigInteger.probablePrime(TAMANHO_DE_BITS / 2, novoNumeroAleatorio);

		while (phi.gcd(expoente).compareTo(BigInteger.ONE) > 0 && expoente.compareTo(phi) < 0) {
			expoente.add(BigInteger.ONE);
		}
		return expoente;
	}

	public BigInteger cifrarMensagem(String mensagem, BigInteger expoente, BigInteger chavePublicaN) {
		BigInteger mensagemBigInteger = new BigInteger(mensagem.getBytes());

		return mensagemBigInteger.modPow(expoente, chavePublicaN);
	}

	public String decifrarMensagem(BigInteger mensagemCifrada, BigInteger chavePrivada, BigInteger chavePublicaN) {
		BigInteger mensagemDecifrada = (new BigInteger(mensagemCifrada.toByteArray())).modPow(chavePrivada,
				chavePublicaN);

		return new String(mensagemDecifrada.toByteArray());
	}

}
