package scrolls64.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import scrolls64.entities.Character;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

}