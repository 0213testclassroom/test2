import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel {
	private BufferedImage image;
	
	public void setImage(BufferedImage img){
		this.image=img;
		if(image!=null) 
			setPreferredSize(new Dimension(image.getWidth(),image.getHeight()));
		else
			setPreferredSize(null);
		repaint();
		System.out.println("aiueo!");
	}	
	@Override 
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image,0,0,null);
		System.out.println("aiueo");
	}
}
