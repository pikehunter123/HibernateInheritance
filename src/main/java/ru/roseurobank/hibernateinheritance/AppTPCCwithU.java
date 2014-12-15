package ru.roseurobank.hibernateinheritance;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.roseurobank.util.HibernateUtil;

public class AppTPCCwithU {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        BankAccountTPCCwithU ba = new BankAccountTPCCwithU("baOwner", "123456789");
        s.save(ba);

        CreditCardTPCCwithU cc = new CreditCardTPCCwithU("ccOwner", "987654321");
        s.save(cc);

        List<BillingDetailsTPCCwithU> list = s.createQuery("from BillingDetailsTPCCwithU").list();
        for (BillingDetailsTPCCwithU bd : list) {
            System.out.println("Id: " + bd.getId());
            System.out.println("Owner: " + bd.getOwner());
            if (bd instanceof BankAccountTPCCwithU) {
                System.out.println("Account: " + ((BankAccountTPCCwithU) bd).getAccount());
            } else {
                if (bd instanceof CreditCardTPCCwithU) {
                    System.out.println("Number: " + ((CreditCardTPCCwithU) bd).getNumber());
                }
            }
        }

        tx.commit();
        s.close();
        sf.close();
    }
}
