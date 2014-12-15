package ru.roseurobank.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.UserTransaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.roseurobank.util.HibernateUtil;

/**
 *
 * @author zadorozhniy276
 */
public class AppSet {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SessionFactory sf = HibernateUtil.getSessionFactory();

        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        CustomerSet c = new CustomerSet();
        c.setName("Customer 1");

        OrderSet o1 = new OrderSet();
        o1.setName("Order 1");
        o1.setCustomer(c);

        OrderSet o2 = new OrderSet();
        o2.setName("Order 2");
        o2.setCustomer(c);

        OrderSet o3 = new OrderSet();
        o3.setName("Order 3");
        o3.setCustomer(c);

        c.addOrder(o1);
        c.addOrder(o2);
        c.addOrder(o3);
        s.save(c);
//        s.save(o1);
//        s.save(o2);
//        s.save(o3);

        List<CustomerSet> custList = s.createQuery("from CustomerSet").list();

        List<OrderSet> orderList = s.createQuery("from OrderSet").list();
        for (OrderSet order : orderList) {
            System.out.printf("Id заказа: %d; Название: %s%nId заказчика: %d; Имя: %s%n%n",
                    order.getId(), order.getName(), order.getCustomer().getId(), order.getCustomer().getName());
        }

        c.getOrders().remove(o3);
        
        tx.commit();
        s.close();

        sf.close();
    }
}
