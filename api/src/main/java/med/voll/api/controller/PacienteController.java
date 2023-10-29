package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.paciente.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
	
	@Autowired
	PacienteRepository pr;
	
	@PostMapping
	@Transactional
	public void cadastrar(@Valid @RequestBody DadosPaciente dados) {
		pr.save(new Paciente(dados));
	}
	
	@GetMapping
	public Page<DadosListagemPaciente> listar(Pageable p) {
		return pr.findAll(p).map(DadosListagemPaciente::new); 
	}
}
