package scrolls64.executables;

import java.util.List;

import org.springframework.stereotype.Service;

import scrolls64.entities.CharStatus;
import scrolls64.entities.Player;
import scrolls64.entities.Player_Character;
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
	
	public List<Player_Character> listarPersonagensDoJogador(Player playerSelecionado) {
		return getRepository().findByInterpreterId(playerSelecionado.getId());
	}
	
	public Player_Character selecionarPorId(Integer idselecionado) {
		return getRepository().findById(idselecionado).get();
	}
	
	public Player_Character encontrarPorNome(String nometeste) {
		return getRepository().findByCharName(nometeste).get();
	}
	
	public void salvarPersonagem(Player_Character teste) {
		getRepository().save(teste);
	}
	
	public void aumentarLevel(Player_Character teste) {
		teste.setCharLevel((teste.getCharLevel() + 1));
		getRepository().save(teste);
	}
	
	public void mudarStatus(Player_Character teste, CharStatus status) {
		teste.setCharStatus(status);
		getRepository().save(teste);
	}
	
	public void excluirPersonagem(Player_Character teste) {
		getRepository().deletar(teste.getId());
	}
}
