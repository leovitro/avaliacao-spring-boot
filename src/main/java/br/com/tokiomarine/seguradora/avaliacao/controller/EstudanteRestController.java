package br.com.tokiomarine.seguradora.avaliacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudanteServiceImpl;

@RestController
@RequestMapping("/api/estudantes/")
public class EstudanteRestController {

	@Autowired
	private EstudanteServiceImpl service;

	@PostMapping
	public ResponseEntity<Estudante> adicionarEstudante(@Valid @RequestBody Estudante estudante) {
		
		estudante = service.cadastrarEstudante(estudante);
		
		return ResponseEntity.ok(estudante);
		
	}

	@PutMapping("/{id}")
	public ResponseEntity<Estudante> atualizarEstudante(@PathVariable long id, @Valid @RequestBody Estudante estudante) {

		estudante.setId(id);
		estudante = service.atualizarEstudante(estudante);
		if(estudante!=null) {
			return ResponseEntity.ok(estudante);
		}else {
			return ResponseEntity.notFound().build();
		}
			
	}

	@GetMapping
	public List<Estudante> listarEstudantes() {
		return service.buscarEstudantes();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Estudante> apagarEstudante(@PathVariable long id) {
		service.apagarEstudante(id);
		return ResponseEntity.ok().build();
	}	
}
