/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linked list points opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/


public class RQueue<T> implements Queue<T> {

    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() 
    {
	_front = _end = new LLNode<T>(null,null);
	_size = 0;
    }//end default constructor


    public void enqueue( T enQVal ) 
    {
	LLNode<T> newNode = new LLNode<T>(enQVal,null);

	if( isEmpty() ) 
	    _front = _end = newNode;
	
	else {
	    _end.setNext(newNode);
	    _end = _end.getNext();
	}
	_size++;
    }//end enqueue()


    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() 
    {
	T retVal = _front.getValue();
	_front = _front.getNext();

	if( _front == null ) //just moved past last node
	    _end = null; //update _end to reflect emptiness

	_size--;

	if( _size > 1 ) sample();
	
	return retVal;
    }//end dequeue()


    public T peekFront() 
    {
	return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * Algo:
     * ...
     * move _front to random location
     * UTILIZE ENQUEUE AND DEQUEUE
     ******************************************/
    public void sample() {
	int rand = (int)(Math.random() * _size);
	for( int i = 0; i < rand; i++ ) 
	    enqueue(dequeue());
    }
    
    /*public void sample () 
    {
	int rand = (int)(Math.random() * _size);
	LLNode<T> tmp = _front;
	for( int i = 0; i < rand; i++ ) 
	    tmp = tmp.getNext(); // move tmp a random amount of spaces over

	_end.setNext(_front); //don't lose front -- still circular
	_front = tmp.getNext();
	_end = tmp;
	tmp.setNext(null);
    }//end sample() 
    */
    public boolean isEmpty() 
    {
	return _size == 0;
    } //O(?) 


    // print each node, separated by spaces
    public String toString() 
    {
	String retStr = "";
	LLNode<T> tmp = _front;
	while( tmp != null ) {
	    retStr += tmp.getValue() + " ";
	    tmp = tmp.getNext();
	}
	return retStr;
    }//end toString()



    //main method for testing
    public static void main( String[] args ) {



	Queue<String> PirateQueue = new RQueue<String>();

	System.out.println("\nnow enqueuing..."); 
	PirateQueue.enqueue("Dread");
	PirateQueue.enqueue("Pirate");
	PirateQueue.enqueue("Robert");
	PirateQueue.enqueue("Blackbeard");
	PirateQueue.enqueue("Peter");
	PirateQueue.enqueue("Stuyvesant");

	System.out.println("\nnow testing toString()..."); 
	System.out.println( PirateQueue ); //for testing toString()...

	System.out.println("\nnow dequeuing..."); 
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  System.out.println("\nnow dequeuing fr empty queue..."); 
	  System.out.println( PirateQueue.dequeue() );

	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main

}//end class RQueue
