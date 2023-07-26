package scrolls64.executables;

import java.util.InputMismatchException;
import java.util.Scanner;

import scrolls64.entities.*;

public class ScreenMethods {

	private static Scanner teclado = new Scanner(System.in);
	private static PlayerMethods pm;
	private static CharacterMethods cm;
	private static Player userLogado;
	
	public ScreenMethods(PlayerMethods pm, CharacterMethods cm) {
		this.pm = pm;
		this.cm = cm;
	}

	public static PlayerMethods getPm() {
		return pm;
	}

	public void setPm(PlayerMethods pm) {
		this.pm = pm;
	}

	public static CharacterMethods getCm() {
		return cm;
	}

	public void setCm(CharacterMethods cm) {
		this.cm = cm;
	}

	public static void telaInicial() {
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|                                                                                 |");
		System.out.println("|                        Bem vindo ao BibliotecaScrolls64                         |");
		System.out.println("|                                                                                 |");
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
		System.out.println("|                                      Login                                      |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Nome: "); String username = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Senha: "); String senha = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		if(!getPm().tentativaLogin(username, senha)) {
			System.out.println("#---------------------------------------------------------------------------------#");
			System.out.println("|                    Nome de Usuário ou Senha Incorretos                          |");
			System.out.println("#---------------------------------------------------------------------------------#");
			telaLogin();
		}
		userLogado = pm.logarUsuario(username, senha);
		telaPaginaInicial();
	}
	
	public static void telaCadastro(){
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|                                    Cadastro                                     |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Nome: "); String nomeCadastro = teclado.nextLine();
		if (!pm.verificarUsername(nomeCadastro)) {
			System.out.println("#---------------------------------------------------------------------------------#");
			System.out.println("|                        Nome de Usuário Já Existe                                |");
			System.out.println("#---------------------------------------------------------------------------------#");
			telaCadastro();
		}
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Email: "); String emailCadastro = teclado.nextLine();
		if (!pm.verificarEmail(emailCadastro)) {
			System.out.println("#---------------------------------------------------------------------------------#");
			System.out.println("|                    Este Email Pertence À Uma Outra Conta                        |");
			System.out.println("#---------------------------------------------------------------------------------#");
			telaCadastro();
		}
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Senha: "); String senhaCadastro = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		pm.salvarPlayer(new Player(nomeCadastro, emailCadastro, senhaCadastro));
		telaLogin();
	}
	
	public static void telaPaginaInicial() {
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|                                                                                 |");
		System.out.println("|                        Bem vindo ao BibliotecaScrolls64                         |");
		System.out.println("|                                                                                 |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("| Seja bem-vindo(a), " + userLogado.getUsername() +"!");
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
			case 2: teclado.nextLine(); ScreenMethods.telaAreaUsuario(); break;
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
	
	public static void telaAlterarSenha() {
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|                             Alterando A Sua Senha                               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Insira sua senha atual: "); String senhaAtual = teclado.nextLine();
		if (!pm.confirmarSenha(userLogado, senhaAtual)) {
			System.out.println("#---------------------------------------------------------------------------------#");
			System.out.println("|                     Senha Incorreta! Tente Novamente                            |");
			System.out.println("#---------------------------------------------------------------------------------#");
			telaAlterarSenha();
		}
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Insira sua nova senha: "); String novaSenhaFirst = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Confirme sua nova senha: "); String novaSenhaSecond = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println();
		if (!novaSenhaFirst.equals(novaSenhaSecond)) {
			System.out.println("#---------------------------------------------------------------------------------#");
			System.out.println("|                        As Senhas São Diferentes!                                |");
			System.out.println("#---------------------------------------------------------------------------------#");
			telaAlterarSenha();
		}
		userLogado.setPassword(novaSenhaFirst);
		pm.salvarPlayer(userLogado);
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|                          Senha Alterada Com Sucesso                             |");
		System.out.println("#---------------------------------------------------------------------------------#");
		telaLogin();
	}
	
	public static void telaDeletarConta() {
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|                            Deletando Sua Conta                                  |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Insira sua senha: "); String senhaDeleteOne = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Confirme sua senha: "); String senhaDeleteTwo = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println();
		if (!senhaDeleteOne.equals(senhaDeleteTwo)) {
			System.out.println("#---------------------------------------------------------------------------------#");
			System.out.println("|                        As Senhas São Diferentes!                                |");
			System.out.println("#---------------------------------------------------------------------------------#");
			telaDeletarConta();
		}
		if (!pm.confirmarSenha(userLogado, senhaDeleteOne)) {
			System.out.println("#---------------------------------------------------------------------------------#");
			System.out.println("|                     Senha Incorreta! Tente Novamente                            |");
			System.out.println("#---------------------------------------------------------------------------------#");
			telaDeletarConta();
		}
		pm.deletarConta(userLogado);
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|                           Sua Conta Foi Deletada                                |");
		System.out.println("#---------------------------------------------------------------------------------#");
		telaLogin();
	}
	
	private static void telaAreaUsuario() {
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("| Olá, " + userLogado.getUsername() +"!");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|               Alterar Senha            |                 Digite 1               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|               Deletar Conta            |                 Digite 2               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|                  Voltar                |                 Digite 3               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.print("| Sua escolha: ");
		
		try {
			switch(teclado.nextInt()) {
			case 1: teclado.nextLine(); ScreenMethods.telaAlterarSenha(); break;
			case 2: teclado.nextLine(); ScreenMethods.telaDeletarConta(); break;
			case 3: teclado.nextLine(); ScreenMethods.telaPaginaInicial(); break;
			default: teclado.nextLine(); telaAreaUsuario(); break;
			}			
		} catch (InputMismatchException e) {
			teclado.nextLine();
			telaAreaUsuario();
		}
	}
}