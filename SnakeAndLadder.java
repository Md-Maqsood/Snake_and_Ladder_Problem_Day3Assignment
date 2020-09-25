public class SnakeAndLadder{
	public static final int START_POSITION=0;
	public static final int FINAL_POSITION=100;

	public static int dieRoll(){
		int number_on_die=(int)(Math.floor(Math.random()*6)+1.0);
		return number_on_die;
	}

	public static void main(String[] args){
		int player_position=START_POSITION;
		int player_numberOnDie=SnakeAndLadder.dieRoll();
		System.out.println("Player's number on die after die roll: "+player_numberOnDie);
		System.out.println("Player's position: "+player_position);
	}
}
