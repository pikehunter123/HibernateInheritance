package ru.roseurobank.hibernateinheritance;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.roseurobank.util.HibernateUtil;

public class AppMix {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        BankAccountMix ba = new BankAccountMix("baOwner", "123456789");
        s.save(ba);

        CreditCardMix cc = new CreditCardMix("ccOwner", "987654321");
        s.save(cc);

        List<BillingDetailsMix> list = s.createQuery("from BillingDetailsMix").list();
        for (BillingDetailsMix bd : list) {
            System.out.println("Id: " + bd.getId());
            System.out.println("Owner: " + bd.getOwner());
            if (bd instanceof BankAccountMix) {
                System.out.println("Account: " + ((BankAccountMix) bd).getAccount());
            } else {
                if (bd instanceof CreditCardMix) {
                    System.out.println("Number: " + ((CreditCardMix) bd).getNumber());
                }
            }
        }

        tx.commit();
        s.close();
        sf.close();
    }
}
