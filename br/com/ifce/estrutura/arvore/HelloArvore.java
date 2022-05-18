package br.com.ifce.estrutura.arvore;

public class HelloArvore {

	public static void main(String[] args) {
		
			//  						Árvore Binária
			//    	 				raiz
			//    			folha1  		 				folha2
			//   	folha3 			folha4 			folha5 			folha6
			// folha7 folha8 	folha9 folha10			folha11	folha12
		
		NoBinario raiz = new NoBinario("raiz");
		NoBinario folha1 = new NoBinario("folha1");
		NoBinario folha2 = new NoBinario("folha2");
		NoBinario folha3 = new NoBinario("folha3");
		NoBinario folha4 = new NoBinario("folha4");
		NoBinario folha5 = new NoBinario("folha5");
		NoBinario folha6 = new NoBinario("folha6");
		NoBinario folha7 = new NoBinario("folha7");
		NoBinario folha8 = new NoBinario("folha8");
		NoBinario folha9 = new NoBinario("folha9");
		NoBinario folha10 = new NoBinario("folha10");
		NoBinario folha11 = new NoBinario("folha11");
		NoBinario folha12 = new NoBinario("folha12");

		ArvoreBinario arvoreBinario = new ArvoreBinario(raiz);
		arvoreBinario.addNo(folha1, "esquerda", raiz);
		arvoreBinario.addNo(folha2, "direita", raiz);
		arvoreBinario.addNo(folha3, "esquerda", folha1);
		arvoreBinario.addNo(folha4, "direita", folha1);
		arvoreBinario.addNo(folha5, "esquerda", folha2);
		arvoreBinario.addNo(folha6, "direita", folha2);
		arvoreBinario.addNo(folha7, "esquerda", folha3);
		arvoreBinario.addNo(folha8, "direita", folha3);
		arvoreBinario.addNo(folha9, "esquerda", folha4);
		arvoreBinario.addNo(folha10, "direita", folha4);
		arvoreBinario.addNo(folha11, "direita", folha5);
		arvoreBinario.addNo(folha12, "esquerda", folha6);
		
		
		arvoreBinario.buscar("folha7");
		arvoreBinario.removerNoEFilhos("folha7");
		arvoreBinario.buscar("folha7");
		arvoreBinario.removerNo("folha4");
		arvoreBinario.buscar("folha4");
		arvoreBinario.removerNo("folha5");
		arvoreBinario.buscar("folha5");
		arvoreBinario.removerNo("folha6");
		arvoreBinario.buscar("folha6");
		arvoreBinario.imprimir();
		
	}

}
