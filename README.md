# RWJ Jason Kim, Raymond Wu, Eric Wong

<p> Our Deque is based on the DLLNode architecture, because it has the fastest runtime. We considered other architectures, espcially ArrayList, since it seemed easier to code, but since it requires the shifting of elements, which in which adding and removing from the front runs in O(n) time, we decided that using DLLNode instead would give us a more efficient algorithm. </p>
<p>Methods</p>
<ul> <li> addFirst </li>
  <li> addLast </li>
  <li> removeFirst </li>
  <li> removeLast </li>
  <li> peekFirst </li>
  <li> peekLast </li>
  <li> removeFirstOccurrence </li>
  <li> removeLastOccurrence </li>
  </ul>
  
<b> To-Do list </b>
  <ol> <li> Choose the most important methods from the API and add them to our interface </li>
  <li> Implement these core methods. </li>
  <ul> <li> Each team member will work on different methods to maximize efficiency </li> </ul>
  </ol>
      
  
<h4> DevPlan </h4>
<p> To create a working version at first, with basic add and remove methods, creating and test each method one at a time (incremental development). Expand and add additional methods to improve efficiency of our Deque, in time remaining. </p>

