package domain;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree) {
		super(data, leftTree, rightTree);
	}
			
	public BinarySearchTree(E data) {
		super(data);
	}

	public boolean lookup(E data) {
		if(this.data.equals(data)) return true;
		if(this.data.compareTo(data)>0) return this.leftTree != null && this.leftTree.lookup(data);
		return this.rightTree != null && this.rightTree.lookup(data);
	}

	public boolean addNode(E data) {
		if(this.data.equals(data)) return false;
		if(this.data.compareTo(data)>0 && this.leftTree==null) {
			this.leftTree=new BinarySearchTree<E>(data);
			return true;
		}
		if(this.data.compareTo(data)>0 && this.leftTree!=null) this.leftTree.addNode(data);
		if(this.data.compareTo(data)<0 && this.rightTree==null) {
			this.rightTree=new BinarySearchTree<E>(data);
			return true;
		}
		if(this.data.compareTo(data)<0 && this.rightTree!=null) this.rightTree.addNode(data);
		return false;

	}

	public boolean removeNode(E data){
		if(this.data.equals(data)){
			if(this.isLeaf()){
				this.data=null;
				return true;
			}
			if(leftTree!=null){
				E gl = this.leftTree.searchGreatest();
				this.data=gl;
				this.leftTree.removeNode(gl);
				return true;
			}
			E kr = this.rightTree.searchSmallest();
			this.data=kr;
			this.rightTree.removeNode(kr);
			return true;
		}
		if(data.compareTo(this.data)<0){
			if(leftTree==null) return false;
			return this.leftTree.removeNode(data);
		}
		if(rightTree==null) return false;
		return this.rightTree.removeNode(data);
	}

	public void cleanUp(){
		if(this.rightTree!=null && this.rightTree.isLeaf() && this.rightTree.data==null) this.rightTree=null;
		if(this.leftTree!=null &&  this.leftTree.isLeaf() && this.leftTree.data==null) this.rightTree=null;
		if(this.leftTree!=null) this.leftTree.cleanUp();
		if(this.rightTree!=null)this.rightTree.cleanUp();
	}

	public E searchSmallest(){
		return this.leftTree!=null ? this.leftTree.searchSmallest() : this.data;
	}

	public E searchGreatest(){
		return this.rightTree!=null ? this.rightTree.searchGreatest() : this.data;
	}

	public ArrayList<E> getPath(E data) {
		if (!lookup(data)) {//data komt niet voor in BST
			return null;
		}
		ArrayList<E> pad = new ArrayList<>();
		if (this.data.compareTo(data) == 0){
			pad.add(data);
			return pad;
		} else {
			pad.add(this.data);
			if (this.data.compareTo(data) > 0) {//ga links, data komt zeker voor!
				pad.addAll(this.leftTree.getPath(data));
			} else {// ga rechts, data zit daar gegarandeerd
				pad.addAll((this.rightTree.getPath(data)));
			}
		}
		return pad;
	}

}


