package scrolls64.executables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import scrolls64.repositories.PlayerRepository;
import scrolls64.repositories.Player_CharacterRepository;

@Component
public class Iniciar {
	
	@Autowired
	private PlayerRepository PLYrepository;
	@Autowired
	private Player_CharacterRepository PCrepository;
	
	@PostConstruct
	private void inicializar() {
		PlayerMethods pm = new PlayerMethods(PLYrepository);
		CharacterMethods cm = new CharacterMethods(PCrepository);
		ScreenMethods sm = new ScreenMethods();	
		sm.telaInicial();
		System.out.println(pm.verificarUsername("BLKZim"));
		System.out.println(pm.verificarEmail("apollyondelta@gmail.com"));
	}
}
