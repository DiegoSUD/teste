package br.com.senac.teste;

import br.com.senac.modelo.ListaPonto;
import br.com.senac.modelo.Ponto;

public class Teste {
	public static void main(String[] args) {
		ListaPonto lista = new ListaPonto(10);

		// Exercicio 01
		lista.adicionarFinalDisponivel(new Ponto(10, 2));
		lista.adicionarFinalDisponivel(new Ponto(2, 4));
		lista.adicionarFinalDisponivel(new Ponto(4, 1));
		lista.adicionarFinalDisponivel(new Ponto(3, 3));

		for (int i = 0; i < lista.getPontos().length; i++) {
			System.out.print(lista.getPontos()[i] + " ");
		}

		System.out.println();
		System.out.println("V�lidos: " + lista.getValidos());

		// Exercicio 02
		lista.adicionarEmPosicao(1, new Ponto(9, 5));
		for (int i = 0; i < lista.getPontos().length; i++) {
			System.out.print(lista.getPontos()[i] + " ");
		}
		System.out.println();
		System.out.println("V�lidos: " + lista.getValidos());

		// Exercicio 03
		System.out.println(lista.indicePrimeiraOcorrencia(new Ponto(3, 10)));

		// Exercicio 04
		lista.remove(3);
		for (int i = 0; i < lista.getPontos().length; i++) {
			System.out.print(lista.getPontos()[i] + " ");
		}
		System.out.println();
		System.out.println("V�lidos: " + lista.getValidos());

		// Exercicio 06
		ListaPonto pontosCircunferencia = lista.pontosCircunferencia(1.9);
		for (int i = 0; i < pontosCircunferencia.getPontos().length; i++) {
			if (pontosCircunferencia.getPontos()[i] != null)
				System.out.print(pontosCircunferencia.getPontos()[i]);
		}
		System.out.println();
		System.out.println(pontosCircunferencia.getValidos());
	}
}
