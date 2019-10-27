package com.barbsmfe.controller;

import java.math.BigInteger;

import com.barbsmfe.domain.RSA;

public class Main {

	public static void main(String[] args) {
		
		RSA rsa = new RSA();
		
		BigInteger primeiroNumeroPrimo = rsa.encontrarPrimo();
		BigInteger segundoNumeroPrimo = rsa.encontrarPrimo();
		BigInteger chavePublica_N = rsa.gerarPrimeiraParteChavePublicaN(primeiroNumeroPrimo, segundoNumeroPrimo);
		BigInteger chavePublica_Phi = rsa.gerarSegundaParteChavePublicaPhi(primeiroNumeroPrimo, segundoNumeroPrimo);
		BigInteger expoente = rsa.calcularExpoente(chavePublica_Phi);
		BigInteger chavePrivada = rsa.gerarChavePrivada(expoente, chavePublica_Phi);
		
		String mensagem = "Hello, this is a test";
		
		BigInteger mensagemCifrada = rsa.cifrarMensagem(mensagem, expoente, chavePublica_N);
		
		String mensagemDecifrada = rsa.decifrarMensagem(mensagemCifrada, chavePrivada, chavePublica_N);
		
		System.out.println("Mensagem original: " + mensagem);
		System.out.println("Mensagem cifrada: " + mensagemCifrada.toString() + " ");		
		System.out.println("Mensagem decifrada: " + mensagemDecifrada);
	}

}
