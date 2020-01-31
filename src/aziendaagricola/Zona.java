package aziendaagricola;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Zona {
	
	int codice;
	int ampiezza;
	int temperaturaMedia;
	float irraggiamentoMedio;
//	he didn't add to the constructor bcz i should check 
//	if it's passed through the method 
	List<String> c;
	Map<String, Coltivazione> colt;
	Map<String, Raccolto> r;
	
	public Zona(int codice) {
		this.codice = codice;
		this.c = new LinkedList<String>();
		this.colt = new LinkedHashMap<String, Coltivazione>();
		this.r = new TreeMap<String, Raccolto>();
	}

	public int getCodice() {
		
		return this.codice;
	}
	
	public int getAmpiezza() {
		
		return this.ampiezza;
	}

	public int getTemperaturaMedia() {
		
		return this.temperaturaMedia;
	}

	public float getIrraggiamentoMedio() {
		
		return this.irraggiamentoMedio;
	}
	
	public void setAmpiezza(int ampiezza) {
		this.ampiezza = ampiezza;
	}

	public void setTemperaturaMedia(int temperaturaMedia) {
		this.temperaturaMedia = temperaturaMedia;
	}

	public void setIrraggiamentoMedio(float irraggiamentoMedio) {
		this.irraggiamentoMedio = irraggiamentoMedio;
	}
	
	public void aggiungiCaratteristica(String c) {
		if(!this.c.contains(c)) {
			this.c.add(c);
		}
	}

	
	
	
//	qui dentro il metodo devo fare una lista temporanea
//	e metto le colonne di quella di sopra 
//	pero ordinati 
	
	public Collection<String> elencoCaratteristiche(){
		List<String> cOrdinate = new LinkedList<String>(this.c);
		
		Collections.sort(cOrdinate, new ComparatoreCaratteristiche());
		
		return cOrdinate;
	}
	
	//facciamo dentro la classe stessa 
	//	 un comparatore 
	
	public class ComparatoreCaratteristiche implements Comparator<String> {

		
		

		@Override
		public int compare(String s0, String s1) {
			return s0.compareTo(s1);
		}
		
	}
	
	public Coltivazione aggiungiColtivazione(String prodotto, int meseSemina, int meseRaccolto) throws ColtivazioneDuplicataException {
		
		if(!this.colt.containsKey(prodotto+meseSemina)) {
			this.colt.put(prodotto+meseSemina, new Coltivazione(prodotto, meseSemina, meseRaccolto));
			return this.colt.get(prodotto+meseSemina);
		}
		else
			throw new ColtivazioneDuplicataException();
	}

	public Collection<Coltivazione> elencoColtivazioni(){

		return this.colt.values();
	}
	
	
	public Raccolto nuovoRaccolto(String prodotto, String data, int quantita){
		
		if (!this.r.containsKey(prodotto+data)) {
			this.r.put(prodotto+data, new Raccolto(prodotto, data, quantita));
			return r.get(prodotto+data);
		}
		
		else 
			return this.r.get(prodotto+data);
	}
	
	public Raccolto cercaRaccolto(String prodotto, String data){
		
		return this.r.get(prodotto+data);
	}
	
	public Collection<Raccolto>elencoRaccolti(){
		
		List<Raccolto> l = new LinkedList<Raccolto>(this.r.values());
		Collections.sort(l, new ComparatoreRaccoltoDataQuantita());
		
		return l;
	}
	
}
