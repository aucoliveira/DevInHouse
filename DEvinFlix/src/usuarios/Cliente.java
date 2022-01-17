package usuarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import Filmes.Filme;
import Filmes.Genero;
import Filmes.Conteudo;

public class Cliente extends Usuario{
	
	private Set<Conteudo> conteudoRecomendados;
	private  LocalDate ultimaRecomendacao = null;
	private ArrayList<Genero> generoAssistido = new ArrayList<Genero>();
	private Set<Filme> filmesAssistido;
	private Boolean adimplente = null;
	
	
	public Boolean getAdimplente() {
		return adimplente;
	}


	public void setAdimplente(Boolean adimplente) {
		this.adimplente = adimplente;
	}


	public Set<Filme> getFilmesAssistido() {
		return filmesAssistido;
	}


	// observação
	public void setFilmesAssistido(Filme filmes) {
		this.filmesAssistido = (Set<Filme>) filmes;
		filmes.addAll(filmes);
	}



	

	public void setGeneroAssistido(ArrayList<Genero> generoAssistido) {
		this.generoAssistido = generoAssistido;
		generoAssistido.addAll(generoAssistido);
	}


	public void setFilmesAssistido(Set<Filme> filmesAssistido) {
		this.filmesAssistido = filmesAssistido;
	}





	public ArrayList<Genero> getGeneroAssistido() {
		return generoAssistido;
	}


	public Set<Conteudo> getConteudoRecomendados() {
		return conteudoRecomendados;
	}



	public void setConteudoRecomendados(Set<Conteudo> conteudoRecomendados) {
		this.conteudoRecomendados = conteudoRecomendados;
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
}
