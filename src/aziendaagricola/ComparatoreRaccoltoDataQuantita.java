package aziendaagricola;

import java.util.Comparator;

public class ComparatoreRaccoltoDataQuantita implements Comparator<Raccolto>{

	@Override
	public int compare(Raccolto r1, Raccolto r2) {
		if (r1.getData().compareTo(r2.getData())!=0) {
			return r1.getData().compareTo(r2.getData());
		}
		else
			return r1.getQuantita() - r2.getQuantita();
	}

}
