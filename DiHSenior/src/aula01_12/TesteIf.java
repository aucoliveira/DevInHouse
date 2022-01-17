package aula01_12;

import java.util.Scanner;

public class TesteIf {

	public static void main(String[] args) {

		long x = 15;
		double y = x;
		
		Scanner scanner;
		scanner = new Scanner(System.in);
		int mes = scanner.nextInt();
		String nomeDoMes;
		switch (mes) {
		case 1:
			nomeDoMes = "janeiro";
			break;
		case 2:
			nomeDoMes = "fevereiro";
			break;
		case 3:
			nomeDoMes = "março";
			break;
		case 4:
			nomeDoMes = "abril";
			break;
		case 5:
			nomeDoMes = "maio";
			break;
		case 6:
			nomeDoMes = "junho";
			break;
		case 7:
			nomeDoMes = "julho";
			break;
		case 8:
			nomeDoMes = "agosto";
			break;
		case 9:
			nomeDoMes = "setembro";
			break;
		case 10:
			nomeDoMes = "outubro";
			break;
		case 11:
			nomeDoMes = "novembro";
			break;
		case 12:
			nomeDoMes = "dezembro";
			break;
		default:
			nomeDoMes = "inválido";
			break;
		}
		
		System.out.println(nomeDoMes);
		
		scanner.close();
	}
}
