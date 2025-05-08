package br.com.exemplo.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;


public class Brinquedo {
	
	// atributos
	
	@Id
	@Field(targetType = FieldType.OBJECT_ID)

	private String id;
	private String nome;
	private String preco;
	private String categoria;
	private String cor;
	private String imagem;
	private String descricao;
	private String detalhes;
	private String marca;
	
	
	// construtor vazio
	public Brinquedo() {
	}

	public Brinquedo(String id, String nome,String preco, String categoria, String cor, String imagem, String descricao,
			String detalhes, String marca) {
		
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.cor = cor;
		this.imagem = imagem;
		this.descricao = descricao;
		this.detalhes = detalhes;
		this.marca = marca;

	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
	


