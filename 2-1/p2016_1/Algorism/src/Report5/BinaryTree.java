package Report5;

class BinaryTree {
	BinaryTree llink;
	BinaryTree btree;
	Object data;
	BinaryTree rlink;
 
	public BinaryTree() {
		llink = null;
		data = null;
		rlink = null;
		// ������
	}
 
	public BinaryTree(Object data) {
		this.llink = null;
		this.data = data;
		this.rlink = null;
		// ������
	}
 
	public BinaryTree(BinaryTree llink, Object data, BinaryTree rlink) {
		this.llink = llink;
		this.data = data;
		this.rlink = rlink;
		// ������
	}
 
	public boolean isEmpty(BinaryTree btree) {
		if (btree == null) {
			return true;
		} else {
			return false;
		}
		// ��������˻�
	}
 
	public BinaryTree leftSubTree(BinaryTree btree) {
		if (isEmpty(btree) == true) {
			return null;
		} else {
			return btree.llink;
		}
		// ���� ���� ��ȯ
	}
 
	public BinaryTree rightSubTree(BinaryTree btree) {
		if (isEmpty(btree) == true) {
			return null;
		} else {
			return btree.rlink;
		}
		// ������ ���� ��ȯ
	}
 
	public Object rootData(BinaryTree btree) {
		if (isEmpty(btree) == true) {
			return null;
		} else {
			return btree.data;
		}
		// ��Ʈ ����Ÿ ��ȯ
	}
 
	public void inorder(BinaryTree btree) {
		if (btree == null)
			return;
 
		inorder(btree.llink);
		System.out.print(btree.data + " ");
		inorder(btree.rlink);
	} // End of inorder
 
	public void preorder(BinaryTree btree) {
		if (btree == null)
			return;
 
		System.out.print(btree.data + " ");
		preorder(btree.llink);
		preorder(btree.rlink);
 
	} // End of Preorder
 
	public void postorder(BinaryTree btree) {
		if (btree == null)
			return;
 
		postorder(btree.llink);
		postorder(btree.rlink);
		System.out.print(btree.data + " ");
	} // end of inorder
 
	public BinaryTree copy(BinaryTree btree) {
		BinaryTree Stree;
 
		Stree = new BinaryTree();
		if (btree == null)
			Stree = null;
		else {
		    Stree.llink = btree.llink; 	  //  Stree�� ���� ����Ʈ���� �Ű������� ���� btree���� ����Ʈ�� ����
			Stree.rlink=btree.rlink;     //  Stree�� ������ ����Ʈ���� �Ű������� ���� btree������ ����Ʈ�� ����
			Stree.data=btree.data;      // Stree�� �����Ϳ� btree�����͸� ����
		}
		return Stree;
	} // end of copy
 
	public boolean equal(BinaryTree btree, BinaryTree ctree) {
		boolean ans = false;
          if((btree==null) && (ctree==null))//  �Ű������� ���� �ΰ��� Ʈ���� null�̸� {
			ans = true;
		
	    else if ((btree != null) && (ctree != null)){
			if (btree.data == ctree.data) {
				ans = equal(btree.llink,ctree.llink);//  equal�� ����� ���� ����Ʈ������ ������ �˻��ϰ�
			  	// ans�� ��ȯ�� ����
			}
			if (ans) {
			   ans= equal(btree.rlink,ctree.rlink);   	//  equal�� ����� ������ ����Ʈ������ ������ �˻��ϰ�
				// ans�� ��ȯ�� ����
			}
		}
		return ans;
	} // end of equal
 
	public BinaryTree swap(BinaryTree btree) {
		BinaryTree Stree;
		BinaryTree ltree;
		BinaryTree rtree;
 
		Stree = null;
		// Try it !!
		// Stree = new BinaryTree();
		if (btree != null) {
			ltree =swap(btree.rlink);//  swap�Լ��� �̿��� btree�� ������ ��ũ�� ltree�� ���� 
			rtree =swap(btree.llink);//  swap�Լ��� �̿��� btree�� ���� ��ũ�� rtree�� ����
			Stree = new BinaryTree(ltree ,btree.data, rtree);
		}
		return Stree;
	} // end of swap
	
