
public class BinaryImageFilter 
//extends AbstractImageFilter 
implements Processable{
	@Override
	public void process(GrayImage img) {
		for(int y=0; y<img.getHeight(); y++) {
			for(int x=0; x<img.getWidth(); x++) {
				if(img.getGray(x, y)<128)
					img.setGray(x, y, 0);
				else	
					img.setGray(x, y, 255);
			}
		}
	}
}

