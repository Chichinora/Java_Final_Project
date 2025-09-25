package project;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Yui extends Character { //ch3
    public String name = "Yui";
    //public int hp = 900;
    public int atk = 25;

    public void Skill(Character mate){ //heal
        mate.hp += 60;
        this.hp += 60;
        JFrame j = new JFrame();
        JOptionPane.showMessageDialog(j, "Yui 發動了技能：全體成員生命值回復60！", "刀劍神域Online", 0);
    }
}
