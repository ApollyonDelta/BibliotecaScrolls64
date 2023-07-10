package scrolls64.executables;

import scrolls64.repositories.PlayerRepository;

public class PlayerMethods {
	
	private PlayerRepository repository;
	
	public PlayerMethods(PlayerRepository repository) {
		this.repository = repository;
	}
	
	public boolean verificarUsername(String usertestado) {
		return (this.repository.verificarDisponibilidadeUsername(usertestado) == 0);
	}
	
	public boolean verificarEmail(String emailtestado) {
		return(this.repository.verificarDisponibilidadeEmail(emailtestado) == 0);
	}
	
	public boolean tentativaDeLogin() {
		return true;
	}
}
