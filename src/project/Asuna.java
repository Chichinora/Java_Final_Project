package project;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Asuna extends Character { //ch1
	    public String name = "Asuna";
	    public int hp = 650;
	    public int atk = 100;

	    public void Skill(Character mate){ //increase dfs
	        mate.dfs += 10;
	        this.dfs += 10;
	        JFrame j = new JFrame();
	        JOptionPane.showMessageDialog(j, "Asuna 發動了技能：全體成員防禦力上升10一回合！", "刀劍神域Online", 0);
	    }
}