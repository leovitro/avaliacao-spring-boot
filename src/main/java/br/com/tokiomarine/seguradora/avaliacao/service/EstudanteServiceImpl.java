package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;

@Service
public class EstudanteServiceImpl implements EstudandeService {

	@Autowired
	private EstudanteRepository repository;

	@Override
	public void cadastrarEstudante(@Valid Estudante estudante) {
		repository.save(estudante);
	}

	@Override
	public void atualizarEstudante(@Valid Estudante estudante) {
		if(repository.existsById(estudante.getId())){
			repository.save(estudante);
		}
	}
	
	@Override
	public void apagarEstudante(@Valid Estudante estudante) {
		if(repository.findById(estudante.getId()).isPresent()) {
			repository.delete(estudante);
		} else {
			throw new IllegalArgumentException("Identificador inválido:" + estudante.getId());
		}
	}	

	@Override
	public List<Estudante> buscarEstudantes() {
		return StreamSupport
				.stream(repository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	@Override
	public Estudante buscarEstudante(long id) {
		Optional<Estudante> estudante = repository.findById(id);
		if(estudante.isPresent()) {
			return estudante.get();
		} else {
			throw new IllegalArgumentException("Identificador inválido:" + id);
		}
	}

}
