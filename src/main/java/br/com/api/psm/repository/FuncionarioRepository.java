package br.com.api.psm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.psm.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	//List<Topico> findByCursoNome(String nomeCurso);

}
