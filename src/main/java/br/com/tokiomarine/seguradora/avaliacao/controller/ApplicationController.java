package br.com.tokiomarine.seguradora.avaliacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tokiomarine.seguradora.avaliacao.service.EstudanteServiceImpl;

@Controller
@RequestMapping("/")
public class ApplicationController {
	
	@Autowired
	private EstudanteServiceImpl service;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("estudantes", service.buscarEstudantes());
		return "index";
	}
	
}
