package shidwn.dev;

import java.util.Random;

public class NPC {
	
	//inicializando variaveis de npc
	int hp = 11;
	int ataque = 2;
	int chute = 3;
	int especial = 4;
	
	//declarando ataque do npc como aleatório
	public int ataqueNPC(){
		Random gerador = new Random();
		return gerador.nextInt(3)+1;
	}
	
}
