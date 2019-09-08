package A160901;
// Start of Binary Tree
class BinaryTree {
	BinaryTree llink;
	BinaryTree btree;
	Object data;
	BinaryTree rlink;

	public BinaryTree() {
		llink = null;
		data = null;
		rlink = null;
		// 생성자
	}

	public BinaryTree(Object data) {
		this.llink = null;
		this.data = data;
		this.rlink = null;
		// 생성자
	}

	public BinaryTree(BinaryTree llink, Object data, BinaryTree rlink) {
		this.llink = llink;
		this.data = data;
		this.rlink = rlink;
		// 생성자
	}

	public boolean isEmpty(BinaryTree btree) {
		if (btree == null) {
			return true;
		} else {
			return false;
		}
		// 비었는지검사
	}

	public BinaryTree leftSubTree(BinaryTree btree) {
		if (isEmpty(btree) == true) {
			return null;
		} else {
			return btree.llink;
		}
		// 왼쪽 서브 반환
	}

	public BinaryTree rightSubTree(BinaryTree btree) {
		if (isEmpty(btree) == true) {
			return null;
		} else {
			return btree.rlink;
		}
		// 오른쪽 서브 반환
	}

	public Object rootData(BinaryTree btree) {
		if (isEmpty(btree) == true) {
			return null;
		} else {
			return btree.data;
		}
		// 루트 데이타 반환
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
			Stree.llink = btree.llink;
			// 빈칸1: Stree의 왼쪽 서브트리에 매개변수로 받은 btree왼쪽 서브트리 복사
			Stree.rlink = btree.rlink;
			// 빈칸2: Stree의 오른쪽 서브트리에 매개변수로 받은 btree오른쪽 서브트리 복사
			Stree.data = btree.data;
			// 빈칸3: Stree의 데이터에 btree데이터를 복사
		}
		return Stree;
	} // end of copy

	public boolean equal(BinaryTree btree, BinaryTree ctree) {
		boolean ans = false;
		// 빈칸4: 매개변수로 받은 두개의 트리가 null이면 
		if((btree == null) && (ctree == null)){
			ans = true;
		} else if ((btree != null) && (ctree != null)) {
			if (btree.data == ctree.data) {
				ans = equal(btree.llink,ctree.llink);
				// 빈칸5: equal을 사용해 왼쪽 서브트리들이 같은지 검사하고
				// ans에 반환값 저장
			}
			if (ans) {
				ans = equal(btree.rlink,ctree.rlink);
				// 빈칸6: equal을 사용해 오른쪽 서브트리들이 같은지 검사하고
				// ans에 반환값 저장
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
			ltree = swap(btree.rlink);
			// 빈칸7: swap함수를 이용해 btree의 오른쪽 링크를 ltree에 저장 
			rtree = swap(btree.llink);
			// 빈칸8: swap함수를 이용해 btree의 왼쪽 링크를 rtree에 저장
			Stree = new BinaryTree(ltree, btree.data, rtree);
		}
		return Stree;
	} // end of swap
	
public boolean isLeaf() {
	    return llink == null && rlink == null; // 빈칸9: 왼쪽 링크와 오른쪽 링크가 null인지 확인
	} // end of isLeaf

	public int size() {
		if(llink == null && rlink == null)
			return 1;
	    // 빈칸10: 왼쪽 링크와 오른쪽 링크가 null이면 반환값 1
		 if(llink == null)
			return 1 + rlink.size();
	    // 빈칸11: 왼쪽 링크만 null이면 오른쪽 링크의 크기와 루트의 크기(1)을 더해서 반환
		 if(rlink == null)
				return 1 + llink.size();
	    // 빈칸12: 오른쪽 링크만 null이면 왼쪽 링크의 크기와 루트의 크기(1)을 더해서 반환
		return 1 + llink.size() + rlink.size();
		// 빈칸13: 왼쪽, 오른쪽 링크 둘 다 null이 아니라면 왼쪽+오른쪽+루트 크기 반환
	  }  // end of size

	public int height() {
		if(llink == null && rlink == null)
			return 0;
		// 빈칸14: 왼쪽 링크와 오른쪽 링크가 null이면 반환값 0
		 if(llink == null)
				return 1 + rlink.height();
		// 빈칸15: 왼쪽 링크가 null이라면 오른쪽 링크의 높이+1
		 if(rlink == null)
				return 1 + llink.height();
		// 빈칸16: 오른쪽 링크가 null이라면 왼쪽 링크의 높이+1
	    return 1 + Math.max(llink.height(), rlink.height());
	  } // end of height 

	public int numLeaves() {
	    if (llink==null && rlink==null) return 1;
	    if (llink==null) return rlink.numLeaves();
	    if (rlink==null) return llink.numLeaves();
	    // 빈칸 17: 오른쪽 링크가 null이면 왼쪽 링크의 numLeaves 호출
	    return llink.numLeaves() + rlink.numLeaves();
	    // 빈칸 18: 왼쪽, 오른쪽 링크가 null이 아니면 왼쪽과 오른쪽 링크의 numLeaves를 더함
	  }  // end of numLeaves

	private void printNode(BinaryTree T) {
		if (T != null) {
			// 빈칸19: 왼쪽괄호 출력 
			System.out.print("(");
			// 빈칸20: printNode를 이용해 이진트리의 왼쪽 서브트리 호출
			printNode(T.llink);
			// 빈칸21: 이지트리의 데이터 출력
			System.out.print(T.data);
			// 빈칸22: printNode를 이용해 이진트리의 오른쪽 서브트리 호출
			printNode(T.rlink);
			// 빈칸23: 오른쪽괄호 출력
			System.out.print(")");
			
		}
	}

	public void printBST() {
		printNode(btree);
		// 빈칸24: printNode를 이용해 이진트리 출력
		System.out.println();
	}
	
	

	// ////////////////////////////////////////////////////////////////
	// 이진 탐색트리 //
	// ////////////////////////////////////////////////////////////////
	private BinaryTree insertKey(BinaryTree T, String x) {
		// 공백노드일시 최상위 노드에 삽입
		if (isEmpty(T)) {
			// 빈칸25: 왼쪽, 오른쪽 링크는 null로 데이터는 x인 이진트리 생성
			llink = null;
			rlink = null;
			btree = new BinaryTree(llink,x,rlink);
			return btree;
			// 빈칸26: 이진트리 반환
		}
		// 입력된 문자열이 data보다 작으면 왼쪽 링크에 삽입
		else if (x.compareTo((String) T.data) < 0) {
			T.llink = insertKey(T.llink,x);
			// 빈칸27: 왼쪽 링크에 다시 insertKey를 사용하여 반환값 저장
			return T;
		}
		// 입력된 문자열이 data보다 크면면 오른쪽 링크에 삽입
		else if (x.compareTo((String) T.data) > 0) {
			T.rlink = insertKey(T.rlink,x);
			// 빈칸28: 오른쪽 링크에 다시 insertKey를 사용하여 반환값 저장
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
			// 비교를 해서 data보다 작음으로 왼쪽 링크를 쫒아감.
			if ((result = x.compareTo((String) T.data)) < 0) {
				T = T.llink; 
				// 빈칸29: 왼쪽 링크 쫓아감
			}
			// 비교를 해서 data와 같으므로 검색된 data를 반환함.
			else if (result == 0) {
				return T;
			}
			// 비교를 해서 data보다 큼으로 오른쪽 링크를 쫒아감.
			else {
				T = T.rlink;
				// 빈칸30: 오른쪽 링크 쫓아감
			}
		}
		return T;
	}
} // end of BinaryTree class
