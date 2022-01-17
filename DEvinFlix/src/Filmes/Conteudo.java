package Filmes;

public abstract class Conteudo {
	
	private String nome;
	private String sinopse;
	private Genero genero;
	private String link;
	private Integer curtidas;
	private Integer descurtidas;
	
	
	
	public Conteudo(String nome, String sinopse, Genero genero, String link, Integer curtidas, Integer descurtidas) {
		this.nome = nome;
		this.sinopse = sinopse;
		this.genero = genero;
		this.link = link;
		this.curtidas = curtidas;
		this.descurtidas = descurtidas;
	}
	public Integer getDescurtidas() {
		return descurtidas;
	}
	public void setDescurtidas(Integer descurtidas) {
		this.descurtidas = descurtidas;
	}
	public void setCurtidas(Integer curtidas) {
		this.curtidas = curtidas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Integer getCurtidas() {
		return curtidas;
	}

	public void setCurtida(Integer curtidas) {
		this.curtidas = curtidas +1;
	}

}
