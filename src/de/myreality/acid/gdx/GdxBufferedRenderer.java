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

package de.myreality.acid.gdx;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.myreality.acid.BufferedRenderer;
import de.myreality.acid.CellRenderer;

/**
 * Buffered renderer for LibGDX context
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class GdxBufferedRenderer implements BufferedRenderer {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private CellRenderer cellRenderer;
	
	private Texture buffer;
	
	private SpriteBatch batch;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public GdxBufferedRenderer() {
		this.cellRenderer = new GdxCellRenderer(this);
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================
	
	public Texture getBuffer() {
		return buffer;
	}
	
	public SpriteBatch getSpriteBatch() {
		return batch;
	}

	// ===========================================================
	// Methods from Superclass
	// ===========================================================
	
	@Override
	public CellRenderer getDefaultCellRenderer() {
		return cellRenderer;
	}

	@Override
	public void drawBuffer(float x, float y) {
		batch.begin();
		batch.draw(buffer, x, y);
		batch.end();
	}

	@Override
	public void createBuffer(float width, float height, float r, float g,
			float b, float a) {
		batch = new SpriteBatch();	
		Pixmap map = new Pixmap((int)width,(int)height, Format.RGBA8888);
		map.setColor(r, g, b, a);
		map.fillRectangle(0, 0, (int)width, (int)height);
		buffer = new Texture(map);
		buffer.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Linear);
		buffer.setWrap(Texture.TextureWrap.ClampToEdge, Texture.TextureWrap.ClampToEdge);
		map.dispose();
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner classes
	// ===========================================================
}
