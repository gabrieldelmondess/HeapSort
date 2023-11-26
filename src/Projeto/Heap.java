package Projeto;


public class Heap {

  int[] array; // criacao do vetor
  
  public Heap(int[] array) { // construtor para inicializar o vetor de elementos
    this.array = array;
  }

  public void buildHeap() { // esse método constrói a heap de baixo para cima.
    for (int i = (array.length - 1) / 2; i >= 0; i--) { // itera do pai da última folha até a raiz.
      heapify(i); // heapfica cada nó de forma bottom-up.
    }
  }

  private void heapify(int i) { // esse método mantém a propriedade de heap para um nó específico.
    if (i >= array.length / 2) { // verifica se o nó é uma folha (sem filhos).
      return; // se for uma folha, não é necessário heapificar mais.
    }

    int leftChild = 2 * i + 1; // índice do filho esquerdo.
    int rightChild = 2 * i + 2; // índice do filho direito.

    int maxChild = leftChild; // inicializa o índice do filho maior com o filho esquerdo.
    if (rightChild < array.length && array[rightChild] > array[leftChild]) { // compara os valores dos filhos esquerdo e direito.
      maxChild = rightChild; // atualiza o índice do filho maior se o filho direito for maior.
    }

    if (array[i] < array[maxChild]) { // verifica se o pai é menor que o filho maior.
      int temp = array[i]; // troca os valores do pai e do filho maior.
      array[i] = array[maxChild];
      array[maxChild] = temp;

      heapify(maxChild); // heapifica recursivamente o filho maior para manter a propriedade de heap.
    }
  }
  
  public void printar() {
	  for(int i = 0; i < array.length; i++) {
		  System.out.println(array[i]);
	  }
  }

  public int remove() {
	  int max = array[0];
	  array[0] = array[array.length - 1];
	  array[array.length - 1] = 0;
	  heapify(0);
	  return max;
	}

}


