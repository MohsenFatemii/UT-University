package Randomized;

import java.util.ArrayList;
import java.util.Random;

public class TicTacToeB {

	public static void main(String[] args) {
		char board[][] = new char[3][3];
		Random r = new Random();
		char a[] = {'X','O'};
		int cnt_x = 0,cnt_o = 0 ,turn = 0;
		empty(board);
		for(int j = 0 ; j < 1000 ; j++){
			ArrayList<Integer> choice = new ArrayList<Integer>();
			choice.clear();
			for(int k = 0 ; k < 9 ; k++)
				choice.add(k);
			turn = 0 ;
			for(int i = 0 ; i < 9 ; i++){
				int rand = r.nextInt(choice.size());
				int choice1 = choice.get(rand);
				board[choice1/3][choice1%3] = a[turn];
				choice.remove(choice.get(rand));
				turn = 1 - turn;
				if(check_o(board)){
					cnt_o++;
					empty(board);
					break;
				}
				if(check_x(board)){
					cnt_x++;
					empty(board);
					break;
				}
			}
		}
		System.out.println((double)cnt_x/1000.0+"  "+(double)cnt_o/1000.0);
		
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
	
	static void empty(char a[][]){
		for(int i = 0 ; i < 3 ; i++)
			for(int j = 0 ; j < 3 ; j++){
				a[i][j]='.';
			}
	}

}
