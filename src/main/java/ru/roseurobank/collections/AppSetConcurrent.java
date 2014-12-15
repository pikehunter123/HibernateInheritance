package ru.roseurobank.collections;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.roseurobank.util.HibernateUtil;

public class AppSetConcurrent {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                SessionFactory sf = HibernateUtil.getSessionFactory();

                Session s = sf.openSession();
                Transaction tx = s.beginTransaction();

                OrderSet os1 = (OrderSet) s.load(OrderSet.class, new Long(1));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AppSet.class.getName()).log(Level.SEVERE, null, ex);
                }
                os1.setName("new Order name1");
                s.save(os1);

                tx.commit();
                s.close();

                sf.close();
            }

        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                SessionFactory sf1 = HibernateUtil.getSessionFactory();

                Session s1 = sf1.openSession();
                Transaction tx1 = s1.beginTransaction();

                OrderSet os2 = (OrderSet) s1.load(OrderSet.class, new Long(1));
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AppSet.class.getName()).log(Level.SEVERE, null, ex);
                }
                os2.setName("new Order name2");
                s1.save(os2);

                tx1.commit();
                s1.close();

                sf1.close();
            }

        });
        t2.start();
        t1.join();
        t2.join();
    }
}
