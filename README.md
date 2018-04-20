# Team RWJ -- Jason Kim, Raymond Wu, Eric Wong

<p> Our Deque is based on the DLLNode architecture, because it has the fastest runtime. We considered other architectures, espcially ArrayList, since it seemed easier to code, but since it requires the shifting of elements, which in which adding and removing from the front runs in O(n) time, we decided that using DLLNode instead would give us a more efficient algorithm. </p>
<p> Additionally, we do not have any capacity restrictions, which was a possibility in the deque API. </p>
<p>Most Crucial Methods</p>
<ul> 
  <li> void addFirst(T t) </li>
  <li> void addLast(T t)</li>
  <li> T removeFirst() </li>
  <li> T removeLast() </li>
  <li> T peekFirst() </li>
  <li> T peekLast() </li>
  </ul>
  <p> These methods the most important methods that allow us to have purpose for deque. Without these fundamental methods, deque will not perform the way that it should. </p>
  
  <p> Additional Methods </pl>
  <ul>
  <li> boolean removeFirstOccurrence() </li>
  <li> boolean removeLastOccurrence() </li>
  <li> boolean contains() </li>
  <li> int size() </li>
  <li> boolean isEmpty() </li>
  </ul>
  <p> These methods are more functionality to deque, making certain functions easier to execute. While not completely necessary, they add uniqueness that allows the user to do more. </p>
  
  <p> "Last Priority </p>
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
<p> To create a working version at first, with basic add and remove methods, creating and test each method one at a time (incremental development). Expand and add additional methods to improve efficiency of our Deque, in time remaining. As we develop more and more methods, we will upadte our main method to test and make sure the methods are all working properly. Once we test, we will add more comments to make sure that any viewer understands the process. That will also help our future-selves.</p>

