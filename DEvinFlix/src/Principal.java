import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Filmes.Conteudo;
import Filmes.Filme;
import Filmes.Genero;
import recomendacoes.Recomendacao;
import usuarios.Cliente;

public class Principal {
	
	static Cliente cliente = new Cliente();
	static Conteudo conteudo;
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Genero> generoAssistido = new ArrayList<Genero>();
	static Recomendacao recomendacao;
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Filme fil1 = new Filme("Matrix"," matrix matrix",Genero.ACAO, " TESTE", 0, 0);
		Filme fil2 = new Filme("Interestrelar","fodastico",null, " TESTE", 0, 0);
		Filme fil3 = new Filme("Eternos"," matrix matrix",null, " TESTE", 0, 0);
		
		
		Cliente cl1 = new Cliente("Augusto", "Rua 9","12/05/1989", " email", "senha");
		cl1.setAdimplente(false);
	
		Cliente cl2 = new Cliente("cesar", "Rua 9","07/05/2014", " email", "senha");
		Cliente cl3 = new Cliente("Francisco", "Rua 9","07/05/2014", " email", "senha");
		Cliente cl4 = new Cliente("joao", "Rua 9","07/05/2014", " email", "senha");
		Cliente cl5 = new Cliente("Ana", "Rua 9","07/05/2014", " email", "senha");
		Cliente cl6 = new Cliente("Raimunda", "Rua 9","07/05/2014", " email", "senha");
		Cliente cl7 = new Cliente("Vanessa", "Rua 9","07/05/2014", " email", "senha");
		Cliente cl8 = new Cliente("Sabrina", "Rua 9","07/05/2014", " email", "senha");
		Cliente cl9 = new Cliente("Alessandra", "Rua 9","07/05/2014", " email", "senha");
		Cliente cl10 = new Cliente("Carlos", "Rua 9","07/05/2014", " email", "senha");
		Cliente cl11 = new Cliente("ph", "Rua 9","07/05/2014", " email", "senha");
		Cliente cl12 = new Cliente("Chico", "Rua 9","07/05/2014", " email", "senha");
		Cliente cl13 = new Cliente("Fernando", "Rua 9","07/05/2014", " email", "senha");
		Cliente cl14 = new Cliente("Bola", "Rua 9","07/05/2014", " email", "senha");
		Cliente cl15 = new Cliente("Caio", "Rua 9","07/05/2014", " email", "senha");
		
		/*		
		Recomendacao recomendacao = new Recomendacao(cl1, cl2, fil1, " Assiste ai. ");
		System.out.println("O cliente "+recomendacao.getClienteRecomendou().getNomeCompleto()+" Indicou para o "
		+recomendacao.getClienteRecebeu().getNomeCompleto()+recomendacao.getMensagem() +recomendacao.getDataDeRecomendacao()+cl1.getData());
		
		
		System.out.println("O filme "+fil1.getNome()+" teve "+fil1.getCurtidas()+" curtidas.");
		
		*/
		
		cl1.setUltimaRecomendacao(LocalDate.of(2021, 12, 1));
		cliente.setFilmeAssistido(fil3);
		//System.out.println(cliente.getFilmeAssistido().getNome());
		//System.out.println(cl1.getAdimplente());
		
		//assistirFilme(cl1, fil1);
		
		recomendarFilmes(fil1, cl1, cl2);
		
		generoClienteMaisAssistido(cl1);
		generoMaisAssistido(generoAssistido);
		cliente.imprimirFilmesAssistidos();
		
	}
	
	static void recomendarFilmes(Filme filme, Cliente cliente, Cliente cliente2) {
		
		Boolean pode;
		
		long mese =  ChronoUnit.MONTHS.between(cliente.getUltimaRecomendacao(), LocalDate.now());
		if (mese > 0) {
			pode = true;
		}else {
			pode = false;
		}
		
		if (cliente.getUltimaRecomendacao() == null || pode )
				{
			System.out.print("Digite a mensagem para o seu amigo.");
			String mensagem = scanner.nextLine();
			recomendacao = new Recomendacao(cliente,cliente2, filme, mensagem);
			cliente.setRecomendacao(recomendacao);
			cliente.setUltimaRecomendacao(LocalDate.now());
			
			System.out.println("Recomendação enviada.");
		}
		System.out.println("Você não pode enviar recomendação no momento.");
	}
	
	static void assistirFilme(Cliente cliente, Filme filmes) {
		
			
		System.out.println(" - "+filmes.getNome()+" "+filmes.getSinopse()+" "+filmes.getGenero());
			
		if (cliente.getAdimplente() == true) {
			
			System.out.println("Cliente em dias");
			cliente.setFilmeAssistido(filmes);
			System.out.println(cliente.getFilmeAssistido().getNome());
			cliente.addFilme();
			System.out.println(cliente.getFilmesJaAssistido());
			
			int opcao = 0;
			
			do {
				System.out.println("Deseja Avaliar o Filme?  1 - Sim e  2 - não");
				opcao = scanner.nextInt();
			}while(!(opcao > 0 && opcao <3));
			
			if (opcao == 1) {
				System.out.println("Digite 1 - curtir ou 2 - para descurtir; ");
				int opc = scanner.nextInt();
				if(opc == 1) {
					filmes.setCurtidas(+1);
				}else {
					filmes.setDescurtidas(+1);
				}
			
			cliente.addGenero(filmes.getGenero());
			generoAssistido.add(filmes.getGenero());
			}
		}else {
			System.out.println("O Cliente "+cliente.getNomeCompleto()+" encontra-se inadimplente, favor regularizar!");
		}
		System.out.println("Verificando se roda");
	}
	
	static void generoClienteMaisAssistido(Cliente cliente) {
		
		Map<Genero, Integer> generoContagem = new HashMap<Genero, Integer>();
		
		for (Genero genero: cliente.getGeneroAssistido()) {
			int count = 0;
			for (Genero genero2: cliente.getGeneroAssistido()) {
				if (genero.equals(genero2)) {
					count++;
				}
			}
			generoContagem.put(genero, count);
		}
		
		System.out.println(generoContagem);		
	}
	
	static void generoMaisAssistido(ArrayList<Genero> generoAssistido) {
			
			Map<Genero, Integer> generoContagem = new HashMap<Genero, Integer>();
			
			for (Genero genero: Principal.generoAssistido) {
				int count = 0;
				for (Genero genero2: generoAssistido) {
					if (genero.equals(genero2)) {
						count++;
					}
				}
				generoContagem.put(genero, count);
			}
			
			System.out.println(generoContagem);		
		}
}
