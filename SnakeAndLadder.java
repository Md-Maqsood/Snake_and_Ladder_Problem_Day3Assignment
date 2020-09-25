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
		System.out.println("Player's number on die after die roll: "+player_numberOnDie);
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
		System.out.println("Player's option (1:LADDER, 0:NO_PLAY, 2:SNAKE): "+player_option);
		if(player_position<START_POSITION) player_position=START_POSITION;
		return player_position; 
	}

	public static void main(String[] args){
		int player_position=START_POSITION;
		while (player_position<FINAL_POSITION){
			player_position=SnakeAndLadder.move(player_position);
			System.out.println("Player's position after move: "+player_position);
		} 
		System.out.println("Player won. Final player position is "+player_position);
	}
}
