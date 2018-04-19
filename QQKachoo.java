public class QQKachoo implements Deque {
    //instance variables
    DLLNode head, end;
    int size;

    public QQKachoo() {
      head = end = null;
      size = 0;
    }
    public void addFirst(String s) {
        head = new DLLNode(s, null, head);
        if (size == 0) {
          end = head;
          size++;
      }
      else {
        head.getNext().setPrev(head);
        size++;
    }
    }

    public void addLast(String s) {
      end = new DLLNode(s, end, null);
      if (size == 0) {
        head = end;
        size++;
      }
      else {
        end.getPrev().setNext(end);
        size++;
      }
    }

/*
    public String toString() {
      String retStr = "";
      for (int i =0; i < size; i++ ) {
        retStr +=
      }
    }
    */

    public static void main(String[] args) {
      QQKachoo test = new QQKachoo();

      test.addFirst("this");
      test.addFirst("is");
      test.addFirst("us");
      test.addFirst("fin");
    }
}
