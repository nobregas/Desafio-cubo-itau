package br.com.cubo.cuboitauchallenge.repositories;

import br.com.cubo.cuboitauchallenge.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository
    extends JpaRepository<Client, Long> {
}
