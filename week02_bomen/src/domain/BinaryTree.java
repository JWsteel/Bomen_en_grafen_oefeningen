package domain;

public class BinaryTree<E> {
	private E data;
	private BinaryTree<E> leftTree, rightTree;
	
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
	
	public void printPreorder(){
			System.out.print(this.data + " ");
			if (this.leftTree != null) this.leftTree.printPreorder();
			if (this.rightTree != null) this.rightTree.printPreorder();
	}

	public void printInorder(){
			if (this.leftTree != null) this.leftTree.printInorder();
			System.out.print(this.data+ " ");
			if (this.rightTree != null) this.rightTree.printInorder();
	}
	public void printPostorder(){
			if (this.leftTree != null) this.leftTree.printPostorder();
			if (this.rightTree != null) this.rightTree.printPostorder();
			System.out.print(this.data+ " ");
	}
	public int countNodes(){
			int aantal=1;
			if(this.leftTree !=null) aantal+=this.leftTree.countNodes();
			if(this.rightTree != null) aantal+=this.rightTree.countNodes();
			return aantal;
	}
	public int getDepth(){
			if(this.leftTree !=null && this.rightTree != null && this.leftTree.getDepth()>=this.rightTree.getDepth()){
				return 1+this.leftTree.getDepth();
			}
			if(this.rightTree != null) return 1+this.rightTree.getDepth();
			return 1;
	}
	public boolean isLeaf(){
		return this.leftTree==null && this.rightTree==null;
	}
	public int countLeaves(){
		if(this.isLeaf()) return 1;
		int aantal=0;
		if(this.leftTree != null) aantal+=this.leftTree.countLeaves();
		if(this.rightTree!=null) aantal+= this.rightTree.countLeaves();
		return aantal;
	}
	public void getDataLeaves(){
		if(this.isLeaf()) System.out.print(this.data + " ");
		if (this.leftTree != null) this.leftTree.getDataLeaves();
		if (this.rightTree != null) this.rightTree.getDataLeaves();
	}
	public boolean contains(E data){
		if(this.data.equals(data)) return true;
		if(this.leftTree != null && this.leftTree.contains(data)) return true;
		return this.rightTree != null && this.rightTree.contains(data);
	}
}
