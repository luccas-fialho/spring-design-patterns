package one.digitalinnovation.gof.repository;

import org.springframework.data.repository.CrudRepository;

import one.digitalinnovation.gof.model.Adress;

public interface AdressRepository extends CrudRepository<Adress, String>{
  
}
