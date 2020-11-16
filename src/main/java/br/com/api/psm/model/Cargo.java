package br.com.api.psm.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargo_id")
	private Long id;
	
	@Column(name = "cargo_name")
	private String nome;
	
	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionario;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the funcionario
	 */
	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cargo [id=" + id + ", nome=" + nome + ", funcionario=" + funcionario + "]";
	}
	
	
	

}
