public class SnakeAndLadder{
	public static final int START_POSITION=0;
	public static final int FINAL_POSITION=100;
	public static final int LADDER=1;
	public static final int NO_PLAY=0;
	public static final int SNAKE=2;
	public static boolean player_keeps_move=false;	

	public static int dieRoll(){
		int number_on_die=(int)(Math.floor(Math.random()*6)+1.0);
		return number_on_die;
	}

	public static int move(int player_position){
		int player_numberOnDie=SnakeAndLadder.dieRoll();
		int player_option=(int)(Math.floor(Math.random()*10)%3);
		player_keeps_move=false;
		switch(player_option){
			case LADDER:
				player_keeps_move=true;
				if ((player_position+player_numberOnDie)<=FINAL_POSITION)
					player_position+=player_numberOnDie;
				break;
			case NO_PLAY:
				player_position+=0;
				break;
			case SNAKE:
				player_position-=player_numberOnDie;
				break;
		}
		if(player_position<START_POSITION) player_position=START_POSITION;
		return player_position; 
	}

	public static void main(String[] args){
		int player1_position=START_POSITION;
		int player2_position=START_POSITION;
		int number_of_dieRolls=0;
		int movable_player=1;
		while (true){
			if (movable_player==1){
				player1_position=SnakeAndLadder.move(player1_position);
				number_of_dieRolls++;
				System.out.println("Player_1's position after die roll number "+number_of_dieRolls+": "+player1_position);
				if (player1_position==100){
					System.out.println("Player_1 has won.");
					break;
				}
				if(player_keeps_move) movable_player=1;
				else movable_player=2;
			}
			else{
				player2_position=SnakeAndLadder.move(player2_position);
				number_of_dieRolls++;
				System.out.println("Player_2's position after die roll number "+number_of_dieRolls+": "+player2_position);
				if (player2_position==100){
					System.out.println("Player_2 has won.");
					break;
				}
				if(player_keeps_move) movable_player=2;
				else movable_player=1;
			}
			
		} 
		System.out.println("Total number of times the dice was played: "+number_of_dieRolls);
	}
}
