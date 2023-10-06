package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Client;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de client. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * @author Luccas Fialho
 */

public interface ClientService {

  Iterable<Client> searchAll();

  Client searchById(Long id);

  void insert(Client client);

  void update(Long id, Client client);

  void delete(Long id);
  
}
