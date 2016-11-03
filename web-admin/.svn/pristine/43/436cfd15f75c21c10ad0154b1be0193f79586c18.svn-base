package com.imarce.core.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.imageio.ImageIO;

/*import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;*/

public class PicUtil {

	static  Random random = new Random();
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");

	//等比例縮小
	public static String uploadPic(String source, int width, String targetDir) {
		String newurl = null;
		try {
			File file = new File(source); // 读入刚才上传的文件
			//newurl = targetDir + createPicName(source); // 新的缩略图保存地址
			Image src = ImageIO.read(file); // 构造Image对象
			float tagsize = 300;
			int old_w = src.getWidth(null); // 得到源图宽
			int old_h = src.getHeight(null); // 得到源图长
			int new_w = 0;
			int new_h = 0;
			int tempsize;
			float tempdouble;
			if (old_w > old_h) {
				tempdouble = old_w / tagsize;
			} else {
				tempdouble = old_h / tagsize;
			}
			new_w = Math.round(old_w / tempdouble);
			new_h = Math.round(old_h / tempdouble);// 计算新图长宽
			BufferedImage tag = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(src, 0, 0, new_w, new_h, null); // 绘制缩小后的图
			FileOutputStream newimage = new FileOutputStream(newurl); // 输出到文件流
		/*	JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
			encoder.encode(tag); // 近JPEG编码   */
			ImageIO.write(tag,"jpg", newimage);
			newimage.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} /*catch (ImageFormatException e) {
			e.printStackTrace();
		} */catch (IOException e) {
			e.printStackTrace();
		}

		return newurl;
	}
	
	    //指定大小 用英語圖片裁剪
		public static String uploadPic(String source, String newurl,int x,int y,int x2,int y2,int w,int h) {
			//String newurl = null;
			try {
				File file = new File(source); // 读入刚才上传的文件
				//newurl = targetDir + "/"+createPicName(source); // 新的缩略图保存地址
				Image src = ImageIO.read(file); // 构造Image对象
				
				BufferedImage tag = new BufferedImage(w,  h, BufferedImage.TYPE_INT_RGB);
				tag.getGraphics().drawImage(src, 0, 0, w, h, x, y, x2, y2, null);
				//tag.getGraphics().drawImage(src, 0, 0, new_w, new_h, null); // 绘制缩小后的图	
				FileOutputStream newimage = new FileOutputStream(newurl); // 输出到文件流
				
				//================================linux下无jar包=============================================//
				//JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
				//encoder.encode(tag); // 近JPEG编码
				//==============================================================================//
				ImageIO.write(tag,"jpg", newimage);
				
				
				newimage.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} //catch (ImageFormatException e) {
				//e.printStackTrace();
			//} 
			catch (IOException e) {
				e.printStackTrace();
			}

			return newurl;
		}

	

	public static void main(String[] args) {
		//System.out.println(new PicUtil().createPicName("adsfadsf.png"));
		
		new PicUtil().uploadPic("G:\\c8a9b4b7e455a0ab9b984643c971e4ed.jpg",100,"F:\\");
	}
}
