/** @author Alexandre Tenorio
 * 	@version 1.0a
 * 	@since release 1
 */


package shidwn.dev;

import java.util.Scanner;

public class Jogador {
	
	//inicializando stats do jogador
	int hp = 150;
	int nivel = 1;
	int ataque = 7;
	int especial = 20;
	int contagemEspecial = 5;
	private String nick;
	
	
	Scanner in = new Scanner(System.in);
	
	public Jogador(String nome) {
		this.nick = nome;
	}
	
	//ataque do jogo
	public int ataque() {
		System.out.println("Escolha seu ataque: ");
		System.out.println("(1) - Soco;");
		System.out.println("(2) - Especial;");
		int opc = in.nextInt();
		return opc;
	}
	//get and setters
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
}
