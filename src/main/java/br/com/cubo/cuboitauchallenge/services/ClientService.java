package br.com.cubo.cuboitauchallenge.services;

import br.com.cubo.cuboitauchallenge.dtos.CreateClientDTO;
import br.com.cubo.cuboitauchallenge.entities.Client;
import br.com.cubo.cuboitauchallenge.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client save(CreateClientDTO dto) {
        var client = dto.toEntity();
        return clientRepository.save(client);
    }

    public List<Client> listAll() {
        return clientRepository.findAll();
    }
}
