package br.com.ifce.estrutura.arvore;

public class NoBinario {
	private String descricao;
	private NoBinario direita;
	private NoBinario esquerda;
	private NoBinario pai;
	private int camada;

	public NoBinario(String descricao) {
		this.direita = null;
		this.esquerda = null;
		this.pai = null;
		this.descricao = descricao;
		this.camada = 0;
	}

	public NoBinario(String descricao, NoBinario pai,
			NoBinario esquerda, NoBinario direita) {
		super();
		this.pai = pai;
		this.descricao = descricao;
		this.direita = direita;
		this.esquerda = esquerda;
		this.camada = pai.getCamada() + 1;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public NoBinario getDireita() {
		return direita;
	}

	public void setDireita(NoBinario direita) {
		this.direita = direita;
	}

	public NoBinario getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NoBinario esquerda) {
		this.esquerda = esquerda;
	}
	public NoBinario getPai() {
		return pai;
	}

	public void setPai(NoBinario pai) {
		this.pai = pai;
	}
	public int getCamada() {
		return camada;
	}

	public void setCamada(int camada) {
		this.camada = camada;
	}
}
