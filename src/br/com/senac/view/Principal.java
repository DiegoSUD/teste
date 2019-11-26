package br.com.senac.view;

import java.util.Scanner;

import br.com.senac.modelo.ListaPonto;
import br.com.senac.modelo.Ponto;

public class Principal {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
				
				System.out.print("Digite um tamanho para o seu vetor: \n");
				int tamanho = Integer.parseInt(scanner.nextLine());
				ListaPonto principal = new ListaPonto(tamanho);
				menu();
				int opcao1 = 0;
				
				//teste
				
				do {
					int opcao = Integer.parseInt(scanner.nextLine());
					opcao1 = opcao;
					switch (opcao) {
					case 1:
						System.out.println("adicione o valor dos pontos x e y \n");
						int pontoX = Integer.parseInt(scanner.nextLine());
						int pontoY = Integer.parseInt(scanner.nextLine());
						principal.adicionarFinalDisponivel(new Ponto(pontoX, pontoY));
						menu();
						break;
					case 2:
						System.out.println("Digite o valor dos pontos x e y \n");
						int pontoX2 = Integer.parseInt(scanner.nextLine());
						int pontoY2 = Integer.parseInt(scanner.nextLine());
						System.out.println("Qual posi��o deseja add o ponto \n ");
						int pos = Integer.parseInt(scanner.nextLine());
						principal.adicionarEmPosicao(pos, new Ponto(pontoX2, pontoY2));
						menu();
						break;	
					case 3:
						principal.listar();
						menu();
						break;
					case 4:
						System.out.println("adicione o valor dos pontos x e y");
						int pontoX4 = Integer.parseInt(scanner.nextLine());
						int pontoY4 = Integer.parseInt(scanner.nextLine());
						int indice = principal.indicePrimeiraOcorrencia(new Ponto(pontoX4, pontoY4));
						if(indice != -1) {
							System.out.println("O indice � : " + indice + "\n");
						}else {
							System.out.println("N�o existe esse ponto na lista: "  + indice + "\n");
						}
						menu();
						break;
					case 5:
						System.out.println("adicione o valor dos pontos x e y");
						int pontoX5 = Integer.parseInt(scanner.nextLine());
						int pontoY5 = Integer.parseInt(scanner.nextLine());
//						principal.adicionarFinalDisponivel(new Ponto(pontoX, pontoY));
						menu();
						break;
					case 6:
						System.out.println("adicione o valor dos pontos x e y");
						int pontoX6 = Integer.parseInt(scanner.nextLine());
						int pontoY6 = Integer.parseInt(scanner.nextLine());
//						principal.adicionarFinalDisponivel(new Ponto(pontoX, pontoY));
						menu();
						break;
					case 7:
						System.out.println("adicione o valor dos pontos x e y");
						int pontoX7 = Integer.parseInt(scanner.nextLine());
						int pontoY7 = Integer.parseInt(scanner.nextLine());
//						principal.adicionarFinalDisponivel(new Ponto(pontoX, pontoY));
						menu();
						break;	
					case 0:
						break;	
			
					default:
						System.out.println("Op��o Inv�lida!");
						break;
					}
					
				} while (opcao1 != 0);
				
				
				
			}

			private static void menu() {
				System.out.printf(
						"******** Menu ***********\n"
						+ "1 - Adicionar novo ponto \n"
						+ "2 - Adicionar novo ponto em determinada posi��o \n"
						+ "3 - Listar \n"
						+ "4 - Buscar por ponto \n"
						+ "5 - Remover ponto \n"
						+ "6 - Calcular dist�ncia entre dois pontos \n"
						+ "7 - Nova cole��o por raio \n"
						+ "0 - Sair \n\n"
						+ "Escolha uma op��o \n"
						);
			}
}
