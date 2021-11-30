/*package src;
import java.util.Scanner;
import java.util.Vector;

public class Staff {
	Vector <String> personale = new Vector <String>();
	Vector  <String> gruppo = new Vector <String>();
	Persona persona [] = new Persona [100];
	
	public Vector <String> StafftoPersonale (Persona[]persona) {
		System.out.println ("Quanti gruppi vuoi fare?");
		Scanner input = new Scanner (System.in);
		int n = input.nextInt();
		System.out.println ("Fai ogni gruppo di 3 persone");
		System.out.println("Inserisci le persone nel gruppo");
		Scanner input1 = new Scanner (System.in);
		//for (int l = 0; l<n; l++) {
		//for (int j = 0; j<n ; j++) {
		for (int i = 0; i<3; i++ ) {
			persona[i].nome = input1.nextLine();
		    //personale.set (i, persona[i].nome);
		}
		
		for (int j = 0; j<n ; j++) {
			//for (int i=3; persona[i]!=null; i--) {
			for (int i=0; persona[i].nome!=null; i++) {
			gruppo.set(j, persona[i].nome);
		}
		}
		return gruppo;
		}
		
	public void toStrings() {
		//for (int j=0; j<3; j++) {
		for (int i = 0; gruppo.get(i) != null; i++) {
			System.out.println (gruppo.get(i));
		}
	
		
	}
}

/*


/*package src;
import java.util.Scanner;
import java.util.Vector;

public class Staff {
	Vector <String> personale = new Vector <String>();
	Vector <String> gruppo = new Vector <String>();
	//String gruppo;
	Persona persona [] = new Persona [100];
	
	public Vector <String> StafftoPersonale (Persona[]persona) {
   // public String StafftoPersonale (Persona[]persona) {
		System.out.println("Inserisci le persone nel gruppo");
		Scanner input1 = new Scanner (System.in);
		for (int i=0; i<3; i++) {
			if (persona[i].nome.equals(input1.nextLine())) {
				//for (int j=0; persona[i].nome!=null; j++) {
					gruppo.add (persona[i].nome);
				//gruppo += " " + persona [i].nome;
		}
		//}
		}
		return gruppo;
	}
		
	public void toStrings() {
		for (int i = 0; i<3; i++) {
			System.out.println (gruppo.get(i));
		}
	
		
	}
	
}
*/


package src;
import java.util.Scanner;
import java.util.Vector;

public class Staff {
	Vector <String> personale = new Vector <String>();
	String gruppo ;
	Persona persona [] = new Persona [100];
	
	public String StafftoPersonale (Persona[]persona) {
		System.out.println ("Quanti gruppi vuoi fare?");
		Scanner input = new Scanner (System.in);
		int n = input.nextInt();
		System.out.println ("Fai ogni gruppo di 3 persone");
		System.out.println("Inserisci le persone nel gruppo");
		Scanner input1 = new Scanner (System.in);
		//for (int l = 0; l<n; l++) {
		//for (int j = 0; j<n ; j++) {
		for (int i = 0; i<3; i++ ) {
			if (persona[i].nome.equals(input1.nextLine())) {
				//for (int j=0; persona[i].nome!=null; j++) {
					gruppo += " " + persona[i].nome;
		    //personale.set (i, persona[i].nome);
		}
		}
		
		return gruppo;
		}
		
	
	public void toStrings() {
			System.out.println (gruppo);
		}
	
		
	}
