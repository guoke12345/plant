package com.framework.core.utils;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class fileInfo {
	
	/*
	 * 专用于图片文件的处理
	 */
	
	/*
	 * 获取文件后缀名
	 */
	public String getPrefix(File file){
		String fileName=file.getName();
		String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
		return prefix;
	}
	
	/*
	 * 判断文件是否为图片
	 */
	public Boolean IfImg(File file){
		String prefix= getPrefix(file);
		if(prefix.equals("PNG")||prefix.equals("GIF")||prefix.equals("JPEG")||prefix.equals("JPG")||prefix.equals("BMP")||prefix.equals("gif")||prefix.equals("png")||prefix.equals("jpeg")||prefix.equals("jpg")||prefix.equals("bmp"))
		{
			return true;
		}else
		{
			return false;
		}
	}
	/*
	 * 获取文件大小 返回long
	 */
	public long getFileSize(File file) throws IOException{
		
		       long s=0;
		       if (file.exists()) {
		           FileInputStream fis = null;
		           fis = new FileInputStream(file);
		          s= fis.available();
		       } else {
		    	   file.createNewFile();
		           System.out.println("文件不存在");
		       }
		       return s;
	}
	
	/*
	 * 获取图片尺寸宽度
	 */
	public int getWidth(File file) throws FileNotFoundException, IOException{
		 BufferedImage sourceImg =ImageIO.read(new FileInputStream(file));    
	     return sourceImg.getWidth();    
	}
	
	/*
	 * 获取图片尺寸高度
	 */
	public int getHeight(File file) throws FileNotFoundException, IOException{
		 BufferedImage sourceImg =ImageIO.read(new FileInputStream(file));    
	     return sourceImg.getHeight();    
	}
	
	/*
	 * 改变图片尺寸
	 */
	public BufferedImage reSize(File file, int targetW,int targetH) throws FileNotFoundException, IOException{
		 BufferedImage source =ImageIO.read(new FileInputStream(file));
		  int type = source.getType();
		  BufferedImage target = null;  
		  double sx = (double) targetW / source.getWidth();  
	        double sy = (double) targetH / source.getHeight();  
		  // 这里想实现在targetW，targetH范围内实现等比缩放。如果不需要等比缩放  
	        // 则将下面的if else语句注释即可  
	        if (sx > sy)  
	        {  
	            sx = sy;  
	            targetW = (int) (sx * source.getWidth());  
	        }  
	        else  
	        {  
	            sy = sx;  
	            targetH = (int) (sy * source.getHeight());  
	        }  
	        if (type == BufferedImage.TYPE_CUSTOM)  
	        { // handmade  
	            ColorModel cm = source.getColorModel();  
	            WritableRaster raster = cm.createCompatibleWritableRaster(targetW,  
	                    targetH);  
	            boolean alphaPremultiplied = cm.isAlphaPremultiplied();  
	            target = new BufferedImage(cm, raster, alphaPremultiplied, null);  
	        }  
	        else  
	        {  
	            //固定宽高，宽高一定要比原图片大  
	            target = new BufferedImage(targetW, targetH, type);  
	            //target = new BufferedImage(800, 600, type);  
	        }  
	          
	        Graphics2D g = target.createGraphics();  
	          
	        //写入背景  
	        g.drawImage(ImageIO.read(new File("ok/blank.png")), 0, 0, null);  
	          
	        // smoother than exlax:  
	        g.setRenderingHint(RenderingHints.KEY_RENDERING,  
	                RenderingHints.VALUE_RENDER_QUALITY);  
	        g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));  
	        g.dispose();  	        
	        return target;  
	}
}
