package model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author iagoMagalhaes
 *UserAddress Entity, getter/setter and annotations para mapeação for mapping.
 */
@Entity
@Table(name = "tbUserAddress")
public class UserAddress extends AbstractEntity{
	
	
	public Long id;
	@NotEmpty(message = "O estado é obrigatório")
	public String stade;
	@NotEmpty(message = "A cidade é obrigatória")
	public String city;
	public String neighborhood;
	@NotEmpty(message = "A rua é obrigatória")
	public String street;
	@NotEmpty(message = "O numero é obrigatório")
	public String homeNumber;
	public String complement;
	public String cep;
	
	
	
	public UserAddress(Long id, @NotEmpty(message = "O estado é obrigatório") String stade,
			@NotEmpty(message = "A cidade é obrigatória") String city, String neighborhood,
			@NotEmpty(message = "A rua é obrigatória") String street,
			@NotEmpty(message = "O numero é obrigatório") String homeNumber, String complement, String cep) {
		super();
		this.id = id;
		this.stade = stade;
		this.city = city;
		this.neighborhood = neighborhood;
		this.street = street;
		this.homeNumber = homeNumber;
		this.complement = complement;
		this.cep = cep;
	}

	public UserAddress(Long id) {
		this.id = id;
	}
	
	public UserAddress() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStade() {
		return stade;
	}

	public void setStade(String stade) {
		this.stade = stade;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	}
