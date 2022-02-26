package ada.elahorcado;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 * DEVOLOPED BY EIMI LEDESMA
 * 
 * */

public class ElAhorcado {

	private static int CHANCES = 10;

	public static void main(String[] args) {
		char ahorcado[];
		char ahorcadoEncriptado[];
		String letra;
		String palabra = "";
		int count = 0;
		char letraValida;

		Scanner scn = new Scanner(System.in);
		System.out.println("\tJUGADOR 1 ");
		System.out.println("Ingrese la palabra a descrifrar ");
		palabra = scn.next().toUpperCase();

		ahorcado = new char[palabra.length()];
		ahorcadoEncriptado = new char[palabra.length()];

		inicializarArreglo(ahorcado, palabra);

		iniciarArregloEncriptado(ahorcadoEncriptado);

		System.out.println("\n\n\n\n\n\n\n\n");
		System.out.println("La palabra tiene " + palabra.length() + " letras: ");
		mostrarArregloEncriptado(ahorcadoEncriptado);
		System.out.println("\n");

		System.out.println("\tJUGADOR 2 ");

		for (int i = 0; i < CHANCES && !(Arrays.equals(ahorcado, ahorcadoEncriptado)); i++) {

			System.out.println("Ingrese la letra de la palabra, de la A a la Z, o guion(-) para espacio ");
			letra = scn.next();

			while (letra.length() > 1) {
				System.out.println("\nIngrese una sola letra, de la A a la Z, o guion(-) para espacio ");
				letra = scn.next();
			}

			letraValida = validarSeaLetra(letra, scn);

			if (palabra.contains(letraValida + "")) {
				for (int j = 0; j < ahorcado.length; j++) {
					if (ahorcado[j] == Character.toUpperCase(letra.charAt(0))) {
						ahorcadoEncriptado[j] = Character.toUpperCase(letra.charAt(0));
					}
				}
				System.out.println("\n¡Bien hecho! Esa letra está en la palabra. Continuemos ☻");

			} else {
				System.out.println("\n¡Uy! Esa letra no se encuentra en la palabra. Elige otra ♦");

			}

			count++;
			System.out.println("\nHasta ahora tenemos: ");
			mostrarArregloEncriptado(ahorcadoEncriptado);
			System.out.println("\n");

		}

		if (count == CHANCES && !(Arrays.equals(ahorcado, ahorcadoEncriptado))) {
			System.out.println("\n¡No pudiste adivinar la palabra, vuelve a jugar!");
			System.out.println("\nLa palabra era: ");
			mostrarArreglo(ahorcado);
		}

		if (count <= CHANCES && (Arrays.equals(ahorcado, ahorcadoEncriptado))) {
			System.out.println("\n\t¡¡Felicitaciones!! ¡Adivinaste la palabra!");
		}

	}

	private static void mostrarArregloEncriptado(char[] ahorcadoArregloEncriptado) {
		for (int i = 0; i < ahorcadoArregloEncriptado.length; i++) {
			System.out.print(" " + Character.toUpperCase(ahorcadoArregloEncriptado[i]));
		}
	}

	private static char validarSeaLetra(String letraAValidar, Scanner scan) {
		char caracter = letraAValidar.charAt(0);

		// Si no está entre A y Z, ni es un espacio
		while (!((caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z') || (caracter == '-'))) {
			System.out.println("\nIngrese solo letra, de la A a la Z, o guion(-) para espacio");
			letraAValidar = scan.next();
			caracter = letraAValidar.charAt(0);
		}

		return Character.toUpperCase(caracter);
	}

	private static void iniciarArregloEncriptado(char[] ahorcadoArreglo) {
		for (int i = 0; i < ahorcadoArreglo.length; i++) {
			ahorcadoArreglo[i] = '*';
		}
	}

	private static void mostrarArreglo(char[] ahorcadoArreglo) {
		for (int i = 0; i < ahorcadoArreglo.length; i++) {
			System.out.print(" " + Character.toUpperCase(ahorcadoArreglo[i]));
		}
	}

	private static void inicializarArreglo(char[] ahorcadoArreglo, String palabraDada) {
		for (int i = 0; i < ahorcadoArreglo.length; i++) {
			ahorcadoArreglo[i] = Character.toUpperCase(palabraDada.charAt(i));
		}
	}

}