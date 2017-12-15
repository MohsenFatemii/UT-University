package Randomized;

import java.util.Random;

public class TicTacToeA {

	public static void main(String[] args) {
		char board[][] = new char[3][3];
		Random r = new Random();
		char a[] = {'X','O'};
		int cnt_x = 0,cnt_o = 0,cnt = 0 ;
		while(cnt<1000){
			for(int i = 0 ; i < 9 ; i++){
				board[i/3][i%3] = a[r.nextInt(2)];
			}
			if(check_x(board)&&!check_o(board)){
				cnt_x++;
				cnt++;
			}else if(!check_x(board)&&check_o(board)){
				cnt_o++;
				cnt++;
			}else if(!check_x(board)&&!check_o(board)){
				cnt++;
			}
		}
		System.out.println((double)cnt_x/(double)cnt);
		
	}
	
	static boolean check_x(char a[][]){
		return (a[0][0]=='X'&&a[1][1]=='X'&&a[2][2]=='X')
				||(a[0][2]=='X'&&a[1][1]=='X'&&a[2][0]=='X')
				||(a[0][0]=='X'&&a[0][1]=='X'&&a[0][2]=='X')
				||(a[1][0]=='X'&&a[1][1]=='X'&&a[1][2]=='X')
				||(a[2][0]=='X'&&a[2][1]=='X'&&a[2][2]=='X')
				||(a[0][0]=='X'&&a[1][0]=='X'&&a[2][0]=='X')
				||(a[0][1]=='X'&&a[1][1]=='X'&&a[2][1]=='X')
				||(a[0][2]=='X'&&a[1][2]=='X'&&a[2][2]=='X');
	}
	
	static boolean check_o(char a[][]){
		return (a[0][0]=='O'&&a[1][1]=='O'&&a[2][2]=='O')
				||(a[0][2]=='O'&&a[1][1]=='O'&&a[2][0]=='O')
				||(a[0][0]=='O'&&a[0][1]=='O'&&a[0][2]=='O')
				||(a[1][0]=='O'&&a[1][1]=='O'&&a[1][2]=='O')
				||(a[2][0]=='O'&&a[2][1]=='O'&&a[2][2]=='O')
				||(a[0][0]=='O'&&a[1][0]=='O'&&a[2][0]=='O')
				||(a[0][1]=='O'&&a[1][1]=='O'&&a[2][1]=='O')
				||(a[0][2]=='O'&&a[1][2]=='O'&&a[2][2]=='O');
	}

}
