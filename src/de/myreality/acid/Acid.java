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

import java.util.LinkedList;
import java.util.Queue;

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
	
	public static final float DEFAULT_CELL_SIZE = 64f;
	
	public static final int DEFAULT_INDEX = 5;

	// ===========================================================
	// Fields
	// ===========================================================
	
	private BufferedRenderer bufferedRenderer;
	
	private CellRenderer cellRenderer;
	
	private float x, y;
	
	private float r, g, b, a;
	
	private float backgroundR, backgroundB, backgroundG, backgroundA;
	
	private int indexX, indexY;
	
	private float size;
	
	private boolean clearingRequested;
	
	private Queue<Cell> renderTargets;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public Acid(int indexX, int indexY, float size, BufferedRenderer renderer) {
		a = 1f;
		backgroundA = 1f;
		this.indexX = indexX;
		this.indexY = indexY;
		this.size = size;
		this.bufferedRenderer = renderer;
		this.cellRenderer = renderer.getDefaultCellRenderer();
		this.renderTargets = new LinkedList<Cell>();
		clear();
	}
	
	public Acid(int indexX, int indexY, BufferedRenderer renderer) {
		this(indexX, indexY, DEFAULT_CELL_SIZE, renderer);
	}
	
	public Acid(float size, BufferedRenderer renderer) {
		this(DEFAULT_INDEX, DEFAULT_INDEX, size, renderer);
	}
	
	public Acid(BufferedRenderer renderer) {
		this(DEFAULT_CELL_SIZE, renderer);
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================
	
	@Override
	public BufferedRenderer getBufferedRenderer() {
		return bufferedRenderer;
	}
	
	@Override
	public void put(int indexX, int indexY) {
		Cell cell = new SimpleCell(indexX, indexY, r, g, b, a, cellRenderer);
		
		if (!renderTargets.contains(cell)) {
			renderTargets.add(cell);
		}
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
		color(r, g, b, 1f);
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
	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
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
	public void clear() {
		renderTargets.clear();
		clearingRequested = true;
	}

	@Override
	public void clear(int indexX, int indexY) {
		float tmpR = r;
		float tmpG = g;
		float tmpB = b;
		float tmpA = a;
		color(backgroundR, backgroundG, backgroundB, backgroundA);
		put(indexX, indexY);
		color(tmpR, tmpG, tmpB, tmpA);
	}

	@Override
	public float getCellSize() {
		return size;
	}

	@Override
	public void setBufferedRenderer(BufferedRenderer renderer) {
		this.bufferedRenderer = renderer;
	}

	@Override
	public CellRenderer getCellRenderer() {
		return cellRenderer;
	}

	@Override
	public void setCellRenderer(CellRenderer renderer) {
		this.cellRenderer = renderer;
	}


	// ===========================================================
	// Methods
	// ===========================================================
	
	public void render() {
		
		if (isClearingRequested()) {

			bufferedRenderer.createBuffer(getWidth(), getHeight(),
					backgroundR, backgroundG, backgroundB, backgroundA);
			clearingRequested = false;
		} else if (!renderTargets.isEmpty()) {
			for (Cell cell : renderTargets) {
				CellRenderer cellRenderer = cell.getRenderer();
				if (cellRenderer != null) {
					cellRenderer.drawCell(getCellSize() * cell.getIndexX(), 
						          getCellSize() * cell.getIndexY(), 
						          getCellSize(), getCellSize(), 
						          cell.getRed(), cell.getGreen(), cell.getBlue(), cell.getAlpha());
				}
			}

			renderTargets.clear();
		}
		
		bufferedRenderer.drawBuffer(getX(), getY());
	}
	
	private boolean isClearingRequested() {
		return clearingRequested;
	}
	
	// ===========================================================
	// Inner classes
	// ===========================================================
}
