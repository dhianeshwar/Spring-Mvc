package CrudApp.Dao;
import CrudApp.Model.FundTransaction;
import CrudApp.Model.Merchant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class DaoClass {
    private final SessionFactory sessionFactory;

    public DaoClass(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createmerchant(Merchant merchant) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(merchant);
            tx.commit();
        }
    }

    public void updateMerchant(Merchant updatedMerchant) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(updatedMerchant);
            tx.commit();
        }
    }

    public List<Merchant> getAllActiveMerchants() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Merchant where isActive = 1", Merchant.class).getResultList();
        }
    }

    public Merchant getMerchantById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Merchant.class, id);
        }
    }
    public void delete(Long accNum)
    {
        try(Session session=sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Merchant merchant = session.get(Merchant.class, accNum);
            if (merchant != null) {
                merchant.setIsActive(0);
                session.merge(merchant);
                transaction.commit();
            }
        }
    }

    public void createTransaction(FundTransaction fundTransaction) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(fundTransaction);
            tx.commit();
        }
    }

    public void updateBalances(Long senderAccountNumber, Long receiverAccountNumber, int amount) {
        try (Session session = sessionFactory.openSession()) {

            Transaction tx = session.beginTransaction();

            Merchant sender = session.get(Merchant.class, senderAccountNumber);
            Merchant receiver = session.get(Merchant.class, receiverAccountNumber);
            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);
            session.merge(sender);
            session.merge(receiver);
            System.out.println("__________________________________________"+sender.getSentTransactions().get(0).getAmount());
            for (FundTransaction fundTransaction:
                    sender.getSentTransactions() ) {
                System.out.println(fundTransaction.getReceiverAccountNumber());
                System.out.println(fundTransaction.getAmount());
            }
            tx.commit();
        }
    }
    public List<FundTransaction> getSenders(Long accountNumber) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(" from FundTransaction  where senderAccountNumber="+accountNumber,FundTransaction.class).getResultList();
        }
    }

    public List<FundTransaction> getReceivers(Long accountNumber) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(" from FundTransaction  where receiverAccountNumber="+accountNumber,FundTransaction.class).getResultList();
        }
    }
}
