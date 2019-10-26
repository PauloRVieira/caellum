package br.com.algoritmo;

import java.util.Arrays;

public class AlgoritmoSequencia {

	/**
	 * 
	 * Implemente o m�todo que recebe um array de inteiros de uma maneira que
	 * retorne os n�meros organizados separados por " - "(h�fen) quando os n�meros
	 * forem sequenciais mostrando o primeiro n�mero at� o �ltimo n�mero do per�odo
	 * e ", "(v�rgula) quando existir uma quebra da sequ�ncia, por exemplo:
	 * 
	 * Exemplo 1 : Entrada : {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} Sa�da : "1 - 10"
	 * Exemplo 2 : Entrada : {1, 2, 3, 4, 6, 7 ,8, 9} Sa�da : "1 - 4, 6 - 9"
	 * Exemplo 3 : Entrada : {1, 2, 3, 4, 5, 8, 10, 11, 12, 13, 14, 15} Sa�da : "1 - 5, 8, 10 - 15"
	 * Exemplo 4 : Entrada : {1, 2, 3, 5, 7, 10, 11, 12, 13, 20} Sa�da : "1 - 3, 5, 7, 10 - 13, 20"
	 * Exemplo 5 : Entrada : {1, 3, 5, 6, 9, 10, 11, 12} Sa�da : "1, 3, 5 - 6, 9 - 12"
	 */
	public static String obterSequenciaFormatada(Integer[] valores) {
		Integer firstElement = 0;
		Integer lastElement = 0;
		Integer valorAnterior;
		Integer valorAtual;
		
		StringBuilder sb = new StringBuilder();
		Integer[] newValores = null;
		
		firstElement = valores[0];
		
		// looping para descobrir o primeiro e o �ltimo elemento de um range.
		// se tiver outros ranges dentro dos valores ir� iterar novamente no m�todo
		for (int i = 1; i < valores.length; i++) {
			valorAnterior = valores[i-1];
			valorAtual = valores[i];
			// valor anterior acr�scido de 1 � igual ao valor sequinte (para descobrir se � sequencial)
			if ((valorAnterior+1) == valorAtual) {
				// atual elemento � sequencial
				lastElement = valorAtual;
			} else {
				// n�o � sequencial, termina o looping e cria novo array com novo range de valores
				newValores = Arrays.copyOfRange(valores, i, valores.length);
				break;
			}
		}
		
		// fim deste range
		sb.append(firstElement);
		if (lastElement > 0 && !firstElement.equals(lastElement)) {
			sb.append(" - ").append(lastElement);
		}
		
		// se tiver outros ranges, ir� iterar novamente no m�todo
		if (newValores != null) {
			sb.append(", ");
			sb.append(obterSequenciaFormatada(newValores));
		}

		return sb.toString();
	}
}