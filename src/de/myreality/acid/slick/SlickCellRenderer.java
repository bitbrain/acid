/* Acid - Provides a Java cell API to display fancy cell boxes.
 * Copyright (C) 2013  Miguel Gonzalez
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 */

package de.myreality.acid.slick;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import de.myreality.acid.CellRenderer;

/**
 * 
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 
 * @version 
 */
public class SlickCellRenderer implements CellRenderer {	

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private Image image;
	
	private SlickBufferedRenderer renderer;
	
	private Color color;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public SlickCellRenderer(Image image, SlickBufferedRenderer bufferedRenderer) {
		this.image = image;
		this.color = new Color(1f, 1f, 1f);
		this.renderer = bufferedRenderer;
	}
	
	public SlickCellRenderer(SlickBufferedRenderer bufferedRenderer) {
		this(null, bufferedRenderer);
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================
	
	public void setImage(Image image) {
		this.image = image;
	}

	// ===========================================================
	// Methods from Superclass
	// ===========================================================
	
	@Override
	public void drawCell(float x, float y, float width, float height, float r,
			float g, float b, float a) {
		
		if (renderer != null) {
			try {
				Graphics graphics = renderer.getBuffer().getGraphics();
				color.r = r;
				color.b = b;
				color.g = g;
				color.a = a;
				
				if (image == null) {
					graphics.setColor(color);
					graphics.fillRect(x, y, width, height);
				} else {		
					graphics.drawImage(image, x, y, 
										x + width, y + height, 
										0, 0, image.getWidth(), image.getHeight(), color);
				}
				graphics.flush();
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}
