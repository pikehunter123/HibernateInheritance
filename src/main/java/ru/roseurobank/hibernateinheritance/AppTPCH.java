package ru.roseurobank.hibernateinheritance;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.roseurobank.util.HibernateUtil;

public class AppTPCH {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        BankAccountTPCH ba = new BankAccountTPCH("baOwner", "123456789");
        s.save(ba);

        CreditCardTPCH cc = new CreditCardTPCH("ccOwner", "987654321");
        s.save(cc);

        List<BillingDetailsTPCH> list = s.createQuery("from BillingDetailsTPCH").list();
        for (BillingDetailsTPCH bd : list) {
            System.out.println("Id: " + bd.getId());
            System.out.println("Owner: " + bd.getOwner());
            if (bd instanceof BankAccountTPCH) {
                System.out.println("Account: " + ((BankAccountTPCH) bd).getAccount());
            } else {
                if (bd instanceof CreditCardTPCH) {
                    System.out.println("Number: " + ((CreditCardTPCH) bd).getNumber());
                }
            }
        }

        tx.commit();
        s.close();
        sf.close();
    }
}
