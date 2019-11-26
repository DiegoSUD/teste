package br.com.senac.view;

import java.util.Scanner;

import br.com.senac.modelo.ListaPonto;
import br.com.senac.modelo.Ponto;

// Trabalho Programacao e Algoritmos II
// Alexandre Vincius Ferreira da Silva
// Diego 
// Lucass

public class Principal {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
				//Inicializa o tamanho desejado.
				System.out.print("Digite um tamanho para o seu vetor: \n");
				int tamanho = Integer.parseInt(scanner.nextLine());
				ListaPonto principal = new ListaPonto(tamanho);
				menu();
				int opcao1 = 0;
				
				// Do While do Menu enquanto != 0
				do {
					int opcao = Integer.parseInt(scanner.nextLine());
					opcao1 = opcao;
					switch (opcao) {
					case 1:
						System.out.println("adicione o valor dos pontos x e y");
						int pontoX = Integer.parseInt(scanner.nextLine());
						int pontoY = Integer.parseInt(scanner.nextLine());
						principal.adicionarFinalDisponivel(new Ponto(pontoX, pontoY));
						menu();
						break;
					case 2:
						System.out.println("Digite o valor dos pontos x e y");
						int pontoX2 = Integer.parseInt(scanner.nextLine());
						int pontoY2 = Integer.parseInt(scanner.nextLine());
						System.out.println("Qual posicao deseja add o ponto");
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
							System.out.println("O indice do valor buscado: " + indice + "\n");
						}else {
							System.out.println("Nao existe esse ponto na lista: "  + indice + "\n");
						}
						menu();
						break;
					case 5:
						System.out.println("Digite a posicao que deseja remover");
						int posicao = Integer.parseInt(scanner.nextLine());
						principal.remove(posicao);
						System.out.println("Posicao removida com sucesso!!!");
						menu();
						break;
					case 6:
						double maiorDistancia = principal.calcularDistancia();
						System.out.println("A distancia dos dois pontos mais distantes na colecao e: " + maiorDistancia + "\n\n");
						menu();
						break;
					case 7:
						System.out.println("Digite o Valor do Raio");
						double value = Double.parseDouble(scanner.nextLine());
						ListaPonto pontosCircunferencia = principal.pontosCircunferencia(value);
						pontosCircunferencia.listar();
						System.out.println("Validos: "+pontosCircunferencia.getValidos()+"\n\n");
						menu();
						break;	
					case 0:
						System.out.println("Programa finalizado com sucesso !");
						break;	
			
					default:
						System.out.println("Opcao Invalida!");
						break;
					}
					
				} while (opcao1 != 0);
				
				
				
			}

			private static void menu() {
				System.out.printf(
						"******** Menu ***********\n"
						+ "1 - Adicionar novo ponto \n"
						+ "2 - Adicionar novo ponto em determinada posicao \n"
						+ "3 - Listar \n"
						+ "4 - Buscar por ponto \n"
						+ "5 - Remover ponto \n"
						+ "6 - Calcular distancia entre dois maiores pontos \n"
						+ "7 - Nova colecao por raio \n"
						+ "0 - Sair \n\n"
						+ "Escolha uma opcao \n"
						);
			}
}
