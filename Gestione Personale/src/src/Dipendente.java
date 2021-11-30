package src;

public class Dipendente extends Persona {
	String codice_fiscale;
	double base_retribuzione;
	
	public Dipendente (String nome, String indirizzo, String numero_telefono, String codice_fiscale, double base_retribuzione) {
		super (nome, indirizzo, numero_telefono);
		this.codice_fiscale = codice_fiscale;
		this.base_retribuzione = base_retribuzione;
	}
	
	public double getPaga () {
		return base_retribuzione;
	}

	public void setPaga (double base_retribuzione) {
		this.base_retribuzione = base_retribuzione;
	}
	
	public String getCodiceFiscale () {
		return codice_fiscale;
	}
	
	public void setCodiceFiscale (String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}
	
	public String toString () {
		return "Nome: " + nome + " Indirizzo: " + indirizzo + " Numero di telefono:" + numero_telefono + " Paga:" + base_retribuzione + "€" + " Codice Fiscale: " + codice_fiscale;
	}
}
