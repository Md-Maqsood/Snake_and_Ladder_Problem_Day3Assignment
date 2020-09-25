public class SnakeAndLadder{
	public static int dieRoll(){
		int number_on_die=(int)(Math.floor(Math.random()*6)+1.0);
		return number_on_die;
	}


	public static void main(String[] args){
		Player player_1=new Player(1);
		Player player_2=new Player(2);
		int number_of_dieRolls=0;
		int movable_player=1;
		boolean player_keeps_move=false;
		while (true){
			if (movable_player==1){
				player_keeps_move=player_1.move();
				number_of_dieRolls++;
				System.out.println("Player_1's position after die roll number "+number_of_dieRolls+": "+player_1.getPlayer_position());
				if (player_1.hasWon()){
					System.out.println("The winning player is "+player_1);
					break;
				}
				if(player_keeps_move) movable_player=1;
				else movable_player=2;
			}
			else{
				player_keeps_move=player_2.move();
				number_of_dieRolls++;
				System.out.println("Player_2's position after die roll number "+number_of_dieRolls+": "+player_2.getPlayer_position());
				if (player_2.hasWon()){
					System.out.println("The winning player is "+player_2);
					break;
				}
				if(player_keeps_move) movable_player=2;
				else movable_player=1;
			}
			
		} 
		System.out.println("Total number of times the dice was played: "+number_of_dieRolls);
	}
}
class Player{
	public static final int START_POSITION=0;
	public static final int FINAL_POSITION=100;
	public static final int LADDER=1;
	public static final int NO_PLAY=0;
	public static final int SNAKE=2;

	private int player_position;
	private int player_id;
	public Player(int player_id){
		this.player_id=player_id;
		this.player_position=START_POSITION;
	}

	public void setPlayer_position(int player_position){
		this.player_position=player_position;
	}

	public int getPlayer_position(){
		return this.player_position;
	}

	public boolean move(){
		boolean player_keeps_move=false;
		int player_numberOnDie=SnakeAndLadder.dieRoll();
		int player_option=(int)(Math.floor(Math.random()*10)%3);
		switch(player_option){
			case LADDER:
				player_keeps_move=true;
				if ((this.getPlayer_position()+player_numberOnDie)<=FINAL_POSITION)
					this.setPlayer_position(this.getPlayer_position()+player_numberOnDie);
				break;
			case NO_PLAY:
				break;
			case SNAKE:
				this.setPlayer_position(this.getPlayer_position()-player_numberOnDie);
				break;
		}
		if(this.getPlayer_position()<START_POSITION) this.setPlayer_position(START_POSITION); 
		return player_keeps_move;
	}
	
	public boolean hasWon(){
		if (this.getPlayer_position()==FINAL_POSITION){
			return true;
		}
		return false;
	}

	public String toString(){
		return "Player_"+this.player_id;
	}
}
