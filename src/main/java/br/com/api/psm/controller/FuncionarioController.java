package br.com.api.psm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.psm.model.Funcionario;
import br.com.api.psm.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	/**
	 * @param funcionario
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Funcionario> save(@RequestBody Funcionario funcionario){
		funcionarioRepository.save(funcionario);
		return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> getAll(){
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		funcionarios = funcionarioRepository.findAll();
		
		return new ResponseEntity<List<Funcionario>>(funcionarios, HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Funcionario>> getById(@PathVariable Long id) {
		Optional<Funcionario> funcionario;
		
		try {
			funcionario = funcionarioRepository.findById(id);
			return new ResponseEntity<Optional<Funcionario>>(funcionario, HttpStatus.OK);
			
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Optional<Funcionario>>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	/**
	 * @param id
	 * @param novoFuncionario
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> update(@PathVariable Long id, @RequestBody Funcionario novoFuncionario) {
		return funcionarioRepository.findById(id)
				.map(funcionario -> {
					funcionario.setName(novoFuncionario.getName());
					funcionario.setAge(novoFuncionario.getAge());
					funcionario.setBirthday(novoFuncionario.getBirthday());
					funcionario.setDocument(novoFuncionario.getDocument());
					funcionario.setCargo(novoFuncionario.getCargo());
					Funcionario funcionarioUpdate = funcionarioRepository.save(funcionario);
					return ResponseEntity.ok().body(funcionarioUpdate);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	
	/**
	 * @param id
	 * @param novoFuncionario
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<Funcionario>> delete(@PathVariable Long id) {
		try {
			funcionarioRepository.deleteById(id);
			return new ResponseEntity<Optional<Funcionario>>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Optional<Funcionario>>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
