package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;
import java.util.Optional;

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
	public Estudante cadastrarEstudante(@Valid Estudante estudante) {
		return repository.save(estudante);
	}

	@Override
	public Estudante atualizarEstudante(@Valid Estudante estudante) {
		if(repository.existsById(estudante.getId())){
			return repository.save(estudante);
		}else {
			throw new IllegalArgumentException("Identificador inválido:" + estudante.getId());
		}
	}
	
	@Override
	public void apagarEstudante(@Valid Estudante estudante) {
		repository.delete(estudante);
	}	 
	
	@Override
	public void apagarEstudante(long id) {
		Optional<Estudante> estudante = repository.findById(id);
		if(estudante.isPresent()){
			repository.delete(estudante.get());
		}else {
			throw new IllegalArgumentException("Identificador inválido:" + id);
		}
	}	

	@Override
	public List<Estudante> buscarEstudantes() {
		return repository.findAll();
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
