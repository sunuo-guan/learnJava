import java.awt.*;
import javax.swing.*;

public class BallGame2 extends JFrame {
	
	Image ball = Toolkit.getDefaultToolkit().getImage("image/ball.jpg");
	Image desk = Toolkit.getDefaultToolkit().getImage("image/desk.jpg");
	
	double x=100;  //������
	double y=100;  //������
	
	double degree = 3.14/3;   //����
	
	//�����ڵķ���
	public void paint(Graphics g) {
		System.out.println("������һ��");
		g.drawImage(desk,0,0,null);
		g.drawImage(ball,(int)x,(int)y,null);
		
		x = x + 10 * Math.cos(degree);
		y = y + 10 * Math.sin(degree);
		
		if(y>500-40||y<40) {
			degree = -degree;
		}
		
		if(x<0||x>856) {
			degree = 3.14 - degree;
		}
	}
	
	//���ڼ���
	void launchFrame() {
		setSize(856,500);
		setLocation(200,200);
		setVisible(true);
	
		//�ػ�
		while(true) {
			repaint();
			try {
				Thread.sleep(40);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		BallGame2 game = new BallGame2();
		game.launchFrame();
	}
}
