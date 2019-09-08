package Image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Data {
	private String title;
	private ImageIcon image;
	
	public Data(byte[] image)
	{
		if(image != null){
			this.image = new ImageIcon(image);
			Image img = this.image.getImage();
			BufferedImage bi = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_ARGB);
			Graphics g= bi.createGraphics();
			g.drawImage(img,0,0,600,600,null); // 사진 사이즈
			this.image = new ImageIcon(bi);
		}
		else
			this.image = new ImageIcon();
		
		//this.title = title;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public ImageIcon getImage()
	{
		return image;
	}
	
	public void  setImage(ImageIcon image)
	{
		this.image = image;
	}
	
}
