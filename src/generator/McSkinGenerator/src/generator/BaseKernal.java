package generator;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map.Entry;

public interface BaseKernal {
	
	/**
	 * 
	 * @return whether the map object is empty
	 */
	public boolean isEmpty();
	
	/**
	 * the size of the map object
	 * @return |storage|
	 */
	public int size();
	
	/**
	 * checks if the skin is single layered (32*64) or double layered (64*64)
	 * @requires this.storage.size >= (32*64)
	 * @return if storage.size() < 4000 --> true
	 * 		   else --> false
	 */
	public boolean isNewSkin();
	
	/**
	 * 
	 * @param color the RGB color you want to set
	 * @param position position of the pixel
	 */
	public void setPixelColor (Position position, Color color);
	
	/**
	 * 
	 * @param x x-coordinate of the pixel
	 * @param y y-coordinate of the pixel
	 * @param color the RGB color you want to set
	 */
	public void setPixelColorFromInts (int x, int y, Color color);
	
	/**
	 * 
	 * @param pathIn  the skin image that should be modified
	 * @return a BufferedImage object, modified according to the info in storage
	 * @throws IOException
	 */
    public BufferedImage toImage (String pathIn) throws IOException;
    
    /**
     * Remove a series of pixels that contains a certain color
     * @param remove color that to be removed
     */
    public void removeColor (Color remove);
    
    public void clear ();
    
    public Iterable<Entry<Position,Color>> entrySet();
    
    /**
     * 
     * @param arr the key you are looking for
     * @return whether this contains arr
     */
    public boolean contains (Position arr);
    
    public void replace(Position key, Color value);
}
