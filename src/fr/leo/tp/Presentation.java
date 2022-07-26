package fr.leo.tp;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import fr.leo.dao.DaoImpl;
import fr.leo.dao.IDao;
import fr.leo.metier.IMetier;
import fr.leo.metier.MetierImpl;

public class Presentation {

	public static void main(String[] args) {

		Scanner fichier;
		try {
			fichier = new Scanner(new File("config.txt"));
			String daoImplName = fichier.nextLine();
			String metierImplName = fichier.nextLine();	

			Class classDao =  Class.forName(daoImplName);
			IDao daoImpl =  (IDao) classDao.newInstance();

			Class classMetier =  Class.forName(metierImplName);
			IMetier  metierImpl =  (IMetier) classMetier.newInstance();

			// Maintenant on a besoin de faire appel à la
			//  méthode setDao() de maniere dynamique,
			//  ceci afin de faire l'injection des dépendances 
			//Method setDao = classMetier.getMethod("setDao", IDao.class);
			Method setDao = classMetier.getMethod("setDao", new Class[] {IDao.class});
			
			//setDao.invoke(metierImpl, daoImpl);
			setDao.invoke(metierImpl, new Object[]{daoImpl});
			
			System.out.println(daoImpl.getTemperature());
			System.out.println(metierImpl.calcul());
			// metierImpl.calcul();
		} catch (FileNotFoundException | ClassNotFoundException |
				InstantiationException | IllegalAccessException |
				NoSuchMethodException | SecurityException | 
				IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		// System.out.println(metier.calcul());
	}

}
