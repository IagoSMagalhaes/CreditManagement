package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import model.UserAddress;


/**
 * @author iagoMagalhaes
 *Interface Repository the layer data acess
 */
@Repository
public interface UserAddressRepository extends PagingAndSortingRepository<UserAddress, Long> {
	
	Optional<UserAddress> findById(Long id);
	
	void deleteById(Long id);
}
