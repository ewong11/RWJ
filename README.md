# Team RWJ -- Jason Kim, Raymond Wu, Eric Wong

<p> Our Deque is based on the DLLNode architecture, because it has the fastest runtime and best in terms of memory as well. While and implementation of ArrayList could run in the same runtime as DLLNodes, it also causes a "memory leak". We did consider ArrayList, since it seemed easier to code, but since it requires the shifting of elements, in which adding and removing from the front runs in O(n) time, we decided that using DLLNode instead would give us a more efficient algorithm. </p>
<p> Additionally, we do not have any capacity restrictions, which was a possibility in the deque API. </p>
<p>Most Crucial Methods</p>
<ul> 
  <li> void addFirst(T t) </li> //adds an item to top of deque
  <li> void addLast(T t)</li> //adds an item to bottom of deque
  <li> T removeFirst() </li> //removes the item at the top of the deque
  <li> T removeLast() </li> //removes the item at the bottom of the deque
  <li> T peekFirst() </li> //looks at the top of the deque
  <li> T peekLast() </li> //looks at the item at the bottom of the deque
  </ul>
  <p> These methods the most important methods that allow us to have purpose for deque. Without these fundamental methods, deque will not perform the way that it should. </p>
  
  <p> Additional Methods </pl>
  <ul>
  <li> boolean removeFirstOccurrence() </li> //removes the first occurence of a specified item
  <li> boolean removeLastOccurrence() </li> //removes the last occurence of a specified item
  <li> boolean contains() </li> //checks if the deque contains a certain item
  <li> int size() </li> //returns the number of elements in the deque
  <li> boolean isEmpty() </li> //checks if the deque has no elements
  </ul>
  <p> These methods are more functionality to deque, making certain functions easier to execute. While not completely necessary, they add uniqueness that allows the user to do more. </p>
  
  <p> "Last" Priority </p>
  <ul> 
  <li> void pollFirst() - similar to removeFirst()</li>
  <li> void pollLast() - similar to removeLast()</li>
  <li> getFirst() - similar to peekFirst() </li>
  <li> getLast() - similar to peekLast() </li>
  <li> add (T t) - similar to addLast(T t) </li>
  </ul>
  <p> These methods act very similary to previously made methods so we will only implement these if time permits. </p>
  <br>
  
<b> To-Do list </b>
  <ol> <li> Choose the most important methods from the API and add them to our interface </li>
  <li> Implement these core methods. </li>
  <ul> <li> Each team member will work on different methods to maximize efficiency </li> </ul>
  <li> Implement generic typing </li>
  <li> Test, Test, TEST </li>
  <li> Add more comments </li>
  <li> Add even more test conditions </li>
  </ol>
      
<h4> DevPlan </h4>
<p> To create a working version at first, with basic add and remove methods, creating and test each method one at a time (incremental development). Expand and add additional methods to improve efficiency of our Deque, in time remaining. As we develop more and more methods, we will update our main method to test and make sure the methods are all working properly. Once we test, we will add more comments to make sure that any viewer understands the process. That will also help our future-selves.</p>

<h4> Changes made: </h4>
<ul>
  <li> added block comments on top of method declarations to explain what each method does </li>
  <li> fixed compiling issue (made before fdbck received)</li>
  <li> added method explanations in README </li>
  </ul>

