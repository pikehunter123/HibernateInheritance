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
public class AppMTM {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();

        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        CustomerMTM c = new CustomerMTM();
        c.setName("Hank");

        CustomerMTM c1 = new CustomerMTM();
        c1.setName("Jack");

        AddressMTM a = new AddressMTM();
        a.setCity("Kazan");
        a.setState("North State");
        a.setStreet("Pionerskay");
        a.setZipcode("221133");

        AddressMTM a1 = new AddressMTM();
        a1.setCity("Kazan2");
        a1.setState("North State2");
        a1.setStreet("Pionerskay2");
        a1.setZipcode("221133");

        c.getAddressList().add(a);
        c.getAddressList().add(a1);

        c1.getAddressList().add(a);
        c1.getAddressList().add(a1);

        s.save(c);
        s.save(c1);

        List<CustomerMTM> custList = s.createQuery("from CustomerMTM").list();
        for (CustomerMTM cust : custList) {
            System.out.printf("%nId => %d%nИмя => %s%n",
                    cust.getId(), cust.getName());
            for (AddressMTM addressList : cust.getAddressList()) {
                System.out.printf("Id => %d%nГород => %s%nШтат => %s%nУлица => %s%nИндекс => %s%n",
                        addressList.getId(), addressList.getCity(), addressList.getState(), addressList.getStreet(), addressList.getZipcode());
            }
        }

//        List<AddressMTM> addressList = s.createQuery("from AddressMTM").list();
//        for (AddressMTM address : addressList) {
//            System.out.printf("Id => %d%nГород => %s%nШтат => %s%nУлица => %s%nИндекс => %s%n",
//                    address.getId(), address.getCity(), address.getState(), address.getStreet(), address.getZipcode());
//            for (CustomerMTM cust : address.getCustomers()) {
//                System.out.printf("%nId => %d%nИмя => %s%n",
//                        cust.getId(), cust.getName());
//            }
//        }

        tx.commit();
        s.close();

        sf.close();
    }
}
