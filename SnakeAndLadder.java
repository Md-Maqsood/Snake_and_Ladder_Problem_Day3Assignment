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

	public static void main(String[] args){
		int player_position=START_POSITION;
		int player_numberOnDie=SnakeAndLadder.dieRoll();
		int player_option=(int)(Math.floor(Math.random()*10)%3);
		System.out.println("Player's number on die after die roll: "+player_numberOnDie);
		System.out.println("Player's position before die roll: "+player_position);
		switch(player_option){
			case LADDER:
				player_position+=player_numberOnDie;
				break;
			case NO_PLAY:
				player_position+=0;
				break;
			case SNAKE:
				player_position-=player_numberOnDie;
				break;
		}
		System.out.println("Player's option (1:LADDER,0:NO_PLAY,2:SNAKE): "+player_option);
		System.out.println("Player's position after die roll: "+player_position); 
	}
}
