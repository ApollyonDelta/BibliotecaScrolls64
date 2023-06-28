package scrolls64.executables;

import scrolls64.repositories.PlayerRepository;

public class PlayerMethods {
	
	private PlayerRepository repository;
	
	public PlayerMethods(PlayerRepository repository) {
		this.repository = repository;
	}
	
	public boolean verificarUsername(String usertestado) {
		if(this.repository.verificarDisponibilidadeUsername(usertestado) == 0 ) {
			return true;
		}
		return false;
	}
	
	public boolean verificarEmail(String emailtestado) {
		if(this.repository.verificarDisponibilidadeEmail(emailtestado) == 0 ) {
			return true;
		}
		return false;
	}
}
