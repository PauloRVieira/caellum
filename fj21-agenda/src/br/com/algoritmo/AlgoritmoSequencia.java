package br.com.algoritmo;

import java.util.Arrays;

public class AlgoritmoSequencia {

	/**
	 * 
	 * Implemente o método que recebe um array de inteiros de uma maneira que
	 * retorne os números organizados separados por " - "(hífen) quando os números
	 * forem sequenciais mostrando o primeiro número até o último número do período
	 * e ", "(vírgula) quando existir uma quebra da sequência, por exemplo:
	 * 
	 * Exemplo 1 : Entrada : {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} Saída : "1 - 10"
	 * Exemplo 2 : Entrada : {1, 2, 3, 4, 6, 7 ,8, 9} Saída : "1 - 4, 6 - 9"
	 * Exemplo 3 : Entrada : {1, 2, 3, 4, 5, 8, 10, 11, 12, 13, 14, 15} Saída : "1 - 5, 8, 10 - 15"
	 * Exemplo 4 : Entrada : {1, 2, 3, 5, 7, 10, 11, 12, 13, 20} Saída : "1 - 3, 5, 7, 10 - 13, 20"
	 * Exemplo 5 : Entrada : {1, 3, 5, 6, 9, 10, 11, 12} Saída : "1, 3, 5 - 6, 9 - 12"
	 */
	public static String obterSequenciaFormatada(Integer[] valores) {
		Integer firstElement = 0;
		Integer lastElement = 0;
		Integer valorAnterior;
		Integer valorAtual;
		
		StringBuilder sb = new StringBuilder();
		Integer[] newValores = null;
		
		firstElement = valores[0];
		
		// looping para descobrir o primeiro e o último elemento de um range.
		// se tiver outros ranges dentro dos valores irá iterar novamente no método
		for (int i = 1; i < valores.length; i++) {
			valorAnterior = valores[i-1];
			valorAtual = valores[i];
			// valor anterior acréscido de 1 é igual ao valor sequinte (para descobrir se é sequencial)
			if ((valorAnterior+1) == valorAtual) {
				// atual elemento é sequencial
				lastElement = valorAtual;
			} else {
				// não é sequencial, termina o looping e cria novo array com novo range de valores
				newValores = Arrays.copyOfRange(valores, i, valores.length);
				break;
			}
		}
		
		// fim deste range
		sb.append(firstElement);
		if (lastElement > 0 && !firstElement.equals(lastElement)) {
			sb.append(" - ").append(lastElement);
		}
		
		// se tiver outros ranges, irá iterar novamente no método
		if (newValores != null) {
			sb.append(", ");
			sb.append(obterSequenciaFormatada(newValores));
		}

		return sb.toString();
	}
}