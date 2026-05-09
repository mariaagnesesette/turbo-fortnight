package com.generation.ListaSpesa.Modello;

public class Utility {
	
	
	//
	public static int aggiungiArticolo(ArticoloSpesa[] lista, int numeroArticoli, ArticoloSpesa nuovoArticolo) {
		
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == null) {	
				lista[i] = nuovoArticolo;
				return numeroArticoli+1;
			}		
		}
		System.out.println("-----------------------------------------------------\nErrore: lista piena");
		return numeroArticoli;
	}
	
	
	//
	public static int cercaIndiceArticolo (ArticoloSpesa[] lista, int numeroArticoli,String nome) {
		int i = 0;
		
		for (int t = 0; t < numeroArticoli; t++) {
			if (lista[t].nome.equalsIgnoreCase(nome)) {
				i=t;
			} else {
				continue;
			}
		}
		return i;
	}
	
	
	//
	public static double calcolaTotaleLista (ArticoloSpesa[] lista, int numeroArticoli) {
		double totProvvisorio =0;
	
		for (int i = 0; i <numeroArticoli ;i++) {
			totProvvisorio += lista[i].calcolaTotaleArticolo();
		}
			return totProvvisorio;
	}
	
	
	//
	public static double calcolaTotaleAcquistati(ArticoloSpesa[] lista, int numeroArticoli) {
		double totAcquistati = 0;
		
		for (int i = 0; i< numeroArticoli; i++) {
			if(lista[i].acquistato) {
				totAcquistati += lista[i].calcolaTotaleArticolo();
			} else {
			continue;	
			}
		}
		return totAcquistati;
	}
	
	
	//
	public static double calcolaTotaleDaAcquistare(ArticoloSpesa[] lista, int numeroArticoli) {
		double totDaAcquistare = 0;
		
		for (int i = 0; i< numeroArticoli; i++) {
			if(!lista[i].acquistato) {
				totDaAcquistare += lista[i].calcolaTotaleArticolo();
			} else {
				continue;	
			}
		} 
		return totDaAcquistare;
	}
	
	
	//
	public static ArticoloSpesa trovaArticoloPiuCostoso(ArticoloSpesa[] lista, int numeroArticoli) {
		double max= 0;
		int t=0;
		
		if (numeroArticoli > 0) {
			for(int i=0; i< numeroArticoli; i++) {
				if(lista[i].calcolaTotaleArticolo() >max) {
					max = lista[i].calcolaTotaleArticolo();
					t=i;
				} else {
					continue;
				} 
			}
			System.out.println("\n===ARTICOLO N° "+(t+1)+"===\n");
			return lista[t];
		} else {
			System.out.println("Impossibile verificare la presenza di articoli");
			return lista[t];
		}
	}
	
	
	//
	public static int eliminaArticolo(ArticoloSpesa[] lista, int numeroArticoli, String nome) {
		int t =  cercaIndiceArticolo(lista, numeroArticoli, nome);
		
		if(t >=0 && t< numeroArticoli) {
			for(int i= t; i<numeroArticoli; i++) {
				lista[i] = lista[i+1];
					if(i+1 == numeroArticoli) {
						lista[i+1] = null;	
					}
			}
			System.out.println("Articolo eliminato con successo");
			return numeroArticoli- 1;
		} else {
			System.out.println("Articolo non trovato");
			return numeroArticoli;
		}
	}
	

}
