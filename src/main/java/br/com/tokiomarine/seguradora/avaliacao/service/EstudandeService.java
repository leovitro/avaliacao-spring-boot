package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;

import javax.validation.Valid;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;

public interface EstudandeService {

	List<Estudante> buscarEstudantes();

	Estudante cadastrarEstudante(@Valid Estudante estudante);

	Estudante buscarEstudante(long id);

	Estudante atualizarEstudante(@Valid Estudante estudante);
	
	void apagarEstudante(@Valid Estudante estudante);
	
	void apagarEstudante(long id);

}
