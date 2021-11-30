package src;


public class Persona {
	 String nome, indirizzo, numero_telefono;
	 
	 public Persona (String nome, String indirizzo, String numero_telefono) {
		 this.nome = nome;
		 this.indirizzo = indirizzo;
		 this.numero_telefono = numero_telefono;
	 }
	 
	 public String getNome() {
		 return nome;
	 }
	 
	 public String getIndirizzo() {
		 return indirizzo;
	 }
	 
	 public String getNumero_Telefono() {
		 return numero_telefono;
	 }
	 
	 public void setNome (String nome) {
		 this.nome = nome;
		 }
	 
	 public void setIndirizzo (String indirizzo) {
		 this.indirizzo = indirizzo;
	 }
	 
	 public void setNumero_Telefono (String numero_telefono) {
		 this.numero_telefono = numero_telefono;
	 }

}
