package org.imt.nordeurope.calcoen_roussel.TpBackEndBancaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TpBackEndBancaire2Application  { //implements CommandLineRunner
	
	@Autowired
	private AccountRepository accountRepo; 

	public static void main(String[] args) {
		SpringApplication.run(TpBackEndBancaire2Application.class, args);
	}

	//@Override
	//public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	//	List<Account> accounts = accountRepo.findAll(); 
	//	accounts.forEach(System.out ::println);
		
	//	System.exit(0);
	//}

}
