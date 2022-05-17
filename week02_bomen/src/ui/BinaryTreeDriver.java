package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {

	public static void main(String[] args) {
		/*BinaryTree<String> nodeD = new BinaryTree<>("D");
		BinaryTree<String> nodeF = new BinaryTree<>("F");
		BinaryTree<String> nodeB = new BinaryTree<>("B");
		BinaryTree<String> nodeH = new BinaryTree<>("H");
		
		// knoop A heeft links D en rechts F
		BinaryTree<String> nodeA = new BinaryTree<>("A",nodeD, nodeF);
		// knoop E heeft links H
		BinaryTree<String> nodeE = new BinaryTree<>("E",nodeH,null);
		// knoop G heeft links E en rechts B
		BinaryTree<String> nodeG = new BinaryTree<>("G",nodeE, nodeB);
		
		// boom heeft root C en heeft links A en rechts G
		BinaryTree<String> boom = new BinaryTree<>("C",nodeA, nodeG);//*/
		BinaryTree<String> nodeA = new BinaryTree<>("A");
		BinaryTree<String> nodeC = new BinaryTree<>("C");
		BinaryTree<String> nodeE = new BinaryTree<>("E");
		BinaryTree<String> nodeH = new BinaryTree<>("H");

		// knoop D heeft links C en rechts E
		BinaryTree<String> nodeD = new BinaryTree<>("D", nodeC, nodeE);
		// knoop B heeft links A en rechts D
		BinaryTree<String> nodeB = new BinaryTree<>("B", nodeA, nodeD);
		// knoop I heeft links H
		BinaryTree<String> nodeI = new BinaryTree<>("I", nodeH, null);
		// knoop G heeft rechts I
		BinaryTree<String> nodeG = new BinaryTree<>("G", null, nodeI);
		// boom heeft root F en heeft links B en rechts G
		BinaryTree<String> boom = new BinaryTree<>("F", nodeB, nodeG);
		//boom.printPostorder();
		System.out.println(boom.getDepth());
		System.out.println(nodeA.isLeaf());
		System.out.println(boom.countLeaves());
		System.out.println(boom.contains("D"));
		System.out.println(boom.contains("H"));
		System.out.println(boom.contains("F"));
		System.out.println(boom.contains("Q"));
		boom.getDataLeaves();
	}

}
