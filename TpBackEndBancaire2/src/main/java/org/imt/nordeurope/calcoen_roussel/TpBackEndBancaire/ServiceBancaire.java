package org.imt.nordeurope.calcoen_roussel.TpBackEndBancaire;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ServiceBancaire implements IService {   
    
    private EntityManager em;
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Override
    public List<Account> findAll() {
    	List<Account> accounts = accountRepository.findAll();  
    	
    	//Account account = new Account(); 
    	//account.setIban("FR7630001007941234567890185");
    	//account.setSomme(200);
    	//accounts.add(account);   
    	return accounts; 
        //return em.createQuery("SELECT * FROM ACCOUNT").getResultList();
    }

    public List<Account> getTransactionList() {
        return em.createQuery("SELECT * FROM TRANSACTION").getResultList();
    }

    public List<Account> getTransactionListWithAccountId(int compteId) {
        return em.createQuery("SELECT * FROM TRANSACTION WHERE TRANSACTION.DEBITEUR_ACCOUNT_ID = " + compteId
                + " OR TRANSACTION.CREDITEUR_ACCOUNT_ID = " + compteId).getResultList();
    }

    public void addAccount(String iban, int somme) {
        // V�rification iban
        try {
            URL url = new URL("http://localhost:8080/TBBackEndIban/IbanCheck?iban=" + iban);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());

            con.setRequestProperty("Accept", "application/json");
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("TP back end inaccessible message d'erreur : " + con.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(con.getInputStream());
            BufferedReader br = new BufferedReader(in);
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(br);
            }

            // On recupere la reponse de notre micro service calqu�e sur une class
            TPBackEndResponse response = new ObjectMapper().readValue(sb.toString(), TPBackEndResponse.class);
            con.disconnect();

            if (response.isValid) {
                Account account = new Account();
                account.setIban(iban);
                account.setSomme(somme);
                accountRepository.save(account);
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout d'un compte :- " + e);
        }
    }
}