package br.com.dominio.creditManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.dominio.creditManagement.enums.RiskEnum;
import br.com.dominio.creditManagement.infra.persistence.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author iagoMagalhaes Client Model
 */
@Entity
@Table(name = "tbClient")
@PrimaryKeyJoinColumn(name = "id")
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)))
public class ClientModel extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7237478195298657938L;

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "id")
	private String id;

	@Column(name = "name", nullable = false)
	public String name;

	@Column(name = "creditLimit", nullable = false)
	public Long creditLimit;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "risk", nullable = false)
	public RiskEnum risk;
	
	@Column(name = "interestRate")
	public Long interestRate;
	
}
