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
	
	Scanner scanner = new Scanner(System.in);
	public ArrayList<Genero> generoAssistido;
	
	public static void main(String[] args) throws ParseException {
		
		// TODO Auto-generated method stub
		Filme fil1 = new Filme("Matrix"," matrix matrix",null, " TESTE", 0, 0);
		Filme fil2 = new Filme("Interestrelar","fodastico",null, " TESTE", 0, 0);
		Filme fil3 = new Filme(""," matrix matrix",null, " TESTE", 0, 0);
		
		
		Cliente cl1 = new Cliente("Augusto", "Rua 9","12/05/1989", " email", "senha");
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
		assistirFilme(cl1, fil1);
		
		
		
	}
	
	public boolean recomendarFilmes(Conteudo conteudo, Cliente cliente) {
		
		if (cliente.getUltimaRecomendacao() == null || 
				ChronoUnit.MONTHS.between(cliente.getUltimaRecomendacao(), LocalDate.now())) {
			
			cliente.getConteudoRecomendados().add(conteudo);
			cliente.setUltimaRecomendacao(LocalDate.now());
			
			return true;
		}
		return false;
	}
	
	public  void assistirFilme(Cliente cliente, Filme filmes ) {
		
			
		System.out.println(" - "+filmes.getNome()+" "+filmes.getSinopse()+" "+filmes.getGenero());
			
		if (cliente.getAdimplente().equals(true)) {
			cliente.setFilmesAssistido(filmes);
			int opcao = 0;
			
			do {
				System.out.println("Deseja Avaliar o Filme?  1 - Sim e  2 - não");
				opcao = scanner.nextInt();
			}while(opcao > 0 && opcao <3);
			
			if (opcao == 1) {
				System.out.println("Digite 1 - curtir ou 2 - para descurtir; ");
				int opc = scanner.nextInt();
				if(opc ==1) {
					filmes.setCurtidas(+1);
				}else {
					filmes.setDescurtidas(+1);
				}
			
			cliente.setGeneroAssistido(filmes.getGenero());
			generoAssistido.add(filmes.getGenero());
			}
		}else {
			System.out.println("O Cliente "+cliente.getNomeCompleto()+" encontra-se inadimplente, favor regularizar!");
		}
	}
	
	public void generoClienteMaisAssistido(Cliente cliente) {
		
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
	
	public void generoMaisAssistido() {
			
			Map<Genero, Integer> generoContagem = new HashMap<Genero, Integer>();
			
			for (Genero genero: generoAssistido) {
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
