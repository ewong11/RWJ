/*
  Team LineCutters
  DequeTester to test Deque implementation
*/

public class DequeTester2 {

  public static void main(String[] args) {

    Deque<String> d = new QQKachoo<String>();
    System.out.println("d: " + d);

    System.out.println("\nTesting addFirst");
    for (int i = 0 ; i < 10; i++) {
      d.addFirst(i + "");
    }
    System.out.println("d: " + d);

    System.out.println("\nTesting addLast");
    for (int i = 9 ; i >= 0; i--) {
      d.addFirst(i + "");
    }
    System.out.println("d: " + d);

    System.out.println("\nfront: " + d.peekFront());
    System.out.println("last: " + d.peekLast());

    System.out.println("\nremoving first occurrence of \"3\"");
    d.removeFirstOccurence("3");
    System.out.println("\td: " + d);

    System.out.println("\nremoving last occurrence of \"5\"");
    d.removeLastOccurence("5");
    System.out.println("\td: " + d);

    System.out.println("\nd is empty: " + d.isEmpty());
    System.out.println("size of d: " + d.size());

    //Note that you have methods in QQKachoo that you don't
    //have in the Deque interface!!!!
    /*
    System.out.println("d contains \"9\": " d.contains("9"));
    */

  }//end main

}//end class
