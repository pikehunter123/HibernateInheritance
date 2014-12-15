package ru.roseurobank.hibernateinheritance;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.roseurobank.util.HibernateUtil;

public class AppTPS {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        BankAccountTPS ba = new BankAccountTPS("baOwner", "123456789");
        s.save(ba);

        CreditCardTPS cc = new CreditCardTPS("ccOwner", "987654321");
        s.save(cc);

        List<BillingDetailsTPS> list = s.createQuery("from BillingDetailsTPS").list();
        for (BillingDetailsTPS bd : list) {
            System.out.println("Id: " + bd.getId());
            System.out.println("Owner: " + bd.getOwner());
            if (bd instanceof BankAccountTPS) {
                System.out.println("Account: " + ((BankAccountTPS) bd).getAccount());
            } else {
                if (bd instanceof CreditCardTPS) {
                    System.out.println("Number: " + ((CreditCardTPS) bd).getNumber());
                }
            }
        }

        tx.commit();
        s.close();
        sf.close();
    }
}