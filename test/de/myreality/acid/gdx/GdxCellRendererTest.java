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

import org.newdawn.slick.Image;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;

import de.myreality.acid.Acid;
import de.myreality.acid.slick.SlickBufferedRenderer;
import de.myreality.acid.slick.SlickCellRenderer;

/**
 * 
 * 
 * @author Miguel Gonzalez <miguel-gonzalez@gmx.de>
 * @since 
 * @version 
 */
public class GdxCellRendererTest implements ApplicationListener {
	
	private Acid acid;
	
	private Texture texture;

	@Override
	public void create() {
		GdxBufferedRenderer renderer = new GdxBufferedRenderer();
		acid = new Acid(renderer);
		acid.backgroundColor(0.2f, 0.2f, 0.2f);
		acid.setIndexX(8);
		acid.setIndexY(6);
		acid.setCellSize(60);
		
		acid.color(0.2f, 1f, 0f);
		acid.put(1, 1);
		acid.color(0.4f, 0f, 0.6f);
		acid.put(2, 2);

		texture = new Texture("banner.png");
		GdxCellRenderer bannerRenderer = new GdxCellRenderer(texture, renderer);
		
		acid.put(3, 3, bannerRenderer);
		
		// Set the element to the middle
		acid.setPosition(Gdx.graphics.getWidth() / 2f - acid.getWidth() / 2f, 
						 Gdx.graphics.getHeight() / 2f - acid.getHeight() / 2f);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		acid.render();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	

	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "LibGDX Cell Renderer Test";
		cfg.useGL20 = true;
		cfg.width = 800;
		cfg.height = 600;
		
		new LwjglApplication(new GdxCellRendererTest(), cfg);
	}
}
