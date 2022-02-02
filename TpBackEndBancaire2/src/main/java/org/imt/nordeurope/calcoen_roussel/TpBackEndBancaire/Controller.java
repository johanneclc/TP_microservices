package org.imt.nordeurope.calcoen_roussel.TpBackEndBancaire;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
    private ServiceBancaire service = new ServiceBancaire();
    
    @RequestMapping( value = "/message")
    public String getMessage() {
        return "redirect";
    }
    
    @RequestMapping( value = "/account", method = RequestMethod.GET,produces = "application/json")
    public List<Account> listAll(Model model) {
        List<Account> accounts = service.findAll();
        //model.addAttribute("accounts", accounts);
        return accounts; 
    }

    @RequestMapping( value = "/account", method = RequestMethod.POST)
    public String addAccount(@RequestParam(value = "iban") String iban, @RequestParam(value = "somme") int somme) {
        try {
            service.addAccount(iban, somme);
            return "" ;
        } catch (Exception e) {
            return e.getMessage();
        } 
    }

    @RequestMapping( value = "/transaction", method = RequestMethod.GET)
    public List transactionList() {
        return service.getTransactionList();
    }

    @RequestMapping( value = "/account/{idCompte}/transaction", method = RequestMethod.GET)
    public List transactionFromAccount(@PathVariable("idCompte") int idCompte) {
        return service.getTransactionListWithAccountId(idCompte); 
    }
}
