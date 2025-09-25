package project;
import javax.swing.*;

import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.sound.sampled.*;

public class App {
	public static menu m = new menu();
	public static Shop s = new Shop();
	public static String[] character = {"Asuna", "Klein", "Yui", "Kirito", "Shino"};
    public static int[] enable = {1, 1, 1, 0, 0};
    public static int pick1, pick2;
    public static Character ch1 = new Character();
    public static Character ch2 = new Character();
    public static Character boss = new Character();
    public static int money = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkStart l = new LinkStart();
		l.visiable();
		Clip clip = null;
	     try {
	    	 String audioName = URLDecoder.decode(App.class.getResource("/project/linkstart.wav").getPath(), StandardCharsets.UTF_8.toString());
	         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(audioName).getAbsoluteFile());
	         //AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(App.class.getResource("/project/bgm.mp3");
	         clip = AudioSystem.getClip();
	         clip.open(audioInputStream);
	         clip.start();
	            
	        } catch(Exception e) {
	            System.out.println("Error with playing sound.");
	            e.printStackTrace();
	        }
		try {
			Thread.sleep(11000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		l.invisiable();
	     try {
	    	 String audioName = URLDecoder.decode(App.class.getResource("/project/bgm.wav").getPath(), StandardCharsets.UTF_8.toString());
	         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(audioName).getAbsoluteFile());
	         //AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(App.class.getResource("/project/bgm.mp3");
	         clip = AudioSystem.getClip();
	         clip.open(audioInputStream);
	         clip.loop(Clip.LOOP_CONTINUOUSLY);
	            
	        } catch(Exception e) {
	            System.out.println("Error with playing sound.");
	            e.printStackTrace();
	        }
		Menu();
	}
	public static void Menu(){
		m.visiable();
		s.invisiable();
    }
	
	public static void Choose_Character(){
		m.invisiable();
        JFrame j = new JFrame();
        String result = JOptionPane.showInputDialog(j, "請選擇兩位角色，一起打敗這裡的大魔王—茅場晶彥!\n角色列表:\n(1) Asuna\n(2) Klein\n(3) Yui\n(4) Kirito\n(5) Shino", 
        "刀劍神域Online", JOptionPane.QUESTION_MESSAGE);
        if (result == null) System.exit(0);
        pick1 = result.charAt(0) - '0';
        pick2 = result.charAt(2) - '0';
        while (enable[pick1-1] == 0 || enable[pick2-1] == 0){
            JOptionPane.showMessageDialog(j, "你選擇的角色尚未開放，請重新選擇!", "刀劍神域Online", JOptionPane.ERROR_MESSAGE);
            String getMessage = JOptionPane.showInputDialog(j, "請選擇兩位角色，一起打敗這裡的大魔王—茅場晶彥!\n角色列表:\n(1) Asuna\n(2) Klein\n(3) Yui\n(4) Kirito\n(5) Shino", 
            "刀劍神域Online", JOptionPane.QUESTION_MESSAGE);
            pick1 = getMessage.charAt(0) - '0';
            pick2 = getMessage.charAt(2) - '0';
        }
        Set_Character(pick1, pick2);
        JOptionPane.showMessageDialog(j, "你選擇的角色是:\n" + ch1.name + " 和 " + ch2.name);
        JOptionPane.showMessageDialog(j, "開始遊戲!");
        Play();
    }
    
    public static void Shop(){
    	m.invisiable();
    	s.visiable();
    }
    public static String result = null;
    public static void Judge() {
    	JFrame j = new JFrame();
		if (result == null) System.exit(0);
		else if (result.charAt(0) == '0') {
            Menu();
		}
		if (result.charAt(0) == '1'){
            if (enable[3] == 1) JOptionPane.showMessageDialog(j, "你已擁有此角色!");
            else if (money < 300) JOptionPane.showMessageDialog(j, "你的錢不夠，笑死");
            else if (money >= 300) {
            	enable[3] = 1;
            	money -= 300;
                JOptionPane.showMessageDialog(j, "購買成功!\n現在你可以選擇Kirito加入你的隊伍了");
            }         
            Menu();
        }
        else if (result.charAt(0) == '2') {
            if (enable[4] == 1) JOptionPane.showMessageDialog(j, "你已擁有此角色!");
            else if (money < 200) JOptionPane.showMessageDialog(j, "你的錢不夠，笑死");
            else if (money >= 200) {
            	enable[4] = 1;
            	money -= 200;
                JOptionPane.showMessageDialog(j, "購買成功!\n現在你可以選擇Shino加入你的隊伍了");
            }            
            Menu();
        }    
    }
    public static void Play(){
        JFrame j = new JFrame();      
        while ((ch1.hp > 0 || ch2.hp > 0) && boss.hp > 0){
            if (ch1.hp == 0 && ch1.status != 0){
                JOptionPane.showMessageDialog(j, "戰況告急！ " + ch1.name + "倒下了！", "刀劍神域Online", 0);
                ch1.status = 0;
            }
            else if (ch2.hp == 0 && ch2.status != 0){
                JOptionPane.showMessageDialog(j, "戰況告急！ " + ch2.name + "倒下了！", "刀劍神域Online", 0);
                ch2.status = 0;
            }
            if (ch1.dfs == 10) ch1.dfs -= 10;
            if (ch2.dfs == 10) ch2.dfs -= 10;
            if (boss.dfs == 30) boss.dfs -= 10;
            //Round for ch1
            if (boss.hp == 0) End_of_the_Game(1);
            if (ch1.hp > 0){
                if (ch1.status == 1){
                    if(ch1.name == "Kirito") ch1.updateATK(ch1.hp);
                    int opt1 = Show_information(1);
                    while (opt1 == 1 && ch1.cd > 0){
                        JOptionPane.showMessageDialog(j, "技能尚在冷卻，請選擇其他選項", "刀劍神域Online", 0);
                        opt1 = Show_information(1);
                    }
                    if (opt1 == 0) { //ch1 attack
                        int hurt = ch1.Attack(boss);
                        JOptionPane.showMessageDialog(j, ch1.name + "採取了普通攻擊，造成" + hurt + "點傷害!", "刀劍神域Online", 0);
                        if (ch1.cd > 0) ch1.cd--;
                    }
                    else if (opt1 == 1){ //ch1 skill
                        if (ch1.name == "Klein") ch1.Skill(boss); //dizzy
                        else if (ch1.name == "Shino" && ch1.hp > ch2.hp) ch1.Skill(ch2, boss);
                        else if (ch1.name == "Shino" && ch1.hp < ch2.hp) ch1.Skill(ch1, boss);
                        else ch1.Skill(ch2); //increase dfs or heal
                        ch1.ResetCD();
                    }
                    else System.exit(0);
                }
                else if (ch1.status == 2){
                    if (ch1.cd == 0 && ch1.name != "Kirito") {
                        if (ch1.name == "Klein") ch1.Skill(ch2);
                        else if (ch1.name == "Shino" && ch1.hp > ch2.hp) ch1.Skill(boss, ch2);
                        else if (ch1.name == "Shino" && ch1.hp < ch2.hp) ch1.Skill(boss, ch1);
                        else ch1.Skill(boss);
                        ch1.ResetCD();
                    }
                    else {
                        int hurt = ch1.Attack(ch2);
                        JOptionPane.showMessageDialog(j, ch1.name + "採取了普通攻擊，對" + ch2.name + "造成" + hurt + "點傷害!", "刀劍神域Online", 0);
                        if (ch1.cd > 0) ch1.cd--;
                    }    
                    ch1.status = 1;          
                }
                else if (ch1.status == 0 && ch1.hp > 0) ch1.status = 1;
            }
            
            if (boss.hp == 0) End_of_the_Game(1);
            //Round for ch2
            if (ch2.hp > 0){
                if (ch2.status == 1){
                    if(ch2.name == "Kirito") ch2.updateATK(ch2.hp);
                    int opt2 = Show_information(2);
                    while (opt2 == 1 && ch2.cd > 0){
                        JOptionPane.showMessageDialog(j, "技能尚在冷卻，請選擇其他選項", "刀劍神域Online", 0);
                        opt2 = Show_information(2);
                    }
                    if (opt2 == 0) { //ch2 attack
                        int hurt = ch2.Attack(boss);
                        JOptionPane.showMessageDialog(j, ch2.name + "採取了普通攻擊，造成" + hurt + "點傷害!", "刀劍神域Online", 0);
                        if (ch2.cd > 0) ch2.cd--;
                    }
                    else if (opt2 == 1){ //ch2 skill
                        if (ch2.name == "Klein") ch2.Skill(boss);
                        else if (ch2.name == "Shino" && ch1.hp > ch2.hp) ch2.Skill(ch2, boss);
                        else if (ch2.name == "Shino" && ch1.hp < ch2.hp) ch2.Skill(ch1, boss);
                        else ch2.Skill(ch1);
                        ch2.ResetCD();
                    }
                    else System.exit(0);
                }
                else if (ch2.status == 2){
                    if (ch2.cd == 0 && ch2.name != "Kirito") {
                        if (ch2.name == "Klein") ch2.Skill(ch1);
                        else if (ch2.name == "Shino" && ch1.hp > ch2.hp) ch2.Skill(boss, ch2);
                        else if (ch2.name == "Shino" && ch1.hp < ch2.hp) ch2.Skill(boss, ch1);
                        else ch2.Skill(boss);
                        ch2.ResetCD();
                    }
                    else{
                        int hurt = ch2.Attack(ch1);
                        JOptionPane.showMessageDialog(j, ch2.name + "採取了普通攻擊，對" + ch1.name + "造成" + hurt + "點傷害!", "刀劍神域Online", 0);
                        if (ch2.cd > 0) ch2.cd--;
                    }     
                    ch2.status = 1; 
                }
                else if (ch2.status == 0 && ch2.hp > 0) ch2.status = 1;
            }
            
            //Round for boss
            if (boss.status == 2){
                JOptionPane.showMessageDialog(j, "當前角色資訊：\n\n" + ch1.name + "\n\t生命值: " + ch1.hp + " 攻擊力: " + ch1.atk + " 防禦力: " + ch1.dfs + "\n\t剩餘冷卻回合: " + ch1.cd
                + "\n\n" + ch2.name + "\n\t生命值: " + ch2.hp + " 攻擊力: " + ch2.atk + " 防禦力: " + ch2.dfs + "\n\t剩餘冷卻回合: " + ch2.cd
                + "\n\n" + boss.name + "\n\t生命值: " + boss.hp + " 攻擊力: " + boss.atk + " 防禦力: " + boss.dfs + "\n\t剩餘冷卻回合: " + boss.cd
                , "刀劍神域Online", 0);
                
                if (boss.cd > 0){ //boss attack
                    int hurt1 = boss.Attack(ch1);
                    JOptionPane.showMessageDialog(j, boss.name + "採取了普通攻擊，對" + ch1.name + "造成" + hurt1 + "點傷害!", "刀劍神域Online", 0);
                    int hurt2 = boss.Attack(ch2);
                    JOptionPane.showMessageDialog(j, boss.name + "採取了普通攻擊，對" + ch2.name + "造成" + hurt2 + "點傷害!", "刀劍神域Online", 0);
                    boss.cd--;
                }
                else {
                    int r = (int)(Math.random()*2)+1; //choose randomly between 1 and 2
                    if (r == 1) boss.Skill(ch1);
                    else boss.Skill(ch2);
                    boss.ResetCD();
                }
            }
            else if (boss.status == 0) boss.status = 2;
        }
        if (boss.hp == 0) End_of_the_Game(1);
        else if (ch1.hp == 0 && ch2.hp == 0) End_of_the_Game(0);
    }

    public static int Show_information(int round){
        int opt = 0;
        String buttons[] = {"普通攻擊", "施放技能", "退出遊戲"};
        String buttonsk[] = {"普通攻擊", "退出遊戲"};
        String name[] = {ch1.name, ch2.name, boss.name};
        JFrame j = new JFrame();
        if (name[round-1] == "Kirito"){
            opt = JOptionPane.showOptionDialog(j, "當前角色資訊：\n\n" + ch1.name + "\n\t生命值: " + ch1.hp + " 攻擊力: " + ch1.atk + " 防禦力: " + ch1.dfs + "\n\t剩餘冷卻回合: " + ch1.cd
         + "\n\n" + ch2.name + "\n\t生命值: " + ch2.hp + " 攻擊力: " + ch2.atk + " 防禦力: " + ch2.dfs + "\n\t剩餘冷卻回合: " + ch2.cd
         + "\n\n" + boss.name + "\n\t生命值: " + boss.hp + " 攻擊力: " + boss.atk + " 防禦力: " + boss.dfs + "\n\t剩餘冷卻回合: " + boss.cd
         + "\n\n現在是" + name[round-1] + "的回合，請選擇以下動作進行攻擊："
        , "刀劍神域Online", 0, 0, null, buttonsk, buttonsk[0]);
        }
        opt = JOptionPane.showOptionDialog(j, "當前角色資訊：\n\n" + ch1.name + "\n\t生命值: " + ch1.hp + " 攻擊力: " + ch1.atk + " 防禦力: " + ch1.dfs + "\n\t剩餘冷卻回合: " + ch1.cd
         + "\n\n" + ch2.name + "\n\t生命值: " + ch2.hp + " 攻擊力: " + ch2.atk + " 防禦力: " + ch2.dfs + "\n\t剩餘冷卻回合: " + ch2.cd
         + "\n\n" + boss.name + "\n\t生命值: " + boss.hp + " 攻擊力: " + boss.atk + " 防禦力: " + boss.dfs + "\n\t剩餘冷卻回合: " + boss.cd
         + "\n\n現在是" + name[round-1] + "的回合，請選擇以下動作進行攻擊："
        , "刀劍神域Online", 0, 0, null, buttons, buttons[0]);
        return opt;
    }

    public static void End_of_the_Game(int result){
        JFrame j = new JFrame();
        String buttons[] = {"回到主畫面", "退出遊戲"};
        if (result == 0) { //lose
            int opt = JOptionPane.showOptionDialog(j, "YOU LOSE\n很不幸的，這次遊戲中你沒能打敗大boss\n不要氣餒，相信你一定能好星有好爆", "刀劍神域Online", 0, 0, null, buttons, buttons[0]);
            if (opt == 0) Menu();
            else System.exit(0);  
        }
        else { //win
            int win_money = 0;
            if (ch1.hp > 0 && ch2.hp > 0) win_money = 300;
            else win_money = 250;
            money += win_money;
            int opt = JOptionPane.showOptionDialog(j, "Congradulations!\n你成功打敗了大boss茅場晶彥，解救了被困在SAO裡的玩家們\n你獲得了通關獎勵：" + win_money + "金幣", "刀劍神域Online", 0, 0, null, buttons, buttons[0]);
            if (opt == 0) Menu();
            else System.exit(0);     
        }
    }

    public static void Set_Character(int pick1, int pick2){
        Asuna asuna = new Asuna();
        Klein klein = new Klein();
        Yui yui = new Yui();
        Kirito kirito = new Kirito();
        Shino shino = new Shino();
        Boss enemy = new Boss();
        
        boss = enemy;
        boss.name = enemy.name;
        boss.hp = enemy.hp;
        boss.atk = enemy.atk;
        boss.dfs = enemy.dfs;
        boss.cd = 5;
        boss.status = enemy.status;

        if (pick1 == 1){
            ch1 = asuna;
            ch1.name = asuna.name;
            ch1.hp = asuna.hp;
            ch1.atk = asuna.atk;
            ch1.dfs = asuna.dfs;
            ch1.cd = asuna.cd;
        }
        else if (pick1 == 2){
            ch1 = klein;
            ch1.name = klein.name;
            ch1.hp = klein.hp;
            ch1.atk = klein.atk;
            ch1.dfs = klein.dfs;
            ch1.cd = klein.cd;
        }
        else if (pick1 == 3){
            ch1 = yui;
            ch1.name = yui.name;
            ch1.hp = 900;
            ch1.atk = yui.atk;
            ch1.dfs = yui.dfs;
            ch1.cd = yui.cd;
        }
        else if (pick1 == 4){
            ch1 = kirito;
            ch1.name = kirito.name;
            ch1.hp = kirito.hp;
            ch1.atk = kirito.atk;
            ch1.dfs = kirito.dfs;
            ch1.cd = kirito.cd;
        }
        if (pick2 == 2){
            ch2 = klein;
            ch2.name = klein.name;
            ch2.hp = klein.hp;
            ch2.atk = klein.atk;
            ch2.dfs = klein.dfs;
            ch2.cd = klein.cd;
        }
        else if (pick2 == 3){
            ch2 = yui;
            ch2.name = yui.name;
            ch2.hp = 900;
            ch2.atk = yui.atk;
            ch2.dfs = yui.dfs;
            ch2.cd = yui.cd;
        }
        else if (pick2 == 4){
            ch2 = kirito;
            ch2.name = kirito.name;
            ch2.hp = kirito.hp;
            ch2.atk = kirito.atk;
            ch2.dfs = kirito.dfs;
            ch2.cd = kirito.cd;
        }
        else if (pick2 == 5){
            ch2 = shino;
            ch2.name = shino.name;
            ch2.hp = shino.hp;
            ch2.atk = shino.atk;
            ch2.dfs = shino.dfs;
            ch2.cd = shino.cd;
        }
    }

}
