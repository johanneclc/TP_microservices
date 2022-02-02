package org.imt.nordeurope.calcoen_roussel.TpBackEndBancaire;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer account_id;

    @Column(name="somme")
    private int somme;

    @Column(name="iban")
    private String iban;

    public Integer getId() {
        return account_id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setId (Integer id) {
    this.account_id = id;
    }

    public int getSomme() {
        return somme;
    }

    public void setSomme(int somme) {
        this.somme = somme;
    }
}