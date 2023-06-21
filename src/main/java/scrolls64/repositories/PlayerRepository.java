package scrolls64.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import scrolls64.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}