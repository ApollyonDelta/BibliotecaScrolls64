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
	private String char_name;

	@Column(length = 50)
	private String char_race;

	@Column(length = 50)
	private String char_class;

	@Column(length = 255)
	private String char_concept;

	@Column
	private int char_level;

	@Temporal(TemporalType.DATE)
	java.time.LocalDate createdAt;

	@Enumerated(EnumType.ORDINAL)
	private CharStatus char_status;

	@Column(length = 50)
	private String RPG_system;

	@ManyToOne
	@JoinColumn(name="player_id", referencedColumnName = "id")
	private Player interpreter;

	public Player_Character(String char_name, String char_race, String char_class, String char_concept,
			int char_level, CharStatus char_status, String rPG_system, Player interpreter) {
		this.char_name = char_name;
		this.char_race = char_race;
		this.char_class = char_class;
		this.char_concept = char_concept;
		this.char_level = char_level;
		this.createdAt = LocalDate.now();
		this.char_status = char_status;
		RPG_system = rPG_system;
		this.interpreter = interpreter;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChar_name() {
		return char_name;
	}

	public void setChar_name(String char_name) {
		this.char_name = char_name;
	}

	public String getChar_race() {
		return char_race;
	}

	public void setChar_race(String char_race) {
		this.char_race = char_race;
	}

	public String getChar_class() {
		return char_class;
	}

	public void setChar_class(String char_class) {
		this.char_class = char_class;
	}

	public String getChar_concept() {
		return char_concept;
	}

	public void setChar_concept(String char_concept) {
		this.char_concept = char_concept;
	}

	public int getChar_level() {
		return char_level;
	}

	public void setChar_level(int char_level) {
		this.char_level = char_level;
	}

	public java.time.LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(java.time.LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public CharStatus getChar_status() {
		return char_status;
	}

	public void setChar_status(CharStatus char_status) {
		this.char_status = char_status;
	}

	public String getRPG_system() {
		return RPG_system;
	}

	public void setRPG_system(String rPG_system) {
		RPG_system = rPG_system;
	}

	public Player getInterpreter() {
		return interpreter;
	}

	public void setInterpreter(Player interpreter) {
		this.interpreter = interpreter;
	}

}