package br.com.api.psm.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionario_id")
	private Long id;
	
	@Column(name = "funcionario_name")
	private String name;
	
	@Column(name = "funcionario_age")
	private Integer age;
	
	@Column(name = "funcionario_birthday")
	private LocalDate birthday;
	
	@Column(name = "funcionario_document")
	private String document;
	
	@OneToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "funcionarioDepartamento", joinColumns = { @JoinColumn(name = "funcionario_id") }, inverseJoinColumns = { @JoinColumn(name = "departamento_id") })
	private Set<Departamento> funcionarioDepartamento = new HashSet<Departamento>(0);
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the document
	 */
	public String getDocument() {
		return document;
	}
	/**
	 * @param document the document to set
	 */
	public void setDocument(String document) {
		this.document = document;
	}
	/**
	 * @return the cargo
	 */
	public Cargo getCargo() {
		return cargo;
	}
	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	
	/**
	 * @return the funcionarioDepartamento
	 */
	public Set<Departamento> getFuncionarioDepartamento() {
		return funcionarioDepartamento;
	}
	/**
	 * @param funcionarioDepartamento the funcionarioDepartamento to set
	 */
	public void setFuncionarioDepartamento(Set<Departamento> funcionarioDepartamento) {
		this.funcionarioDepartamento = funcionarioDepartamento;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", name=" + name + ", age=" + age + ", birthday=" + birthday + ", document="
				+ document + ", cargo=" + cargo + "]";
	}
	
	
	

}
