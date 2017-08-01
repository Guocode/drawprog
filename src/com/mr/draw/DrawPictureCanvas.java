package com.mr.draw;

import java.awt.*;

@SuppressWarnings("serial")
public class DrawPictureCanvas extends Canvas{
	private Image image = null;
	public void setImage(Image image){
		this.image=image;
	}
	public void paint(Graphics g){
		g.drawImage(image, 0, 0, null);
	}
	public void updata(Graphics g){
		paint(g);
	}
}
