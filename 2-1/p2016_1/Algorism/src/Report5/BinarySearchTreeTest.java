package Report5;

public class BinarySearchTreeTest {
	public static void main(String args[]) {
		// BinaryTree T = new BinaryTree(null, "S", null);
		BinaryTree T = new BinaryTree();

		T.insert("S");
		T.insert("J");
		T.insert("B");
		T.insert("D");
		T.insert("U");
		T.insert("M");
		T.insert("R");
		T.insert("Q");
		T.insert("A");
		T.insert("G");
		T.insert("E");

		System.out.println("The Tree is : ");
	
		System.out.println();
		// System.out.println(T.data);

		System.out.println("Find the root of the Tree is : ");
		BinaryTree F = T.find("S");
		System.out.println(F.data);

		System.out.println("The inorder traveral of the Tree is : ");
		F.inorder(F);
		System.out.println();

		System.out.println("The inorder traveral of the Tree is : ");
		F.preorder(F);
		System.out.println();

		System.out.println("The inorder traveral of the Tree is : ");
		F.postorder(F);
		System.out.println();

		System.out.println("Search For \"R\" ");
		BinaryTree N = T.find("R");
		System.out.println("Key of node found = " + N.data);
		System.out.println();

		System.out.println("Search For \"C\" ");
		BinaryTree C = T.find("C");
		if (C != null) {
			System.out.println("Key of node found = " + C.data);
		} else {
			System.out.println("Node that was found = null");
		}
		System.out.println();
	

		System.out.println("Find the root of the Tree is : ");
		BinaryTree F2 = T.find("S");
		System.out.println(F2.data);

		System.out.println("The inorder traveral of the Tree is : ");
		F2.inorder(F2);
		System.out.println();

		// BinaryTree CTree = T.copy(T);
		BinaryTree CTree = F2.copy(F2);
		System.out.println("The Copied Tree (inorder) is : ");
		CTree.inorder(CTree);
		System.out.println();
		System.out.println("The Copied Tree is (preorder) : ");
		CTree.preorder(CTree);
		System.out.println();
		System.out.println("The Copied Tree (postorder) is : ");
		CTree.postorder(CTree);
		System.out.println();
		System.out.println();

		BinaryTree STree = F2.swap(F2);
		System.out.println("The Swapped Tree (inorder) is : ");
		STree.inorder(STree);
		System.out.println();
		System.out.println("The Swapped Tree (preorder) is : ");
		STree.preorder(STree);
		System.out.println();
		System.out.println("The Swapped Tree (postorder) is : ");
		STree.postorder(STree);
		System.out.println();
		System.out.println();

		if (F2.equal(F2, CTree))
			System.out.println("The two trees are the Same");
		else
			System.out.println("The two trees are not the Same");

		if (F2.equal(CTree, STree))
			System.out.println("The two trees are the Same");
		else
			System.out.println("The two trees are not the Same");
	

		System.out.println("isLeaf() : " +STree.isLeaf());
		System.out.println("size : "+STree.size());
		System.out.println("height : "+STree.height());
		System.out.println("numLeaves : "+STree.numLeaves());
	}
}
