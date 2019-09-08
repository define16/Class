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
	private int[][] move ={{-1,0},{0,1},{1,0},{0,-1}}; //북 동 남 서
	private int m = maze.length -2;
	private int n = maze[0].length -1;
	
	public MazePath(){  
		int mark[][] = new int[maze.length][maze[0].length];
		Stack st = new Stack();
		Stack st1 = new Stack();  //올바른 경로 삽입할 스택
		st.push(new MazeCell(1,1,1));  //초기출발위치맟 방향 설정
		
		while(st.isEmpty()!=true){
			MazeCell mc = (MazeCell)st.pop();  //지나온 경로를 pop함
			
			while(mc.dir<=3){
				int nextI = mc.i + move[mc.dir][0];  //갈려고하는 방향으로 i+
			    int nextJ = mc.j + move[mc.dir][1]; //갈려고하는 방향으로 j+
				// 	빈칸1을 채우시오                                       
				
				if(nextI == m && nextJ ==n){           //미로경로 발견
					System.out.println("경로를 발견했습니다");
					st.push(new MazeCell(mc.i, mc.j, mc.dir)); //마지막 경로 지정
					st.push(new MazeCell(nextI, nextJ, 0));    //마지막 지점 지정
					
					while(st.isEmpty()!=true){
						st1.push((MazeCell)st.pop());
					}  // end of while
					
					while(st1.isEmpty()!=true/* 빈칸 2를 채우시오 */ ){
						mc = (MazeCell)st1.pop();       //올바른 경로 출력
						System.out.println(mc);
						maze[mc.i][mc.j]=2;
					} // end of if
					
					displayMaze();  //경로 확인 완료후 출력					
					return;
				}
				
                                       // 빈칸을 채우기 바랍니다. 
				
				// 이동가능할때 한번도 가지 않는곳에서 실행
				if(maze[nextI][nextJ]==0 && mark[nextI][nextJ]==0){
							mark[nextI][nextJ]=1;		   // 빈칸3를 채우시오
				 st.push(new MazeCell(mc.i,mc.j,mc.dir));
                 mc.i = nextI;
                 mc.j = nextJ;
				 mc.dir = 0;
                 /* 	
                                                                                        적당한 코드를 삽입하라. 
                                       */
				}
				
				else
				{
					mc.dir++; 
				}
			}
		}
		System.out.println("경로를 발견하지 못했습니다");
	}
	
	public void displayMaze(){
		String[] str = {"○","●","◎"};
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
