//---------------------------------
//assignment 3
//Written by Jiemin Liang 40262509
//----------------------------------


/**
 * Name and ID: Jiemin liang 40262509
 * COMP 249
 * Assignment 3
 * Due Date: Dec 2,2024
 */
import java.util.NoSuchElementException;

public class CellList {
	/**
	 * Name and ID: Jiemin liang 40262509 
	 * COMP 249 Assignment 3 
	 * Due Date: Dec 2,2024
	 * 
	 * 
	 */
	// inner class
	private static class CellNode implements Cloneable {

		// attributes
		private CellPhone c;
		private CellNode next;

		// constructor
		public CellNode() {
			c = null;
			next = null;
		}

		public CellNode(CellPhone c, CellList.CellNode x) {
			this.c = c;
			this.next = x;
		}

		public CellNode(CellNode temp) throws CloneNotSupportedException {
			long n = temp.c.getSerialNum()+1;
			c = temp.c.clone(n);
			next = null;
		}

		// clone method
		public CellNode clone() throws CloneNotSupportedException {
			CellNode temp = (CellList.CellNode) super.clone();
			long n = temp.c.getSerialNum()+1;
			temp.c = this.c.clone(n);
			temp.next = null;
			return temp;

		}

		// getter and setter
		public CellPhone getC() {
			return c;
		}

		public void setC(CellPhone c) {
			this.c = c;
		}

		public CellNode getX() {
			return next;
		}

		public void setX(CellNode x) {
			this.next = x;
		}

	}

	// attributes
	private CellNode head;
	private int size = 0;

	// constructor
	public CellList() {
		head = null;

	}

	// copy constructor
	public CellList(CellList cl1) {

		if (cl1.head == null) {
			head = null;
		}

		CellPhone c1=new CellPhone(cl1.head.c);
		c1.serialNum=c1.serialNum+1;
		head = new CellNode(c1, null);
		size = 1;

		CellNode t2 = head;
		CellNode t1 = cl1.head.next;

		while (t1 != null) {
			CellPhone c2=new CellPhone(t1.c);
			c2.serialNum=c2.serialNum+1;
			t2.next = new CellNode(c2, null);
			t1 = t1.next;
			t2 = t2.next;
			size++;
		}

	}

	// getter and setter
	public CellNode getHead() {
		return head;
	}

	public void setHead(CellNode head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// add created node at the head of the list
	public void addToStart(CellPhone c) {

		head = new CellNode(c, head);
		size++;

	}

	// create a node and insert it at the given index
	public void insertAtIndex(CellPhone c, int n) {
		try {
			if (n < 0 || n > size - 1)
				throw new NoSuchElementException();
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element Exists. \nThe Program Terminate.");
			System.exit(-1);
		}

		if (n == 0) {
			addToStart(c);
			return;
		}

		CellNode t = head;
		
		int i=0;
		while(i< n-1) {			
			t=t.next;
			i++;
		}

		CellNode temp = new CellNode(c, t.next);

		t.next=temp;
		t=null;
		size++;

	}

	// delete the node at given index
	public void deleteFromIndex(int n) {
		try {
			if (n < 0 || n > size - 1)
				throw new NoSuchElementException();
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element Exists. \nThe Program Terminate.");
			System.exit(-1);
		}

		if (n == 0) {

			head = head.next;
			size--;
			return;
		}

		CellNode t = head;
		CellNode prev = null;
		int i =0;
		
		while(i<n) {
			prev=t;
			t=t.next;
			i++;
		}

		prev.next=t.next;
		
		size--;

	}

	// delete the node at the head of the list
	public void deleteFromStart() {

		if (head == null) {
			System.out.println("No Such Element Exists. \nThe Program Terminate.");
			System.exit(-1);
		}

		head = head.next;
		size--;
	}

	// replace the cellphone info at given index
	public void replaceAtIndex(CellPhone c, int n) {

		try {
			if (n < 0 || n > size - 1)
				throw new NoSuchElementException();
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element Exists. \nThe Program Terminate.");
			System.exit(-1);
		}

		if (n == 0) {
			CellNode temp = new CellNode(c, head.next);
			head = temp;
			return;
		}

		CellNode t = head;
		int i=0;
		while(i!=n) {
			t=t.next;
			i++;
		}
		
		t.setC(c);

	}

	
	/** 
	 *  find the pointer of the node by given serial number
	 *  possible have privacy leak, will be better if do a password check before run the method
	 *  need to make sure the pointor is given to who
	 * @param n
	 * @return cellnode
	 */
	public CellNode find(long n) {

		CellNode t = head;

		for (int i = 0; i < size; i++) {
			if (t.c.getSerialNum() == n) {
				t.next = null;
				return t;
			}
			t = t.next;
		}
		System.out.println("The serialnumber is not found.");
		return null;
	}

	// return boolean depends on the given serial number
	public boolean contains(long n) {

		CellNode t = head;

		for (int i = 0; i < size; i++) {
			if (t.c.getSerialNum() == n) {
				return true;
			}
			t = t.next;
		}

		return false;

	}

	@Override
	// equals method
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CellList other = (CellList) obj;

		if (other.size != size) {
			return false;
		}

		CellNode t1 = other.head;
		CellNode t2 = head;

		while (t1 != null) {

			if (!t1.c.equals(t2.c)) {
				return false;
			}
			t1 = t1.next;
			t2 = t2.next;

		}
		return t1 == null && t2 == null;
	}

	@Override
	// toString method
	public String toString() {

		if (head == null) {
			return "CellList: []";
		} else {
			System.out.println("The current size of the list is " + size + ". Here are the contents of the list");
			System.out.println("===========================================================================");

			CellNode t = head;
			while (t != null) {

				System.out.print(t.c + " ---> ");
				t = t.next;

			}

		}

		return "X ";
	}

}
