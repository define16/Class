package A160922;


public class UndirectWeightedGraph {
	private String V;		// �׷����� Node ����
	private Edge E[];		// �׷����� Edge ����

	// ���Ϸκ��� ���� �о�鿩�� Edge ����Ÿ�� �ʱ�ȭ���ִ� �޼ҵ�
	public void readFile() {
		V = "";
		E = new Edge[9];

		// ��ĭ�� ä��ÿ�: P383�� �׷����� ����ÿ�.
		E[0] = new Edge('0',5,'1');
		E[1] = new Edge('0',4,'2');
		E[2] = new Edge('1',2,'2');
		E[3] = new Edge('1',7,'3');
		E[4] = new Edge('2',6,'3');
		E[5] = new Edge('2',11,'4');
		E[6] = new Edge('3',3,'4');
		E[7] = new Edge('3',8,'5');
		E[8] = new Edge('4',8,'5');
	
		addNode();
	}
	
	private void addNode()
	{
		for(int i=0; i<E.length; i++)
			addNode(E[i].VERTEX_1, E[i].VERTEX_2);
	}
	
	//��忡 ���� ������ �߰���Ų��.
	private void addNode(char v1, char v2){
		addNode(v1);
		addNode(v2);
	}

	//��忡 ���� ������ �߰���Ű�� ���� �޼ҵ�
	private void addNode(char node){ 
		if ( V.indexOf(node) == -1 )
			// ��ĭ�� ä��ÿ�: ���ڿ� V�� �Ű������� ���� node�� �ִ��� Ȯ���ϰ� ���ٸ� V�� node�� �߰�
			V += node;
	}
	// ���ڿ� V�� �������� �����Ѵ�.
	
	// Kruskal �˰��� ���� ����ó�� �޼ҵ�
	public void kruskal() {
		
		System.out.println(":::�Էµ� Edge ����::: (������ �̿��ؼ� ������)");
		for (int i = 0 ; i < E.length ; i++) {
			System.out.println(E[i]);
		}
		
		Sort();

		System.out.println("\n:::���ĵ� Edge ����::: ");
		for (int i = 0 ; i < E.length ; i++) {
			System.out.println(E[i]);
		}

		System.out.println("\n:::�ּ� ��� Edge ����::: ");
		UNION_FIND uf = new UNION_FIND( V.toCharArray() );	// ������ ���� ���ջ���

		// Edge �� ����ŭ �����ݺ�
		for (int i = 0, k = 1 ; i < E.length ; i++) {
			// Find �����ڸ� �̿��ؼ� ����Ŭ������ Ȯ���� (find ���ο� union ��������)
			if ( uf.find(E[i].VERTEX_1, E[i].VERTEX_2) ) {
				visit(i); // ã�Ƴ� �ִܰ�ο� ���� ó��
				
				// ���Ʈ���� Edge �� ���� V-1 �̵Ǹ� ����.
				if (k==V.length()-1)
						// ��ĭ�� ä��ÿ�: k�� V�� ũ�� -1�� �Ǹ� ) 
					break;
				else k++;
			}
		}
	}

	// �ּҺ�� ������ �湮�������� ���� ó��
	public void visit(int i) {
		System.out.println(E[i]);
	}

	public void Sort()
	{
		for(int i=0;i<E.length-1;i++)
			for(int j=i+1;j<E.length;j++)
				if(E[i].WEIGHT > E[j].WEIGHT)
				{
					Edge temp;
					temp = E[i];
					E[i] = E[j];
					E[j] = temp;
				}
	}
}