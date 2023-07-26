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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "player_character")
public class Player_Character {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 255)
	private String charName;

	@Column(length = 50)
	private String charRace;

	@Column(length = 50)
	private String charClass;

	@Column(length = 255)
	private String charConcept;

	@Column
	private int charLevel;

	@Temporal(TemporalType.DATE)
	java.time.LocalDate createdAt;

	@Enumerated(EnumType.ORDINAL)
	private CharStatus charStatus;

	@Column(length = 50)
	private String RPGSystem;

	@ManyToOne
	@JoinColumn(name="playerId", referencedColumnName = "id")
	private Player interpreter;

	public Player_Character() {
	}
	
	public Player_Character(String char_name, String char_race, String char_class, String char_concept,
			int char_level, CharStatus char_status, String rPG_system, Player interpreter) {
		this.charName = char_name;
		this.charRace = char_race;
		this.charClass = char_class;
		this.charConcept = char_concept;
		this.charLevel = char_level;
		this.createdAt = LocalDate.now();
		this.charStatus = char_status;
		RPGSystem = rPG_system;
		this.interpreter = interpreter;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public String getCharRace() {
		return charRace;
	}

	public void setCharRace(String charRace) {
		this.charRace = charRace;
	}

	public String getCharClass() {
		return charClass;
	}

	public void setCharClass(String charClass) {
		this.charClass = charClass;
	}

	public String getCharConcept() {
		return charConcept;
	}

	public void setCharConcept(String charConcept) {
		this.charConcept = charConcept;
	}

	public int getCharLevel() {
		return charLevel;
	}

	public void setCharLevel(int charLevel) {
		this.charLevel = charLevel;
	}

	public java.time.LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(java.time.LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public CharStatus getCharStatus() {
		return charStatus;
	}

	public void setCharStatus(CharStatus charStatus) {
		this.charStatus = charStatus;
	}

	public String getRPGSystem() {
		return RPGSystem;
	}

	public void setRPGSystem(String rPGSystem) {
		RPGSystem = rPGSystem;
	}

	public Player getInterpreter() {
		return interpreter;
	}

	public void setInterpreter(Player interpreter) {
		this.interpreter = interpreter;
	}

}