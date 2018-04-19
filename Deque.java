public interface Deque {
    //public boolean add(String s); //necessary?

    public void addFirst(String s);

    public void addLast(String s);

    //are the get methods necessary when we have peek?
    
    public String removeFirst();

    public String removeLast();

    public boolean removeFirstOccurence (String s);

    public boolean removeLastOccurence (String s);

    public String peekFront();

    public String peekLast();

    //public int size();
    
  }//end interface
