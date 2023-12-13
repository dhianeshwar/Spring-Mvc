package CrudApp.Controller;
import CrudApp.Model.FundTransaction;
import CrudApp.Model.Merchant;
import CrudApp.Service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MerchantController {

    private final ServiceClass serviceClass;

    @Autowired
    public MerchantController(ServiceClass serviceClass) {
        this.serviceClass = serviceClass;
    }

    @GetMapping("/form")
    public String form()
    {
        return "form";
    }

    @PostMapping("/insert")
    public String saveMerchant(@ModelAttribute Merchant merchant,Model model) {
        if(serviceClass.getMerchantById(merchant.getAccountNumber())==null) {
            serviceClass.createMerchant(merchant);
            return "redirect:/list";
        }
        else {
            model.addAttribute("error", "account number already exist");
            return "form";
        }
    }

    @GetMapping("/list")
    public String list(Model model)
    {
        model.addAttribute("merchants",serviceClass.getAllMerchant());
        return "list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam Long accountNumber, Model model)
    {
        serviceClass.deleteTemp(accountNumber);
        return "redirect:/list";
    }

    @GetMapping("/update")
    public String updateMerchant(@RequestParam Long accountNumber, Model model) {
        model.addAttribute("merchant",serviceClass.getMerchantById(accountNumber));
        return "update";
    }

    @PostMapping("/updateNow")
    public String updateMerchant(@ModelAttribute Merchant merchant) {
        serviceClass.updateMerchant(merchant);
        return "redirect:/list";
    }


    @GetMapping("/send")
    public String send(@RequestParam Long accountNumber,Model model)
    {
        model.addAttribute("merchant",serviceClass.getMerchantById(accountNumber));
        return "money";
    }
    @PostMapping("/performTransaction")
    public String performTransaction(@ModelAttribute FundTransaction fundTransaction,Model model) {

            if(serviceClass.createTransactionAndHandleBalances(fundTransaction)=="true")
                return "redirect:/list";
            else
            {
                model.addAttribute("error",serviceClass.createTransactionAndHandleBalances(fundTransaction));
                return "money";
            }
    }
    @GetMapping("/viewSenders")
    public String viewSenders(@RequestParam Long accountNumber,Model model)
    {
        if(serviceClass.senders(accountNumber).isEmpty())
        {
            model.addAttribute("error","currently you have no transaction");
        }
        model.addAttribute("senders",serviceClass.senders(accountNumber));
        return "senders";
    }
    @GetMapping("/viewReceivers")
    public String viewReceivers(@RequestParam Long accountNumber,Model model)
    {
        if(serviceClass.receivers(accountNumber).isEmpty())
        {
            model.addAttribute("error","currently you have no transaction");
        }
        model.addAttribute("senders",serviceClass.receivers(accountNumber));
        return "senders";
    }
}