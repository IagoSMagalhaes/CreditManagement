package br.com.dominio.creditManagement.infra.persistence;
import java.io.Serializable;

public interface BaseModelInterface extends Serializable {
	
	Serializable getId();
}
