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
	BufferedRenderer getBufferedRenderer();
	
	/**
	 * Sets a new buffered renderer
	 * 
	 * @param renderer new buffered renderer
	 */
	void setBufferedRenderer(BufferedRenderer renderer);
	
	/**
	 * Returns the current cell renderer
	 * 
	 * @return current cell renderer
	 */
	CellRenderer getCellRenderer();
	
	/**
	 * Sets a new cell renderer
	 * 
	 * @param renderer new cell renderer
	 */
	void setCellRenderer(CellRenderer renderer);

	/**
	 * Sets a cell of the current color at the given position
	 * 
	 * @param indexX index x position for the cell
	 * @param indexY index y position of the cell
	 */
	void put(int indexX, int indexY);
	
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
	 * Sets a new background color state
	 * 
	 * @param r red
	 * @param g green
	 * @param b blue
	 * @param a alpha
	 */
	void backgroundColor(float r, float g, float b, float a);
	void backgroundColor(float r, float g, float b);
	
	/**
	 * Checks if the position is contained
	 * 
	 * @param x x position
	 * @param y y position
	 * @return true when contained
	 */
	boolean contains(float x, float y);
	
	/**
	 * Returns the width of the element
	 * 
	 * @return element width
	 */
	float getWidth();
	
	/**
	 * Returns the height of the element
	 * 
	 * @return element height
	 */
	float getHeight();
	
	/**
	 * @return x position
	 */
	float getX();
	
	/**
	 * @return y position
	 */
	float getY();
	
	/**
	 * Sets a new position of this element
	 * 
	 * @param x x position
	 * @param y y position
	 */
	void setPosition(float x, float y);
	
	/**
	 * Returns the current X index
	 * 
	 * @return current x index
	 */
	int getIndexX();
	
	/**
	 * Returns the current Y index
	 * 
	 * @return current y index
	 */
	int getIndexY();
	
	/**
	 * Returns the current cell size
	 * 
	 * @return cell size
	 */
	float getCellSize();
	
	/**
	 * Clears the current box to the background color
	 */
	void clear();
	void clear(int indexX, int indexY);
	
	/**
	 * 
	 * @param indexX
	 * @return
	 */
	float translateIndexX(int indexX);
	
	/**
	 * 
	 * @param indexY
	 * @return
	 */
	float translateIndexY(int indexY);
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	int translateRealX(float x);
	
	/**
	 * 
	 * @param y
	 * @return
	 */
	int translateRealY(float y);
	
	/**
	 * 
	 * @param padding
	 */
	void setPadding(int padding);
	
	/**
	 * 
	 * @return
	 */
	int getPadding();
}
