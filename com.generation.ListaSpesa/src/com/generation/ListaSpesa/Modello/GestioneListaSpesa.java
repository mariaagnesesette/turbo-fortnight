package com.generation.ListaSpesa.Modello;

import java.util.Scanner;

public class GestioneListaSpesa {

	public static void main(String[] args) {
		
		int azione;
		boolean continua = true;
		boolean check = false;
		Scanner scanner = new Scanner(System.in);
		ArticoloSpesa[] lista = new ArticoloSpesa[20];
		int contatoreArticoli = 0;
		
		do {
			System.out.println("\n-----------------------------------------------------\n"
							+"Digitare il numero dell'azione che vorresti eseguire:\n"
							+"\n 1. Aggiungi un articolo alla lista"
							+"\n 2. Visualizza tutta la lista della spesa"
							+"\n 3. Cerca un articolo per nome"
							+"\n 4. Modifica la quantità di un articolo"
							+"\n 5. Aggiorna il prezzo di un articolo"
							+"\n 6. Applica uno sconto a un articolo"
							+"\n 7. Segna un articolo come acquistato"
							+"\n 8. Segna un articolo come ancora da acquistare"
							+"\n 9. Visualizza solo gli articoli ancora da acquistare"
							+"\n 10. Visualizza solo gli articoli già acquistati"
							+"\n 11. Visualizza il totale stimato della spesa"
							+"\n 12. Visualizza il totale degli articoli già acquistati"
							+"\n 13. Visualizza l’articolo più costoso della lista"
							+"\n 14. Elimina un articolo dalla lista"
							+"\n 15. Esci");
			azione = Integer.parseInt(scanner.nextLine());
			
			
			switch (azione) {
				
				// Aggiungi un articolo alla lista
				case 1:
					ArticoloSpesa articolo = new ArticoloSpesa();
					
					System.out.println("\n===ARTICOLO N° "+(contatoreArticoli+1)+"===\n");
					System.out.print("Inserire nome prodotto: ");
					articolo.nome = scanner.nextLine();
					System.out.print("Inserire tipo prodotto: ");
					articolo.categoria = scanner.nextLine();
					
					do {
						System.out.print("Inserire prezzo prodotto: ");
						articolo.prezzoUnitario = Double.parseDouble(scanner.nextLine());
						if (!ArticoloSpesa.prezzoValido(articolo.prezzoUnitario)) {
							System.out.println("Errore: prezzo non valido, ritenta\n");
						}
					} while (articolo.prezzoUnitario < 0);
				
					do {
						System.out.print("Inserire quantità prodotto: ");
						articolo.quantita = Integer.parseInt(scanner.nextLine());
						if (!ArticoloSpesa.quantitaValida(articolo.quantita)) {
							System.out.println("Errore: quantità non valida, ritenta\n");
						}
					} while (articolo.quantita <= 0);
					
					articolo.acquistato = false;
					contatoreArticoli = Utility.aggiungiArticolo(lista, contatoreArticoli, articolo);
					break;
					
					
				// Visualizza tutta la lista della spesa
				case 2:
					if (contatoreArticoli > 0) {
						for (int i = 0; i < contatoreArticoli; i++) {
							System.out.println("\n===ARTICOLO N° "+(i+1)+"===\n"+lista[i].toString());
						}
					} else {
						System.out.println("-----------------------------------------------------\n\nErrore: lista vuota");
					}
					break;
				
					
					
				// Cerca un articolo per nome
				case 3:
					if (contatoreArticoli > 0) {
						System.out.println("Quale Articolo vuoi controllare?");
						String rispostaUt = scanner.nextLine();
						check = false;
						
						for (int t = 0; t < contatoreArticoli; t++) {
							if (lista[t].nome.equalsIgnoreCase(rispostaUt)) {	
								System.out.println("\n===ARTICOLO N° "+(t+1)+"===\n"+lista[t].toString());
							}
						}
						if (!check) {
							System.out.println("-----------------------------------------------------\n\nErrore: articolo non trovato");
						}
					} else {
						System.out.println("-----------------------------------------------------\n\nErrore: lista vuota");
					}
					break;
				
					
				// Modifica la quantità di un articolo 
				case 4:
					String cambio = "Errore";
					if (contatoreArticoli > 0) {
						int nuovaQuantita = 0;
						int moreOrLess = 0;
						int indiceTrovato = -1;
						System.out.println("Di quale articolo vuoi modificare la quantità?");
						cambio = scanner.nextLine();
						for (int i = 0; i < contatoreArticoli; i++) {
							if (lista[i].nome.equalsIgnoreCase(cambio)) {
								indiceTrovato = i;
								break;
							} else {
								continue;
							}
						}
						if (!(indiceTrovato == -1)) {
							System.out.println("-----------------------------------------------------\n\nErrore: articolo non trovato");
							break;
						}
						System.out.println("Digitare il numero dell'azione che vorresti eseguire:"
												+"\n 1. Aggiungere"
												+"\n 2. Diminuire");
							moreOrLess = Integer.parseInt(scanner.nextLine());
							if (moreOrLess == 1) {
								System.out.println("Quanto vuoi aggiungere a "+cambio+"?");
								nuovaQuantita = Integer.parseInt(scanner.nextLine());
								System.out.println("\n===ARTICOLO N° "+(indiceTrovato+1)+"===\n");
								lista[indiceTrovato].aumentaQuantita(nuovaQuantita);
							} else if (moreOrLess == 2) {
								System.out.println("Quanto vuoi diminuire di "+cambio+"?");
								nuovaQuantita = Integer.parseInt(scanner.nextLine());
								System.out.println("\n===ARTICOLO N° "+(indiceTrovato+1)+"===\n");
								lista[indiceTrovato].riduciQuantita(nuovaQuantita);
							} else {
								System.out.println("-----------------------------------------------------\n\nErrore: azione non trovata");
							}
					} else {
							System.out.println("-----------------------------------------------------\n\nErrore: lista vuota");
					}
					break;
					
						
				// Aggiorna il prezzo di un articolo
				case 5:
					if (contatoreArticoli > 0) {
						System.out.println("Di quale articolo vorresti aggiornare il prezzo?");
						String risposta = scanner.nextLine();
						check = false;
						
						for (int i =0; i < contatoreArticoli; i++) {
							if (lista[i].nome.equalsIgnoreCase(risposta)) {
								System.out.println("Inserire il nuovo prezzo per l'articolo indicato: ");
								double nuovoPrezzo = Double.parseDouble(scanner.nextLine());
								System.out.println("\n===ARTICOLO N° "+(i+1)+"===\n");
								lista[i].aggiornaPrezzoUnitario(nuovoPrezzo);
								check = true;
								break;
							}
						}
						if (!check) {
							System.out.println("-----------------------------------------------------\n\nErrore: articolo non trovato");
						}
					} else {
						System.out.println("-----------------------------------------------------\n\nErrore: lista vuota");
					}
					break;
				
				
				// Applica uno sconto a un articolo 
				case 6:
					if (contatoreArticoli > 0) {
						System.out.println("Di quale articolo vorresti scontare il prezzo?");
						String input = scanner.nextLine();
						check = false;
						
						for (int i= 0; i < contatoreArticoli; i++) {
							if (lista[i].nome.equalsIgnoreCase(input)) {
								System.out.println("Qual è la percentuale di sconto da applicare?");
								double sconto = Double.parseDouble(scanner.nextLine());
								System.out.println("\n===ARTICOLO N° "+(i+1)+"===\n");
								lista[i].applicaSconto(sconto);
								check = true;
								break;
							} 
						}
						if (!check) {
							System.out.println("-----------------------------------------------------\n\nErrore : articolo non trovato");	
						}
					} else {
						System.out.println("-----------------------------------------------------\n\nErrore: lista vuota");
					}
					break;
					
					
				// Segna un articolo come acquistato 
				case 7:
					if (contatoreArticoli > 0) {
						System.out.println("Quale articolo vuoi segnare come acquistato?");
						String articoloAcquistato = scanner.nextLine();
					
						for (int i = 0; i < contatoreArticoli; i++) {
							if (lista[i].nome.equalsIgnoreCase(articoloAcquistato)) {
								lista[i].segnaComeAcquistato();
								System.out.println("L'articolo è stato segnato correttamente");
							} else {
								System.out.println("-----------------------------------------------------\n\nErrore : articolo non trovato");
							}
						}
					} else {
						System.out.println("-----------------------------------------------------\n\nErrore: lista vuota");
					}
					break;
					
					
				// Segna un articolo come ancora da acquistare
				case 8:
					if (contatoreArticoli > 0) {
						System.out.println("Quale articolo vuoi segnare come da acquistare?");
						String articoloDaAcquistare = scanner.nextLine();
						boolean presenzaArt = true;
					
						for (int i = 0; i < contatoreArticoli; i++) {
							if (lista[i].nome.equalsIgnoreCase(articoloDaAcquistare)) {
								lista[i].segnaComeDaAcquistare();
								presenzaArt = false;
								System.out.println("L'articolo è stato segnato correttamente");
							}
						}
						if (presenzaArt) {
							System.out.println("-----------------------------------------------------\n\nErrore : articolo non trovato");	
						}
					} else {
						System.out.println("-----------------------------------------------------\n\nErrore: lista vuota");
					}
					break;
					
					
				// Visualizza solo gli articoli ancora da acquistare 
				case 9:
					if (contatoreArticoli > 0) {
						System.out.println("Ecco la lista dei prodotti ancora da acquistare: ");
					
						for (int i = 0; i < contatoreArticoli; i++) {
							if (!lista[i].acquistato) {
								System.out.println("\n===ARTICOLO N° "+(i+1)+"===\n"+lista[i].toString());
							} else {
								System.out.println("-----------------------------------------------------\n\nNessun articolo da acquistato");
							}
						}
					} else {
						System.out.println("-----------------------------------------------------\n\nErrore: lista vuota");
					}
					break;
					
					
				// Visualizza solo gli articoli già acquistati
				case 10:
					if (contatoreArticoli > 0) {
						System.out.println("Ecco la lista dei prodotti acquistati: ");
					
						for (int i = 0; i < contatoreArticoli; i++) {
							if (lista[i].acquistato) {
								System.out.println("\n===ARTICOLO N° "+(i+1)+"===\n"+lista[i].toString());
							} else {
								System.out.println("-----------------------------------------------------\n\nNessun articolo acquistato");
							}
						}
					} else {
						System.out.println("-----------------------------------------------------\n\nErrore: lista vuota");
					}	
					break;
				
					
				// Visualizza il totale stimato della spesa
				case 11:
					if (contatoreArticoli > 0) {
					System.out.println("Il totale provvisorio degli acquisti è: "+Utility.calcolaTotaleLista(lista, contatoreArticoli)); 
					} else {
						System.out.println("-----------------------------------------------------\n\nErrore: nessun articolo presente");
					}
					break;
					
					
				// Visualizza il totale degli articoli già acquistati
				case 12:
					if (contatoreArticoli > 0) {
						System.out.println("il totale dei prodotti acquistati è: "+Utility.calcolaTotaleAcquistati(lista, contatoreArticoli));
					} else {
						System.out.println("-----------------------------------------------------\n\nErrore: nessun articolo presente");
					}
					break;
				
					
				// Visualizza l’articolo più costoso della lista
				case 13:
					if (contatoreArticoli > 0) {
						System.out.println("L'articolo più costoso della lista è: \n"+Utility.trovaArticoloPiuCostoso(lista, contatoreArticoli));
					} else {
						System.out.println("-----------------------------------------------------\n\nErrore: nessun articolo presente");
					}
					break;
					
					
				// Elimina un articolo dalla lista
				case 14:
					if (contatoreArticoli > 0) {
						System.out.println("Quale articolo vuoi eliminare?");
						contatoreArticoli = Utility.eliminaArticolo(lista, contatoreArticoli, scanner.nextLine());
						} else {
							System.out.println("-----------------------------------------------------\n\nErrore: nessun articolo presente");
						}
					break;
					
					
				// Esci
				case 15:
					System.out.println("Grazie per aver usato cassa amica");
					continua = false;
					break;
					
					
				// Opzione del menù non valida
				default:
					System.out.println("-----------------------------------------------------\n\nErrore: azione non riconosciuta, ritenta");
					break;
			}
			
			
		} while (continua);
		
		scanner.close();
	}
}
	

