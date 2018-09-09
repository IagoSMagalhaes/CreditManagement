package endpoint;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import error.ResourceNotFoundException;
import io.swagger.annotations.ApiOperation;
import model.UserAddress;
import repository.UserAddressRepository;

/**
 * @author iagoMagalhães
 * Client / Server access layer
 */
@RestController
@RequestMapping("usersAddress")
@Transactional
public class UserAddressEndpoint {
	
	@Autowired
	UserAddressRepository userAddressDAO;
	
	public UserAddressEndpoint(UserAddressRepository userAddressDAO) {
		this.userAddressDAO = userAddressDAO;
	}
	
	@GetMapping(path = "/listAll")
	@ApiOperation(value = "List all list userAddress" , response = UserAddress[].class)
	public ResponseEntity<?> listAll(Pageable pageable){
		return new ResponseEntity<>(userAddressDAO.findAll(), HttpStatus.OK);
		
	}
	@GetMapping(path = "/{id}")
	@ApiOperation(value = "Return userAddress searching by Id" , response = UserAddress.class)
	public ResponseEntity<?> getUserAddressById(@PathVariable("id") Long id){		
		verifyIfUserAddressExist(id);		
		Optional<UserAddress> userAddress = userAddressDAO.findById(id);
		return new ResponseEntity<>(userAddress, HttpStatus.OK);	
	}

	@PostMapping(path="/save")
	@ApiOperation(value = "Save userAddress request Body" , response = String.class)
	@Transactional(rollbackOn = RuntimeException.class)
	public ResponseEntity<?> save(@Valid @RequestBody UserAddress userAddress){
		userAddressDAO.save(userAddress);
		return new ResponseEntity<>(userAddress, HttpStatus.OK);
	
	}
	@DeleteMapping(path="/delete/{id}")
	@ApiOperation(value = "delete userAddress searching by Id" , response = String.class)
	public ResponseEntity<?> deleteUserAddressById(@PathVariable Long id){
	verifyIfUserAddressExist(id);
		userAddressDAO.deleteById(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	

	@PutMapping(path="/update")
	@ApiOperation(value = "Update userAddress" , response = String.class)
	public ResponseEntity<?> updateUserAddresById(@Valid @RequestBody UserAddress userAddress){		
		verifyIfUserAddressExist(userAddress.getId());		
		userAddressDAO.save(userAddress);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	private void verifyIfUserAddressExist(Long id) {
		Optional<UserAddress> userAddress = userAddressDAO.findById(id); 
		if(!userAddress.isPresent()) {
			throw new ResourceNotFoundException("Endereco não encontrado " + " id: " + id);
		}
	}
}
