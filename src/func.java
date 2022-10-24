import java.awt.Toolkit;
import java.awt.Dimension;
public class func {
	
	private static Dimension size;
	
	public static int getWidth() {
		size = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)size.getWidth();
		return width;
	}
	
	public static int getHeight() {
		size = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)size.getHeight();
		return height;
	}

}
