// Trabalho de Linguagem de Programação III - BibliotecaScrolls64
// Daniel de Oliveira e Miguel Valentim Silva dos Santos
// Turma 4K - 28/07/2023 

package scrolls64.executables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import scrolls64.entities.CharStatus;
import scrolls64.entities.Player;
import scrolls64.entities.Player_Character;
import scrolls64.repositories.PlayerRepository;
import scrolls64.repositories.Player_CharacterRepository;

@Component
public class Iniciar {
	
	@Autowired
	private PlayerRepository PLYrepository;
	@Autowired
	private Player_CharacterRepository PCrepository;
	
	@SuppressWarnings("static-access")
	@PostConstruct
	private void inicializar() {
		PlayerMethods pm = new PlayerMethods(PLYrepository);
		CharacterMethods cm = new CharacterMethods(PCrepository);
		ScreenMethods sm = new ScreenMethods(pm, cm);
		initialCheck();
		sm.telaInicial();
	}
	
	private void initialCheck() {
		if (PLYrepository.contarRegistrosDeJogadores() > 0) {
			return;
		}
		Player daniel = new Player("ApollyonDelta", "apollyondelta@gmail.com", "Hollow2011");
		Player cesar = new Player("FlorinSupreme", "arteirocleitan@gmail.com", "Gug1806");
		Player miguel = new Player("BLKZim", "miguelmigue804@gmail.com", "Teutio0303");
		Player_Character kirion = new Player_Character("Kirion Newlin", "Elfo", "Mago", "Um mago estudioso que combate a ignorância.", 4, CharStatus.MORTO, "Tormenta20", daniel);
		Player_Character vidar = new Player_Character("Vidar", "Draconato", "Paladino da Vingança", "Um morto que busca vingança e redenção.", 3, CharStatus.ATIVO, "Dungeons And Dragons", daniel);
		Player_Character minus = new Player_Character("Minus Maximus", "Minotauro", "Bárbaro", "Um gigante gentil.", 5, CharStatus.HIATO, "Tormenta20", cesar);
		Player_Character nero = new Player_Character("Nero Vancover", "Kliren", "Inventora", "Uma inventora que perdeu sua verdadeira forma.", 10, CharStatus.INATIVO, "Tormenta20", miguel);
		PLYrepository.save(daniel); PLYrepository.save(cesar); PLYrepository.save(miguel);
		PCrepository.save(kirion); PCrepository.save(minus); PCrepository.save(nero); PCrepository.save(vidar);
	}
}
