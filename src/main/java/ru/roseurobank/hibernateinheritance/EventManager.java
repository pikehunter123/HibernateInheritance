package ru.roseurobank.hibernateinheritance;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import ru.roseurobank.util.HibernateUtil;

public class EventManager {

    public static void main(String[] args) {
        EventManager mgr = new EventManager();
        
        mgr.createAndStoreEvent("My Event", new Date());
        List<Event> events = mgr.listEvents();
        for(Event e : events) {
            System.out.println("Event: " + e.getTitle() + " Time: " + e.getDate());
        }

        HibernateUtil.getSessionFactory().close();
    }

    private void createAndStoreEvent(String title, Date theDate) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);
        
        session.getTransaction().commit();

    }
    
    private List<Event> listEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        List<Event> result = session.createQuery("from Event").list();
        
        session.getTransaction().commit();
        return result;
    }

}
