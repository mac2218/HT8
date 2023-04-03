/*
 * Daniel Machic (22118)
 * HT8
 * Esta interface contiene los métodos para la clase Vector Heap
 */

public interface PriorityQueue<E> {

    void add(E value);  // agrega un elemento a la cola de prioridad

    E remove(); // elimina el elemento de mayor prioridad en la cola}

    E getFirst(); // devuelve el elemento de mayor prioridad en la cola

    boolean isEmpty(); // verifica si la cola de prioridad esta vacia

    int size(); // devuelve el tamaño de la cola de prioridad
    
}
