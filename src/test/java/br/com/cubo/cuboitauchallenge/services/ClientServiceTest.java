package br.com.cubo.cuboitauchallenge.services;

import br.com.cubo.cuboitauchallenge.dtos.CreateClientDTO;
import br.com.cubo.cuboitauchallenge.entities.Client;
import br.com.cubo.cuboitauchallenge.repositories.ClientRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.any;

import static org.hamcrest.Matchers.in;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    private Client client;

    private CreateClientDTO createClientDTO;

    @BeforeEach
    void setUp(){
        this.createClientDTO = new CreateClientDTO(
                "John",
                "Doe",
                10D
        );

        this.client = new Client(
                1L,
                "John",
                "Doe",
                10D
        );
    }

    @Test
    @DisplayName("Should create client with success")
    void save() {
        var client = this.client;

        doReturn(client)
                .when(this.clientRepository)
                .save(ArgumentMatchers.any(Client.class));

        var output = clientService.save(createClientDTO);

        assertNotNull(output);
        assertEquals(output.getId(), client.getId());
        assertEquals(output.getFirstName(), client.getFirstName());
        assertEquals(output.getLastName(), client.getLastName());
        assertEquals(output.getParticipation(), client.getParticipation());
    }

    @Test
    @DisplayName("Should get a list of all clients")
    void getAll() {
        List<Client> clients = new ArrayList<>();
        clients.add(this.client);

        doReturn(clients)
                .when(this.clientRepository)
                .findAll();

        var output = clientService.listAll();

        assertNotNull(output);
        assertEquals(output.size(), 1);

        assertEquals(output.get(0).getId(), client.getId());
        assertEquals(output.get(0).getFirstName(), client.getFirstName());
        assertEquals(output.get(0).getLastName(), client.getLastName());
        assertEquals(output.get(0).getParticipation(), client.getParticipation());
    }

    @Test
    @DisplayName("Should get empty list")
    void getEmptyList() {
        List<Client> clients = new ArrayList<>();

        doReturn(clients)
                .when(this.clientRepository)
                .findAll();

        var output = clientService.listAll();

        assertNotNull(output);
        assertTrue(output.isEmpty());
    }
}