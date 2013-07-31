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
 * Handles all existing cells. Considering if a specific cell has been changed 
 * and draws it to the buffer.
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public interface CellManager {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================
	
	/**
	 * @return Returns the current cell renderer
	 */
	CellRenderer getRenderer();
	
	/**
	 * Sets a cell of the current color at the given position
	 * 
	 * @param x x position for the cell
	 * @param y y position of the cell
	 */
	void set(float x, float y);
	
	/**
	 * Sets a new color state
	 * 
	 * @param r red
	 * @param g green
	 * @param b blue
	 * @param a alpha
	 */
	void color(float r, float g, float b, float a);
	void color(float r, float g, float b);
	
	/**
	 * Checks if the position is contained
	 * 
	 * @param x x position
	 * @param y y position
	 * @return true when contained
	 */
	boolean contains(float x, float y);
	
	/**
	 * 
	 * @return
	 */
	float getWidth();
	
	/**
	 * 
	 * @return
	 */
	float getHeight();
	
	/**
	 * 
	 * @return
	 */
	float getX();
	
	/**
	 * 
	 * @return
	 */
	float getY();
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	void setBounds(float x, float y, float width, float height);
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	void setPosition(float x, float y);
	
	/**
	 * 
	 * @param width
	 * @param height
	 */
	void setDimension(float width, float height);
	
	/**
	 * 
	 * @param size
	 */
	void setSize(float size);
}
