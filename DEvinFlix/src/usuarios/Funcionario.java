package usuarios;

import java.time.LocalDate;
import java.util.Scanner;

import Filmes.Filme;

public class Funcionario extends Usuario{
	
	public Funcionario(String nomeCompleto, String endereco, 
			String dataNascimento, String email, String senha) {
		super(nomeCompleto, endereco, dataNascimento, email, senha);
	}
	
	public Filme adicionarFilme(Filme filme) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Informe o nome do filme: ");
		filme.setNome(scanner.nextLine());
		scanner.close();
		
		return filme;
	}
}