	public boolean isLeaf() {
	    
		return rlink==null&&llink==null; //  ���� ��ũ�� ������ ��ũ�� null���� Ȯ��
	} // end of isLeaf
	
	public int size() {
	   if(rlink==null&&llink==null) return 1; //  ���� ��ũ�� ������ ��ũ�� null�̸� ��ȯ�� 1
	   if(llink==null) return rlink.size()+1; // ���� ��ũ�� null�̸� ������ ��ũ�� ũ��� ��Ʈ�� ũ��(1)�� ���ؼ� ��ȯ
	   if(rlink==null) return llink.size()+1;//  ������ ��ũ�� null�̸� ���� ��ũ�� ũ��� ��Ʈ�� ũ��(1)�� ���ؼ� ��ȯ
	   else return rlink.size()+llink.size()+1; //  ����, ������ ��ũ �� �� null�� �ƴ϶�� ����+������+��Ʈ ũ�� ��ȯ
	  }  // end of size
 
	public int height() {
		if(llink==null&&rlink==null) return 0;//  ���� ��ũ�� ������ ��ũ�� null�̸� ��ȯ�� 0
		if(llink==null) return rlink.height()+1;//  ���� ��ũ�� null�̶�� ������ ��ũ�� ����+1
		if(rlink==null) return llink.height()+1;//  ������ ��ũ�� null�̶�� ���� ��ũ�� ����+1
	    return 1 + Math.max(llink.height(), rlink.height());
	  } // end of height 
 
	public int numLeaves() {
	    if (llink==null && rlink==null) return 1;
	    if (llink==null) return rlink.numLeaves();
	   if(rlink==null) return llink.numLeaves(); //  ������ ��ũ�� null�̸� ���� ��ũ�� numLeaves ȣ��
	   else return rlink.numLeaves()+llink.numLeaves(); // ����, ������ ��ũ�� null�� �ƴϸ� ���ʰ� ������ ��ũ�� numLeaves�� ����
	  }  // end of numLeaves
	

 
	// ////////////////////////////////////////////////////////////////
	// ���� Ž��Ʈ�� //
	// ////////////////////////////////////////////////////////////////
	private BinaryTree insertKey(BinaryTree T, String x) {
		// �������Ͻ� �ֻ��� ��忡 ����
		if (isEmpty(T)) {
		BinaryTree newNode = new BinaryTree(null,x,null);	//  ����, ������ ��ũ�� null�� �����ʹ� x�� ����Ʈ�� ����
		return newNode;// ����Ʈ�� ��ȯ
		}
		// �Էµ� ���ڿ��� data���� ������ ���� ��ũ�� ����
		else if (x.compareTo((String) T.data) < 0) {
		T.llink = insertKey(T.llink,x);	// ���� ��ũ�� �ٽ� insertKey�� ����Ͽ� ��ȯ�� ����
			return T;
		}
		// �Էµ� ���ڿ��� data���� ũ��� ������ ��ũ�� ����
		else if (x.compareTo((String) T.data) > 0) {
		 T.rlink=insertKey(T.rlink,x);	// ������ ��ũ�� �ٽ� insertKey�� ����Ͽ� ��ȯ�� ����
			return T;
		} 
		else {
			return T;
		}
	}
 
	public void insert(String x) {
		btree = insertKey(btree, x);
	}
 
	public BinaryTree find(String x) {
		BinaryTree T = btree;
		int result;
 
		while (T != null) {
			// �񱳸� �ؼ� data���� �������� ���� ��ũ�� �i�ư�.
			if ((result = x.compareTo((String) T.data)) < 0) {
			T=T.llink;	//  ���� ��ũ �Ѿư�
			}
		 	// �񱳸� �ؼ� data�� �����Ƿ� �˻��� data�� ��ȯ��.
			else if (result == 0) {
				return T;
			}
			// �񱳸� �ؼ� data���� ŭ���� ������ ��ũ�� �i�ư�.
			else {
				T=T.rlink;// ������ ��ũ �Ѿư�
			}
		}
		return T;
	}
} // end of BinaryTree class
