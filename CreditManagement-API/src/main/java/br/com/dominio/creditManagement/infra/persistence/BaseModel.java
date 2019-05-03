package br.com.dominio.creditManagement.infra.persistence;

import javax.persistence.MappedSuperclass;

import lombok.Data;


/**
 * @author iagoMagalhaes
 *Default generate Serializable Entitys
 */
@Data
@MappedSuperclass
public abstract class BaseModel implements BaseModelInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3718062672968944600L;
}
