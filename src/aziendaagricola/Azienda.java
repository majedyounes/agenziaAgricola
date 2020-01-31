package aziendaagricola;

import java.util.*;
import java.io.*;

public class Azienda {

	int codice;
	Map<Integer, Zona> z;
	Map<String, Magazzino> m;
	
	public Azienda() {
		this.codice = 1000;
		this.z = new TreeMap<Integer, Zona>();
		this.m = new TreeMap<String, Magazzino>();
	}
	
 	
	public Zona aggiungiZona(){

		Zona z1 =  new Zona(codice);
		
		this.z.put(codice, z1);
		
		return this.z.get(codice++);
	}
	
	public Zona cercaZona(int codice){				
		if(this.z.containsKey(codice))
			return this.z.get(codice);
		else 
			return aggiungiZona();
	}
	
	
	public void specificaCaratteristicheZona(int codice, String caratteristica){
		if (this.z.containsKey(codice)) {
			this.z.get(codice).aggiungiCaratteristica(caratteristica);
		}
	}
	
	public Collection<Zona> elencoZone(){
		
		return this.z.values();
	}

	
	public Collection<Zona> elencoZone(int ampiezza){
		
		List<Zona> zFiltro = new LinkedList<Zona>();
		
		for (Zona zi : this.elencoZone()) {
			if (zi.getAmpiezza() > ampiezza)
				zFiltro.add(zi);
		}
		
		return zFiltro;

	}

		
		
		
		
		
		
		
	public Magazzino aggiungiMagazzino(String nome, String prodotto, int quantitaStoccabile){
		
		this.m.put(nome, new Magazzino(nome, prodotto, quantitaStoccabile));

		return this.m.get(nome);		
	}
	
	
	
	
	
	public int totaleMagazzino(){
		
		int sum = 0;
		
		for (Magazzino mi : this.m.values()) {
			sum += mi.getQuantitaStoccata();
		}
		
		return sum;
	}
	
	
	
	
	
	public void leggi(String nomeFile) throws IOException, ColtivazioneDuplicataException{
		@SuppressWarnings("resource")
		BufferedReader b = new BufferedReader(new FileReader(nomeFile));
		String l;
		
		while((l = b.readLine())!= null) {
			StringTokenizer st = new StringTokenizer(l, ";");
			String cod = st.nextToken();
			
			if (cod.compareTo("C")==0) {
				int codice = Integer.parseInt(st.nextToken());
				String prodotto = st.nextToken();
				int meseSemina = Integer.parseInt(st.nextToken());
				int meseRaccolto = Integer.parseInt(st.nextToken());
				
				if (this.z.containsKey(codice)) {
					this.z.get(codice).aggiungiColtivazione(prodotto, meseSemina, meseRaccolto);
				}
			}
			else {
				int codice = Integer.parseInt(st.nextToken());
				String prodotto = st.nextToken();
				String data = st.nextToken();
				int quantita = Integer.parseInt(st.nextToken());
				
				if (this.z.containsKey(codice)) {
					this.z.get(codice).nuovoRaccolto(prodotto, data, quantita);
				}
			}
		}
		
	}
	
}
