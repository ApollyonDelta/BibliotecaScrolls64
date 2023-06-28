package scrolls64.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import scrolls64.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
	
	@Query("SELECT COUNT(id) FROM Player WHERE username LIKE :testedeusuario")
	int verificarDisponibilidadeUsername(String testedeusuario);
	
	@Query("SELECT COUNT(id) FROM Player WHERE email LIKE :testedeemail")
	int verificarDisponibilidadeEmail(String testedeemail);
}