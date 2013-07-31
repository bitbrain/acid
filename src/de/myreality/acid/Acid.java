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
 * Main acid class which provides functionality to display a box
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class Acid implements CellManager {
	
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private CellRenderer renderer;
	
	private float x, y;
	
	private float r, g, b, a;
	
	private float backgroundR, backgroundB, backgroundG, backgroundA;
	
	private int indexX, indexY;
	
	private float size;
	
	private boolean renderingRequested, clearingRequested;

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================
	
	@Override
	public CellRenderer getRenderer() {
		return renderer;
	}

	@Override
	public void set(float x, float y) {
		
	}

	@Override
	public void color(float r, float g, float b, float a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

	@Override
	public void color(float r, float g, float b) {
		color(r, g, b, a);
	}

	@Override
	public void backgroundColor(float r, float g, float b, float a) {
		backgroundR = r;
		backgroundG = g;
		backgroundB = b;
		backgroundA = a;
	}

	@Override
	public void backgroundColor(float r, float g, float b) {
		backgroundColor(r, g, b, a);
	}

	@Override
	public boolean contains(float x, float y) {
		return x >= 0 && x < getIndexX() 
		    && y >= 0 && y < getIndexY();
	}

	@Override
	public float getWidth() {
		return getCellSize() * getIndexX();
	}

	@Override
	public float getHeight() {
		return getCellSize() * getIndexY();
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public void setBounds(float x, float y, int indexX, int indexY) {
		setPosition(x, y);
		setIndexX(indexX);
		setIndexY(indexY);
	}

	@Override
	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void setSize(float size) {
		this.size = size;
	}

	@Override
	public int getIndexX() {
		return indexX;
	}

	@Override
	public int getIndexY() {
		return indexY;
	}

	@Override
	public void setIndexX(int indexX) {
		this.indexX = indexX;
	}

	@Override
	public void setIndexY(int indexY) {
		this.indexY = indexY;
	}

	@Override
	public void clear() {
		clearingRequested = true;
	}

	@Override
	public void setCellSize(float size) {
		this.size = size;
	}

	@Override
	public float getCellSize() {
		return size;
	}

	// ===========================================================
	// Methods
	// ===========================================================
	
	public void render() {
		
		if (isClearingRequested()) {
			renderer.createBuffer(getWidth(), getHeight(),
					backgroundR, backgroundG, backgroundB, backgroundA);
		} else if (isRenderingRequested()) {
			
		}
		
		renderer.drawBuffer(getX(), getY());
	}
	
	private boolean isRenderingRequested() {
		return renderingRequested;
	}
	
	private void requestRendering() {
		renderingRequested = true;
	}
	
	private boolean isClearingRequested() {
		return clearingRequested;
	}

	// ===========================================================
	// Inner classes
	// ===========================================================
}
