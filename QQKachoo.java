//Team RWJ - Jason Kim, Raymond Wu, Eric Wong
//APCS2 pd8
//LAB#02 -- All Hands on Deque
//2018-04-18

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

    
    public String removeFirst() {
	if (size == 0)
	    return null;
	else if (size == 1) {
	    String retStr = head.getValue();
	    head = end = null;
	    size--;
	    return retStr;
	}
	else {   
	    String retStr = head.getValue();
	    head = head.getNext();
	    size--;
	    return retStr;
	}
    } // end removeFirst()
    

    public String removeLast() {
	if (size == 0)
	    return null;
	else if (size == 1) {
	    String retStr = end.getValue();
	    end = head = null;
	    size--;
	    return retStr;
	}
	else {
	    String retStr = end.getValue();
	    end = end.getPrev();
	    size--;
	    return retStr;
	}
    } // end removeLast()
    

    public boolean removeFirstOccurence (String s) {
	DLLNode temp = head; //create an alias
	if (head.getCargo().equals(s)) {
	    head = head.getNext();
	    head.setPrev(null);
	    return true;
	}
	while (temp.getNext() != null) {
	    if (temp.getNext().getCargo().equals(s)) {
		temp.setNext(temp.getNext().getNext());
		temp.getNext().setPrev(temp);
		return true;
	    }
	    temp = temp.getNext();
	}
	if (end.getCargo().equals(s)) {
	    end = end.getPrev();
	    end.setNext(null);
	    return true;
	}
	return false;
    }

    public boolean removeLastOccurence (String s) {
	DLLNode temp = end; //create an alias
	if (end.getCargo().equals(s)) {
	    end = end.getPrev();
	    end.setNext(null);
	    return true;
	}
	while (temp.getPrev() != null) {
	    if (temp.getPrev().getCargo().equals(s)) {
		temp.setPrev(temp.getPrev().getPrev());
		temp.getPrev().setNext(temp);
		return true;
	    }
	    temp = temp.getPrev();
	}
	if (head.getCargo().equals(s)) {
	    head = head.getNext();
	    head.setPrev(null);
	    return true;
	}
	return false;
    }
	
    public String toString() {
	String retStr = "";
	DLLNode temp = head;
        while (temp != null) {
	    retStr += temp.getCargo() + " ";
	    temp = temp.getNext();
	}
    }
    public static void main(String[] args) {
	QQKachoo test = new QQKachoo();

	test.addFirst("this");
	test.addFirst("is");
	test.addFirst("us");
	test.addFirst("fin");
    }
}
