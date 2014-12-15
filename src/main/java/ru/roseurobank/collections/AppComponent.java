package ru.roseurobank.collections;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.roseurobank.util.HibernateUtil;

/**
 *
 * @author zadorozhniy276
 */
public class AppComponent {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();

        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        Address a = new Address();
        a.setCity("Moscow");
        a.setState("Center");
        a.setStreet("Leninskiy");
        a.setZipcode("100200");

        CustomerComponent c = new CustomerComponent();
        c.setName("Customer 1");
        c.setAddress(a);
        s.persist(c);

        List<CustomerComponent> custList = s.createQuery("from CustomerComponent").list();
        for (CustomerComponent cust : custList) {
            System.out.printf("Id => %d%nИмя => %s%nГород => %s%nШтат => %s%nУлица => %s%nИндекс => %s%n",
                    cust.getId(), cust.getName(), 
                    cust.getAddress().getCity(), cust.getAddress().getState(), cust.getAddress().getStreet(), cust.getAddress().getZipcode());
        }

        tx.commit();
        s.close();

        sf.close();
    }
}
