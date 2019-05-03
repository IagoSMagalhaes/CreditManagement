package br.com.dominio.creditManagement.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.dominio.creditManagement.model.ClientModel;


/**
 * @author iagoMagalhaes
 *Interface Repository the layer data acess User Entity
 */
@Repository
public interface ClientRepository extends PagingAndSortingRepository<ClientModel, String> {
}
