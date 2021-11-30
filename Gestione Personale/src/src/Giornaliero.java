package src;

public class Giornaliero extends Dipendente {
	double GiorniDiLavoro;
	double paga;
	
	public Giornaliero (String nome, String indirizzo, String numero_telefono, String codice_fiscale, double base_retribuzione, double GiorniDiLavoro) {
		super (nome, indirizzo, numero_telefono, codice_fiscale, base_retribuzione );
		this.GiorniDiLavoro = GiorniDiLavoro;
		this.paga =  base_retribuzione*GiorniDiLavoro; 
	}

	/*public double getPaga () {
		paga = base_retribuzione*GiorniDiLavoro;
		return paga;
	}
	*/
	public void setPaga (int paga) {
		this.paga = paga;	
	}
	
	public String toString () {
		return "Nome: " + nome + " Indirizzo: " + indirizzo + " Numero di telefono:" + numero_telefono + " Paga:" + paga + "€" + " Codice Fiscale: " + codice_fiscale + " Giorni di Lavoro: " + GiorniDiLavoro;
	}
}
