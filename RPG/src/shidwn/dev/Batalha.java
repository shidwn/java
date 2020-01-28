/** @author Alexandre Tenorio
 * 	@version 1.0a
 * 	@since release 1
 */


package shidwn.dev;

import java.util.Scanner;

public class Batalha {
	Scanner in = new Scanner(System.in);
	
	//função de batalha
	int batalha(String nome) {
		Jogador j = new Jogador(nome);
		NPC n = new NPC();
		int i = 1;
		
		//enquanto o hp do jogador for maior do que zero
		while(j.hp > 0) {
			n.hp = 10 + i;
			
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*");
			System.out.println("Inimigo: " + i);
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*\n");
			
			while(j.hp > 0 && n.hp > 0) {
				System.out.println("========================");
				System.out.println("- HP " + j.getNick() + ": " + j.hp);
				System.out.println("- NÃ­vel do " + j.getNick() + ": " + j.nivel);
				System.out.println("- HP Computador: " + n.hp);
				System.out.println("* Contagem de Especiais: " + j.contagemEspecial);
				System.out.println("========================");
				
				//Escolha de ataques
				System.out.println("Escolha seu ataque: ");
				System.out.println("(1) - Soco;");
				System.out.println("(2) - Especial;");
				int ataque = in.nextInt();
				switch(ataque) {
					case 1:
						System.out.println("Usuário aplicou um soco.");
						//reduzindo hp do npc
						n.hp -= j.ataque;
						break;
					case 2:
						if(j.contagemEspecial > 0) {
						System.out.println("Usuário aplicou um ataque especial.");
						//reduzindo hp do npc
						n.hp -= j.especial;
						//reduzindo contagem de especial
						j.contagemEspecial--;
						}
						else {
							//caso não possua ataque especial
							System.out.println("Opção inválida, sem ataque especial suficiente.");
						}
						
						break;
					default:
						System.out.println("Opção inválida.");
				}
				if(n.hp > 0) {
					ataque = n.ataqueNPC();
					switch(ataque) {
						case 1:
							System.out.println("Computador aplicou um soco.");
							//reduzindo hp do jogador e aumentando o nível da máquina a cada loop
							j.hp -= n.ataque + (int)(i/10);
							break;
						case 2:
							System.out.println("Computador aplicou um chute.");
							j.hp -= n.chute + (int)(i/10);
							break;
						case 3:
							System.out.println("Computador aplicou um ataque especial.");
							j.hp -= n.especial + (int)(i/20);
							break;
						}
					}
						else {
							System.out.println("Inimigo derrotado.\n");
				}
			}
			if(j.hp > 0) {
				j.hp += 5;
				if(j.hp > 150) {
					j.hp = 150;
				}
				if (i % 10 == 0) {
					//subindo de nível o jogador a cada 10 monstros.
					System.out.println("\n");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					System.out.println("ParabÃ©ns, seu personagem subiu de nÃ­vel!");
					System.out.println("VocÃª acaba de recuperar 1 de especial.");
					System.out.println("VocÃª acaba de ganhar 5 de dano de ataque.");
					System.out.println("VocÃª acaba de ganhar 10 dano de especial.");
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
					j.especial += 10;
					j.ataque += 5;
					j.nivel += 1;
					n.ataque += 2;
					n.chute += 3;
					n.especial += 4;
					j.contagemEspecial++;
					if(j.contagemEspecial > 5) {
						j.contagemEspecial = 5;
					}
				}
			}
			i++;
		}
		return i;
	}
}
