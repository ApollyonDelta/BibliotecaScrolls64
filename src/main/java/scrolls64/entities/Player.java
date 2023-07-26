package scrolls64.entities;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=255, unique=true)
	private String username;
	
	@Column(length=100, unique=true)
	private String email;
	
	@Column(length=24)
	private String password;
	
    @Temporal(TemporalType.DATE) 
    java.time.LocalDate createdAt;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy="interpreter", cascade = CascadeType.PERSIST, orphanRemoval=true)
    private Set <Player_Character> characters;
    
    public Player() {
    }

	public Player(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.createdAt = LocalDate.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public Set<Player_Character> getCharacters() {
		return characters;
	}

	public void setCharacters(Set<Player_Character> characters) {
		this.characters = characters;
	}

	@Override
	public String toString() {
		return "Player [id= " + id + ", username= " + username + ", email= " + email + ", password= " + password
				+ ", createdAt= " + createdAt + ", characters= " + characters + "]";
	}
	
}