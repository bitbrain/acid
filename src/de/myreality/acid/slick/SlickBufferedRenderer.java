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

import de.myreality.acid.BufferedRenderer;
import de.myreality.acid.CellRenderer;

/**
 * Implementation of a Slick2D cell renderer
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class SlickBufferedRenderer implements BufferedRenderer {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private Image buffer;
	
	private Color color;
	
	private SlickCellRenderer cellRenderer;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public SlickBufferedRenderer() {
		this.color = new Color(0f, 0f, 0f);
		cellRenderer = new SlickCellRenderer(this);
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================
	
	public Image getBuffer() {
		return buffer;
	}

	// ===========================================================
	// Methods from Superclass
	// ===========================================================

	@Override
	public void drawBuffer(float x, float y) {
		buffer.draw(x, y);
	}

	@Override
	public void createBuffer(float width, float height, float r, float g,
			float b, float a) {
		try {
			buffer = new Image((int) width, (int) height);
			Graphics graphics = buffer.getGraphics();
			color.r = r;
			color.b = b;
			color.g = g;
			color.a = a;
			System.out.println(color);
			graphics.setColor(color);
			graphics.fillRect(0, 0, width, height);
			graphics.flush();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public CellRenderer getCellRenderer() {
		return cellRenderer;
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}
