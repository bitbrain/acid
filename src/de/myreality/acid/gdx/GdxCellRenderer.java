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

import de.myreality.acid.CellRenderer;

/**
 * Cell renderer for LibGDX context
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class GdxCellRenderer implements CellRenderer {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	private Texture image;
	
	private GdxBufferedRenderer renderer;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public GdxCellRenderer(Texture image, GdxBufferedRenderer bufferedRenderer) {
		this.image = image;
		this.renderer = bufferedRenderer;
	}
	
	public GdxCellRenderer(GdxBufferedRenderer bufferedRenderer) {
		this(null, bufferedRenderer);
	}

	// ===========================================================
	// Getters and Setters
	// ===========================================================

	// ===========================================================
	// Methods from Superclass
	// ===========================================================
	
	@Override
	public void drawCell(float x, float y, float width, float height, float r,
			float g, float b, float a) {
		Texture buffer = renderer.getBuffer();
		if (buffer != null) {			
			
			if (image != null) {
				image.getTextureData().prepare();
				Pixmap map = image.getTextureData().consumePixmap();
				Pixmap tmp = new Pixmap((int)width, (int)height, Format.RGBA8888);
				tmp.drawPixmap(map, 0, 0, 
							map.getWidth(), map.getHeight(), 0, 0, (int)width, (int)height);
		
				tmp.setColor(r, g, b, a);
				buffer.draw(tmp, (int)x, (int)y);
				image.getTextureData().disposePixmap();
				tmp.dispose();
			} else {
				Pixmap map = new Pixmap((int)width, (int)height, Format.RGBA8888);
				map.setColor(r, g, b, a);
				map.fillRectangle(0, 0, (int)width, (int)height);
				buffer.draw(map, (int)x, (int)y);
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
