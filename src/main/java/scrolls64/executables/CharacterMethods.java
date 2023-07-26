package scrolls64.executables;

import org.springframework.stereotype.Service;

import scrolls64.entities.Player;
import scrolls64.repositories.Player_CharacterRepository;

@Service
public class CharacterMethods {
	
	private Player_CharacterRepository repository;
	
	public CharacterMethods (Player_CharacterRepository repository) {
		this.repository = repository;
	}
	
	public Player_CharacterRepository getRepository() {
		return repository;
	}

	public void setRepository(Player_CharacterRepository repository) {
		this.repository = repository;
	}
	
//	public void apagarPersonagensDoPlayer(Player interprete) {
//		getRepository().deletarPersonagensDePlayer(interprete.getId());
//	}
}
