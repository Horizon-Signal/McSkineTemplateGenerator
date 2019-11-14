package body;

import java.awt.Color;
import java.awt.image.BufferedImage;

import generator.Base;
import generator.Position;

public class body extends Base{
	
	static final Position leftTop = new Position (23, 20);
	static final Position rightBottom = new Position (25, 28);
	static  Color from = new Color (0, 0, 0, 0);
	//this line is just for initialization and the color is likely be changed in the methods. 
	
	/**
	 * Set a tie
	 * @param img an existed skin file that provides pattern reference
	 * @param exceptions colors that shouldn't be read (purpose: in order to skip pixels of face & eyes)
	 * @param to the selected color
	 */
	public void tie (BufferedImage img, Color [] exceptions, Color to) {
		this.readFromExistImage(img, exceptions, leftTop, rightBottom);
		from = new Color(img.getRGB(24, 21));
		this.changeMainColor(to, from, exceptions);
	}
}
