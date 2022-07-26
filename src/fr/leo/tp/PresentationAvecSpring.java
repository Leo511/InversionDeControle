package fr.leo.tp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.leo.dao.IDao;
import fr.leo.metier.IMetier;

public class PresentationAvecSpring {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext( new String[] {"applicationContext.xml"} );
		
		IMetier metier = (IMetier) context.getBean("metier");
		//IDao dao = (IDao) context.getBean("d");
		
		 System.out.println(metier.calcul());
		
	}
}
