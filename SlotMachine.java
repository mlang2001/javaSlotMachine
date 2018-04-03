import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SlotMachine
{
	int num1, num2, num3, bet, winnings, balance;
	boolean win, start;
	public SlotMachine(int balance)
	{
		this.balance = balance;
		num1 = 0;
		num2 = 0;
		num3 = 0;
		bet = 0;
		winnings = 1;
		win = false;
		start = false;
	}
	public void playSoundWin() {
        try {
            URL url = this.getClass().getClassLoader().getResource("Sound/win.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
    public void playSoundLose() {
 
        try {
            URL url = this.getClass().getClassLoader().getResource("Sound/lose.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
    public void playSoundSelect() {
 
        try {
            URL url = this.getClass().getClassLoader().getResource("Sound/select.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
	public void drawMe(Graphics g)
	{
		Color blue = new Color(0, 0, 200);
		Color white = new Color(255, 255, 255);
		Color red = new Color(255, 0, 0);

		Font title = new Font("Impact", Font.BOLD, 50);
		Font numbers = new Font("Impact", Font.BOLD, 200);
		Font text = new Font("Impact", Font.PLAIN, 30);

		g.setColor(blue);
		g.fillRect(0, 0, 800, 600);

		g.setColor(white);
		g.fillRect(50, 150, 200, 300);
		g.fillRect(300, 150, 200, 300);
		g.fillRect(550, 150, 200, 300);

		g.setFont(title);
		g.drawString("CS Slots", 320, 100);

		g.setFont(numbers);
		g.setColor(red);
		g.drawString(num1 + " ", 95, 375);
		g.drawString(num2 + " ", 345, 375);
		g.drawString(num3 + " ", 595, 375);

		g.setFont(text);
		g.drawString("Balance: " + balance, 50, 100);

		if (balance == 0)
		{
			g.drawString("You are now broke!", 50, 50);

		}
		if (win == true && start == true)
		{
			g.drawString("You win " + winnings + " points!", 50, 50);
			this.playSoundWin();
			win = false;
			start = false;
		}
		else if (start == true && win == false)
		{
			g.drawString("You don't win anything!", 50, 50);
			this.playSoundLose();
			start = false;
		}
	}
	public void play()
	{
		num1 = (int)(Math.random() * 9 + 1);
		num2 = (int)(Math.random() * 9 + 1);
		num3 = (int)(Math.random() * 9 + 1);
		if (num1 == 7 && num2 == num1 && num3 == num2)
		{
			winnings =  bet * 100;
			bet = 0;
			win = true;
			start = true;
		}
		else if (num1 == num2 && num2 == num3)
		{
			winnings = bet * 5;
			bet = 0;
			win = true;
			start = true;

		}
		else if ((num1 == num2 && num2 != num3) || (num1 == num3 && num1 != num2) || (num2 == num3 && num1 != num2))
		{
			winnings = bet * 2;
			bet = 0;
			win = true;
			start = true;
		}
		else
		{
			winnings = 0;
			win = false;
			start = true;
		}
		balance = balance + winnings;
	}
	public int setBet(int bet)
	{
		this.bet = bet;
		return bet;
	}
	public int getBet()
	{
		return bet;
	}
	public int getBalance()
	{
		return balance;
	}
	public void editBalance(int bet)
	{
		balance = balance - bet;
	}
}