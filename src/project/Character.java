package project;

public class Character {
	    public String name = "";
	    public int hp = 0;
	    public int atk = 0;
		public int dfs = 0;
	    public int cd = 3; 
	    public int status = 1; // 0: cannot move 1:hero 2:enemy

	    public int Attack(Character ch) {
	        int hurt = this.atk-ch.dfs;
	        if (hurt > 0 && ch.hp - hurt > 0) ch.hp -= hurt;
	        else if (hurt > 0 && ch.hp > 0 && ch.hp - hurt < 0){
	            hurt = ch.hp;
	            ch.hp = 0;
	        }
	        return hurt;
	    }
	    public void Skill(Character ch){
	        
	    }
	    public void Skill(Character ch, Character enemy){
	        
	    }
		public void ResetCD() {
	        this.cd = 3;
	    }
	    public void updateATK(int hp) {

	    }
}
