package generator;

import java.awt.Color;
import java.awt.image.BufferedImage;

public interface Base1 extends BaseKernal{

	/**
	 * add pixels info to Base and set all these pixels to a specific color
	 * 
	 * @param leftTop the coordinates of left-top pixel
	 * @param rightBottom the coordinates of right-bottom pixel
	 * @param color the RGB color you want to set
	 */
    public void addRectangleZone(Position leftTop, Position rightBottom, Color color);
    
    /**
     * add pixels info to Base and set all these pixels to a specific color
     * 
     * @param leftTopX the x coordinates of left-top pixel
     * @param leftTopY the y coordinates of left-top pixel
     * @param rightBottomX the x coordinates of right-bottom pixel
     * @param rightBottomY the y coordinates of right-bottom pixel
     * @param color color the RGB color you want to set
     */
    public void addRectangleZoneFromInts(int leftTopX, int leftTopY, int rightBottomX, int rightBottomY, Color color);
    
    /**
     * Read info from a rectangle zone of an existed picture
     * 
     * @param img the source image
     * @param exceptions RGB colors that you don't want to include
     * @param leftTop the coordinates of left-top pixel
	 * @param rightBottom the coordinates of right-bottom pixel
	 * @requires |this| == 0
     */
    public void readFromExistImage (BufferedImage img, Color [] exceptions, Position leftTop, Position rightBottom);
    
    /**
     * Keeps the pattern, but changes the color
     * @param to the color after change
     * @param from the original main color
     */
    public void changeMainColor(Color to, Color from, Color [] exceptions);
    
	/**
	 * 
	 * @param color the RGB color you want to set
	 */
	public void setBottomColor (Color color);
}
