package scrolls64.executables;

import org.springframework.stereotype.Service;

import scrolls64.entities.Player;
import scrolls64.repositories.PlayerRepository;

@Service
public class PlayerMethods {

	private PlayerRepository repository;
	
	public PlayerMethods(PlayerRepository repository) {
		this.repository = repository;
	}
	
	public PlayerRepository getRepository() {
		return repository;
	}

	public void setRepository(PlayerRepository repository) {
		this.repository = repository;
	}

	public boolean verificarUsername(String usertestado) {
		return (getRepository().verificarDisponibilidadeUsername(usertestado) == 0);
	}
	
	public boolean verificarEmail(String emailtestado) {
		return(getRepository().verificarDisponibilidadeEmail(emailtestado) == 0);
	}
	
	public boolean tentativaLogin(String username, String senha) {
		return !(getRepository().tentativaLogin(username, senha) == null);
	}
	
	public Player logarUsuario(String username, String senha) {
		return getRepository().findById(getRepository().tentativaLogin(username, senha)).get();
	}
	
	public boolean confirmarSenha(Player playerTeste, String senhaTeste) {
		return (playerTeste.getPassword().equals(senhaTeste));
	}
	
	public void salvarPlayer (Player playerSalvo) {
		getRepository().save(playerSalvo);
	}
	
	public void deletarConta(Player playerSalvo) {
		getRepository().delete(playerSalvo);
	}
}
