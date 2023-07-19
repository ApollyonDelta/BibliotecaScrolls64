package scrolls64.executables;

import java.util.InputMismatchException;
import java.util.Scanner;

import scrolls64.entities.*;

public class ScreenMethods {

	private static Scanner teclado = new Scanner(System.in);
	private PlayerMethods pm;
	private CharacterMethods cm;
	
	public ScreenMethods(PlayerMethods pm, CharacterMethods cm) {
		this.pm = pm;
		this.cm = cm;
	}

	public PlayerMethods getPm() {
		return pm;
	}

	public void setPm(PlayerMethods pm) {
		this.pm = pm;
	}

	public CharacterMethods getCm() {
		return cm;
	}

	public void setCm(CharacterMethods cm) {
		this.cm = cm;
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
		System.out.println("|                 Login                  |                 Digite 1               |");
		System.out.println("|----------------------------------------|----------------------------------------|");
		System.out.println("|                Cadastro                |                 Digite 2               |");
		System.out.println("|----------------------------------------|----------------------------------------|");
		System.out.println("|                  Sair                  |                 Digite 3               |");
		System.out.println("|----------------------------------------|----------------------------------------|");
		System.out.println("");
		System.out.print("| Sua escolha: ");
		
		try {
			switch(teclado.nextInt()) {
			case 1: teclado.nextLine(); ScreenMethods.telaLogin(); break;
			case 2: teclado.nextLine(); ScreenMethods.telaCadastro(); break;
			case 3: break;
			default: teclado.nextLine(); telaInicial(); break;
			}			
		} catch (InputMismatchException e) {
			teclado.nextLine();
			telaInicial();
		}
	}
	
	public static void telaLogin(){
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("                                       Login                                       ");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Nome: "); String username = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Senha: "); String senha = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		//Keep going
	}
	
	public static void telaCadastro(){
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("                                     Cadastro                                      ");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Nome: "); String nomeCadastro = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Email: "); String emailCadastro = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Senha: "); String senhaCadastro = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		//Keep going
	}
	
	public static void telaPaginaInicial(Player usuarioLogado) {
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("                               BibliotecaScrolls64                                 ");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("| Seja bem-vindo(a), " + usuarioLogado.getUsername() +"!");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|               Personagens              |                 Digite 1               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|              Area do Usuario           |                 Digite 2               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|                   Sair                 |                 Digite 3               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.print("| Sua escolha: ");
		
		try {
			switch(teclado.nextInt()) {
			case 1: teclado.nextLine(); ScreenMethods.telaPersonagens(); break;
			case 2: teclado.nextLine(); ScreenMethods.telaAreaUsuario(usuarioLogado); break;
			case 3: break;
			default: teclado.nextLine(); telaInicial(); break;
			}			
		} catch (InputMismatchException e) {
			teclado.nextLine();
			telaInicial();
		}
	}
	
	private static void telaPersonagens() {
		
	}
	
	private static void telaAreaUsuario(Player usuarioLogado) {
		
	}
}