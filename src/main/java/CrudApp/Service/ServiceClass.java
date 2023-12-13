package CrudApp.Service;

import CrudApp.Dao.DaoClass;
import CrudApp.Model.FundTransaction;
import CrudApp.Model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ServiceClass {

    private final DaoClass daoClass;
    @Autowired
    public ServiceClass(DaoClass daoClass) {
        this.daoClass = daoClass;
    }

    @Transactional
    public void createMerchant(Merchant merchant)  {
       daoClass.createmerchant(merchant);
    }
    public void updateMerchant(Merchant merchant)
    {
        daoClass.updateMerchant(merchant);
    }

    @Transactional
    public List<Merchant> getAllMerchant() {
        return daoClass.getAllActiveMerchants();
    }

    @Transactional
    public Merchant getMerchantById(Long id) {
        return daoClass.getMerchantById(id);
    }

    @Transactional
    public void deleteTemp(Long accNum)
    {
        daoClass.delete(accNum);
    }
    // ServiceClass.java
    @Transactional
    public String createTransactionAndHandleBalances(FundTransaction fundTransaction) {
        Merchant sender=getMerchantById(fundTransaction.getSenderAccountNumber());
        Merchant receiver=getMerchantById(fundTransaction.getReceiverAccountNumber());
        if(receiver!=null) {
            if(sender.getAccountNumber().equals(receiver.getAccountNumber()))
                return "You can't send money to Yourself";
            if (sender.getBalance() >= fundTransaction.getAmount()) {

                daoClass.createTransaction(fundTransaction);
                daoClass.updateBalances(fundTransaction.getSenderAccountNumber(), fundTransaction.getReceiverAccountNumber(), fundTransaction.getAmount());
                return "true";
            }
            else
                return "In sufficient Balance";
        }
        else
            return "no receiver in this account number";
    }

    @Transactional
    public List<FundTransaction> senders(Long accountNumber)
    {
        return daoClass.getSenders(accountNumber);
    }

    @Transactional
    public List<FundTransaction> receivers(Long accountNumber)
    {
        return daoClass.getReceivers(accountNumber);
    }
}
