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

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import de.myreality.acid.Acid;

/**
 * Test for a simple slick cell renderer
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 1.0
 * @version 1.0
 */
public class SlickCellRendererTest extends BasicGame {
	
	private Acid acid;
	
	private Image image;

	public SlickCellRendererTest(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {		
		acid.render();
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		
		SlickBufferedRenderer renderer = new SlickBufferedRenderer();
		acid = new Acid(renderer);
		acid.backgroundColor(0.2f, 0.2f, 0.2f);
		acid.setIndexX(8);
		acid.setIndexY(6);
		acid.setCellSize(60);
		
		acid.color(0.2f, 1f, 0f);
		acid.put(1, 1);
		acid.color(0.4f, 0f, 0.6f);
		acid.put(2, 2);

		image = new Image("banner.png");
		
		SlickCellRenderer bannerRenderer = new SlickCellRenderer(image, renderer);
		
		acid.put(3, 3, bannerRenderer);
		
		// Set the element to the middle
		acid.setPosition(gc.getWidth() / 2f - acid.getWidth() / 2f, 
						 gc.getHeight() / 2f - acid.getHeight() / 2f);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SlickCellRendererTest("Slick Cell Renderer Test"));
		app.setDisplayMode(800, 600, false);
		app.start();
	}
}
