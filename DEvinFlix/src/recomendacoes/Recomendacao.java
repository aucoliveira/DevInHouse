package recomendacoes;

import java.util.Date;

import Filmes.Filme;
import usuarios.Cliente;


public class Recomendacao   {
	
	private Cliente clienteRecomendou;
	private Cliente clienteRecebeu;
	private Filme filme;
	private String mensagem;
	
	public Date getDataDeRecomendacao() {
		return dataDeRecomendacao;
	}

	public void setDataDeRecomendacao(Date dataDeRecomendacao) {
		this.dataDeRecomendacao = dataDeRecomendacao;
	}

	

	private Date  dataDeRecomendacao = new Date(); 
	
	public Cliente getClienteRecomendou() {
		return clienteRecomendou;
	}

	public void setClienteRecomendou(Cliente clienteRecomendou) {
		this.clienteRecomendou = clienteRecomendou;
	}

	public Cliente getClienteRecebeu() {
		return clienteRecebeu;
	}

	public void setClienteRecebeu(Cliente clienteRecebeu) {
		this.clienteRecebeu = clienteRecebeu;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	
	
	public Recomendacao(Cliente clienteRecomendou, Cliente clienteRecebeu, Filme filme, String mensagem) {
		this.clienteRecomendou = clienteRecomendou;
		this.clienteRecebeu = clienteRecebeu;
		this.filme = filme;
		int maxLength = 20;
		this.mensagem = (mensagem.length() > maxLength) ? mensagem.substring(0, maxLength) 
				: mensagem;
	}
}
