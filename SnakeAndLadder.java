public class SnakeAndLadder{
	public static final int START_POSITION=0;
	public static final int FINAL_POSITION=100;
	public static final int LADDER=1;
	public static final int NO_PLAY=0;
	public static final int SNAKE=2;

	public static int dieRoll(){
		int number_on_die=(int)(Math.floor(Math.random()*6)+1.0);
		return number_on_die;
	}

	public static int move(int player_position){
		int player_numberOnDie=SnakeAndLadder.dieRoll();
		int player_option=(int)(Math.floor(Math.random()*10)%3);
		switch(player_option){
			case LADDER:
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
		int player_position=START_POSITION;
		int number_of_dieRolls=0;
		while (player_position<FINAL_POSITION){
			player_position=SnakeAndLadder.move(player_position);
			number_of_dieRolls++;
			System.out.println("Player's position after die roll number "+number_of_dieRolls+": "+player_position);
		} 
		System.out.println("Total number of times the dice was played: "+number_of_dieRolls);
	}
}
