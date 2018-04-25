public interface Deque<T> {
    //public boolean add(T s); //necessary?

    public void addFirst(T s);

    public void addLast(T s);

    //are the get methods necessary when we have peek?
    
    public T removeFirst();

    public T removeLast();

    public boolean removeFirstOccurrence (T s);

    public boolean removeLastOccurrence (T s);

    public T peekFront();

    public T peekLast();

    public int size();

    public boolean isEmpty();
    
  }//end interface
