# RWJ Jason Kim, Raymond Wu, Eric Wong

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
  <p> Additional methods </pl>
  <ul>
  <li> boolean removeFirstOccurrence() </li>
  <li> boolean removeLastOccurrence() </li>
  <li> boolean contains() </li>
  <li> int size() </li>
  <li> Iterator iterator() </li>
  </ul>
  <p> Methods that perform similarly to already implemented methods (unecessary to implement, unless time permits) </p>
  <ul> 
  <li> void pollFirst() - similar to removeFirst()</li>
  <li> void pollLast() - similar to removeLast()</li>
  <li> getFirst() - similar to peekFirst() </li>
  <li> getLast() - similar to peekLast() </li>
  <li> add (T t) - similar to addLast(T t) </li>
  </ul><br>
  
  
<b> To-Do list </b>
  <ol> <li> Choose the most important methods from the API and add them to our interface </li>
  <li> Implement these core methods. </li>
  <ul> <li> Each team member will work on different methods to maximize efficiency </li> </ul>
  <li> Implement generic typing </li>
  </ol>
      
  
<h4> DevPlan </h4>
<p> To create a working version at first, with basic add and remove methods, creating and test each method one at a time (incremental development). Expand and add additional methods to improve efficiency of our Deque, in time remaining. </p>

