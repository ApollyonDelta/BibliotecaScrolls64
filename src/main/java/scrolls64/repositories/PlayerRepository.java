package scrolls64.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import scrolls64.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
	
	@Query("SELECT COUNT(id) FROM Player")
	int contarRegistrosDeJogadores();
	
	@Query("SELECT COUNT(id) FROM Player WHERE username LIKE :testedeusuario")
	int verificarDisponibilidadeUsername(String testedeusuario);
	
	@Query("SELECT COUNT(id) FROM Player WHERE email LIKE :testedeemail")
	int verificarDisponibilidadeEmail(String testedeemail);
	
	@Query("SELECT id FROM Player WHERE username LIKE :testedeusuario AND password LIKE :senhatestada")
	Integer tentativaLogin(String testedeusuario, String senhatestada);
	
	Optional <Player> findById(Long id);
}