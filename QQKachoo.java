//Team RWJ - Jason Kim, Raymond Wu, Eric Wong
//APCS2 pd8
//LAB#02 -- All Hands on Deque
//2018-04-18

public class QQKachoo<T> implements Deque<T> {
    //instance variables
    DLLNode<T> head, end;
    int size;

    //CONSTRUCTOR
    
    public QQKachoo() {
	head = end = null;  // CHAINED assignment (head = null, end = null)
	size = 0;           // DEQueue has no nodes upon creation
    } //end QQKachoo()
    
    //END OF CONSTRUCTOR

    
    
    //ADD AND REMOVE
    
    //adds element to front of Deque O(1)
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
    } //end addFirst()

    //adds element to end of deque O(1)
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
    } //end addLast()

    //removes the element at 'head' node (front) O(1)
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

    //removes the element at 'tail' node (end) O(1)
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

    //removes the first occurrence of an element starting from head s O(n)
    public boolean removeFirstOccurrence (T s) {
	DLLNode<T> temp = head; //create an alias
	if (head.getCargo().equals(s)) {          // if first node = target
	    removeFirst();                        // this takes care of size conds and size--
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
    } //end removeFirstOccurrence()

    //removes the last occurrence of an element s O(n)
    public boolean removeLastOccurrence (T s) {
	DLLNode<T> temp = end; //create an alias
	if (end.getCargo().equals(s)) {         // if last node = target
	    removeLast();                       // this takes care of size conds, and size--
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
	    System.out.println( "> reach 5");
	    temp = temp.getPrev();                       // update cond for while loop... traverse
	}

	// if target is at first node
	if (head.getCargo().equals(s)) {
	    head = head.getNext();   // head now at old 2nd node
	    head.setPrev(null);      // new head's prev = null
	}
	
	return false;
    } //end removeLastOccurence()

    //END OF ADD AND REMOVE


    //ACCESSORS
    
    //see what element is at the head O(1)
    public T peekFront() {
	return head.getCargo();
    } //end peekFront()

    //see what element is at the end O(1)
    public T peekLast() {
	return end.getCargo();
    } //end peekLast()

    //END OF ACCESSORS

    
    //TOSTRING
    
    //turns the deque into a readable string 
    public String toString() {
	String retStr = "";
	DLLNode<T> temp = head;
        while (temp != null) {
	    retStr += temp.getCargo() + " ";
	    temp = temp.getNext();
	}
	return retStr;
    } //end toString()

    //END OF TOSTRING


    //HELPER METHODS
    
    //returns the current size of the deque
    public int size() {
	return size;
    } //end size()

    //returns if the deque is empty
    public boolean isEmpty() {
	return size == 0;
    } //end isEmpty()

    //checks if the element s is present in Deque O(n)
    public boolean contains(T s) {
	DLLNode<T> temp = head;               // create an alias
	while ( temp.getNext() != null ) {    // this cond leaves out the last node
	    if ( temp.getCargo().equals(s) )
		return true;                  // iterate through Deque... if found ret true
	    else
		temp = temp.getNext();        // else continue to iterate
	}

	// last chance...
	if ( end.getCargo().equals(s) )       // consider last node...
	    return true;
	else
	    return false;
        
    } //end contains()

    //END OF HELPER METHODS

    public static void main(String[] args) {
	/*----------------TESTING------------------------*/

	// create an instance of QQKachoo to test its methods!
	QQKachoo<String> test = new QQKachoo<String>();

	// test toString()
	System.out.print  ( "DEQUE: " );
	System.out.println( test );            // expecting DEQUE: 
	
	// check Deque is empty...
	System.out.print  ( "empty?: " );
	System.out.println( test.isEmpty() );  // expecting true...

	// add an element to front of Deque...
	test.addFirst( "Water" );

	// test addFirst()
	System.out.print  ( "DEQUE: " );
	System.out.println( test );            // expecting DEQUE: Water

	// retest isEmpty...
	System.out.print  ( "empty?: " );
	System.out.println( test.isEmpty() );  // expecting false... 

	// add an element preceding sole existing element
	test.addFirst( "Sparkling" );
	
	System.out.print  ( "DEQUE: " );
	System.out.println( test );            // expecting DEQUE: Sparkling Water

	// add an element at end
	test.addLast( "Healthy?" );

	System.out.print  ( "DEQUE: " );
	System.out.println( test );            // expecting DEQUE: Sparkling Water Healthy?

	// add element of same cargo to Deque
	test.addLast( "Water" );

	System.out.print  ( "DEQUE: " );
	System.out.println( test );            // expecting DEQUE: Sparkling Water Healthy? Water

	// add third element of same cargo to Deque
	test.addLast( "Water" );

	System.out.print  ( "DEQUE: " );
	System.out.println( test );            // expecting DEQUE: Sparkling Water Healthy? Water Water


	// test peek methods
	System.out.print  ( "front: ");
	System.out.println( test.peekFront() );     // expecting Sparkling
	System.out.print  ( "last: ");
	System.out.println( test.peekLast() );      // expecting Water

	// test size() method
	System.out.print  ( "size: ");
	System.out.println( test.size() );          // expecting 5
	
	// remove first occurrence of "Water"
	System.out.println( "remove 1st inst of \"Water\"  ... ");
	test.removeFirstOccurrence("Water");

	System.out.print  ( "DEQUE: " );
	System.out.println( test );            // expecting DEQUE: Sparkling Healthy? Water Water

	// remove last occurrence of "Water"
	System.out.println( "remove last inst of \"Water\" ... ");
	test.removeLastOccurrence("Water");

	System.out.print  ( "DEQUE: " );
	System.out.println( test );            // expecting DEQUE: Sparkling Healthy? Water

	// test contains() ...
	System.out.print ( "contains \"Water\"? " );
	System.out.println( test.contains("Water") );  // expecting true

	// test removeLast();
	System.out.println( "remove last elem ..." );
	test.removeLast();

	System.out.print  ( "DEQUE: ");
	System.out.println( test );            // expecting DEQUE: Sparkling Healthy?

	// verify contains() works ...
	System.out.print ( "contains \"Water\"? " );
	System.out.println( test.contains("Water") );	// expecting false


	// test removeFirst()
	System.out.println( "remove first elem ...");
	test.removeFirst();

	System.out.print  ( "DEQUE: ");
	System.out.println( test );           // expecting DEQUE: Healthy?

			   

    }
}
