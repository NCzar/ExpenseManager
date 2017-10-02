/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

/**
 *
 * @author nikhilv85
 */
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.imageio.ImageIO;

public class SaveImageFromUrl {

	public static void main(String[] args) throws Exception {
		String imageUrl = "http://www.avajava.com/images/avajavalogo.jpg";
                String imgSrcParam1="http://api.grabz.it/services/getjspicture.ashx?id=YWE1YTViZjIzZjFlNDE3Yzk2ZGU1YTVjYWEzZjIyN2I=-d5e68b24ea5e413fbd42973dda9bcd2da";
                SaveImageFromUrl s=new SaveImageFromUrl();
                /*
		String destinationFile = "image.jpg";
                
		s.saveImage(imageUrl, destinationFile);
               */
                byte[] b=null;
                b=s.converttobyte(imgSrcParam1);
                System.out.println(b);
                
	}

	public void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}
        public byte[] converttobyte(String imgUrl) throws IOException{
         byte[] b=null;
            URL imageURL = new URL(imgUrl);
    BufferedImage originalImage=ImageIO.read(imageURL);
    ByteArrayOutputStream baos=new ByteArrayOutputStream();
    ImageIO.write(originalImage, "png", baos );

    //Persist - in this case to a file
    //FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\nikhilv85\\\\Desktop\\\\InspiredLiving\\\\output\\\\y2.png");
   // baos.writeTo(fos);
    b=baos.toByteArray();
   // fos.close();
    
    return b;
        }

}
