package p20161127;

public class Work1 {
	int[] num = {1,2,3,4};
	String[] name = {"김순자　 ", "남창기　 ", "다담　　 ", "박나리아"};
	float[] kor = {100.3f, 89.5f, 70.2f, 56.5f};
	float[] eng = {90.0f, 90.4f, 100.0f, 100.0f};
	float[] math = {67.9f, 80.5f, 78.8f, 60.4f};

	float[] total = new float[name.length];
	float[] avg = new float[name.length];
	char[] hak = new char[name.length];
	int[] rank = {1,2,3,4};


	public void total()
	{
		for(int i=0; i<4; i++)
			total[i] = (kor[i] + eng[i] + math[i]);
	}

	public void average()
	{
		for(int i=0; i<4; i++)
			avg[i] = total[i]/3;
	}

	public void hak()
	{
		for(int i=0; i<4; i++)
		{
			if(avg[i] >= 90 && avg[i] <= 100)
				hak[i] = 'A';
			else if(avg[i] >= 80)
				hak[i] = 'B';
			else if(avg[i] >= 70)
				hak[i] = 'C';
			else if(avg[i] >= 60)
				hak[i] = 'D';
			else
				hak[i] = 'F';
		}
	}

	public void rank()
	{
		int temp;

		for(int i=0; i<total.length; i++)
		{
			for(int j=i; j<total.length; j++)
			{
				if(total[i] < total[j])
				{
					temp = rank[i];
					rank[i] = rank[j];
					rank[j] = temp;
				}
			}
		}
	}

	public void chart()
	{
		System.out.println("┌─────┬───────┬────────┬────────┬────────┬─────────┬────────┬─────┬─────┐");
		System.out.println("│ 번호  │ 나라성명 │　　국어 　 │　　영어 　 │　　수학 　 │　 　총점　 　 │　　평균　    │ 학점  │ 석차  │");
		for(int i=0; i<4; i++)
		{
			System.out.println("├─────┼───────┼────────┼────────┼────────┼─────────┼────────┼─────┼─────┤");
			System.out.format("│ %2d  │ %s │  %-6.1f│  %-6.1f│  %-6.1f│　%.2f　 │　%.2f　 │ %2c  │ %2d  │\r\n", num[i], name[i], kor[i], eng[i], math[i], total[i], avg[i], hak[i], rank[i]);
		}
		System.out.println("└─────┴───────┴────────┴────────┴────────┴─────────┴────────┴─────┴─────┘");
	}

	public void graph()
	{
		
	}
	
	public static void main(String[] args) {

		Work1 wk = new Work1();

		wk.total();
		wk.average();
		wk.hak();
		wk.rank();
		
		wk.chart();
		wk.graph();
	}
}

