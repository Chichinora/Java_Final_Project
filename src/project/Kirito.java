package project;
public class Kirito extends Character { //ch4
    public String name = "Kirito";
    public int hp = 600;

    public void updateATK(int hp) {
		if(hp >= 450) this.atk = 40; 
        else if(hp < 450 && hp >= 300) this.atk = 60;
		else if(hp < 300 && hp >= 100) this.atk = 80;
		else if(hp < 100  && hp > 0) this.atk = 120;
		else this.atk = 0;
	}
}

