package frogger;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
	View view;
	private Image street;
	
	public Background(View view) {
		this.view = view;
	}

	/**
	 * loads / draws the street image
	 * @return returns the image of the street
	 */
	public Image drawBackground() {
		String streetImage = new String("street.png");
		  try {
			     street = ImageIO.read(new File(streetImage));
			         } catch (IOException exc) {
			       System.out.println(streetImage);
			             System.out.println("Can't load image.");
			         }
			   return street;
			 }
	}

