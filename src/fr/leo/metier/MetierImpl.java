package fr.leo.metier;

import fr.leo.dao.IDao;

public class MetierImpl implements IMetier {

	private IDao dao;
	
	@Override
	public double calcul() {
		// Ici je récupère la température,
		//  mais comme dao c'est une interface, je ne sais
		//  pas si je la récupère depuis la bdd ou depuis un webservice !
		// L'application reste ouverte, extensible.
		double t = dao.getTemperature();
		return t * 7;
	}

	// Il nous faut un setter car la variable dao est ptivée !
	public void setDao(IDao dao) {
		this.dao = dao;
	}
}
