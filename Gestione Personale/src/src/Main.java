/*package src;
import java.util.Scanner;
import java.util.Vector;


public class Main {

	public static void main(String[] args) {
		//Vector <String> staff = new Vector <String>();
		//Staff[] staff = new Staff[20];
		Staff staff = new Staff();
		String nome, indirizzo, numero_di_telefono, codice_fiscale;
		double base_retribuzione, bonus, giorni_di_lavoro;
		Persona[] persona = new Persona[100];
		char risposta = ' ';
		Scanner input = new Scanner (System.in);
		int i = 0;
		while (risposta != 'f') {
		System.out.println ("Salve, queste sono le opzioni che può svolgere");
		System.out.println ("a)Aggiungere un volontario");
		System.out.println ("b)Aggiungere un dipendente");
		System.out.println ("c)Aggiungere un impiegato");
		System.out.println ("d)Aggiungere un giornaliero");
		System.out.println ("e)Suddividere in gruppi");
		System.out.println ("g)Visualizzare tutte le informazioni");
		System.out.println ("f)Uscire dal programma");
		risposta = input.next().charAt (0);
	    Scanner input1 = new Scanner (System.in);
        Scanner input2 = new Scanner (System.in);
        Scanner input3 = new Scanner (System.in);
        Scanner input4 = new Scanner (System.in);
        Scanner input5 = new Scanner (System.in);
        Scanner input6 = new Scanner (System.in);
        Scanner input7 = new Scanner (System.in);
		switch (risposta) {
		case 'a' : System.out.println ("Inserisci nome, indirizzo, numero di telefono");
		           nome = input1.nextLine();
		           indirizzo = input2.nextLine();
		           numero_di_telefono = input3.nextLine();
		           persona[i] = new Volontario (nome, indirizzo, numero_di_telefono);
		           i++; break;
		case 'b' : System.out.println ("Inserisci nome, indirizzo, numero di telefono, codice fiscale e base retribuzione");
                   nome = input1.nextLine();
		           indirizzo = input2.nextLine();
		           numero_di_telefono = input3.nextLine();
		           codice_fiscale = input4.nextLine();
		           base_retribuzione = input5.nextDouble();
		           persona[i] = new Dipendente (nome, indirizzo, numero_di_telefono, codice_fiscale, base_retribuzione);
		           i++; break;
		case 'c' : System.out.println ("Inserisci nome, indirizzo, numero di telefono, codice fiscale, base di retribuzione e bonus");
				   nome = input1.nextLine();
				   indirizzo = input2.nextLine();
				   numero_di_telefono = input3.nextLine();
				   codice_fiscale = input4.nextLine();
				   base_retribuzione = input7.nextDouble();
				   bonus = input6.nextDouble();
				   persona[i] = new Impiegato (nome, indirizzo, numero_di_telefono, codice_fiscale, base_retribuzione, bonus);
		           i++; break;
		case 'd': System.out.println ("Inserisci nome, indirizzo, numero di telefono, codice fiscale, base di retribuzione e giorni di lavoro");
		 		   nome = input1.nextLine();
		 		   indirizzo = input2.nextLine();
		 		   numero_di_telefono = input3.nextLine();
				   codice_fiscale = input4.nextLine();
		 		   base_retribuzione = input7.nextDouble();
		 		   giorni_di_lavoro = input6.nextDouble();
		 		   persona[i] = new Giornaliero (nome, indirizzo, numero_di_telefono, codice_fiscale, base_retribuzione, giorni_di_lavoro);
		           i++; break;
		case 'e': System.out.println ("Suddividi in gruppi scrivendo il nome (gruppi di tre persone)");
				  System.out.println ("Quanti gruppi vuoi fare?");
				  Scanner input10 = new Scanner (System.in);
				  int n = input10.nextInt();
				  System.out.println ("Fai ogni gruppo di 3 persone");
				  for (int f = 0; f<n;f++) {
					  staff.StafftoPersonale(persona);
					  staff.toStrings();
					 // staff.set(f, staff1.StafftoPersonale(persona));
				  }
				  staff.toString();
				  //for (int f =0; f<n; f++) staff.toStrings();
		          break;
		case 'g': for (i=0; persona[i]!=null; i++) System.out.println(persona[i].toString());  //Late Biding: nella classe Persona non è presente il metodo toString
			break;
		case 'f':
		}
		}
		
	    

	}

}
*/



