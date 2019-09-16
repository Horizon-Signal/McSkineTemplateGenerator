package generator;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class BaseSecondary extends Base{
	
	static final Color skinColor = new Color(255, 227, 207);
	static final Color transparent = new Color(0, 0, 0, 0);
	//(0, 0, 0, 0) doesn't work
	static final Color transparent1 = new Color(1, 1, 1, 0);
	
	private static boolean contain(Color[] list, Color color) {
		boolean re = false;
		for (int index = 0; index < list.length; index++) {
			if (list[index].equals(color)) {
				
				re = true;
				break;
			}
		}
		return re;
	}
	
	private static int correctRGB(int value) {
		if (value < 0) {
			return 0;
		}
		else if (value > 255) {
			return 255;
		}
		return value;
	}
	
	/**
	 * add pixels info to Base and set all these pixels to a specific color
	 * 
	 * @param leftTop the coordinates of left-top pixel
	 * @param rightBottom the coordinates of right-bottom pixel
	 * @param color the RGB color you want to set
	 */
    public void addRectangleZone(Position leftTop, Position rightBottom, Color color) {
    	int height = rightBottom.getY() - leftTop.getY();
    	int width = rightBottom.getX() - leftTop.getX();
    	
    	for (int col = leftTop.getY(); col < rightBottom.getY(); col++) {
    		for (int row = leftTop.getX(); row < rightBottom.getX(); row++) {
    			
    			Position posi = new Position(row, col);			
    			this.setPixelColor(posi, color);
    			
    		}
    	}
    }
    
    /**
     * add pixels info to Base and set all these pixels to a specific color
     * 
     * @param leftTopX the x coordinates of left-top pixel
     * @param leftTopY the y coordinates of left-top pixel
     * @param rightBottomX the x coordinates of right-bottom pixel
     * @param rightBottomY the y coordinates of right-bottom pixel
     * @param color color the RGB color you want to set
     */
    public void addRectangleZoneFromInts(int leftTopX, int leftTopY, int rightBottomX, int rightBottomY, Color color) {
    	int height = rightBottomY - leftTopY;
    	int width = rightBottomX - leftTopX;
    	
    	for (int col = leftTopY; col < height; col++) {
    		for (int row = leftTopX; row < width; row++) {
    			//System.out.println(row + " , " + col);
    			this.setPixelColorFromInts(row, col, color);
    		}
    	}
    }
    
    /**
     * Read info from a rectangle zone of an existed picture
     * 
     * @param img the source image
     * @param exceptions RGB colors that you don't want to include
     * @param leftTop the coordinates of left-top pixel
	 * @param rightBottom the coordinates of right-bottom pixel
	 * @requires |this| == 0
     */
    public void readFromExistImage (BufferedImage img, Color [] exceptions, Position leftTop, Position rightBottom) {
    	int height = rightBottom.getY() - leftTop.getY();
    	int width = rightBottom.getX() - leftTop.getX();
    	
    	for (int col = leftTop.getY(); col < rightBottom.getY(); col++) {
    		for (int row = leftTop.getX(); row < rightBottom.getX(); row++) {
    			
    			Position posi = new Position(row, col);
    			Color temp = new Color(img.getRGB(row, col));
    			if (!contain(exceptions, temp) && !temp.equals(transparent)) {
    				this.setPixelColor(posi, temp);
    			}
    			
    		}
    	}
    }
    
    /**
     * Keeps the pattern, but changes the color
     * @param to the color after change
     * @param from the original main color
     */
    public void changeMainColor(Color to, Color from, Color [] exceptions) {
    	Iterator<Map.Entry<Position, Color>> entries = this.entrySet().iterator();
    	
		while (entries.hasNext()) {
			Map.Entry<Position, Color> entry = entries.next();
			Color original = entry.getValue();
			if (!contain(exceptions, original)) {
				if (original.equals(from)) {
					this.setPixelColor(entry.getKey(), to);
				}
				else {
					int R = from.getRed() - to.getRed();
					int G = from.getGreen() - to.getGreen();
					int B = from.getBlue() - to.getBlue();
					
					Color c = new Color(correctRGB(original.getRed() - R), 
							correctRGB(original.getGreen() - G), 
							correctRGB(original.getBlue() - B));
					
					this.setPixelColor(entry.getKey(), c);
				}
			}
		}
    }
    

}
