import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 */

/**
 * @author arisa0328
 *
 */
public class DrawPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	Float currentWidth=10f;
Color currentColor=Color.black;
Color currentColor2=Color.black;
Color currentBackground=Color.white;
BufferedImage bufferImage=null;
Graphics2D bufferGraphics=null;
int j=0;

public void createBuffer(int width, int height) {
    
		bufferImage = new BufferedImage(width, height,BufferedImage.TYPE_INT_BGR);
		bufferGraphics=bufferImage.createGraphics(); 
		bufferGraphics.setBackground(Color.white);

		
		bufferGraphics.clearRect(0, 0, width, height); //バッファクリア

	}
	public void drawLine(int x1, int y1, int x2, int y2){
		if(null==bufferGraphics) {
		 	this.createBuffer(this.getWidth(),this.getHeight()); 
		}
		
		
				bufferGraphics.setStroke(new BasicStroke(currentWidth ,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
		bufferGraphics.setColor(currentColor);
		
if(j==1) {
	bufferGraphics.setColor(currentColor2);
}
		bufferGraphics.drawLine(x1, y1, x2, y2);
		repaint();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(null!=bufferImage) g.drawImage(bufferImage, 0,0,this);
	}
	public void setPenColor(Color newColor) {
		currentColor = newColor;
	}
	public void setBackground2(Color newBackground) {
		currentBackground=newBackground;
		
	     bufferGraphics.setColor(currentBackground);
		  bufferGraphics.fillRect(0, 0, 1000, 1000 );
		
		  repaint();
	}
	public void stamp(BufferedImage sticker,int x,int y) {
		
	    bufferGraphics.drawImage(sticker, x-220, y-130, null);
	    repaint();
	}
	public Color getBackColor() {
		return currentBackground;
	}
	public Color getPenColor() {
		return currentColor;
	}
	public void setPenWidth(float newWidth) {
		currentWidth = newWidth;
	}
	public void setText(String newString,int a,int b ,int c,Color color) {
		bufferGraphics.setColor(color);
		
	String  currentString=null;
		currentString=newString;
		bufferGraphics.setFont(new Font("Hiragino Maru Gothic Pro W4", Font.BOLD, c));
		bufferGraphics.drawString(currentString, a, b);
		repaint();
	}
	
	public void korokoro(int x,int y,int z) {
		bufferGraphics.setColor(currentColor);
		bufferGraphics.setStroke(new BasicStroke(currentWidth ,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
		bufferGraphics.setFont(new Font("Hiragino Maru Gothic Pro W4", Font.PLAIN, z));
		bufferGraphics.drawString("♡", x, y);
		repaint();
		
	}
	public void korokoro2(int x,int y,int z) {
		bufferGraphics.setColor(currentColor);
		bufferGraphics.setStroke(new BasicStroke(currentWidth ,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
		bufferGraphics.setFont(new Font("Hiragino Maru Gothic Pro W4", Font.BOLD, z));
		bufferGraphics.drawString("☆", x, y);
		repaint();
		
	}
	public void korokoro3(int x,int y,int z) {
		bufferGraphics.setColor(currentColor);
		bufferGraphics.setStroke(new BasicStroke(currentWidth ,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER));
		bufferGraphics.setFont(new Font("Hiragino Maru Gothic Pro W4", Font.BOLD, z));
		bufferGraphics.drawString("✳︎", x, y);
		repaint();
		
	}
	public void flag1() {
		j=1;
	}
	public void flag0() {
		j=0;
	}
	public void openFile(File file2open){
		BufferedImage pictureImage;
		try {
			pictureImage = ImageIO.read(file2open);
		 
		} catch(Exception e){
			System.out.println("Error: reading file="+file2open.getName());
			return;
		}

		this.createBuffer(pictureImage.getWidth(),pictureImage.getHeight());
		bufferGraphics.drawImage(pictureImage,0,0,this);
		repaint();
	}
	public void saveFile(File file2save) {
		try {
			ImageIO.write(bufferImage, "jpg", file2save);
		} catch (Exception e) {
			System.out.println("Error: writing file="+file2save.getName());
			return;
		}
	}
	public void run2() {
		Timer timer = new Timer(false);
		TimerTask task = new TimerTask() {
			
			public void run() {
			long beforeTime = System.currentTimeMillis();
			int cnt=0;
		long t = System.currentTimeMillis();
		int R=(int)(Math.random()*1000%256);
	      int G=(int)(Math.random()*1000%256);
	      int B=(int)(Math.random()*1000%256);
	      currentColor2=new Color(R,G,B);
		
		beforeTime = System.currentTimeMillis();
			}
		};
		timer.scheduleAtFixedRate(task, 0, 50);	
}
	
}


