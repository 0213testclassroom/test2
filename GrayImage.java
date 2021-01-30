import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GrayImage extends BufferedImage {
	
	public GrayImage(BufferedImage img) {
		super(img.getWidth(),img.getHeight(),TYPE_BYTE_GRAY);
		Graphics g = getGraphics();
		g.drawImage(img, 0, 0, null);
	}
	public int getGray(int x, int y) {
		return getRGB(x,y) & 0xff;
	}
	public void setGray(int x, int y,int gray) {
		setRGB(x,y,(0xff<<24) | (gray<<16) | (gray<<8) | gray);
	}
	public void applyFilter(Processable f) {
		f.process(this);
	}
}
