package fr.leo.dao;

import org.apache.log4j.Logger;

public class DaoImpl2 implements IDao {
	
	private Logger logger  = Logger.getLogger(this.getClass());

	@Override
	public double getTemperature() {
		logger.info("ceci est un test de log ...");
		logger.error("voila une erreur ...");
		logger.warn("ceci est un message de warning !");
		double t = 14;
		return t;
	}

}
