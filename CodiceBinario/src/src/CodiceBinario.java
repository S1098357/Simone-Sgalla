package src;


import java.util.Scanner;

public class CodiceBinario {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		String binario=input.nextLine();
		int lunghezza=binario.length();
		if (binario.length()>8) System.out.println("errore");
		else
		System.out.println(convertiintero(binario, lunghezza));
		System.out.println(lunghezza);
		input.close();
	}
	
	public static double convertiintero(String stringa, int lunghezza) {
		double appoggio=0;
		for (int i=lunghezza;i>0;i--)
		//if (stringa.substring((lunghezza-1)-i,lunghezza-i).equals("1"))appoggio=appoggio+Math.pow(2.0,i);
		if (stringa.charAt(i-1)==('1'))appoggio=appoggio+Math.pow(2.0,lunghezza-i);
		return appoggio;
	}

}
