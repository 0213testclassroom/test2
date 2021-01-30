
public class NegativeImageFilter
//extends AbstractImageFilter
implements Processable{
	@Override
	public void process(GrayImage img) {
		for(int y=0; y<img.getHeight(); y++) {
			for(int x=0; x<img.getWidth(); x++) {
					img.setGray(x, y, 255 - img.getGray(x, y));
			}
		}
	}
}
