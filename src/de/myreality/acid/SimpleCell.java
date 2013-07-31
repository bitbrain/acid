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
 * Simple cell implementation
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
class SimpleCell implements Cell {
	
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private int indexX, indexY;
	
	private float r, g, b, a;

	// ===========================================================
	// Constructors
	// ===========================================================

	SimpleCell(int indexX, int indexY, float r, float g, float b, float a) {
		super();
		this.indexX = indexX;
		this.indexY = indexY;
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================
	
	@Override
	public int getIndexX() {
		return indexX;
	}

	@Override
	public int getIndexY() {
		return indexY;
	}

	@Override
	public float getRed() {
		return r;
	}

	@Override
	public float getGreen() {
		return g;
	}

	@Override
	public float getBlue() {
		return b;
	}

	@Override
	public float getAlpha() {
		return a;
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}
