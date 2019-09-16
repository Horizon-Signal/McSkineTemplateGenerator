package head;

import generator.BaseSecondary;
import generator.Position;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class head extends BaseSecondary{
	
	/**
	 * 
	 * @param originalColor the color that should be darked
	 * @param difference the extent of darked
	 * @requires difference <= originalColor.getRed() && difference <= originalColor.getGreen() && difference <= originalColor.getBlue()
	 * @return darker color
	 */
	public static Color darker(Color originalColor, int difference) {
		int R = originalColor.getRed();
		int G = originalColor.getGreen();
		int B = originalColor.getBlue();
		if (R >= difference) {
			R = R - difference;
		}else {
			R = 0;
		}
		if (G >= difference) {
			G = G - difference;
		}else {
			G = 0;
		}
		if (B >= difference) {
			B = B - difference;
		}else {
			B = 0;
		}
		
		return new Color (R, G, B);
	}
	
	/**
	 * Draw eyes with their height == 2, with shadows of bang
	 * 
	 * @param eyeColor the iris color
	 * 
	 */
	public void setEyesWithBang(Color eyeColor) {
		Color eyeWhiteNormal = new Color(255, 255, 255);
		int difference = 37;
		Color eyeWhiteDark = darker (eyeWhiteNormal, difference);
		Color eyeColorDark = darker (eyeColor, difference);
		
		Position eyeUpWhiteR = new Position(9, 12);
		Position eyeDownWhiteR = new Position(9, 13);
		Position eyeUpColorR = new Position(10, 12);;
		Position eyeDownColorR = new Position(10, 13);
		//Right eye coordinates
		
		
		Position eyeUpColorL = new Position(13, 12);
		Position eyeDownColorL = new Position(13, 13);
		Position eyeDownWhiteL = new Position(14, 13);
		Position eyeUpWhiteL = new Position(14, 12);
		//left eye coordinates
		
		this.setPixelColor(eyeDownWhiteL, eyeWhiteNormal);
		this.setPixelColor(eyeDownWhiteR, eyeWhiteNormal);
		
		this.setPixelColor(eyeUpWhiteL, eyeWhiteDark);
		this.setPixelColor(eyeUpWhiteR, eyeWhiteDark);
		
		this.setPixelColor(eyeUpColorR, eyeColorDark);
		this.setPixelColor(eyeUpColorL, eyeColorDark);
		
		this.setPixelColor(eyeDownColorR, eyeColor);
		this.setPixelColor(eyeDownColorL, eyeColor);
		
	}
	
	
	/**
	 * Draw eyes with their height == 3. 
	 * 
	 * @param eyeColor the iris color
	 * 
	 */
	public void setEyes3(Color eyeColor) {
		int difference = 28;
		
		Position eyeUpR = new Position(9, 12);
		Position eyeMidR = new Position(9, 13);
		Position eyeDownR = new Position(9, 14);
				
		Position eyeUpL = new Position(14, 12);
		Position eyeMidL = new Position(14, 13);
		Position eyeDownL = new Position(14, 14);
		
		this.setPixelColor(eyeDownR, eyeColor);
		this.setPixelColor(eyeDownL, eyeColor);
		
		Color dColor = darker(eyeColor, difference);
		this.setPixelColor(eyeMidR, dColor);
		this.setPixelColor(eyeMidL, dColor);
		
		this.setPixelColor(eyeUpR, darker(dColor, difference));
		this.setPixelColor(eyeUpL, darker(dColor, difference));
	}
	
	/**
	 * Set hair based on the pattern from an existed skin file and selected color
	 * @param img an existed skin file that provides pattern reference
	 * @param exceptions colors that shouldn't be read (purpose: in order to skip pixels of face & eyes)
	 * @param leftTop start position
	 * @param rightBottom end position
	 * @param to the selected color
	 * @param from original color that should be changed
	 */
	public void setHair(BufferedImage img, Color [] exceptions, Position leftTop, Position rightBottom, Color to, Color from) {
		this.readFromExistImage(img, exceptions, leftTop, rightBottom);
		this.changeMainColor(to, from, exceptions);
		
	}
	
}
