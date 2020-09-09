package dataModel;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class EntityManager {

    private EntityManagerFactory entityManagerFactory;


    protected void setUp() throws Exception {
        // like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
        // 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
        entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
    }


    protected void tearDown() throws Exception {
        entityManagerFactory.close();
    }

    public void testBasicUsage() {
        // create a couple of events...
        javax.persistence.EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist( new incident( "Our very first event!", new Date() ) );
        entityManager.getTransaction().commit();
        entityManager.close();

        // now lets pull events from the database and list them
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Event> result = entityManager.createQuery( "from Event", Event.class ).getResultList();
        for ( Event event : result ) {
            System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
