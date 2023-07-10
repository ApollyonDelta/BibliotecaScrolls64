package scrolls64.executables;

import java.util.Scanner;

public class ScreenMethods {

	private static Scanner teclado = new Scanner(System.in);
	
	public ScreenMethods () {
	}
	
	public static void telaInicial() {
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("                         Bem vindo ao BibliotecaScrolls64                          ");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("|----------------------------------------|----------------------------------------|");
		System.out.println("|                 Login                  |                 Cadastro               |");
		System.out.println("|----------------------------------------|----------------------------------------|");
		System.out.println("|                 Digite 1               |                 Digite 2               |");
		System.out.println("|----------------------------------------|----------------------------------------|");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("                   Sair                  |                 Digite 3                ");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		
		int selecao = teclado.nextInt();
		for(int i=0; i<2;) {
		switch(selecao) {
		
		case 1:
			ScreenMethods.telaLogin();
			i=2;
			break;
			
		case 2:
			ScreenMethods.telaCadastro();
			i=2;
			break;
			
		case 3:
			i=2;
		break;
			}
		}
	}
	public static void telaLogin(){
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("                                       Login                                       ");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("                  Nome                   | ");
		String nomeLogin = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("                  Senha                  | ");
		String senhaLogin = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		ScreenMethods.telaInicial();
	}
	
	public static void telaCadastro(){
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("                                     Cadastro                                      ");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("                  Nome                   | ");
		String nomeCadastro = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("                  E-mail                 | ");
		String emailCadastro = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("                  Senha                  | ");
		String senhaCadastro = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		ScreenMethods.telaInicial();
	}
	
	public static void telaPaginaInicial() {
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("                               BibliotecaScrolls64                                 ");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("       Jogador  |  "); //Colocar o nome do Usuário Logado
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("                Personagens              |                 Digite 1                ");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("                    Sair                 |                 Digite 2                ");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		
		int selecao = teclado.nextInt();
		for(int i=0; i<2;) {
		switch(selecao) {
		
		case 1:
			ScreenMethods.telaTodosPersonagens();
			i=2;
			break;
		case 2:
			ScreenMethods.telaInicial();
			i=2;
			break;
			}
		}
	}
	
	public static void telaTodosPersonagens() {
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("                                   Personagens                                     ");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("                 * Pandora               |                 Digite 1               ");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("                 * Pandora               |                 Digite 2               ");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("                 * Pandora               |                 Digite 3               ");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("                 * Pandora               |                 Digite 4               ");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("                   Voltar                |                 Digite 5                ");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		
		int selecao = teclado.nextInt();
		for(int i=0; i<2;) {
		switch(selecao) {
		
		case 1:
			i=2;
			break;
			
		case 2:
			i=2;
			break;
			
		case 3:
			i=2;
			break;
			
		case 4:
			i=2;
			break;
			
		case 5:
			ScreenMethods.telaPaginaInicial();
			i=2;
			break;
			}
		}
	}
	
	public static void telapersonagem() {
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("                                   " + "Nome do Personagem" +"                                     ");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		
	}
}

