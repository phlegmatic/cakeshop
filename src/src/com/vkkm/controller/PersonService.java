package src.com.vkkm.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class PersonService {

	/*static Session session =null;
	public static void main(String args[]) {
	
		SessionFactory factory=SanketFactory.getSessionFactory();
		session =factory.openSession();
		session.beginTransaction();
		
		//Actor
		Actor actor1 = new Actor();
		actor1.setActorName("Salman");
		
		Actor actor2 = new Actor();
		actor2.setActorName("Sunny");
		
		Actor actor3 = new Actor();
		actor3.setActorName("Shahrukh");
		
		Actor actor4 = new Actor();
		actor4.setActorName("Aamir");
		
		session.save(actor1);
		session.save(actor2);
		session.save(actor3);
		session.save(actor4);
		
		session.getTransaction().commit();
		session.close();
		session =factory.openSession();
		session.beginTransaction();
		
		Director director1 = new Director();
		director1.setDirectorName("Bhansali");
		
		Director director2 = new Director();
		director2.setDirectorName("Nolan");
		
		Director director3 = new Director();
		director3.setDirectorName("Spielberg");
		
		Director director4 = new Director();
		director4.setDirectorName("Kashyap");
		
		session.save(director1);
		session.save(director2);
		session.save(director3);
		session.save(director4);
	
		Movie m1 =new Movie();
		m1.setMovieTitle("Titanic");
		m1.setMovieGenre("Romance");
		m1.setMovieDescription("test description");
		m1.setActors(actor1);
		m1.setDirector(director1);
		
		session.save(m1);
		
		
		session.getTransaction().commit();
		session.close();
			
	}
*/	
}
