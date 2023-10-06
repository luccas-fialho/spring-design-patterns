package one.digitalinnovation.gof.service.impl;

import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Client;
import one.digitalinnovation.gof.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

  // TODO Singleton: Injetar os componentes do Spring com @Autowired.
  // TODO Strategy: Implementear os métodos definidos na interface.
  // TODO Facade: Abstrair integrações com subsistemas, provendo uma interface simples.


  @Override
  public Iterable<Client> searchAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'searchAll'");
  }

  @Override
  public Client searchById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'searchById'");
  }

  @Override
  public void insert(Client client) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insert'");
  }

  @Override
  public void update(Long id, Client client) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }
  
  
}
