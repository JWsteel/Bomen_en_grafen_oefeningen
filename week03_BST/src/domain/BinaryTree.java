package domain;

import java.util.ArrayList;

public abstract class BinaryTree<E>{
	E data;
	BinaryTree<E> leftTree, rightTree;
	
	public BinaryTree(E data){
		this(data,null,null);
	}
	
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
		if (data == null) {
			throw new IllegalArgumentException();
		}
		this.data= data;
		this.leftTree= leftTree;
		this.rightTree= rightTree;
	}
	
	public void printInorder(){
			if (this.leftTree != null) this.leftTree.printInorder();
			System.out.print(this.data + " ");
			if (this.rightTree != null) this.rightTree.printInorder();
	}

	public boolean isLeaf(){
		return this.leftTree==null && this.rightTree==null;
	}
	public int countNodes(){
		int aantal=1;
		if(this.leftTree !=null) aantal+=this.leftTree.countNodes();
		if(this.rightTree != null) aantal+=this.rightTree.countNodes();
		return aantal;
	}
	//*ONDERSTAANDE METHODES NIET IMPLEMENTEREN! DEZE MOETEN GEIMPLEMENTEERD WORDEN IN DE BinarySearchTree file!*//
	boolean lookup(E data) {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	boolean addNode(E data) {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	boolean removeNode(E data){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	E searchSmallest(){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	E searchGreatest(){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	void cleanUp(){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	public abstract ArrayList<E> getPath(E data);

}
