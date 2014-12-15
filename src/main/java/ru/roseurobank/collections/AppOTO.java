/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roseurobank.collections;

import com.atomikos.icatch.jta.UserTransactionImp;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.roseurobank.util.HibernateUtil;

/**
 *
 * @author zadorozhniy276
 */
public class AppOTO {

    public static void main(String[] args) throws NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException, NamingException {
        SessionFactory sf = HibernateUtil.getSessionFactory();

        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        AddressOTO a = new AddressOTO();
        a.setCity("Moscow");
        a.setState("Center");
        a.setStreet("Leninskiy");
        a.setZipcode("100200");

        CustomerOTO c = new CustomerOTO();
        c.setName("Customer 1");
        c.setAddress(a);
        a.setCustomer(c);

        s.save(c);

        List<CustomerOTO> custList = s.createQuery("from CustomerOTO as c fetch left join c.orders").list();
        for (CustomerOTO cust : custList) {
            System.out.printf("Id => %d%nИмя => %s%nГород => %s%nШтат => %s%nУлица => %s%nИндекс => %s%n",
                    cust.getId(), cust.getName(),
                    cust.getAddress().getCity(), cust.getAddress().getState(), cust.getAddress().getStreet(), cust.getAddress().getZipcode());
        }

        List<AddressOTO> addressList = s.createQuery("from AddressOTO").list();
        for (AddressOTO address : addressList) {
            System.out.printf("%nId => %d%nГород => %s%nШтат => %s%nУлица => %s%nИндекс => %s%n",
                    //            System.out.printf("%nId => %d%nИмя => %s%nId => %d%nГород => %s%nШтат => %s%nУлица => %s%nИндекс => %s%n",
                    //                    address.getCustomer().getId(), address.getCustomer().getName(),
                    address.getId(),
                    address.getCity(), address.getState(), address.getStreet(), address.getZipcode());
        }

        tx.commit();
        s.close();

        sf.close();
    }
}
