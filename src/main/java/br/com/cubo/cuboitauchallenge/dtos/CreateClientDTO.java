package br.com.cubo.cuboitauchallenge.dtos;

import br.com.cubo.cuboitauchallenge.entities.Client;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateClientDTO(
        @NotBlank(message = "fistName field is mandatory")
        String fistName,

        @NotBlank(message = "lastName field is mandatory")
        String lastName,

        @Min(value = 1, message = "participation must be higher than 0")
        @NotNull(message = "participation field is mandatory")
        Double participation
        ) {

    public Client toEntity() {
        var client = new Client();
        client.setFirstName(this.fistName);
        client.setLastName(this.lastName);
        client.setParticipation(this.participation);

        return client;
    }
}
