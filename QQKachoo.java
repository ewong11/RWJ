//Team RWJ - Jason Kim, Raymond Wu, Eric Wong
//APCS2 pd8
//LAB#02 -- All Hands on Deque
//2018-04-18

public class QQKachoo<T> implements Deque<T> {
    //instance variables
    DLLNode<T> head, end;
    int size;

    public QQKachoo() {
	head = end = null;
	size = 0;
    }
    public void addFirst(T s) {
        head = new DLLNode<T>(s, null, head);
        if (size == 0) {
	    end = head;
	    size++;
	}
	else {
	    head.getNext().setPrev(head);
	    size++;
	}
    }

    public void addLast(T s) {
	end = new DLLNode<T>(s, end, null);
	if (size == 0) {
	    head = end;
	    size++;
	}
	else {
	    end.getPrev().setNext(end);
	    size++;
	}
    }

    public T removeFirst() {
	if (size == 0)
	    return null;
	else if (size == 1) {
	    T retStr = head.getCargo();
	    head = end = null;
	    size--;
	    return retStr;
	}
	else {   
	    T retStr = head.getCargo();
	    head = head.getNext();
	    head.setPrev(null);
	    size--;
	    return retStr;
	}
    } // end removeFirst()
    

    public T removeLast() {
	if (size == 0)
	    return null;
	else if (size == 1) {
	    T retStr = end.getCargo();
	    end = head = null;
	    size--;
	    return retStr;
	}
	else {
	    T retStr = end.getCargo();
	    end = end.getPrev();
	    end.setNext(null);
	    size--;
	    return retStr;
	}
    } // end removeLast()
    

    public boolean removeFirstOccurence (T s) {
	DLLNode<T> temp = head; //create an alias
	if (head.getCargo().equals(s)) {
	    head = head.getNext();
	    head.setPrev(null);
	    return true;
	}
	while (temp.getNext() != null) {
	    if (temp.getNext().getCargo().equals(s)) {
		temp.setNext(temp.getNext().getNext());
		if (temp.getNext() != null) {
		    temp.getNext().setPrev(temp);
		    return true;
		}
		else {
		    head.setPrev(temp);
		    return true;
		}
	    }
	    temp = temp.getNext();
	}
	return false;
    }

    public boolean removeLastOccurence (T s) {
	DLLNode<T> temp = end; //create an alias
	if (end.getCargo().equals(s)) {
	    end = end.getPrev();
	    end.setNext(null);
	    return true;
	}
	while (temp.getPrev() != null) {
	    if (temp.getPrev().getCargo().equals(s)) {
		temp.setPrev(temp.getPrev().getPrev());
		if (temp.getPrev() != null) {
		    temp.getPrev().setNext(temp);
		    return true;
		}
		else {
		    head.setNext(temp);
		    return true;
		}
	    }
	    temp = temp.getPrev();
	}
	return false;
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
	System.out.println(test);
	System.out.println(test.peekFront());
	System.out.println(test.peekLast());
	test.removeFirst();
	System.out.println(test.peekFront());
	
	test.removeFirst();
	test.removeFirst();
	System.out.println(test);
	test.removeLast();
	test.removeLast();
	System.out.println(test);
	test.removeFirstOccurence("four");
	test.removeLastOccurence("three");
	test.removeLastOccurence("hauidhashu");
	System.out.println(test);
	
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
	
	
    }
}
