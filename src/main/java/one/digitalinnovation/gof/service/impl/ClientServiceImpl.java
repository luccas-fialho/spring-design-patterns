package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Adress;
import one.digitalinnovation.gof.model.Client;
import one.digitalinnovation.gof.repository.AdressRepository;
import one.digitalinnovation.gof.repository.ClientRepository;
import one.digitalinnovation.gof.service.ClientService;
import one.digitalinnovation.gof.service.ViaCepService;

@Service
public class ClientServiceImpl implements ClientService {

  // Injetar os componentes do Spring com @Autowired.
  @Autowired
  private ClientRepository clientRepository;
  @Autowired
  private AdressRepository adressRepository;
  @Autowired
  private ViaCepService viaCepService;
  // Implementear os métodos definidos na interface.
  // Abstrair integrações com subsistemas, provendo uma interface
  // simples.

  @Override
  public Iterable<Client> searchAll() {
    return clientRepository.findAll();
  }

  @Override
  public Client searchById(Long id) {
    // caso não exista um client retornar nulo.
    Optional<Client> client = clientRepository.findById(id);
    return client.get();
  }

  @Override
  public void insert(Client client) {
    saveClientWithAdress(client);
  }

  @Override
  public void update(Long id, Client client) {
    // Buscar cliente por id, caso exista
    Optional<Client> clientBd = clientRepository.findById(id);
    if (clientBd.isPresent()) {
      saveClientWithAdress(client);
    }
  }

  @Override
  public void delete(Long id) {
    Optional<Client> client = clientRepository.findById(id);
    if (client.isPresent()) {
      clientRepository.deleteById(id);
    }
  }

  private void saveClientWithAdress(Client client) {
    // Verifica se o endereco do Cliente já existe (pelo CEP).
		String cep = client.getAdress().getCep();
		Adress adress = adressRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Adress newAdress = viaCepService.cepQuery(cep);
			adressRepository.save(newAdress);
			return newAdress;
		});
		client.setAdress(adress);
		// Insere cliente, vinculando o endereco (novo ou existente).
		clientRepository.save(client);
  }
}
