package scrolls64.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import scrolls64.entities.Player_Character;

public interface Player_CharacterRepository extends JpaRepository<Player_Character, Integer> {
	
	List<Player_Character> findByInterpreterId(Integer id);
	
	Optional <Player_Character> findById(Integer id);
	
	Optional <Player_Character> findByCharName(String nome);
}