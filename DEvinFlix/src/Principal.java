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
import java.util.Random;
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
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	static ArrayList<Filme>filmesDisponiveis = new ArrayList<Filme>();
	static Recomendacao recomendacao;
	static Random gerador = new Random();
	
	static String[] nomes = {"Maria", "José","Antônio","João","Francisco","Ana","Luiz",
			"Paulo","Carlos","Manoel","Pedro","Francisca","Marcos","Raimundo",
			"Sebastião"};
	
	static String[] enderecos = {"Travessa Evidências (São Paulo, SP)","Praça dos Enfartados (Mogi das Cruzes, SP)",
			"Rua do Corno (São Luís, MA)","Travessa Maravilha Tristeza (São Paulo, SP)","Avenida Penetração Norte-Sul (Fortaleza, CE)",
			"Rua Só Nós Dois (Recife, PE)","Rua Borboletas Psicodélicas (São Paulo, SP)", "Rua Grito de Alerta (Fortaleza, CE)",
			"Travessa Nave-Mãe (São Paulo, SP)","Rua Pato Donald (Ferraz de Vasconcelos, SP)", "Rua Deus te Guarde (Recife, PE)",
			"Rua Somos Todos Iguais (São Paulo, SP)","Rua do Cascão (Campo Grande, MS)","Rua da Música Aquática (São Paulo, SP)",
			"Rua da Feia (Búzios, RJ)"};
	
	static String[] emails = {"andrezinho_bvjs@hotmail.com", "gabikate@hotmail.com","natan(algumacoisa)@hotmail.com","maxpires@zipmail.com",
			"monalisa_RBD@hotmail.com","pepino@zipmail.com","comprebaton@gmail.com"};
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Filme fil1 = new Filme("Matrix"," matrix matrix",Genero.ACAO, " TESTE", 0, 0);
		Filme fil2 = new Filme("Interestrelar","fodastico",Genero.FICCAO_CIENTIFICA, " TESTE", 0, 0);
		Filme fil3 = new Filme("Eternos"," matrix matrix",Genero.FANTASIA, " TESTE", 0, 0);
		Filme fil4 = new Filme("Não olhe para cima"," Filme de comédia",Genero.COMEDIA, " TESTE", 0, 0);
		Filme fil5 = new Filme("ALien"," Filme de ação, terror e Ficção cientifica",Genero.TERROR, " TESTE", 0, 0);
		Filme fil6 = new Filme("As Aventuras de Pi"," As aventuras de Pi",Genero.AVENTURA, " TESTE", 0, 0);
		Filme fil7 = new Filme("Gente grande"," Comédia",Genero.COMEDIA, " TESTE", 0, 0);
		Filme fil8 = new Filme("Ela é demais para mim"," Comédia Romantica",Genero.COMEDIA_ROMANTICA, " TESTE", 0, 0);
		Filme fil9 = new Filme("Fogo contra Fogo"," Filmasso de ação, só ator foda.",Genero.ACAO, " TESTE", 0, 0);
		Filme fil10 = new Filme("O senhor dos aneis"," Filme muito",Genero.FANTASIA, " TESTE", 0, 0);
		Filme fil11 = new Filme("Aladin"," As aventuras de aladin",Genero.FANTASIA, " TESTE", 0, 0);
		Filme fil12 = new Filme("Coração Valente"," Filmão",Genero.GUERRA, " TESTE", 0, 0);
		Filme fil13 = new Filme("O patriota"," ótimo filme",Genero.GUERRA, " TESTE", 0, 0);
		Filme fil14 = new Filme("Malcom X"," filmão",Genero.BIOGRAFIA, " TESTE", 0, 0);
		Filme fil15 = new Filme("Yesterday"," Filme musical",Genero.MUSICAL, " TESTE", 0, 0);
		
		filmesDisponiveis.add(fil1);
		filmesDisponiveis.add(fil2);
		filmesDisponiveis.add(fil3);
		filmesDisponiveis.add(fil4);
		filmesDisponiveis.add(fil5);
		filmesDisponiveis.add(fil6);
		filmesDisponiveis.add(fil7);
		filmesDisponiveis.add(fil8);
		filmesDisponiveis.add(fil9);
		filmesDisponiveis.add(fil10);
		filmesDisponiveis.add(fil11);
		filmesDisponiveis.add(fil12);
		filmesDisponiveis.add(fil13);
		filmesDisponiveis.add(fil14);
		filmesDisponiveis.add(fil15);
		
		
			for (int i = 0; i < 15; i++) {
				Boolean[] pagou = {true, false};
				int ano = 2021;
				int mes = gerador.nextInt(12)+1;
				int dia = gerador.nextInt(30)+1;
				
				if ((mes == 2) && (dia >28 || dia == 30)) {
					if ( dia > 28 && dia < 30) {
						dia -= 1;
					}else {
						dia -=2;
					}
				}
				
				LocalDate dataOff = LocalDate.of(ano, mes, dia);
				LocalDate[] dataTeste = {dataOff, null, LocalDate.now()};

				String nome = nomes[gerador.nextInt(15)];
				String endereco = enderecos[gerador.nextInt(15)];
				String email = emails[gerador.nextInt(7)];
				String senha = "senha";
				String dataNascimento = "12/05/1989";
				Boolean pago = pagou[gerador.nextInt(2)];
				LocalDate dataReco = dataTeste[gerador.nextInt(3)]; // gera um indice aleatório para pegar um valor para ultima Recomendação do usuario
				
				cliente =  new Cliente(nome,endereco,dataNascimento, email, senha);
				cliente.setAdimplente(pago);
				cliente.setUltimaRecomendacao(dataReco);
				
				//System.out.println(cliente.getNomeCompleto()+", "+cliente.getEndereco()+", "
				//+cliente.getDataNascimento()+", "+cliente.getEmail());
				clientes.add(cliente);
				
			}
			
			for (Cliente cliente: clientes) {
				//System.out.println(clientes);
			}
			
			
			for (int i = 0; i < 15; i++) {
				assistirFilmeTeste(clientes.get(i), filmesDisponiveis.get(gerador.nextInt(15)));
				
			}
			
			//assistirFilmeTeste(clientes.get(1), fil1);
			for (Cliente cliente: clientes) {
				//generoClienteMaisAssistido(cliente);
			}
			
			//generoClienteMaisAssistido(clientes.get(2));
			generoMaisAssistido(generoAssistido);
				
			clientes.get(gerador.nextInt(15)).recoRecebidas();
		
		/*		
		Recomendacao recomendacao = new Recomendacao(cl1, cl2, fil1, " Assiste ai. ");
		System.out.println("O cliente "+recomendacao.getClienteRecomendou().getNomeCompleto()+" Indicou para o "
		+recomendacao.getClienteRecebeu().getNomeCompleto()+recomendacao.getMensagem() +recomendacao.getDataDeRecomendacao()+cl1.getData());
		
		
		System.out.println("O filme "+fil1.getNome()+" teve "+fil1.getCurtidas()+" curtidas.");
		
		*/
		
		//cl1.setUltimaRecomendacao(LocalDate.of(2021, 12, 1));
		//cliente.setFilmeAssistido(fil3);
		//System.out.println(cliente.getFilmeAssistido().getNome());
		//System.out.println(cl1.getAdimplente());
		
		//assistirFilme(cl1, fil1);
		
		//recomendarFilmes(fil1, cl1, cl2);
		
		
		
		//cliente.imprimirFilmesAssistidos();
		scanner.close();
		
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
			//String mensagem = scanner.nextLine();
			String mensagem = "Assiste o esse filme que é da hora. ";
			System.out.println(mensagem);
			
			recomendacao = new Recomendacao(cliente,cliente2, filme, mensagem);
			cliente.setRecomendacao(recomendacao);
			cliente.setUltimaRecomendacao(LocalDate.now());
			cliente2.addRecomendacao();
			
			System.out.println("Recomendação enviada.");
		}
		System.err.println("Você não pode enviar recomendação no momento.");
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
		
	}
	
	// usado para gerar automáticamente os testes.
	static void assistirFilmeTeste(Cliente cliente, Filme filmes) {
		System.out.println();
		System.out.println("------------------------------------------------------------------");
				
			
		if (cliente.getAdimplente() == true) {
		
			System.out.println(" - "+filmes.getNome()+", "+filmes.getSinopse()+", "+filmes.getGenero());
			
			System.out.println(" - Cliente "+cliente.getNomeCompleto()+" está com o pagamento em dia.");
			cliente.setFilmeAssistido(filmes);
			System.out.println(cliente.getFilmeAssistido().getNome());
			cliente.addFilme();
			//System.out.println(cliente.getFilmesJaAssistido());
			
			int opcao = gerador.nextInt(2)+1;
			
			do {
				System.out.println("Deseja Avaliar o Filme?  1 - Sim e  2 - não");
				//opcao = scanner.nextInt();
				System.out.println(opcao);
			}while(!(opcao > 0 && opcao <3));
			
			if (opcao == 1) {
				System.out.println("Digite 1 - curtir ou 2 - para descurtir; ");
				//int opc = scanner.nextInt();
				int opc = gerador.nextInt(2)+1;
				System.out.println(opc);
				if(opc == 1) {
					filmes.setCurtidas(+1);
				}else {
					filmes.setDescurtidas(+1);
				}
			
			cliente.addGenero(filmes.getGenero());
			generoAssistido.add(filmes.getGenero());
			}
			
			int recomendar = gerador.nextInt(2)+1;
			
			System.out.println("Desenja recomendar o filme para alguem? 1 - Sim e 2 - Não.");
			System.out.println(recomendar);
			if (recomendar == 1) {
				recomendarFilmes(filmes, cliente,clientes.get(gerador.nextInt(15)));
			}
			
			//System.out.println("Volte sempre!");
			
		}else {
			System.out.println();
			System.err.println("O Cliente "+cliente.getNomeCompleto()+" encontra-se inadimplente, favor regularizar!");
		}
		
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
			System.out.println();
			System.out.println("--------------------------------------------------------");
			System.out.println("Generos Mais Assistidos. ");
			System.err.println("--------------------------------------------------------");
			
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
