package scrolls64.entities;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Character {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=255)
	private String name;
	
	@Column(length=50)
	private String race;
	
	@Column(length=50)
	private String charClass;
	
	@Column(length=255)
	private String concept;
	
	@Column
	private int hitpoints;
	
	@Temporal(TemporalType.DATE) java.time.LocalDate createdAt;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	@Column(length=50)
	private String system;
	
	@ManyToOne
	@JoinColumn(name="interpreter", nullable=false)
	private Player interpreter;

	public Character(Integer id, String name, String race, String charClass, String concept, int hitpoints,
			LocalDate createdAt, Status status, String system) {
		this.id = id;
		this.name = name;
		this.race = race;
		this.charClass = charClass;
		this.concept = concept;
		this.hitpoints = hitpoints;
		this.createdAt = createdAt;
		this.status = status;
		this.system = system;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getCharClass() {
		return charClass;
	}

	public void setCharClass(String charClass) {
		this.charClass = charClass;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public int getHitpoints() {
		return hitpoints;
	}

	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
	}

	public java.time.LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(java.time.LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public Player getInterpreter() {
		return interpreter;
	}

	public void setInterpreter(Player interpreter) {
		this.interpreter = interpreter;
	}
	
}