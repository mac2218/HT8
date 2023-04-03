/*
 * Daniel Machic (22118)
 * HT8
 * Esta interface contiene los métodos para la clase Vector Heap
 */

 import java.util.Vector;

 public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>{
    protected Vector<E> cola; 

    /** @param cola */// Parámetro en donde se almacenaran los valores que entraran a la cola

    // ****Constructores ****

    public VectorHeap() {cola = new Vector<>();} // Crea una cola de prioridad vacia

    /** @param coll */// crea una nueva cola de prioridad
    public VectorHeap(Vector<E> coll) {
    	cola = new Vector<>(coll);
        buildHeap();
    }

    // ****Métodos****


 }

 