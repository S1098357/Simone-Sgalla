package src;

public class Impiegato extends Dipendente {
     double bonus;
     double paga;
     
     public Impiegato (String nome, String indirizzo, String numero_telefono, String codice_fiscale, double bonus, double base_di_retribuzione) {
 		super (nome, indirizzo, numero_telefono, codice_fiscale, base_di_retribuzione );
 		this.bonus = bonus;
 		paga = base_retribuzione + bonus;;
 	}
     
  /*   public double getPaga () {
 		paga = base_retribuzione + bonus;
 		return paga;
 	}
  */
     public void setPaga (double paga) {
 		this.paga = paga;
 		}
     
     public String toString () {
 		return "Nome: " + nome + " Indirizzo: " + indirizzo + " Numero di telefono:" + numero_telefono + " Paga:" + paga + "€" + " Codice Fiscale: " + codice_fiscale + " Bonus: " + bonus + "€";
 	}
}

