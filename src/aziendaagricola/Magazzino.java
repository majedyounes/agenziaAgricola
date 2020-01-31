package aziendaagricola;

public class Magazzino {

	String nome;
	String prodotto;
	int quantitaStoccabile;
	int quantitaStoccata;
	
	public Magazzino(String nome, String prodotto, int quantitaStoccabile) {
		this.nome = nome;
		this.prodotto = prodotto;
		this.quantitaStoccabile = quantitaStoccabile;
		this.quantitaStoccata = 0;
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getProdotto() {
		return this.prodotto;
	}
	
	public int getQuantitaStoccabile() {
		return this.quantitaStoccabile;
	}

	public int getQuantitaStoccata() {
		return this.quantitaStoccata;
	}

	public void setNome(String nome) {
		this.nome = nome;
		
	}

	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	public void setQuantitaStoccabile(int quantitaStoccabile) {
		this.quantitaStoccabile = quantitaStoccabile;
	}

	public void setQuantitaStoccata(int quantitaStoccata) {
		this.quantitaStoccata = quantitaStoccata;
	}	
	
	public int stocca(Raccolto raccolto) throws ProdottoNonCompatibileException{
		
		if (raccolto.getProdotto().compareTo(this.prodotto)!=0) {
			throw new ProdottoNonCompatibileException();
		}
		
		else {
			if (this.quantitaStoccata+raccolto.getQuantita() < this.quantitaStoccabile) {
				this.quantitaStoccata += raccolto.getQuantita();
				return this.quantitaStoccabile - this.quantitaStoccata;
			}
			else {
				int ret;
				ret = this.quantitaStoccabile - (this.quantitaStoccata + raccolto.getQuantita());
				this.quantitaStoccata = this.quantitaStoccabile;
				return ret;
			}
		}
	}
	
	public void preleva(int quantita){
		this.quantitaStoccata -= quantita;
		if (quantitaStoccata < 0)
			quantitaStoccata = 0;
	}
	
}
