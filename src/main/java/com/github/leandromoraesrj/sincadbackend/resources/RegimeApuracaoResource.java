package com.github.leandromoraesrj.sincadbackend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.leandromoraesrj.sincadbackend.services.RegimeApuracaoService;

@RestController
public class RegimeApuracaoResource {
	@Autowired
	private RegimeApuracaoService service;

	@RequestMapping(value = "/regimeapuracao", method = RequestMethod.GET)
	public ResponseEntity<?> listarTodos() {
		return ResponseEntity.ok(service.listarTodos());
	}

	@RequestMapping(value = "/regimeapuracao/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obter(@PathVariable Integer id) {
		return ResponseEntity.of(service.obter(id));
	}
}