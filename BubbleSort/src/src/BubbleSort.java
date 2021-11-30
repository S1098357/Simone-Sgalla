package src;

import java.util.Scanner;


public class BubbleSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//sort g= new sort();
		Scanner input= new Scanner(System.in);
		int[] vettore=new int[10];
		for(int i=0;i<10;i++)vettore[i]=input.nextInt();
		vettore=sort.ordina(vettore);
		for(int i=0;i<10;i++)System.out.println(vettore[i]);
		input.close();
	}
	public void Stampa () {
		System.out.println ("Funziona?");
}
}
te piasse un colpo
