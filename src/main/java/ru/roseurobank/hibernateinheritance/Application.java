/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roseurobank.hibernateinheritance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hsqldb.rights.User;
import ru.roseurobank.util.HibernateUtil;

/**
 *
 * @author zadorozhniy276
 */
public class Application {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        Users u = new Users();
        u.setName("Hank");
        
        Role r = new Role();
        r.setName("Administrator");
        

//        u.setRols(new HashSet<>(Arrays.asList(r)));
        u.getRols().add(r);
        
        s.save(r);
        s.save(u);

        tx.commit();
        s.close();
        sf.close();
        
        SessionFactory sf1 = HibernateUtil.getSessionFactory();
        Session s1 = sf1.openSession();
        Transaction tx1 = s1.beginTransaction();
        
        Users u1 = (Users) s1.get(Users.class, new Long(1));
//        System.out.println(u1.getClass());
        System.out.println(u1.getName());

//        List<BillingDetailsTPS> list = s.createQuery("from BillingDetailsTPS").list();
//        for (BillingDetailsTPS bd : list) {
//            System.out.println("Id: " + bd.getId());
//            System.out.println("Owner: " + bd.getOwner());
//            if (bd instanceof BankAccountTPS) {
//                System.out.println("Account: " + ((BankAccountTPS) bd).getAccount());
//            } else {
//                if (bd instanceof CreditCardTPS) {
//                    System.out.println("Number: " + ((CreditCardTPS) bd).getNumber());
//                }
//            }
//        }

        tx1.commit();
        s1.close();
        sf1.close();
    }
}
