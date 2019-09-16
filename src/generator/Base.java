package generator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.sun.xml.internal.bind.api.impl.NameConverter.Standard;

public class Base extends Standard{
	
	protected HashMap<Position, Color> storage;
	
	/*
	 * constructor
	 */
	public Base() {
		storage = new HashMap<Position, Color>();
	}
	

	
	/**
	 * 
	 * @return whether the map object is empty or not
	 */
	public boolean isEmpty() {
		return this.storage.isEmpty();
	}
	
	/**
	 * the size of the map object
	 * @return |storage|
	 */
	public int size() {
		return this.storage.size();
	}
	
	/**
	 * checks if the skin is single layered (32*64) or double layered (64*64)
	 * @requires this.storage.size >= (32*64)
	 * @return if storage.size() < 4000 --> true
	 * 		   else --> false
	 */
	public boolean isNewSkin() {
		
		return (this.storage.size() > 4000);
	}
	
	/**
	 * 
	 * @param color the RGB color you want to set
	 */
	public void setBottomColor (Color color) {
		
		for (Entry<Position, Color> entry : this.storage.entrySet()) {
			// for all elements in this map object
			this.storage.put(entry.getKey(), color);
		}
	}
	
	/**
	 * 
	 * @param color the RGB color you want to set
	 * @param position position of the pixel
	 */
	public void setPixelColor (Position position, Color color) {

		this.storage.put(position, color);
		
	}
	
	/**
	 * 
	 * @param x x-coordinate of the pixel
	 * @param y y-coordinate of the pixel
	 * @param color the RGB color you want to set
	 */
	public void setPixelColorFromInts (int x, int y, Color color) {
		Position coordinate = new Position (x, y);

		this.storage.put(coordinate, color);
		
	}
	
	/**
	 * 
	 * @param pathIn  the skin image that should be modified
	 * @return a BufferedImage object, modified according to the info in storage
	 * @throws IOException
	 */
    public BufferedImage toImage (String pathIn) throws IOException {
    	File imagePath = new File (pathIn);
    	BufferedImage re = ImageIO.read(imagePath);
    	

    	Iterator<Map.Entry<Position, Color>> entries = this.storage.entrySet().iterator();
    	int count = 0;
		while (entries.hasNext()) {
			Map.Entry<Position, Color> entry = entries.next();

			re.setRGB(entry.getKey().getX(), entry.getKey().getY(), entry.getValue().getRGB());
			count++;
		}
    	System.out.println("count: " + count);
    	return re;
    }
    /**
     * Remove a series of pixels that contains a certain color
     * @param remove color that to be removed
     */
    public void removeColor (Color remove) {
    	Iterator<Map.Entry<Position, Color>> entries = this.storage.entrySet().iterator();
    	while (entries.hasNext()) {
    		Map.Entry<Position, Color> entry = entries.next();
    		Color temp = entry.getValue();
    		if (temp.equals(remove)) {
    			this.storage.remove(entry.getKey());
    		}
    	}
    }
    
    public void clear () {
    	this.storage.clear();
    }
    
    public Iterable<Entry<Position,Color>> entrySet() {
    	return this.storage.entrySet();
    }

    
    /**
     * 
     * @param arr the key you are looking for
     * @return 
     */
    public boolean contains (Position arr) {
    	return this.storage.containsKey(arr);
    }
    
    public void replace(Position key, Color value) {
    	this.storage.replace(key, value);
    }
    
    @Override
    public int hashCode() {
		return this.storage.hashCode();
    	
    }
    
    @Override
    public boolean equals(Object obj) {
		return this.storage.equals(obj);
    	
    }
	
    @Override
    public String toString() {
    	return this.storage.toString();
    }
	
}
