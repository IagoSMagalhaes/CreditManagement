package br.com.dominio.creditManagement.infra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.dominio.creditManagement.infra.persistence.BaseModel;

public abstract class BaseController {
	
	public <T extends BaseModel> ResponseEntity<Long> created(final T valor) {
		return new ResponseEntity<>((Long) valor.getId(), HttpStatus.CREATED);
	}
	public ResponseEntity<Long> created(final Long valor) {
		return new ResponseEntity<>(valor, HttpStatus.CREATED);
	}

	public ResponseEntity<Void> created() {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public ResponseEntity<Void> deleted() {
		return this.noContent();
	}

	public ResponseEntity<Long> updated(final String valor) {
		return new ResponseEntity<>(Long.valueOf(valor), HttpStatus.OK);
	}
	
	public <T> ResponseEntity<T> ok(final T valor) {
		return new ResponseEntity<>(valor, HttpStatus.OK);
	}

	public ResponseEntity<Void> ok() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public <T> ResponseEntity<T> notFound() {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<Void> noContent() {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
	}
}
