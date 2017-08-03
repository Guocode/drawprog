package com.mr.draw;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class DrawPictureFrame extends JFrame {
	BufferedImage image = new BufferedImage(570, 390, BufferedImage.TYPE_INT_BGR);
	Graphics gs = image.getGraphics();
	Graphics2D g = (Graphics2D) gs;
	DrawPictureCanvas canvas = new DrawPictureCanvas();
	Color foreColor = Color.BLACK;
	Color backgroundcolor = Color.WHITE;
	int x = -1;
	int y = -1;
	boolean rubber = false;

	public DrawPictureFrame() {
		this.setResizable(false);
		this.setTitle("»­Í¼³ÌÐò");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(500, 200, 570, 460);
		init();
		addListener();
	}

	public void init() {
		g.setColor(backgroundcolor);
		g.fillRect(0, 0, 570, 400);
		g.setColor(foreColor);
		canvas.setImage(image);
		this.getContentPane().add(canvas);
	}

	public void addListener(){
		canvas.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(final MouseEvent e){
				if(x>0&&y>0){
					if(rubber){
						g.setColor(backgroundcolor);
						g.fillRect(x, y, 10, 10);
					}else{
						g.drawLine(x, y, e.getX(), e.getY());
					}
				}
				x = e.getX();
				y = e.getY();
				canvas.repaint();
			}
		});
		canvas.addMouseListener(new MouseAdapter(){
			public void mouseReleased(final MouseEvent e){
				x = -1;
				y = -1;
			}
		});
	}

	public static void main(String args[]) {
		DrawPictureFrame frame = new DrawPictureFrame();
		frame.setVisible(true);
	}

}
