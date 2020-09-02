import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame {
	
	Image ball = Toolkit.getDefaultToolkit().getImage("image/ball.jpg");
	Image desk = Toolkit.getDefaultToolkit().getImage("image/desk.jpg");
	
	double x=100;  //横坐标
	double y=100;  //纵坐标
	boolean right=true;  //方向
	
	//画窗口的方法
	public void paint(Graphics g) {
		System.out.println("被划了一次");
		g.drawImage(desk,0,0,null);
		g.drawImage(ball,(int)x,(int)y,null);
		
		if(right) {
			x=x+50;
		}else {
			x=x-50;
		}
		if(x>856) {
			right = false;
		}
		if(x<0) {
			right = true;
		}
	}
	
	//窗口加载
	void launchFrame() {
		setSize(856,500);
		setLocation(200,200);
		setVisible(true);
	
		//重画
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
		BallGame game = new BallGame();
		game.launchFrame();
		
		
	}
}
