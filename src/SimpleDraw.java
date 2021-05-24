import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 */

/**
 * @author arisa0328
 *
 */
public class SimpleDraw extends JFrame implements MouseListener, MouseMotionListener,ActionListener{
	private static final long serialVersionUID = 1L;
	int  newx, newy,lastx,lasty,nowx,nowy,newx2,newy2,lastx2,lasty2;
	DrawPanel panel;
	JFileChooser fileChooser;
	JButton button;
	JColorChooser colorchooser;
Color color3=Color.white;
BufferedImage bufferImage=null;
Graphics2D bufferGraphics=null;
JPanel panel2,panel3;
int a=10,b=10,flag=0,d=0,f=0,g=1,h=1,z=20,i=30,j=0;
Color color=Color.black;
JToolBar toolBar;
BufferedImage bufferedImage = null;


	@Override
	public void mouseDragged(MouseEvent e) {
		if(g==1) {

			newx=e.getX()-160;
			newy=e.getY()-50;
		panel.drawLine(lastx,lasty,newx,newy);
		lastx=newx;
		lasty=newy;
		}

		if(f==1) {
			newx2=e.getX()-160;
			newy2=e.getY()-50;
			//System.out.println("a");
			if(((newx2-lastx2)+(newy2-lasty2))>=i||((newx2-lastx2)+(newy2-lasty2))<=-i) {
				if(h==1) {
				panel.korokoro(newx2,newy2,z);
				}else if(h==0) {
					panel.korokoro2(newx2,newy2,z);
				}else {
					panel.korokoro3(newx2,newy2,z);
				}
				System.out.println(newy2);
				lastx2=newx2;
				lasty2=newy2;

			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if(d==1) {
			//System.out.println("a");
			nowx=e.getX();
			nowy=e.getY();
			panel.stamp(bufferedImage,nowx,nowy);
			d=0;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(g==1) {
		// TODO 自動生成されたメソッド・スタブ
		lastx=e.getX()-160;
		lasty=e.getY()-50;
		}
		if(f==1) {
			lastx2=e.getX();
			lasty2=e.getY();
		}
		if(j==1) {
			panel.flag1();
		}


	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(f==1) {
			f=0;
			g=1;

		}
		if(j==1) {
			panel.flag0();

			j=0;


		}
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}
	private void addMenuItem
	(JMenu targetMenu, String itemName, String actionName, ActionListener listener) {
		JMenuItem menuItem = new JMenuItem(itemName);
		menuItem.setActionCommand(actionName);
		menuItem.addActionListener(listener);
		targetMenu.add(menuItem);
	}
	private void addMenuItem2
	(JMenu targetMenu, String itemName, String actionName, ActionListener listener,ImageIcon icon) {
		JMenuItem menuItem = new JMenuItem(itemName);
		menuItem.setActionCommand(actionName);
		menuItem.addActionListener(listener);
		targetMenu.add(menuItem);
		menuItem.setIcon(icon);
	}
	public void initialize() {
		JMenuBar menubar=new JMenuBar();
		JMenu menuFile = new JMenu("File");
		this.addMenuItem(menuFile,"New","New",this);
		this.addMenuItem(menuFile,"Open","Open",this);
		this.addMenuItem(menuFile,"Save","Save",this);
		menubar.add(menuFile);
		JMenu menuPen = new JMenu("Pen");
		ImageIcon icon102=new ImageIcon("./src/photo/iroenpitsu.png");
		JMenu menuColor=new JMenu("Color");
		ImageIcon icon112=new ImageIcon("./src/photo/black.png");
		ImageIcon icon122=new ImageIcon("./src/photo/gray.png");
		ImageIcon icon132=new ImageIcon("./src/photo/blue.png");
		ImageIcon icon142=new ImageIcon("./src/photo/green.png");
		ImageIcon icon152=new ImageIcon("./src/photo/yellow.png");
		ImageIcon icon162=new ImageIcon("./src/photo/orange.png");
		ImageIcon icon172=new ImageIcon("./src/photo/pink.png");
		ImageIcon icon182=new ImageIcon("./src/photo/red.png");
		ImageIcon icon192=new ImageIcon("./src/photo/white.png");
		this.addMenuItem2(menuColor, "use the palet", "palet",this,icon102);
		this.addMenuItem2(menuColor, "black", "black",this,icon112);

		this.addMenuItem2(menuColor, "gray", "gray",this,icon122);
		this.addMenuItem2(menuColor, "blue", "blue",this,icon132);
		this.addMenuItem2(menuColor, "green", "green",this,icon142);
		this.addMenuItem2(menuColor, "yellow", "yellow",this,icon152);
		this.addMenuItem2(menuColor, "orange", "orange",this,icon162);
		this.addMenuItem2(menuColor, "pink", "pink",this,icon172);
		this.addMenuItem2(menuColor, "red", "red",this,icon182);
		this.addMenuItem2(menuColor, "white", "white",this,icon192);

		JMenu menuWidth = new JMenu("Width");
		this.addMenuItem(menuWidth, "width1", "width1", this);
		this.addMenuItem(menuWidth, "width5", "width5", this);
		this.addMenuItem(menuWidth, "width10", "width10", this);
		this.addMenuItem(menuWidth, "width20", "width20", this);
		menuPen.add(menuWidth);
		menuPen.add(menuColor);
		menubar.add(menuPen);
		JMenu menuEraser =new JMenu("Eraser");

		JMenu menuWidth2 = new JMenu("Width");
		this.addMenuItem(menuWidth2, "width1", "width12", this);
		this.addMenuItem(menuWidth2, "width5", "width52", this);
		this.addMenuItem(menuWidth2, "width10", "width102", this);
		this.addMenuItem(menuWidth2, "width20", "width202", this);
		menuEraser.add(menuWidth2);
		menubar.add(menuEraser);


		JMenu menuSticker=new JMenu("Sticker");
		ImageIcon icon32=new ImageIcon("./src/photo/pine.png");
		ImageIcon icon12=new ImageIcon("./src/photo/melon.png");
		ImageIcon icon22=new ImageIcon("./src/photo/grape.png");
		ImageIcon icon42=new ImageIcon("./src/photo/suika.png");
		ImageIcon icon52=new ImageIcon("./src/photo/ichigo.png");
		this.addMenuItem2(menuSticker,"melonbaby","melonbaby",this,icon12);
		this.addMenuItem2(menuSticker,"grapebaby","grapebaby",this,icon22);
		this.addMenuItem2(menuSticker,"pinebaby","pinebaby",this,icon32);
		this.addMenuItem2(menuSticker,"suikababy","suikababy",this,icon42);
		this.addMenuItem2(menuSticker,"ichigobaby","ichigobaby",this,icon52);
		menubar.add(menuSticker);

		JMenu menuKorokoro=new JMenu("Korokorostamp");
		ImageIcon icon72=new ImageIcon("./src/photo/heart.png");
		ImageIcon icon82=new ImageIcon("./src/photo/star.png");
		ImageIcon icon92=new ImageIcon("./src/photo/snow.png");
		this.addMenuItem2(menuKorokoro, "Heart", "Heart", this,icon72);
		this.addMenuItem2(menuKorokoro, "Star", "Star", this,icon82);
		this.addMenuItem2(menuKorokoro, "Snow", "Snow", this,icon92);
		JMenu menuWidth3 = new JMenu("Width");
		this.addMenuItem(menuWidth3, "width10", "width103", this);
		this.addMenuItem(menuWidth3, "width20", "width203", this);
		this.addMenuItem(menuWidth3, "width40", "width403", this);
		this.addMenuItem(menuWidth3, "width60", "width603", this);
		menuKorokoro.add(menuWidth3);
		menubar.add(menuKorokoro);

		JMenu menuWeirdpen=new JMenu("Rainbow");
		ImageIcon icon62=new ImageIcon("./src/photo/rainbow.png");
		this.addMenuItem2(menuWeirdpen, "rainbowpen", "rainbowpen", this,icon62);
		menubar.add(menuWeirdpen);
		ImageIcon icon202=new ImageIcon("./src/photo/fill.png");
		JMenu menuBackground=new JMenu("Fill back");
		this.addMenuItem2(menuBackground, "choose the color", "palet2", this,icon202);
		menubar.add(menuBackground);

		JMenu menuText=new JMenu("Text");
		//menuText.setActionCommand("text");
		this.addMenuItem(menuText,"make","make",this);
		menubar.add(menuText);


		menubar.setLayout(new FlowLayout());
		this.setJMenuBar(menubar);




		this.setTitle("お絵かきプログラム");



		this.setSize(900,620);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
		if(command == "New"){
			panel.setBackground2(Color.white);
		}

		if(command=="black") {
			color=Color.black;
			panel.setPenColor(color);
		}

		if(command=="gray") {
			color=Color.gray;
			panel.setPenColor(color);
		}
		if(command=="blue") {
			color=Color.blue;
			panel.setPenColor(color);
		}
		if(command=="green") {
			color=Color.green;
			panel.setPenColor(color);
		}

		if(command=="yellow") {
			color=Color.yellow;
			panel.setPenColor(color);
		}
		if(command=="orange") {
			color=Color.orange;
			panel.setPenColor(color);
		}
		if(command=="pink") {
			color=Color.pink;
			panel.setPenColor(color);
		}
		if(command=="red") {
			color=Color.red;
			panel.setPenColor(color);
		}
		if(command=="white") {
			color=Color.white;
			panel.setPenColor(color);
		}

		if(command=="palet") {






		 color = colorchooser.showDialog(this,"choose a color",panel.getPenColor());
 	    panel.setPenColor(color);






		}
		if(command=="palet2") {






			 color3 = colorchooser.showDialog(this,"choose a color",panel.getBackColor());
			 //color2=color3;
			 panel.setBackground2(color3);
	 	    //panel.setBackground(color3);
	 	  }
		if(command=="width1") {
			a=1;
			panel.setPenWidth(a);
		}
		if(command=="width5") {
			a=5;
			panel.setPenWidth(a);
		}
		if(command=="width10") {
			a=10;
			panel.setPenWidth(a);
		}
		if(command=="width20") {
			a=20;
			panel.setPenWidth(a);
		}
		if(command=="width12") {
			b=1;
			panel.setPenColor(color3);
			panel.setPenWidth(b);
		}
		if(command=="width32") {
			b=3;
			panel.setPenColor(color3);
			panel.setPenWidth(b);
		}
		if(command=="width52") {
			b=5;
			panel.setPenColor(color3);
			panel.setPenWidth(b);
		}
		if(command=="width102") {
			b=10;
			panel.setPenColor(color3);
			panel.setPenWidth(b);
		}
		if(command=="width202") {
			b=20;
			panel.setPenColor(color3);
			panel.setPenWidth(b);
		}
		if(command=="width103") {
			z=10;
			i=20;
		}
		if(command=="width203") {
			z=20;
			i=30;
		}
		if(command=="width403") {
			z=40;
			i=50;
		}
		if(command=="width603") {
			z=60;
			i=80;
		}

		if(command=="Open") {
			int returnVal = fileChooser.showOpenDialog(this);
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	        panel.openFile(fileChooser.getSelectedFile());
	        }
		}
		if(command=="Save") {
			int returnVal = fileChooser.showSaveDialog(this);
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	        	panel.saveFile(fileChooser.getSelectedFile());
	        }
		}
	        if(command=="save") {
				int returnVal = fileChooser.showSaveDialog(this);
		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		        	panel.saveFile(fileChooser.getSelectedFile());
		        }
		}
	        if(command=="rainbowpen") {
	        	j=1;
	        	panel.run2();

	        }
	        if(command=="pen") {
	        	panel.setPenWidth(a);
	        	panel.setPenColor(color);
	        }
	        if(command=="eraser") {
	        	panel.setPenWidth(b);
	        	panel.setPenColor(color3);
	        }
	        if(command=="melonbaby") {
	        	d=1;

	        	try {
	        	 bufferedImage = ImageIO.read(new File("./src/photo/nyanya1.png"));
	        	}catch(IOException ee) {
	        		System.out.println("image file not found.");
	            }




	        }
	        if(command=="grapebaby") {
	        	d=1;

	        	try {
	        	 bufferedImage = ImageIO.read(new File("./src/photo/nyanya2.png"));
	        	}catch(IOException ee) {
	        		System.out.println("image file not found.");//[107]
	            }




	        }
	        if(command=="pinebaby") {
	        	d=1;

	        	try {
	        	 bufferedImage = ImageIO.read(new File("./src/photo/nyanya3.png"));
	        	}catch(IOException ee) {
	        		System.out.println("image file not found.");//[107]
	            }



	        }
	        if(command=="suikababy") {
	        	d=1;

	        	try {
	        	 bufferedImage = ImageIO.read(new File("./src/photo/nyanya4.png"));
	        	}catch(IOException ee) {
	        		System.out.println("image file not found.");//[107]
	            }




	        }
	        if(command=="ichigobaby") {
	        	d=1;

	        	try {
	        	 bufferedImage = ImageIO.read(new File("./src/photo/nyanya5.png"));
	        	}catch(IOException ee) {
	        		System.out.println("image file not found.");//[107]
	            }


	        	//panel.stamp(bufferedImage,nowx*10,nowy*10);

	        }
	        if(command=="sticker") {
	        	d=1;

	        }
	        if(command=="Heart") {
	        	h=1;
	        	g=0;
	        f=1;


	        }
	        if(command=="Star") {
	        	h=0;
	        	g=0;
	        f=1;


	        }
	        if(command=="Snow") {
	        	h=2;
	        	g=0;
	        f=1;


	        }
	       if(command=="redo") {
	        panel.setBackground2(Color.white);

	        }
	        if(command=="make") {
	        	Color color4=null;

	        	JLabel ansLabel=null;
	        	 String value = JOptionPane.showInputDialog(this, "入力するText");

	        	    if (value == null){
	        	    	return;
	        	    }else{

	        	    	 String value2 = JOptionPane.showInputDialog(this, "x座標");
	        	    	if(value2==null) {
	        	    		return;
	        	    	}else {
	        	    		String value3 = JOptionPane.showInputDialog(this, "y座標");
	        	    		if(value3==null) {
	        	    			return;
	        	    		}
	        	    		else {
	        	    			String value4 = JOptionPane.showInputDialog(this, "fontsize");
	        	    			if(value4==null) {
	        	    				return;
	        	    			}
	        	    			else {
	        	    				color4 = colorchooser.showDialog(this,"choose a color",Color.white);
	        	    				if(color4==null) {
	        	    					return;
	        	    				}else {


	        	    			int num1=Integer.parseInt(value2)+50;
	        	    			int num2=Integer.parseInt(value3)+50;
	        	    			int num3=Integer.parseInt(value4);
	        	    			panel.setText(value,num1,num2,num3,color4);

	        	    		}
	        	    	}


	        	    }
	        	    	}
	        	    }


	        }
		}
	public void toolbar() {
		 panel2=new JPanel();
		 panel3=new JPanel();

		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		ImageIcon icon202=new ImageIcon("./src/photo/nya1.png");
		JLabel label1 = new JLabel(icon202);
		panel3.add(label1);

		ImageIcon icon1 = new ImageIcon("./src/photo/nya1.png");
			JButton btn = new JButton("pen",icon1);
			btn.setAlignmentX(Component.CENTER_ALIGNMENT);

			btn.setFont(new Font("Farah", Font.BOLD, 18));
			ImageIcon icon2=new ImageIcon("./src/photo/nya2.png");
		JButton btn2 = new JButton("eraser",icon2 );
		btn2.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn2.setFont(new Font("Farah", Font.BOLD, 18));
		ImageIcon icon3=new ImageIcon("./src/photo/nya3.png");
		JButton btn3 = new JButton("save",icon3 );
		btn3.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn3.setFont(new Font("Farah", Font.BOLD, 18));
		ImageIcon icon4=new ImageIcon("./src/photo/nya4.png");
		JButton btn4 = new JButton("redo" ,icon4);
		btn4.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn4.setFont(new Font("Farah", Font.BOLD, 18));
		ImageIcon icon5=new ImageIcon("./src/photo/nya5.png");

		JButton btn5 = new JButton("sticker" ,icon5);

		btn5.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn5.setFont(new Font("Farah", Font.BOLD, 18));
		btn.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
			panel2.add(btn);
			panel2.add(btn2);
			panel2.add(btn3);
			panel2.add(btn4);
			panel2.add(btn5);
			panel2.setBackground(new Color(232,211,209));



	}



	private void init() {
		this.setTitle("Simple Draw");
		this.setSize(900, 620);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		panel=new DrawPanel();
		panel.createBuffer(2000,2000);
		this.toolbar();
		 try {
			bufferedImage = ImageIO.read(new File("./src/photo/nyanya1.png"));
		} catch (IOException ee) {
			// TODO 自動生成された catch ブロック

			System.out.println("image file not found.");
		}
		//panel.setBackground2(Color.white);
		 colorchooser = new JColorChooser();
		fileChooser = new JFileChooser();


		//panel.setBackground(Color.white);



this.getContentPane().add(panel,BorderLayout.CENTER);




		this.getContentPane().add(panel2,BorderLayout.WEST);
		//this.getContentPane().add(panel3,BorderLayout.EAST);
		this.setVisible(true);
		this.initialize();



		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		SimpleDraw frame=new SimpleDraw();
		frame.init();

	}

}
