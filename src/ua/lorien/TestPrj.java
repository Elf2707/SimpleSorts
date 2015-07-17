package ua.lorien;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TestPrj {

	public static void main(String[] args) {
		System.out
				.println("¬ведите количество элемнтов массива (10 by default)");
		Scanner userInput = new Scanner(System.in);

		int elmCount = userInput.nextInt();
		elmCount = (elmCount > 0) ? elmCount : 10;

		int[] a = new int[elmCount];

		Random rndmGen = new Random();
		for (int i = 0; i < elmCount; i++) {
			a[i] = rndmGen.nextInt(100);
		}
		int[] b = a.clone();
		int[] c = a.clone();
		int[] d = a.clone();
		int[] e = a.clone();

		// System.out.println(Arrays.toString(a));

		long startTime = System.currentTimeMillis();
		int temp = 0;
		for (int i = 0; i < elmCount; i++) {

			for (int j = 1; j < elmCount - i; j++) {
				if (a[j - 1] > a[j]) {
					temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}

		long endTime = System.currentTimeMillis();

		// System.out.println(Arrays.toString(a));
		System.out.println("Simple bubble: " + (endTime - startTime));

		startTime = System.currentTimeMillis();
		temp = 0;
		for (int i = 0; i < elmCount / 2; i++) {

			for (int j = 1; j < elmCount - i; j++) {
				if (b[j - 1] > b[j]) {
					temp = b[j];
					b[j] = b[j - 1];
					b[j - 1] = temp;
				}
			}

			for (int j = elmCount - (i + 1) - 1; j > i; j--) {
				if (b[j] < b[j - 1]) {
					temp = b[j];
					b[j] = b[j - 1];
					b[j - 1] = temp;
				}
			}
		}

		endTime = System.currentTimeMillis();
		System.out.println("Shaker bubble: " + (endTime - startTime));

		startTime = System.currentTimeMillis();
		temp = 0;
		int pointer = 0;
		for (int i = 0; i < elmCount; i++) {
			pointer = i;
			for (int j = i; j < elmCount; j++) {
				if (c[j] < c[pointer]) {
					pointer = j;
				}
			}
			temp = c[i];
			c[i] = c[pointer];
			c[pointer] = temp;
		}

		// System.out.println(Arrays.toString(c));
		endTime = System.currentTimeMillis();
		System.out.println("Choosing: " + (endTime - startTime));

		// simple insert
		// System.out.println(Arrays.toString(d));
		startTime = System.currentTimeMillis();
		temp = 0;
		pointer = 0;
		for (int i = 1; i < elmCount; i++) {
			temp = d[i];
			int j;
			for ( j = i; ( j > 0) && (d[j - 1] > temp); j--) {
				d[j] = d[j - 1];
			}
			d[j] = temp;
		}

		endTime = System.currentTimeMillis();
		System.out.println( "Simple insert:" + (endTime - startTime));
			
		startTime = System.currentTimeMillis();
		temp = 0;
		pointer = 0;
		for (int i = 1; i < elmCount; i++) {
			temp = e[i];
			pointer = getPos(e, i, temp);
			for (int j = i; j > pointer; j--) {
				e[j] = e[j - 1];
			}
			e[pointer] = temp;
		}

		endTime = System.currentTimeMillis();
		System.out.println("Binary insert: " + (endTime - startTime));
	}

	public static int getPos(int[] mas, int maxLevel, int element) {
		int minPoint = 0;
		int maxPoint = maxLevel;
		int midPoint = 0;

		while ((maxPoint - minPoint > 1) || ( (maxPoint == 1) && (element < mas[midPoint]))) {
			midPoint = (maxPoint + minPoint) / 2;
			if (element >= mas[midPoint]) {
				minPoint = midPoint;
			} else {
				maxPoint = midPoint;
			}
		}

		return maxPoint;
	}

}
