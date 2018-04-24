public class DequeTester{
    public static void main(String[] args){
	QQKachoo<String> test = new QQKachoo<String>();
	test.addFirst("020");
	test.addFirst("074");
	test.addLast("037");
	test.addFirst("023");
	test.addFirst("371");
	test.addFirst("112");
	test.addLast("020");
	test.addFirst("800");
	test.addLast("556");
	test.addLast("184");
	
	System.out.println(test.contains("184"));//true
	System.out.println(test.contains("800"));//true
	System.out.println(test.contains("20"));//false
	System.out.println(test.contains("412"));//false
	System.out.println(test);
	System.out.println(test.removeFirst());
	System.out.println(test);
	System.out.println(test.removeFirst());
	System.out.println(test);
	System.out.println(test.removeLast());
	System.out.println(test);
	System.out.println(test.removeFirstOccurence("020"));
	System.out.println(test);
	System.out.println(test.removeLastOccurence("430"));
	System.out.println(test);
	System.out.println(test.removeFirst());
	System.out.println(test);
	System.out.println(test.removeFirst());
	System.out.println(test);
	System.out.println(test.removeLast());
	System.out.println(test);
	System.out.println(test.removeLast());
	System.out.println(test);
	System.out.println(test.removeFirstOccurence("074"));
	System.out.println(test);
	System.out.println(test.removeLast());
	System.out.println(test);
    }
}
