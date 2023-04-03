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

    /** @param i
     *  @return */// Devuelve el indice del padre
    protected static int parent(int i) { return (i - 1) / 2;}

    // Reordena el vector interno para que cumpla con los heaps
    protected void buildHeap() {
        for (int i = cola.size() / 2 - 1; i >= 0; i--) {
            FiltrarAbajo(i);
        }
    }

    /** @return */// Convierte la cola de elementos a una representacion de caracteres
    @Override
    public String toString() {return cola.toString();}

    // Agrega un elemento a la cola de prioridad
    @Override
    public void add(E value) {
        cola.add(value);
        FiltrarArriba(cola.size() - 1);
    }

    // Muestra y elimina el elemento de mayor prioridad en la cola
    @Override
    public E remove() {
    	if (cola.isEmpty()) {
            return null;
        }
        E Min = cola.get(0);
        E Last = cola.remove(cola.size() - 1);
        if (!cola.isEmpty()) {
            cola.set(0, Last);
            FiltrarAbajo(0);
        }
        return Min;
    }

    // Devuelve el elemento de mayor prioridad en la cola
    @Override
    public E getFirst() {
    	if (cola.isEmpty()) {
            return null;
        }
        return cola.get(0);
    }

    /** @param root */// Filtra un elemento hacia abajo del vecto para cumplir con los heaps
    protected void FiltrarAbajo(int root) {
        E value = cola.get(root);
        while (root < cola.size() / 2) {
            int child = 2 * root + 1;
            if ((child < cola.size() - 1) && (cola.get(child).compareTo(cola.get(child + 1)) > 0)) {
                child++;
            }
            if (value.compareTo(cola.get(child)) <= 0) {
                break;
            }
            cola.set(root, cola.get(child));
            root = child;
        }
        cola.set(root, value);
    }

    /** @param leaf */// Filtra un elemento hacia arriba del vector para cumplir con los heaps
    protected void FiltrarArriba(int leaf) {
        int parent = parent(leaf);
        E value = cola.get(leaf);
        while (leaf > 0 && (value.compareTo(cola.get(parent)) < 0)) {
            cola.set(leaf, cola.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        cola.set(leaf, value);
    }

    @Override
    public int size() {return cola.size();} // Devuelve el tamaño de la cola de prioridad

    @Override
    public boolean isEmpty() {return cola.isEmpty();} // Verifica si la cola de prioridad esta vacia

 }

 