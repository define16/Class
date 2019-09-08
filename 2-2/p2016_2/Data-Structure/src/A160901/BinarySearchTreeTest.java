package A160901;

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
//
		System.out.println("The Tree is : ");
		T.printBST();
		System.out.println();
		//System.out.println(T.data);
//
//	
		
		System.out.println("Find the root of the Tree is : ");
		BinaryTree F = T.find("S");
		System.out.println(F.data);
//
		System.out.println("The inorder traveral of the Tree is : ");
		F.inorder(F);
		System.out.println();

		System.out.println("The preorder traveral of the Tree is : ");
		F.preorder(F);
		System.out.println();

		System.out.println("The postorder traveral of the Tree is : ");
		F.postorder(F);
		System.out.println();
		
		
		
		System.out.println("Find the root of the Tree is : ");
		BinaryTree F2 = T.find("S");
		System.out.println(F2.data);
//
		System.out.println("The inorder traveral of the Tree is : ");
		F2.inorder(F2);
		System.out.println();

		BinaryTree CTree = F2.copy(F2);
		System.out.println("The Copied Tree (inorder) is : ");
		CTree.inorder(CTree);
		System.out.println();
		
		if(F2.equal(F2, CTree))
			System.out.println("Two binary trees are the same");
		else
			System.out.println("Two binary trees are not the same");	
		
		BinaryTree STree = F2.swap(F2);
		System.out.println("The Swapped Tree (inorder) is : ");
		CTree.inorder(STree);
		System.out.println();
		
		System.out.println("isLeaf() : " + STree.isLeaf());
		System.out.println("size : " + STree.size());
		System.out.println("height : " + STree.height());
		System.out.println("numLeaves : " + STree.numLeaves());
		

	}
}
