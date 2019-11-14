package generator;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.imageio.ImageIO;

import body.body;
import body.clothes;
import head.head;

public class main {
	
	/**
	 * 
	 * @param image BufferedImage object that should be output
	 * @param format format of the picture file (usually png)
	 * @param path storage location
	 */
	public static void output (BufferedImage image, String format, String path) throws IOException {
		File outFile = new File (path);
		ImageIO.write (image, format, outFile);
		
	}

	public static void main(String[] args) {
		
		
		Position a = new Position(1, 1);
		Position b = new Position(1, 1);
		System.out.println(a.equals(b));
		

		
		
		Scanner in = new Scanner (System.in);
		System.out.print("Image path: ");
		String imagePath = in.nextLine();
		
		
		System.out.print("Hair Color(RBG): ");
		Color hair = new Color (in.nextInt(), in.nextInt(), in.nextInt());
		try {
			Color [] ex = new Color[2];
			ex[0] = new Color(255, 229, 211);
			ex[1] = BaseSecondary.transparent;
			BufferedImage headZoneTemplate = ImageIO.read(new File("E:\\Game\\McSkin3D\\mcskin3d_1_6_0_603\\Skins\\programTest\\t.png"));
			
			
			
			System.out.println("------------- <Processing Hair>");
			
			head infoHair = new head();
			infoHair.setHair(headZoneTemplate, ex , new Position(0, 0), new Position(64, 16), hair, new Color(28, 28, 28));
			
			BufferedImage out = infoHair.toImage(imagePath);

			output(out, "png", imagePath);
			
			
			
			
			
			System.out.println("------------- <Processing face>");
			head infoHead = new head();
			
			infoHead.addRectangleZoneFromInts(0, 0, 4*8, 2*8, BaseSecondary.skinColor);
			out = infoHead.toImage(imagePath);
			infoHead.clear();
			
			infoHead.addRectangleZoneFromInts(0, 0, 8, 8, BaseSecondary.transparent);
			
			
			infoHead.addRectangleZone(new Position (24, 0), new Position (32, 9), BaseSecondary.transparent);
			
			System.out.print("eye color: ");
			Color eyeColor = new Color(in.nextInt(), in.nextInt(), in.nextInt());
			infoHead.setEyesWithBang(eyeColor);


			
			out = infoHead.toImage(imagePath);
			output(out, "png", imagePath);
			infoHead.clear();
			
			//head eye = new head();
			//eye.readFromExistImage(headZoneTemplate, ex, new Position(0, 0), new Position(32, 16));
			//System.out.print("eye color: ");
			//Color eyeColor = new Color(in.nextInt(), in.nextInt(), in.nextInt());
			//eye.setEyesWithBang(eyeColor);
			//out = eye.toImage(imagePath);
			//output(out, "png", imagePath);
			//eye.clear();
			
			


			
			
			
			
			Color [] noTransparent = new Color [1];
			noTransparent[0] = BaseSecondary.transparent;
			
			System.out.println("------------- <Processing clothes>");
			System.out.print("clothes color: ");
			Color clothesColor = new Color(in.nextInt(), in.nextInt(), in.nextInt());
			clothes suitInfo = new clothes();
			suitInfo.suit(headZoneTemplate, noTransparent, clothesColor);
			out = suitInfo.toImage(imagePath);
			output(out, "png", imagePath);
			
			
			
			System.out.println("------------- <Processing body>");
			System.out.print("tie color: ");
			Color tieColor = new Color(in.nextInt(), in.nextInt(), in.nextInt());
			body bodyInfo = new body();
			bodyInfo.tie(headZoneTemplate, noTransparent, tieColor);
			out = bodyInfo.toImage(imagePath);
			output(out, "png", imagePath);
		}
		catch (IOException e) {
			System.out.println("IO error");
		}
		
		System.out.println("DONE~");
	}

}
