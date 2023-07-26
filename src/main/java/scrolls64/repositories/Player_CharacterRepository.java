package scrolls64.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import scrolls64.entities.Player_Character;

public interface Player_CharacterRepository extends JpaRepository<Player_Character, Integer> {
	
}