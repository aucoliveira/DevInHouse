package usuarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Filmes.Filme;

public abstract class Usuario {
	
	protected String nomeCompleto;
	protected String endereco;
	protected String dataNascimento;
	protected String email;
	protected String senha;
	protected Date data;
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	//Date data = formato.parse(dataNascimento);
	
	 
	public Usuario() {}
	public Usuario(String nomeCompleto, String endereco, String dataNascimento, String email, String senha) {
		this.nomeCompleto = nomeCompleto;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
		// TODO Auto-generated constructor stub
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Date getData() throws ParseException {
		data = formato.parse(dataNascimento);
		return data;
	}
}
