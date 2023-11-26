package Projeto;

import java.util.Arrays;

public class HeapSort {

  public static void main(String[] args) {
    int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    // Constrói uma heap com os elementos do vetor
    Heap heap = new Heap(arr);

    // Ordena o vetor removendo os elementos da heap
    for (int i = 0; i < arr.length; i++) {
      arr[i] = heap.remove();
    }

    // Imprime o vetor ordenado
    System.out.println(Arrays.toString(arr));
  }
}

class HeapS{

  private int[] array; // Vetor que armazena os elementos da heap

  public HeapS(int[] array) {
    this.array = array;
  }

  // Constrói a heap de baixo para cima
  public void buildHeap() {
    for (int i = (array.length - 1) / 2; i >= 0; i--) {
      heapify(i);
    }
  }

  // Remove o elemento máximo da heap
  public int remove() {
    int max = array[0];
    array[0] = array[array.length - 1];
    array[array.length - 1] = 0;
    heapify(0);
    return max;
  }

  // Mantem a propriedade de heap para um nó específico
  private void heapify(int i) {
    if (i >= array.length / 2) {
      return;
    }

    int leftChild = 2 * i + 1;
    int rightChild = 2 * i + 2;

    int maxChild = leftChild;
    if (rightChild < array.length && array[rightChild] > array[leftChild]) {
      maxChild = rightChild;
    }

    if (array[i] < array[maxChild]) {
      int temp = array[i];
      array[i] = array[maxChild];
      array[maxChild] = temp;

      heapify(maxChild);
    }
  }
}

