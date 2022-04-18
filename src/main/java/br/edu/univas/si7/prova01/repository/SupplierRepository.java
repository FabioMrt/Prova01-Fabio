package br.edu.univas.si7.prova01.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.univas.si7.prova01.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{

	Optional<Supplier> findById(long id);


}
