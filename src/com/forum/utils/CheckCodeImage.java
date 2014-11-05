package com.forum.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CheckCodeImage")
public class CheckCodeImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String STRING = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";
    private static Random random = new Random();

    public CheckCodeImage() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("image/jpeg");
		
		String randomString = getRandomString();
		request.getSession().setAttribute("checkCode", randomString);
		
		BufferedImage bi = getCheckCodeImage(randomString);
		
		ServletOutputStream sos = response.getOutputStream();		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bi, "JPEG", baos);
		byte[] buf = baos.toByteArray();
		response.setContentLength(buf.length);
		sos.write(buf);
		baos.close();
		sos.close();
	}
	
	public static String getRandomString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			int randomInt = random.nextInt(STRING.length());
			sb.append(STRING.charAt(randomInt));
		}
		return sb.toString();
	}
	
	public static Color getRandomColor() {
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
	
	public static Color getReverseColor(Color color) {
		return new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
	}
	
	public BufferedImage getCheckCodeImage(String randomString) {
		int width = 100;
		int height = 30;		
		Color color = getRandomColor();
		Color reverse = getReverseColor(color);
		
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		g.setColor(color);
		g.fillRect(0, 0, width, height);
		g.setColor(reverse);
		g.drawString(randomString, 18, 20);
		for (int i = 0, n = random.nextInt(100); i < n; i++) {
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}
		return bi;
	}

}
