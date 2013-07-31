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

package de.myreality.acid;

/**
 * Renderer which handles the rendering of a single cell
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public interface CellRenderer {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================
	
	/**
	 * Draws a single cell at the contained position. 
	 * <p>
	 * Be aware of that this method is only called when something has changed. 
	 * Therefore, draw to a buffer of your choice.
	 * 
	 * @param cell Cell to draw
	 */
	void drawCell(Cell cell);
	
	/**
	 * Draws a complete buffer to the screen.
	 * <p>
	 * Make sure to draw the buffer here!
	 * 
	 * @param x x position of the buffer
	 * @param y y position of the buffer
	 */
	void drawBuffer(float x, float y);
	
	/**
	 * Create a new buffer with the given width and height
	 * 
	 * @param width width of the buffer
	 * @param height height of the buffer
	 * @param r red amount of the buffer
	 * @param g green amount of the buffer
	 * @param b blue amount of the buffer
	 * @param a alpha amount of the buffer
	 */
	void createBuffer(float width, float height, float r, float g, float b, float a);
}
