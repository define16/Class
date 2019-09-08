package P;


import java.util.*;


class MazeCell{
	int i;
	int j;
	int dir;
	
	public MazeCell(int _i,int _j,int _dir){
		i = _i;
		j = _j;
		dir = _dir;
	}
	
	public String toString(){
		return "<" + i  + "," + j + ">";
	}
}
 
public class MazePath 
{
	private int[][] maze = {
			{1,1,1,1,1,1,1,1}, //0
			{1,0,1,1,0,1,1,1}, //1       
			{1,0,0,1,0,1,1,1}, //2
			{1,1,0,0,0,1,1,1}, //3
			{1,1,1,0,0,0,1,1}, //4
			{1,0,0,0,1,1,1,1}, //5
			{1,1,0,1,0,0,0,1}, //6
			{1,0,0,0,0,1,0,0}, //7
			{1,1,1,1,1,1,1,1}  //8
			};
	private int[][] move ={{-1,0},{0,1},{1,0},{0,-1}}; //�� �� �� ��
	private int m = maze.length -2;
	private int n = maze[0].length -1;
	
	public MazePath(){  
		int mark[][] = new int[maze.length][maze[0].length];
		Stack st = new Stack();
		Stack st1 = new Stack();  //�ùٸ� ��� ������ ����
		st.push(new MazeCell(1,1,1));  //�ʱ������ġ�� ���� ����
		
		while(st.isEmpty()!=true){
			MazeCell mc = (MazeCell)st.pop();  //������ ��θ� pop��
			
			while(mc.dir<=3){
				int nextI = mc.i + move[mc.dir][0];  //�������ϴ� �������� i+
			    int nextJ = mc.j + move[mc.dir][1]; //�������ϴ� �������� j+
				// 	��ĭ1�� ä��ÿ�                                       
				
				if(nextI == m && nextJ ==n){           //�̷ΰ�� �߰�
					System.out.println("��θ� �߰��߽��ϴ�");
					st.push(new MazeCell(mc.i, mc.j, mc.dir)); //������ ��� ����
					st.push(new MazeCell(nextI, nextJ, 0));    //������ ���� ����
					
					while(st.isEmpty()!=true){
						st1.push((MazeCell)st.pop());
					}  // end of while
					
					while(st1.isEmpty()!=true/* ��ĭ 2�� ä��ÿ� */ ){
						mc = (MazeCell)st1.pop();       //�ùٸ� ��� ���
						System.out.println(mc);
						maze[mc.i][mc.j]=2;
					} // end of if
					
					displayMaze();  //��� Ȯ�� �Ϸ��� ���					
					return;
				}
				
                                       // ��ĭ�� ä��� �ٶ��ϴ�. 
				
				// �̵������Ҷ� �ѹ��� ���� �ʴ°����� ����
				if(maze[nextI][nextJ]==0 && mark[nextI][nextJ]==0){
							mark[nextI][nextJ]=1;		   // ��ĭ3�� ä��ÿ�
				 st.push(new MazeCell(mc.i,mc.j,mc.dir));
                 mc.i = nextI;
                 mc.j = nextJ;
				 mc.dir = 0;
                 /* 	
                                                                                        ������ �ڵ带 �����϶�. 
                                       */
				}
				
				else
				{
					mc.dir++; 
				}
			}
		}
		System.out.println("��θ� �߰����� ���߽��ϴ�");
	}
	
	public void displayMaze(){
		String[] str = {"��","��","��"};
		for(int i = 0 ; i < maze.length ; i++){
			for(int j = 0 ; j < maze[0].length ; j++){
				System.out.print(str[(maze[i][j])]);
			}
			System.out.println("");
		}
	}
	public static void main(String[] args)
	{
		new MazePath();
	}
}
