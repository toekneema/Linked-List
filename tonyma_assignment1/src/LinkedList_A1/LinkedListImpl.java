/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	int size;
	Node sentinel; //this will be the entry point to your linked list (the head)
  
  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
    sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
    size = 0;
  }
  
  //implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
    return sentinel;
  }

@Override
public boolean insert(double elt, int index) {
	Node current = sentinel;
	Node insert = new Node(elt);
	
	if (index > size || index < 0) {
		return false;
	}
	
	if (size == 0 && index == 0) {			//when inserting for the first time
		sentinel.next = insert;
		sentinel.prev = insert;
		insert.prev = sentinel;
		insert.next = sentinel;
		size++;
		return true;
	}
	
	if (index <= size && index >= 0) {   //when inserting in between two other existing nodes
		for (int i=0; i<index; i++) {
			current = current.next;
		}
		insert.prev = current;
		insert.next = current.next;
		current.next.prev = insert;
		current.next = insert;
		size++;
		return true;
	}
	return false;
}

@Override
public boolean remove(int index) {
	Node current = sentinel;
	
	if (index+1 > size || index < 0) {
		return false;
	}
	for (int i=0; i<index; i++) {
		current = current.next;
	}
	current.next.next.prev = current;
	current.next = current.next.next;
	size--;
	return true;
}

@Override
public double get(int index) {
	Node current = sentinel;
	
	if (index+1 > size || index < 0 || size == 0) {
		return Double.NaN;
	}
	for (int i=0; i<index+1; i++) {
		current = current.next;
	}
	return current.getData();
}

@Override
public int size() {
	return size;
}

@Override
public boolean isEmpty() {
	return size == 0;
}

@Override
public void clear() {
	sentinel.next = null;
	sentinel.prev = null;
	size = 0;
}

}