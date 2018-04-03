import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JPanel implements ActionListener
{
	SlotMachine slot;
	JButton spinButton;
	JButton bet1Button;
	JButton bet2Button;
	JButton bet3Button;

	int bet;

	public Screen()
	{
		this.setLayout(null);

		slot = new SlotMachine(100);

		spinButton = new JButton("Spin");
		spinButton.setBounds(300, 540, 200, 50);
		spinButton.addActionListener(this);
		this.add(spinButton);

		bet1Button = new JButton("Bet 1");
		bet1Button.setBounds(50, 470, 200, 50);
		bet1Button.addActionListener(this);
		this.add(bet1Button);


		bet2Button = new JButton("Bet 5");
		bet2Button.setBounds(300, 470, 200, 50);
		bet2Button.addActionListener(this);
		this.add(bet2Button);


		bet3Button = new JButton("Bet 10");
		bet3Button.setBounds(550, 470, 200, 50);
		bet3Button.addActionListener(this);
		this.add(bet3Button);

		this.setFocusable(true);
	}

	public Dimension getPreferredSize()
	{
		return new Dimension(800,600);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		slot.drawMe(g);
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == spinButton)
		{
			if (slot.getBet() == 0)
			{

			}
			else if (slot.getBalance() == 0)
			{

			}
			else
			{
			slot.play();
			bet = slot.setBet(0);
			}
		}
		else if (e.getSource() == bet1Button)
		{
			if (slot.getBet() == 0)
			{
				bet = slot.setBet(1);
				slot.editBalance(bet);
				slot.playSoundSelect();
			}
		}
		else if (e.getSource() == bet2Button)
		{
			if (slot.getBet() == 0)
			{
				bet = slot.setBet(5);
				slot.editBalance(bet);
				slot.playSoundSelect();
			}
		}
		else if (e.getSource() == bet3Button)
		{
			if (slot.getBet() == 0)
			{
				bet = slot.setBet(10);
				slot.editBalance(bet);
				slot.playSoundSelect();
			}
		}
		repaint();

	}
}