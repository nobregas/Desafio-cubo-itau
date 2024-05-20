package br.com.cubo.cuboitauchallenge.controllers;

import br.com.cubo.cuboitauchallenge.dtos.CreateClientDTO;
import br.com.cubo.cuboitauchallenge.entities.Client;
import br.com.cubo.cuboitauchallenge.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@Tag(name = "Client Management")
public class ClientController {

    private final ClientService clientService;

    @Operation(
            description = "Get endpoint for all clients registered",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    )
    }
    )
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        var clients = clientService.listAll();
        return ResponseEntity.ok(clients);
    }

    @Operation(
            description = "Post endpoint for create a client",
            responses = {
                    @ApiResponse(
                            description = "Created",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "Bad Request / invalid fields",
                            responseCode = "400"
                    )
            }
    )
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody @Validated CreateClientDTO client) {
        var createdClient = clientService.save(client);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }
}
