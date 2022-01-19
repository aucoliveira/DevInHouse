package usuarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Filmes.Filme;
import Filmes.Genero;
import recomendacoes.Recomendacao;
import Filmes.Conteudo;

public class Cliente extends Usuario{
	
	private Set<Recomendacao> conteudoRecomendados = new HashSet<Recomendacao>();
	private  LocalDate ultimaRecomendacao = null;
	private ArrayList<Genero> generoAssistido = new ArrayList<Genero>();
	private Set<Filme> filmesJaAssistido = new HashSet<Filme>();
	private Boolean adimplente = null;
	private Genero genero;
	private Filme filmeAssistido;
	private Recomendacao recomendacao;
	
	public Recomendacao getRecomendacao() {
		return recomendacao;
	}
	public void setRecomendacao(Recomendacao recomendacao) {
		this.recomendacao = recomendacao;
	}
	public Cliente() {}
	public Boolean getAdimplente() {
		return adimplente;
	}


	public void setAdimplente(Boolean adimplente) {
		this.adimplente = adimplente;
	}


	public Set<Filme> getFilmesJaAssistido() {
		return filmesJaAssistido;
	}
	

	public Genero getGenero() {
		return genero;
	}
	
	public void setGenero(Genero genero) {
		this.genero = genero;
		generoAssistido.add(genero);
	}
	public Filme getFilmeAssistido() {
		return filmeAssistido;
	}
	
	public void setFilmeAssistido(Filme filmeAssistido) {
		this.filmeAssistido = filmeAssistido;
		
	}
	
	public void addFilme() {
		filmesJaAssistido.add(getFilmeAssistido());
	}
	
	public void imprimirFilmesAssistidos() {
		for (Filme filme: filmesJaAssistido) {
			System.out.println(filme.getNome());
		}
	}
	
	public void setGeneroAssistido(ArrayList<Genero> generoAssistido) {
		this.generoAssistido = generoAssistido;
		generoAssistido.addAll(generoAssistido);
	}

	public ArrayList<Genero> generoAssistido() {
		return generoAssistido;
	}
	
	public Set<Filme> filmeAssistido() {
		return (Set<Filme>) filmesJaAssistido;
	}
	
	public void setFilmesJáAssistido(Set<Filme> filmesJaAssistido) {
		this.filmesJaAssistido = filmesJaAssistido;
	}


	public ArrayList<Genero> getGeneroAssistido() {
		return generoAssistido;
	}


	
	public LocalDate getUltimaRecomendacao() {
		return ultimaRecomendacao;
	}



	public void setUltimaRecomendacao(LocalDate ultimaRecomendacao) {
		this.ultimaRecomendacao = ultimaRecomendacao;
	}



	public Cliente(String nomeCompleto, String endereco, String dataNascimento,
			 String email, String senha) {
		super(nomeCompleto, endereco, dataNascimento, email, senha);
	}
	
	

	public void curtiDescurti(Filme filme, boolean curti) {
		if (curti == true) {
			filme.setCurtida( +1);
		}
	}
	
	public Filme  filmesFavoritos(Filme filme) {
		return filme;
	}
	
	public void addGenero(Genero genero) {
		generoAssistido.add(genero);
	}
}
