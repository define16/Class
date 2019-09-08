package HW161024;


public class UNION_FIND {
	private char[] VALUE;	// ������ ��
	private int[] PARENT;	// ������ �θ��� ��S
	private int[] HEIGHT;	// ������ ���̰�

	// ������ �ʱ�ȭ��Ű�� ���� ������
	public UNION_FIND(char[] v) {
		VALUE = new char[v.length];
		PARENT = new int[VALUE.length];
		HEIGHT = new int[VALUE.length];
		for (int i = 0 ; i < VALUE.length ; i++) {
			VALUE[i] = v[i];
			PARENT[i] = -1;
			HEIGHT[i] = 1;
		}
	}

	// ������ Union ���� �޼ҵ� (v�� u�߿��� ū�ʿ� ���� ���� Ʈ���� ��ģ��.)
	public void union(int vNum, int uNum) {

		// �� Ʈ���� ���̰� �Ȱ��ٸ�
		if ( HEIGHT[vNum] == HEIGHT[uNum] )
			// ��ĭ�� ä��ÿ�: �� Ʈ���� ���̰� �Ȱ��ٸ� vNum�� HEIGHT�� 1����
			HEIGHT[vNum]++;

		// �� Ʈ���� ���̰� �ٸ��ٸ� ū�ʿ� �������� ���δ�.
		if ( HEIGHT[uNum] > HEIGHT[vNum] ) {
			int temp = uNum;
			// ��ĭ�� ä��ÿ�: uNum ���� vNum ���� �ٲ�
			uNum = vNum;
			// ��ĭ�� ä��ÿ�: uNum ���� vNum ���� �ٲ�
			vNum = temp;
		}
		// ��ĭ�� ä��ÿ�: PARENT�� uNum��° ���� vNum���� ����
		 PARENT[uNum] =  vNum;
	}

	// ������ Find ���� �޼ҵ� (v �� ���� ���հ� u �� ���� ������ �ٸ����� �˻�, ������ false �ٸ��� true)
	// ���� ���տ� ������ �ʴ´ٸ� Union ������ �ϵ��� �Ѵ�. ��, true ���ǿ����� Union()�� �ϰ� �ȴ�.
	public boolean find(char v, char u) {
		int vNum = -1, uNum = -1;

		// v�� u�� index���� vNum �� uNum �� ã�´�.
		for (int i = 0; i < VALUE.length; i++) {
			if ( VALUE[i] == v ) vNum = i;
			else if ( VALUE[i] == u ) uNum = i;

			if ( vNum != -1 && uNum != -1 ) break;
		}

		// v�� root �� ã�´�.
		while(PARENT[vNum] > -1) // ��ĭ�� ä��ÿ�: v�� root�� ã�´�.
			vNum = PARENT[vNum];

		// u�� root �� ã�´�.
		while(PARENT[uNum] > -1) // ��ĭ�� ä��ÿ�: u�� root�� ã�´�.
			uNum = PARENT[uNum];

		// �ΰ��� ���� ������ �ƴϸ� �� ����Ŭ�� �ƴ϶�� union �� ���ش�.
		if ( vNum != uNum ) {
			union(vNum, uNum);
			return true;
		}
		return false;
	}

	public String toString() {
		String str = "";
		for (int i = 0 ; i < VALUE.length ;i++) {

			String k = "Root";
			if ( PARENT[i] != -1 )
				k = String.valueOf(VALUE[PARENT[i]]);

			str += VALUE[i] + " " + k + " " + HEIGHT[i] +"\n";
		}
		return str;
	}
}