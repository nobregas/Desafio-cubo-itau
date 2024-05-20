package br.com.cubo.cuboitauchallenge.repositories;

import br.com.cubo.cuboitauchallenge.dtos.CreateClientDTO;
import br.com.cubo.cuboitauchallenge.entities.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    private Client client;

    @BeforeEach
    void setClient() {
        var dto = new CreateClientDTO(
                "John",
                "Doe",
                10D
        );

        this.client = dto.toEntity();
    }

    @Test
    @DisplayName("Should create client with success")
    void createClient() {
        var createdClient = clientRepository.save(client);

        assertNotNull(createdClient);
        assertNotNull(createdClient.getId());
        assertEquals(createdClient.getFirstName(), client.getFirstName());
        assertEquals(createdClient.getLastName(), client.getLastName());
        assertEquals(createdClient.getParticipation(), client.getParticipation());
    }

    @Test
    @DisplayName("Should get client list with success")
    void getClientList() {
        var createdClient = clientRepository.save(client);

        var clientList = clientRepository.findAll();
        var clientInList = clientList.get(0);

        assertNotNull(clientList);
        assertEquals(1, clientList.size());

        assertEquals(createdClient.getId(), clientInList.getId());
        assertEquals(createdClient.getFirstName(), clientInList.getFirstName());
        assertEquals(createdClient.getLastName(), clientInList.getLastName());
        assertEquals(createdClient.getParticipation(), clientInList.getParticipation());
    }

    @Test
    @DisplayName("Should get empty client list with success")
    void getClientListEmpty() {
        var clientList = clientRepository.findAll();

        assertNotNull(clientList);
        assertTrue(clientList.isEmpty());
    }
}