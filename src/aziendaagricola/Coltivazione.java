package aziendaagricola;

import java.util.Map;
import java.util.TreeMap;

public class Coltivazione {
	
	String prodotto;
	int meseSemina;
	int meseRaccolto;
	Map<String, Fertilizzante> f;
	
	public Coltivazione(String prodotto, int meseSemina, int meseRaccolto) {
		this.prodotto = prodotto;
		this.meseSemina = meseSemina;
		this.meseRaccolto = meseRaccolto;
		this.f = new TreeMap<String, Fertilizzante>();
	}

	public String getProdotto() {
		return this.prodotto;
	}

	public int getMeseSemina() {
		return this.meseSemina;
	}

	public int getMeseRaccolta() {
		return this.meseRaccolto;
	}
	
	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	public void setMeseSemina(int meseSemina) {
		this.meseSemina = meseSemina;
	}

	public void setMeseRaccolta(int meseRaccolta) {
		this.meseRaccolto = meseRaccolta;
	}

   public Fertilizzante richiedeFertilizzante(char tipo, String nome, float costo, int periodicita, int quantitaImpiego){

	   if (tipo == 'N')
	   {
		   this.f.put(nome, new FertilizzanteNaturale(nome, costo, periodicita, quantitaImpiego));
		   return this.f.get(nome);
	   }
	   else
	   {
		   this.f.put(nome, new FertilizzanteArtificiale(nome, costo, periodicita, quantitaImpiego));
		   return this.f.get(nome);
	   }
   }
	
}
