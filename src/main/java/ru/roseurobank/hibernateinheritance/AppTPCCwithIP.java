package ru.roseurobank.hibernateinheritance;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.roseurobank.util.HibernateUtil;

public class AppTPCCwithIP {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        
        BankAccountTPCCwithIP ba = new BankAccountTPCCwithIP("baOwner", "123456789");
        s.save(ba);
        
        CreditCardTPCCwithIP cc = new CreditCardTPCCwithIP("ccOwner", "987654321");
        s.save(cc);
        
        
        List<BankAccountTPCCwithIP> baList = s.createQuery("from BankAccountTPCCwithIP").list();
        for (BankAccountTPCCwithIP baElement : baList) {
            System.out.println("Id: " + baElement.getId() );
            System.out.println("Owner: " + baElement.getOwner() );
            System.out.println("Account: " + baElement.getAccount() );
        }
        
        List<CreditCardTPCCwithIP> ccList = s.createQuery("from CreditCardTPCCwithIP").list();
        for (CreditCardTPCCwithIP ccElement : ccList) {
            System.out.println("Id: " + ccElement.getId() );
            System.out.println("Owner: " + ccElement.getOwner() );
            System.out.println("Number: " + ccElement.getNumber());
        }

//        Person person = new Person("John", "Donne");
//        s.save(person);
//
//        Employee employee = new Employee("Edson", "Arantos do Nacimento", "Soccer", new Date());
//        s.save(employee);
//
//        Owner owner = new Owner("Hank", "Marshal", 300L);
//        s.save(owner);

        tx.commit();
        s.close();
        sf.close();
    }
}
