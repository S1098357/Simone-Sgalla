package src;

public class Volontario extends Persona {
	int paga = 0;
	
	public Volontario (String nome, String indirizzo, String numero_telefono) {
		super (nome, indirizzo, numero_telefono);
	}
	
	public int getPaga () {
		return paga;
	}
	
	public String toString () {
		return "Nome: " + nome + " Indirizzo: " + indirizzo + " Numero di telefono:" + numero_telefono + " Paga:" + paga + "€";
	}

	
}
