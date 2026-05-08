package com.generation.ListaSpesa.Modello;

public class ArticoloSpesa {
	
	String nome;
	String categoria;
	double prezzoUnitario;
	int quantita;
	boolean acquistato = false;
	
	public ArticoloSpesa() {
		
	}
	
	public ArticoloSpesa(String nome) {
		
		this.nome = nome;
		
	}
	
	public ArticoloSpesa(String nome, String categoria, double prezzoUnitario) {
		
		this.nome = nome;
		this.categoria = categoria;
		this.prezzoUnitario = prezzoUnitario;
	}
	
	public ArticoloSpesa(String nome, String categoria, double prezzoUnitario, int quantita, boolean acquistato) {
		
		this.nome = nome;
		this.categoria = categoria;
		this.prezzoUnitario = prezzoUnitario;
		this.quantita = quantita;
		this.acquistato = acquistato;
		
	}
	
	public double calcolaTotaleArticolo() {
		
		return prezzoUnitario*quantita;
		
	}
	
	public String toString() {
		
		 if (!acquistato) {
			return "Nome: " +nome+ "\nCategoria: " +categoria+ "\nPrezzo Unitario: " +prezzoUnitario+
					"\nQuantità: " +quantita+ "\nTotale articolo: "+calcolaTotaleArticolo()+ "\nStato: acquistato";
		}else {
			return "Nome: " +nome+ "\nCategoria: " +categoria+ "\nPrezzo Unitario: " +prezzoUnitario+
					"\nQuantità: " +quantita+ "\nTotale articolo: "+calcolaTotaleArticolo()+ "\nStato: non cquistato";
		}
	}
	
	
	public void aumentaQuantità(int quantitaDaAggiungere) {
		
		if (quantitaDaAggiungere > 0 ) {
			
			System.out.println(nome+ ", quantità iniziale: " +this.quantita+
					           "\naggiungo: " +quantitaDaAggiungere+
					           "\n Nuova quantità: "+(quantitaDaAggiungere+this.quantita));
		}else {
			
			System.out.println("!!ERRORE!!");
			
		}  
		
	}
	
	public void riduciQuantita(int quantitaDaTogliere) {
		
		if (quantitaDaTogliere > 0 && this.quantita-quantitaDaTogliere >= 1) {
			
			System.out.println(nome+ ", quantità iniziale: " +this.quantita+
			           "\ntolgo: " +quantitaDaTogliere+
			           "\n Nuova quantità: "+(this.quantita-quantitaDaTogliere));
		}else {
			
			System.out.println("!!ERRORE!!");
			
		}  
		
	}
	
	public void aggiornaPrezzoUnitario(double nuovoPrezzo) {
		
		if (nuovoPrezzo > 0) {
			
			System.out.println("Prezzo stimato: " +prezzoUnitario+ "€\n"
					           + "Prezzo reale al supermercato: " +nuovoPrezzo+ "€\n");
			
			this.prezzoUnitario = nuovoPrezzo;
		}
	}
	
	public void applicaSconto(double percentuale) {
		
		if (percentuale < 100 && percentuale > 0 ) {
			
			System.out.println("Prezzo iniziale: " +prezzoUnitario+ "€\n"+
					           "Sconto: " +percentuale+ "%\n"+
					           "Nuovo prezzo: " +prezzoUnitario*percentuale/100);
			
		}else {
			System.out.println("non è possibile inserire una percentuale negativa o uguale a 100");
		}
		
	}
	
	public void segnaComeAcquistato() {
		
		this.acquistato = true;
	}
	
	public void segnaComeDaAcquistare() {
		
		this.acquistato = false;
	}
	
	public boolean isCostoso() {
		if(calcolaTotaleArticolo() > 20) {
			
			return true;
			
		}else {
			return false;
		}
	}
	
	// 4
	
	static boolean prezzoValido(double prezzo) {
		
		if (prezzo >= 0) {
			
			return true;
		}else {
			return false;
		}
	}
	
	static boolean quantitaValida(int quantita) {
		if (quantita > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	static ArticoloSpesa articoloConTotaleMaggiore(ArticoloSpesa a1, ArticoloSpesa
			a2) {
		
		if (a1.calcolaTotaleArticolo() > a2.calcolaTotaleArticolo()) {
			
			return a1;
		}else {
			return a2;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
