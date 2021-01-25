package datastructure.queue;

public class Heap<E> {

    private static final int DEFAULT_SIZE = 10;

    private Object[] elements;
    private int size = 0;

    public Heap() {
        elements = new Object[DEFAULT_SIZE];
    }

    public Heap(Object[] objects) {
        elements = new Object[objects.length + 5];
        System.arraycopy(objects, 0, elements, 1, objects.length);
        size = objects.length;
        heapify();
    }

    private int left(int i) {
        return i << 1;
    }

    private int right(int i) {
        return (i << 1) + 1;
    }

    private int parent(int i) {
        return i >> 1;
    }

    private <E> void siftDown(int hole) {
        int child;
        Comparable<E> tmp = (Comparable<E>) elements[hole];

        for (; left(hole) <= size; hole = child) {
            child = left(hole);
            if (child != size &&
                    ((Comparable<E>) elements[right(hole)])
                            .compareTo((E) elements[child]) < 0) {
                child = right(hole);
            }

            if (tmp.compareTo((E) elements[child]) > 0) {
                elements[hole] = elements[child];
            }
            else
                break;
        }

        elements[hole] = tmp;
    }

    private void heapify() {
        for (int i = parent(size); i > 0; i--)
            siftDown(i);
    }

    public void grow() {
        Object[] newElements = new Object[elements.length >> 1];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    public void add(E e) {
        int hole = ++size;
        if (size >= elements.length)
            grow();
        for (elements[0] = e; ((Comparable<E>) e)
                .compareTo((E) elements[parent(hole)]) < 0; hole = parent(hole)) {
            elements[hole] = elements[parent(hole)];
        }
        elements[hole] = e;
    }

    public E poll() {
        if (isEmpty())
            return null;
        E res = (E) elements[1];
        elements[1] = elements[size--];
        siftDown(1);
        return res;
    }

    public E peek() {
        if (isEmpty())
            return null;
        return (E) elements[1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
