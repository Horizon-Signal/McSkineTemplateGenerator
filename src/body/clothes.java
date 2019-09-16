package body;

import generator.BaseSecondary;
import generator.Position;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class clothes extends BaseSecondary{
	
	
	static final Position leftTop = new Position (16, 32);
	static final Position rightBottom = new Position (56, 48);
	static  Color from = new Color (39, 39, 48);
	//this line is just for initialization and the color is likely be changed in the methods. 
	
	/**
	 * Set suit from template
	 * @param img an existed skin file that provides pattern reference
	 * @param exceptions colors that shouldn't be read (purpose: in order to skip pixels of face & eyes)
	 * @param to the selected color
	 * @param from original color that should be changed
	 */
	public void suit(BufferedImage img, Color [] exceptions, Color to) {
		this.readFromExistImage(img, exceptions, leftTop, rightBottom);
		//from = new Color(img.getRGB(17, 33));
		this.changeMainColor(to, from, exceptions);
	}
	
}

