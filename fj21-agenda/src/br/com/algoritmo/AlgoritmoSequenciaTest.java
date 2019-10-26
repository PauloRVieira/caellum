package br.com.algoritmo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlgoritmoSequenciaTest {
	
	@Test
	void test1() {
		Integer[] input = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		String output = AlgoritmoSequencia.obterSequenciaFormatada(input);
		assertEquals(output, "1 - 10");
	}
	
	@Test
	void test2() {
		Integer[] input = new Integer[] { 1, 2, 3, 4, 6, 7, 8, 9 };
		String output = AlgoritmoSequencia.obterSequenciaFormatada(input);
		assertEquals(output, "1 - 4, 6 - 9");
	}
	
	@Test
	void test3() {
		Integer[] input = new Integer[] { 1, 2, 3, 4, 5, 8, 10, 11, 12, 13, 14, 15 };
		String output = AlgoritmoSequencia.obterSequenciaFormatada(input);
		assertEquals(output, "1 - 5, 8, 10 - 15");
	}
	
	@Test
	void test4() {

		Integer[] input = new Integer[] { 1, 2, 3, 5, 7, 10, 11, 12, 13, 20 };
		String output = AlgoritmoSequencia.obterSequenciaFormatada(input);
		assertEquals(output, "1 - 3, 5, 7, 10 - 13, 20");
	}
	
	@Test
	void test5() {
		Integer[] input = new Integer[] { 1, 3, 5, 6, 9, 10, 11, 12 };
		String output = AlgoritmoSequencia.obterSequenciaFormatada(input);
		assertEquals(output, "1, 3, 5 - 6, 9 - 12");
	}

	@Test
	void test6() { // Test começando com 0
		Integer[] input = new Integer[] { 0, 1, 3, 5, 7 };
		String output = AlgoritmoSequencia.obterSequenciaFormatada(input);
		assertEquals(output, "0 - 1, 3, 5, 7");
	}

	@Test
	void test7() {// Test começando com 0
		Integer[] input = new Integer[] { 0, 3, 5, 6 };
		String output = AlgoritmoSequencia.obterSequenciaFormatada(input);
		assertEquals(output, "0, 3, 5 - 6");
	}

	@Test
	void test8() {// Test começando com 0
		Integer[] input = new Integer[] { 0, 1, 2, 3, 5, 6 };
		String output = AlgoritmoSequencia.obterSequenciaFormatada(input);
		assertEquals(output, "0 - 3, 5 - 6");
	}

	@Test
	void test9() { // teste números grandes
		Integer[] input = new Integer[] { 110, 111, 1000, 100001, 100002, 1000002, 10000002, 10000003 };
		String output = AlgoritmoSequencia.obterSequenciaFormatada(input);
		assertEquals(output, "110 - 111, 1000, 100001 - 100002, 1000002, 10000002 - 10000003");
	}
	
}
