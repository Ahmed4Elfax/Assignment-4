package eg.edu.alexu.csd.datastructure.linkedList;
/**
*
* @author Ahmed Elfax
*/
 class DNode {
	private DNode next, prev;
	private Object element;
	public DNode(Object  e, DNode p, DNode n) {
		element = e;
		prev = p;
		next = n;
		    }
	/** Returns the element of this node */
	public Object getElement() {return element;}
	/** Returns the previous node of this node */
	public DNode getPrev() {return prev;}
	/** Returns the next node of this node */
	public DNode getNext() {return next;}
	/** Sets the element of this node */
	public void setElement(Object  newElem) {element = newElem;}
	/** Sets the previous node of this node */
	public void setPrev(DNode newPrev) {prev = newPrev;}
	/** Sets the next node of this node */
	public void setNext(DNode newNext) {next = newNext;}
}

public class DoublyLinkedList implements ILinkedList {
	private long size;
	public DNode header,tailer;
	/** Constructor that creates an empty list */
	public DoublyLinkedList() {
		 size = 0;
		 header = new DNode(null, null, null); // create header
	     tailer = new DNode(null, header, null); // create trailer
		header.setNext(tailer); // make header and trailer point to each other
	}
	@Override
	public void add(int index, Object element) {
		DNode a = header;
		if (index < 0 || index > size) {
			throw new RuntimeException();
		}
		else {
		for(int i=0 ; i<=index;i++) {a=a.getNext(); }
		DNode b=a.getPrev();
		DNode c = new DNode(element , b, a);
		a.setPrev(c);
		b.setNext(c);
		size++;
	}}

	@Override
	public void add(Object element) {
		DNode a =tailer.getPrev();
		DNode c = new DNode(element , a, tailer);
		tailer.setPrev(c);
		a.setNext(c);
		size++;	
	}

	@Override
	public Object get(int index) {
		DNode a = header;
		if (index < 0 || index > size) {
			throw new RuntimeException();}
		else {
		for(int i=0;i<=index;i++) {a=a.getNext(); }
		return a.getElement();
	}}

	@Override
	public void set(int index, Object element) {
		DNode a = header;
		if (index < 0 || index > size) {
			throw new RuntimeException();}
		else {
		for(int i=0;i<=index;i++) {a=a.getNext(); }	
		a.setElement(element);
	}}

	@Override
	public void clear() {
		tailer.setPrev(header);
		header.setNext(tailer);
		size=0;
	}

	@Override
	public boolean isEmpty() {
		if((header.getNext()==tailer)&&(tailer.getPrev()==header)) {
			return true;
		}else
		return false;
	}

	@Override
	public void remove(int index) {
		DNode a = header;
		if (index < 0 || index > size) {
			throw new RuntimeException();
		}
		else {
		for(int i=0 ; i<=index;i++) {a=a.getNext(); }
		DNode n=a.getNext();
		DNode p=a.getPrev();
		p.setNext(n);
		n.setPrev(p);
		size--;
	}
		
	}

	@Override
	public int size() {
		return (int)size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		if (fromIndex < 0 || fromIndex >= size) {
				throw new RuntimeException();
			}
		else if (toIndex < 0 || toIndex >= size) {
				throw new RuntimeException();
			}
		else if (fromIndex > toIndex) {
				throw new RuntimeException();
			}
		else {
		DoublyLinkedList DLL = new 	DoublyLinkedList();
		DNode a=header ;            Object ele;
		for(int i = 0;i<fromIndex ;i++) {a=a.getNext();}
		for(int i = 0;i<toIndex-fromIndex+1 ;i++) {
			a=a.getNext();
			ele=a.getElement();
			DLL.add(ele);
			}
		
		return DLL;
	}}

	@Override
	public boolean contains(Object o) {
		DNode v = header.getNext();
		while (v.getNext() != null) {
			if (v.getElement().equals(o)) {
				return true;
			} else {
				v = v.getNext();
			}

		}
		return false;
		}
	public Object[] listToArr(DoublyLinkedList list) {
		Object [] arr = new Object [list.size()];
		for (int i=0;i<list.size();i++) {
			arr[i]=list.get(i);
		}
		return arr;
	}
	
	public DoublyLinkedList arrToList (Object[] arr) {
		DoublyLinkedList list = new DoublyLinkedList();
		for (int i=0;i<arr.length;i++) {
			list.add(arr[i]);
		}
		return list;
	}
	}
