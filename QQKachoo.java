//Team RWJ - Jason Kim, Raymond Wu, Eric Wong
//APCS2 pd8
//LAB#02 -- All Hands on Deque
//2018-04-18

public class QQKachoo<T> implements Deque<T> {
    //instance variables
    DLLNode<T> head, end;
    int size;

    public QQKachoo() {
	head = end = null;  // CHAINED assignment (head = null, end = null)
	size = 0;           // DEQueue has no nodes upon creation
    }
    public void addFirst(T s) {
        head = new DLLNode<T>(s, null, head);  // head becomes added node
        if (size == 0) {    // if starting w/ no nodes... (size not yet updated)
	    end = head;     // b/c added node is only node... head = end
	    size++;         // update size
	}
	else {                            // if nodes existed prior to add...
	    head.getNext().setPrev(head); // added node precedes old head 
	    size++;                       // update size
	}
    }

    public void addLast(T s) {
	end = new DLLNode<T>(s, end, null);  // end becomes added node
	if (size == 0) {    // if starting w/ no nodes (size not yet updated)
	    head = end;     // b/c added node is only node... head = end
	    size++;         // update size
	}                   // ** identical as addFirst if start w/ no nodes
	else {                            // if nodes existed prior to add...
	    end.getPrev().setNext(end);   // added node succeeds old end
	    size++;                       // update size
	}
    }

    public T removeFirst() {
	if (size == 0)     // if no nodes in first place...
	    return null;   // nothing to remove!
	else if (size == 1) {             // if only one node in DEQueue...
	    T retCar = head.getCargo();   // prep for return...
	    head = end = null;            // no nodes after removal...
	    size--;                       // update size
	    return retCar;
	}
	else {                            // if >=2 nodes in DEQueue...
	    T retCar = head.getCargo();   // prep for return...
	    head = head.getNext();        // head becomes old 2nd node
	    head.setPrev(null);           // set new head's prev = null
	    size--;                       // update size
	    return retCar;
	}
    } // end removeFirst()


    public T removeLast() {
	if (size == 0)    // if no nodes in first place...
	    return null;  // nothing to remove!
	else if (size == 1) {             // if only one node
	    T retStr = end.getCargo();    // prep for return...
	    end = head = null;            // no nodes after removal...
	    size--;                       // update size
	    return retStr;
	}
	else {                            // >=2 nodes pre-existing...
	    T retStr = end.getCargo();    // prep for return...
	    end = end.getPrev();          // end becomes old penultimate node
	    end.setNext(null);            // set new end's next = null
	    size--;                       // update size
	    return retStr;
	}
    } // end removeLast()


    public boolean removeFirstOccurence (T s) {
	DLLNode<T> temp = head; //create an alias
	if (head.getCargo().equals(s)) {          // if first node = target
	    removeFirst();                        // this takes care of size conds
	    size--;
	    return true;
	}
	while (temp.getNext() != null) {                // traversing...
	    if (temp.getNext().getCargo().equals(s))  { // if found target at upcoming node...
		temp.setNext(temp.getNext().getNext()); // set curr node's next --> 2 nodes over
		if (temp.getNext() != null) {      // if 2 nodes over is NOT null...
		    temp.getNext().setPrev(temp);  // 2 nodes over's prev = curr node
		    size--;
		    return true;
		}
		else {                             // if 2 nodes over IS null...
		    end.setPrev(temp);             // end's prev = curr node (skip upcoming node)
		    size--;
		    return true;
		}
	    }
	    temp = temp.getNext();                      // update cond for while loop... traverse
	}
	

	// if target is at last node
	if (end.getCargo().equals(s)) {
	    end = end.getPrev();    // end now at old penultimate node
	    end.setNext(null);      // new end's next = null
	}
	
	return false;
    }

    public boolean removeLastOccurence (T s) {
	DLLNode<T> temp = end; //create an alias
	if (end.getCargo().equals(s)) {         // if last node = target
	    removeLast();                       // this takes care of size conds
	    size--;
	    return true;
	}
	while (temp.getPrev() != null) {                 // traversing backward...
	    if (temp.getPrev().getCargo().equals(s)) {   // if found target at upcoming node...
		temp.setPrev(temp.getPrev().getPrev());  // set curr node's prev --> 2 nodes back
		if (temp.getPrev() != null) {      // if 2 nodes over is NOT null
		    temp.getPrev().setNext(temp);  // 2 nodes back's next = curr node
		    size--;
		    return true;
		}
		else {                             // if 2 nodes back IS null...
		    head.setNext(temp);            // head's next = curr node (skip upcoming node)
		    size--;
		    return true;                   
		}
	    }
	    temp = temp.getPrev();                       // update cond for while loop... traverse
	}

	// if target is at first node
	if (head.getCargo().equals(s)) {
	    head = head.getNext();   // head now at old 2nd node
	    head.setPrev(null);      // new head's prev = null
	}
	
	return false;
    }

    public boolean contains(T s) {
	DLLNode<T> temp = head; //create an alias
	for (int i = 0; i < size; i++) {     // do the following (size) amt of times...
	    if (temp.getCargo().equals(s)) { // if curr node == target
		return true;                 // return true
	    }
	    else {                           // else, keep traversing thru DEQueue
		temp = temp.getNext();
	    }
	}                                    // finished traversing... target not found
	return false;                        // return false
    }

    public T peekFront() {
	return head.getCargo();
    }

    public T peekLast() {
	return end.getCargo();
    }

    public String toString() {
	String retStr = "";
	DLLNode<T> temp = head;
        while (temp != null) {
	    retStr += temp.getCargo() + " ";
	    temp = temp.getNext();
	}
	return retStr;
    }

    public int size() {
	return size;
    }

    public boolean isEmpty() {
	return size == 0;
    }

    public static void main(String[] args) {
	QQKachoo<String> test = new QQKachoo<String>();

	test.addFirst("four");
	test.addLast("five");
	test.addFirst("three");
	test.addFirst("two");
	test.addFirst("one");
	test.addLast("six");
	test.addFirst("first");
	test.addLast("last");
	System.out.println(test.contains("iubaubdciqwkv"));
	System.out.println(test.contains("i"));
	System.out.println(test.contains("five"));
	/*
	  System.out.println(test);
	  System.out.println(test.peekFront());
	  System.out.println(test.peekLast());
	  test.removeFirst();
	  System.out.println(test.peekFront());
	*/

	test.removeFirst();
	test.removeFirst();
	System.out.println(test);
	System.out.println(test.contains("one"));
	test.removeLast();
	test.removeLast();
	System.out.println(test);
	System.out.println(test.contains("three"));
	System.out.println(test);
	System.out.println(test.contains("six"));
	System.out.println(test);
	test.removeFirstOccurence("four");
	test.removeLastOccurence("three");
	test.removeLastOccurence("hauidhashu");
	System.out.println(test);
	/*
	  QQKachoo<String> test2 = new QQKachoo<String>();
	  test2.addFirst("HI");
	  test2.addFirst("hello");
	  test2.addFirst("HI");
	  test2.addFirst("hello");
	  test2.addFirst("HI");
	  test2.addFirst("hello");
	  test2.addFirst("HI");
	  test2.addFirst("hello");
	  System.out.println(test2);

	  test2.removeFirstOccurence("HI");
	  test2.removeLastOccurence("hello");
	  System.out.println(test2);
	*/

    }
}
