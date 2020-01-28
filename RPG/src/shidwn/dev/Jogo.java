/** @author Alexandre Tenorio
 * 	@version 1.0a
 * 	@since release 1
 */

package shidwn.dev;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Jogo {
	
	public static void main(String[] args) {
		//chamando objeto batalha;
		Batalha b = new Batalha();
		//declarando scanner
		Scanner in = new Scanner (System.in);
		
		//inicializando variaveis
		int loop = 1;
		int recorde = 0;
		
		//pegando o nome do jogador;
		System.out.println("Digite seu nome: ");
		String nome = in.nextLine();
		Jogador j = new Jogador(nome);
		
		
		//loop de tela do jogo
		while(loop == 1) {
			int pontos = b.batalha(nome);
			System.out.println("UsuÃ¡rio " + j.getNick() + " chegou a " + pontos + " pontos.");
			if (pontos > recorde) {
				recorde = pontos;
			}
			//printando recorde e continue
			System.out.println("Recorde atual: " + recorde);
			System.out.println("Fim de jogo. Deseja continuar?");
			System.out.println("(1) - Sim;");
			System.out.println("(2) - Não;");
			loop = in.nextInt();
			
			//bloco de exception para checar arquivo
			try {
				FileOutputStream arquivo = new FileOutputStream("pontos.txt");
				PrintWriter pr = new PrintWriter(arquivo);
				pr.println("Jogador " + j.getNick() + " fez " + pontos + " pontos " + "e chegou ao recorde de: " + recorde + ".");
				pr.close();
			}
			catch(Exception e) {
				System.out.println("Erro ao escrever o arquivo.");
			}
		}
		in.close();
	}

}
