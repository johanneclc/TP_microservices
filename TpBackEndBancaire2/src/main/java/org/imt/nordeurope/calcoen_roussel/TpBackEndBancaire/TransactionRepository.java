package org.imt.nordeurope.calcoen_roussel.TpBackEndBancaire;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	Optional<Transaction> findById(Integer id);

}