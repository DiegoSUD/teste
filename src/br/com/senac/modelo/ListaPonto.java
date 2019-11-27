package br.com.senac.modelo;

public class ListaPonto {
	
	
	/*
	 * Atributos
	 */
	private Ponto pontos[];
	private int validos;

	
	
	/*
	 * Construtor
	 */
	public ListaPonto(int n) {
		this.pontos = new Ponto[n];
		this.validos = 0;
	}

	/*
	 * Adiciona o ponto no final da lista
	 */
	public void adicionarFinalDisponivel(Ponto p) {
		for (int i = 0; i < this.pontos.length; i++) {
			if (this.pontos[i] == null) {
				this.pontos[i] = p;
				this.validos++;
				return;
			}
		}
		System.out.println("[ERROR] - Lista cheia, nao foi possivel adicionar o ponto: " + p );
		System.out.println();
		System.out.println();
	}

	/*
	 * Adicionar em uma posicao especifica
	 */
	public void adicionarEmPosicao(int posicao, Ponto p) {
		if (this.pontos.length <= posicao || this.validos == this.pontos.length) {
			System.out.println("[ERROR] - Posicao indisponivel \n\n");
			return;
		}
		if (this.pontos[posicao] == null) {
			adicionarFinalDisponivel(p);
		} else {
			for (int i = this.pontos.length - 1; i >= posicao; i--) {
				if (this.pontos[i] != null) {
					int pos = i;
					pos++;
					this.pontos[pos] = this.pontos[i];
					this.pontos[i] = null;
				}
			}
			adicionarFinalDisponivel(p);
		}
	}

	/*
	 * Retornar o indice da primeiro ocorrencia
	 */
	public int indicePrimeiraOcorrencia(Ponto p) {
		for (int i = 0; i < this.pontos.length; i++) {
			if (this.pontos[i] != null) {
				if (this.pontos[i].igual(p)) {
					return i;
				}
			}
		}
		return -1;
	}

	/*
	 * Remover um ponto atraves do indice
	 */
	public void remove(int posicao) {
		if (this.pontos.length <= posicao || this.pontos[posicao] == null) {
			System.out.println("[ERROR] - Posicao indisponivel");
			return;
		}
		this.pontos[posicao] = null;
		this.validos--;
		for (int i = 0; i < this.pontos.length - 1; i++) {
			if (this.pontos[i] == null) {
				int pos = i;
				pos++;
				this.pontos[i] = this.pontos[pos];
				this.pontos[pos] = null;
			}
		}
	}

	/*
	 * Calcular distancia entre os dois maiores pontos
	 */
	public double calcularDistancia() {
		double distanciaMaior = 0.0;
		for (int i = 0; i < this.pontos.length - 1; i++) {
			if (this.pontos[i] != null) {
				int pos = i;
				pos++;

				for (int j = pos; j < this.pontos.length; j++) {
					if (this.pontos[j] != null) {
						double distancia = this.pontos[i].distancia(this.pontos[j]);
						if (distancia > distanciaMaior) {
							distanciaMaior = distancia;
						}
					}
				}
			}
		}
		return distanciaMaior;
	}
	
	public ListaPonto pontosCircunferencia(double raio) {
		ListaPonto novosPontos = new ListaPonto(this.validos);
		double raioPontos = 0.0;
		for(int i = 0; i < this.pontos.length; i++) {
			if(this.pontos[i] != null) {
				raioPontos = calculadorRaio(this.pontos[i]);
				if(raioPontos < raio) {
					novosPontos.adicionarFinalDisponivel(this.pontos[i]);
				}
			}
		}
		return novosPontos;
	}
	
	public void listar() {
		System.out.println("Valores da Lista: ");
		for(int i = 0; i < this.pontos.length; i++) {
			if(getPontos()[i] != null) {
			System.out.print("pos: "+i+" "+getPontos()[i] + " / ");
			}
		}
		System.out.println("\n\n");
	}
	
	private double calculadorRaio(Ponto p) {
		return ((p.getX() + p.getY()) / 2) / Math.PI;
	}

	public Ponto[] getPontos() {
		return pontos;
	}

	public int getValidos() {
		return validos;
	}

}
