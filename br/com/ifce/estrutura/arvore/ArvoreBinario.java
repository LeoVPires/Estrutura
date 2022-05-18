package br.com.ifce.estrutura.arvore;

public class ArvoreBinario {
	private NoBinario root;

	public ArvoreBinario() {
		super();
		this.root = new NoBinario("raiz");
	}

	public ArvoreBinario(NoBinario root) {
		super();
		if (root == null) {
			this.root = new NoBinario("raiz");
		} else {
			this.root = root;
		}
	}

	public void addNo(String Add, String posicao, NoBinario noPai) {
		addNo(new NoBinario(Add), posicao, noPai);
	}
	public void addNo(NoBinario noToAdd, String posicao, NoBinario noPai) {
		if (noPai == null) {
			addFilho(noToAdd, posicao, root);
		} else {
			addFilho(noToAdd, posicao, noPai);
		}
	}

	private void addFilho(NoBinario noToAdd, String posicao, NoBinario pai) {
		noToAdd.setPai(pai);
		noToAdd.setCamada(pai.getCamada() + 1) ;
		if (posicao.equals("direita")) {
			pai.setDireita(noToAdd);
		} else {
			pai.setEsquerda(noToAdd);
		}
	}
	public void imprimir() {
		print(root);
	}
	public void print(NoBinario no) {
		System.out.println(no.getDescricao());
		if (no.getEsquerda() != null) {
			print(no.getEsquerda());
		}
		if (no.getDireita() != null) {
			print(no.getDireita());
		}
	}
	
	public void buscar(String descricao) {
		if (buscaPorDescricao(root, descricao) != null) {
			System.out.println(descricao + " encontrada");
		} else {
			System.out.println(descricao + " não encontrada");
		}
	}
	private NoBinario buscaPorDescricao(NoBinario no, String descricao) {
		if(no == null) {
			return null;
		}
		if (descricao == no.getDescricao()) {
			return no;
		}
		if(buscaPorDescricao(no.getEsquerda(), descricao) != null) {
			return buscaPorDescricao(no.getEsquerda(), descricao);
		} else { 
			return buscaPorDescricao(no.getDireita(), descricao);
		}
	}
	
	public void removerNoEFilhos(String descricao) {
		if (buscaPorDescricao(root, descricao) != null) {
			removerSubindo(buscaPorDescricao(root, descricao), descricao);
			System.out.println(descricao + " removido");
		} else {
			System.out.println("No não encontrado");
		}
	}
	
	
	private void removerSubindo(NoBinario no, String descricao) {
		if (no.getDescricao() != descricao) {
			if (no.getEsquerda() != null) {
				removerSubindo(no.getEsquerda(), descricao);
			}
			if (no.getDireita() != null) {
				removerSubindo(no.getDireita(), descricao);
			} else {
				no.getPai().setEsquerda(null);
				no.getPai().setDireita(null);
			}
		} else {
			if(no.getPai().getEsquerda().getDescricao() == descricao) {
				no.getPai().setEsquerda(null);
			} else {
				no.getPai().setDireita(null);
			}
		}
	}
	
	public void removerNo(String descricao) {
		if (buscaPorDescricao(root, descricao) != null) {
			removerNoSemRemoverFilhos(buscaPorDescricao(root, descricao), descricao);
		} else {
			System.out.println("No não encontrado");
		}
	}
	private void removerNoSemRemoverFilhos(NoBinario no, String descricao) {
		if (no.getEsquerda() != null & no.getDireita() != null) {
			System.out.println("Impossivel remover " + descricao + "pois o nó possui dois filhos");
		} else {
			if(no.getPai().getEsquerda() == no) {
				no.getPai().setEsquerda(getFilhoUnico(no));
			} else {
				no.getPai().setDireita(getFilhoUnico(no));
			}
			System.out.println(descricao + " removido");
		}
	}
	public NoBinario getFilhoUnico(NoBinario pai) {
		if (pai.getEsquerda() != null) {
			return pai.getEsquerda();
		} else if (pai.getDireita() != null){
			return pai.getDireita();
		} else {
			return null;
		}
	}
}