package src;
import java.util.Scanner;
import java.util.Vector;


public class Main {

	public static void main(String[] args) {
		Vector <String> staff = new Vector <String>();
		//Staff[] staff = new Staff[20];
		Staff staff1 = new Staff();
		String nome, indirizzo, numero_di_telefono, codice_fiscale;
		double base_retribuzione, bonus, giorni_di_lavoro;
		Persona[] persona = new Persona[100];
		char risposta = ' ';
		Scanner input = new Scanner (System.in);
		int i = 0;
		while (risposta != 'f') {
		System.out.println ("Salve, queste sono le opzioni che può svolgere");
		System.out.println ("a)Aggiungere un volontario");
		System.out.println ("b)Aggiungere un dipendente");
		System.out.println ("c)Aggiungere un impiegato");
		System.out.println ("d)Aggiungere un giornaliero");
		System.out.println ("e)Suddividere in gruppi");
		System.out.println ("g)Visualizzare tutte le informazioni");
		System.out.println ("f)Uscire dal programma");
		risposta = input.next().charAt (0);
	    Scanner input1 = new Scanner (System.in);
        Scanner input2 = new Scanner (System.in);
        Scanner input3 = new Scanner (System.in);
        Scanner input4 = new Scanner (System.in);
        Scanner input5 = new Scanner (System.in);
        Scanner input6 = new Scanner (System.in);
        Scanner input7 = new Scanner (System.in);
		switch (risposta) {
		case 'a' : System.out.println ("Inserisci nome, indirizzo, numero di telefono");
		           nome = input1.nextLine();
		           indirizzo = input2.nextLine();
		           numero_di_telefono = input3.nextLine();
		           persona[i] = new Volontario (nome, indirizzo, numero_di_telefono);
		           i++; break;
		case 'b' : System.out.println ("Inserisci nome, indirizzo, numero di telefono, codice fiscale e base retribuzione");
                   nome = input1.nextLine();
		           indirizzo = input2.nextLine();
		           numero_di_telefono = input3.nextLine();
		           codice_fiscale = input4.nextLine();
		           base_retribuzione = input5.nextDouble();
		           persona[i] = new Dipendente (nome, indirizzo, numero_di_telefono, codice_fiscale, base_retribuzione);
		           i++; break;
		case 'c' : System.out.println ("Inserisci nome, indirizzo, numero di telefono, codice fiscale, base di retribuzione e bonus");
				   nome = input1.nextLine();
				   indirizzo = input2.nextLine();
				   numero_di_telefono = input3.nextLine();
				   codice_fiscale = input4.nextLine();
				   base_retribuzione = input7.nextDouble();
				   bonus = input6.nextDouble();
				   persona[i] = new Impiegato (nome, indirizzo, numero_di_telefono, codice_fiscale, base_retribuzione, bonus);
		           i++; break;
		case 'd': System.out.println ("Inserisci nome, indirizzo, numero di telefono, codice fiscale, base di retribuzione e giorni di lavoro");
		 		   nome = input1.nextLine();
		 		   indirizzo = input2.nextLine();
		 		   numero_di_telefono = input3.nextLine();
				   codice_fiscale = input4.nextLine();
		 		   base_retribuzione = input7.nextDouble();
		 		   giorni_di_lavoro = input6.nextDouble();
		 		   persona[i] = new Giornaliero (nome, indirizzo, numero_di_telefono, codice_fiscale, base_retribuzione, giorni_di_lavoro);
		           i++; break;
		case 'e': System.out.println ("Suddividi in gruppi scrivendo il nome (gruppi di tre persone)");
				  System.out.println ("Quanti gruppi vuoi fare?");
				  Scanner input10 = new Scanner (System.in);
				  int n = input10.nextInt();
				  System.out.println ("Fai ogni gruppo di 3 persone");
				  //staff.StafftoPersonale(persona);
				  //staff.toStrings();
				  for (int f=0; f<n; f++) staff.add(staff1.StafftoPersonale(persona));
				  staff1.toStrings();
				  //for (int f =0; f<n; f++) staff.toStrings();
		          break;
		case 'g': for (i=0; persona[i]!=null; i++) System.out.println(persona[i].toString());  //Late Biding: nella classe Persona non è presente il metodo toString
			break;
		case 'f':
		}
		}
		
	    

	}

}