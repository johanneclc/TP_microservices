package org.imt.nordeurope.calcoen_roussel.TpBackEndBancaire;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
    @Column(name="TRANSACTION_ID")
    private Long id;

    @Column(name="MONTANT")
    private int montant;

    @Column(name="DEBITEUR_ACCOUNT_ID")
    private Long debiteur_account_id;

    @Column(name="CREDITEUR_ACCOUNT_ID")
    private Long crediteur_account_id;

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Long getDebiteur_account_id() {
        return debiteur_account_id;
    }

    public void setDebiteur_account_id(Long debiteur_account_id) {
        this.debiteur_account_id = debiteur_account_id;
    }

    public Long getCrediteur_account_id() {
        return crediteur_account_id;
    }

    public void setCrediteur_account_id(Long crediteur_account_id) {
        this.crediteur_account_id = crediteur_account_id;
    }

    public Long getId() {
        return id;
    }

    public void setId (Long id) {
    this.id = id;
    }

}