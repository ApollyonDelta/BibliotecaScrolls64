package scrolls64.executables;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import scrolls64.entities.CharStatus;
import scrolls64.entities.Player;
import scrolls64.entities.Player_Character;

public class ScreenMethods {

	private static Scanner teclado = new Scanner(System.in);
	private static PlayerMethods pm;
	private static CharacterMethods cm;
	private static Player userLogado;
	
	public ScreenMethods(PlayerMethods pm, CharacterMethods cm) {
		ScreenMethods.pm = pm;
		ScreenMethods.cm = cm;
	}

	public static PlayerMethods getPm() {
		return pm;
	}

	public static CharacterMethods getCm() {
		return cm;
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
			case 1: teclado.nextLine(); ScreenMethods.telaOptionsPersona(); break;
			case 2: teclado.nextLine(); ScreenMethods.telaAreaUsuario(); break;
			case 3: break;
			default: teclado.nextLine(); telaInicial(); break;
			}			
		} catch (InputMismatchException e) {
			teclado.nextLine();
			telaPaginaInicial();
		}
	}
	
	public static void telaOptionsPersona() {
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|             Criar Personagem           |                 Digite 1               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|             Seus Personagens           |                 Digite 2               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|                  Voltar                |                 Digite 3               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.print("| Sua escolha: ");
		
		try {
			switch(teclado.nextInt()) {
			case 1: teclado.nextLine(); ScreenMethods.telaCriarPersonagem(); break;
			case 2: teclado.nextLine(); ScreenMethods.telaPersonagens(); break;
			case 3: teclado.nextLine(); telaPaginaInicial(); break;
			default: teclado.nextLine(); telaOptionsPersona(); break;
			}			
		} catch (InputMismatchException e) {
			teclado.nextLine();
			telaOptionsPersona();
		}
	}
	
	public static void telaCriarPersonagem() {
		try {
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|                                                                                 |");
		System.out.println("|                           Criando um Personagem                                 |");
		System.out.println("|                                                                                 |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println();
		System.out.print("| Insira o nome do seu personagem: "); String nomeChar = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Insira a raça do seu personagem: "); String raceChar = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Insira a classe do seu personagem: "); String classeChar = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Descreva o conceito do seu personagem: "); String conceitoChar = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Insira o level do seu personagem: "); int levelChar = teclado.nextInt(); teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.print("| Insira o sistema onde joga com ele: "); String sistemaChar = teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		
		cm.salvarPersonagem(new Player_Character(nomeChar, raceChar, classeChar, conceitoChar, levelChar, CharStatus.ATIVO, sistemaChar, userLogado));
		alterarStatus(cm.encontrarPorNome(nomeChar));
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|                                                                                 |");
		System.out.println("|                           Personagem Criado!                                    |");
		System.out.println("|                                                                                 |");
		System.out.println("#---------------------------------------------------------------------------------#");
		telaPersonagens();
		
	} catch (InputMismatchException e) {
		teclado.nextLine();
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|                                                                                 |");
		System.out.println("|                   Dados Informados de Maneira Incorreta!                        |");
		System.out.println("|                                                                                 |");
		System.out.println("#---------------------------------------------------------------------------------#");
		telaCriarPersonagem();
	}
		
	}
	
	public static void telaPersonagens() {
		if (cm.listarPersonagensDoJogador(userLogado).isEmpty()) {
			System.out.println("");
			System.out.println("#---------------------------------------------------------------------------------#");
			System.out.println("|                                                                                 |");
			System.out.println("|                    Você não tem personagens cadastrados!                        |");
			System.out.println("|                                                                                 |");
			System.out.println("#---------------------------------------------------------------------------------#");
			telaOptionsPersona();
		}
		List<String> listaDeNomes = new ArrayList<>();
		for (Player_Character persona : cm.listarPersonagensDoJogador(userLogado)) {
			listaDeNomes.add(persona.getCharName());
			celulaPersonagem(persona);
		}
		System.out.println();
		System.out.print("| Escreva o nome completo do personagem que deseja acessar: "); String nomePersona = teclado.nextLine();
		
		try {
			if (!listaDeNomes.contains(nomePersona)) {
				System.out.println("");
				System.out.println("#---------------------------------------------------------------------------------#");
				System.out.println("|                                                                                 |");
				System.out.println("|                               Opção Inválida!                                   |");
				System.out.println("|                                                                                 |");
				System.out.println("#---------------------------------------------------------------------------------#");
				telaPersonagens();
			}
			areaDoPersonagem(cm.encontrarPorNome(nomePersona));
		} catch (InputMismatchException e) {
			teclado.nextLine();
			telaPersonagens();
		}
		
	}
	
	public static void areaDoPersonagem(Player_Character persona) {
		celulaPersonagem(persona);
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|              Aumentar Level            |                 Digite 1               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|              Alterar Status            |                 Digite 2               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|            Excluir Personagem          |                 Digite 3               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|                  Voltar                |                 Digite 4               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("");
		System.out.print("| Sua escolha: ");
		
		try {
			switch(teclado.nextInt()) {
			case 1: teclado.nextLine(); cm.aumentarLevel(persona); ScreenMethods.areaDoPersonagem(persona); break;
			case 2: teclado.nextLine(); ScreenMethods.alterarStatus(persona); areaDoPersonagem(persona); break;
			case 3: teclado.nextLine(); ScreenMethods.excluirPersonagem(persona); break;
			case 4: teclado.nextLine(); telaOptionsPersona(); break;
			default: teclado.nextLine(); areaDoPersonagem(persona); break;
			}			
		} catch (InputMismatchException e) {
			teclado.nextLine();
			areaDoPersonagem(persona);
		}
	}
	
	public static void alterarStatus(Player_Character persona) {
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|                        Qual O Status Do Seu Personagem?                         |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|     Ativo - Vivo e Campanha Aberta     |                 Digite 1               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|   Inativo - Vivo e Campanha Encerrada  |                 Digite 2               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|    Hiato - Vivo e Campanha Em Hiato    |                 Digite 3               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|                  Morto                 |                 Digite 4               |");
		System.out.println("#---------------------------------------------------------------------------------#");
		try {
			switch(teclado.nextInt()) {
			case 1: teclado.nextLine(); cm.mudarStatus(persona, CharStatus.ATIVO); break;
			case 2: teclado.nextLine(); cm.mudarStatus(persona, CharStatus.INATIVO); break;
			case 3: teclado.nextLine(); cm.mudarStatus(persona, CharStatus.HIATO); break;
			case 4: teclado.nextLine(); cm.mudarStatus(persona, CharStatus.MORTO); break;
			default: alterarStatus(persona); break;
			}
		} catch (InputMismatchException e) {
			teclado.nextLine();
			alterarStatus(persona);
		}
	}
	
	public static void excluirPersonagem(Player_Character persona) {
		System.out.println("");
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("|                        Deletando Seu Personagem                                 |");
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
			excluirPersonagem(persona);
		}
		if (!pm.confirmarSenha(userLogado, senhaDeleteOne)) {
			System.out.println("#---------------------------------------------------------------------------------#");
			System.out.println("|                     Senha Incorreta! Tente Novamente                            |");
			System.out.println("#---------------------------------------------------------------------------------#");
			excluirPersonagem(persona);
		}
		cm.excluirPersonagem(persona);
		System.out.println("#---------------------------------------------------------------------------------#");
		System.out.println("| Personagem deletado com sucesso! Adeus, " + persona.getCharName() + "!");
		System.out.println("#---------------------------------------------------------------------------------#");
		telaOptionsPersona();
	}
	
	public static void celulaPersonagem(Player_Character persona) {
		System.out.println();
		System.out.println("@======================================================@");
		System.out.println("| " + persona.getCharName());;
		System.out.println("@======================================================@");
		System.out.println("| " + persona.getCharRace() + " " + persona.getCharClass());
		System.out.println("@======================================================@");
		System.out.println("| " + persona.getCharConcept());
		System.out.println("@======================================================@");
		System.out.println();
		System.out.println("#---------------------------------------------------#");
		System.out.println("| Level " + persona.getCharLevel() + " | " + persona.getRPGSystem() + " | " + persona.getCharStatus().toString());
		System.out.println("| Jogador: " + persona.getInterpreter().getUsername() + " | Criado em: " + persona.getCreatedAt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println("#---------------------------------------------------#");
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