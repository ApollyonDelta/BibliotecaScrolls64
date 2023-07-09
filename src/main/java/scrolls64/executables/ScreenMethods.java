package scrolls64.executables;

public class ScreenMethods {

	public ScreenMethods () {
		
	}
	
	public void limparTela () {
		System.out.print("Everything on the console will cleared");
        System.out.print("\033[H\033[2J");
        System.out.flush();
	}
	
	public void telaInicial() {
		System.out.println("#-------------------------------#");
		System.out.println("Bem vindo ao BibliotecaScrolls64");
		System.out.println("#-------------------------------#");
	}
}
