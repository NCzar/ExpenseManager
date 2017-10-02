package api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author nikhilv85
 */


import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.sun.media.jai.codec.ImageCodec; 

import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.ImageEncoder;
import com.sun.media.jai.codec.PNGEncodeParam;
import com.sun.media.jai.codec.SeekableStream;
import com.sun.media.jai.codec.TIFFDecodeParam;
import com.sun.media.jai.codec.TIFFDirectory;

import multivalent.Behavior;
import multivalent.Context;
import multivalent.Document;
import multivalent.Node;
import multivalent.std.adaptor.pdf.PDF;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import api.FileUploadExample;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFToPNG extends HttpServlet {

/**
*
*/
private static final long serialVersionUID = 1L;
byte[] b1=null;

public byte[] ConvertToPngImage(byte[] tiffRawData, HttpServletResponse res)
throws Exception {
Vector pngs = new Vector();
// set stream to the tiff url
SeekableStream tiffStream = SeekableStream.wrapInputStream(
new ByteArrayInputStream(tiffRawData), true);

// how many pages in one tiff
int pageNumber = TIFFDirectory.getNumDirectories(tiffStream);

TIFFDecodeParam decodeParam = new TIFFDecodeParam();
decodeParam.setDecodePaletteAsShorts(true);

ImageDecoder tiffDecoder = ImageCodec.createImageDecoder("tiff",
tiffStream, decodeParam);

// for (int p = 0; p < pageNumber; p ++) {
// render the current page
RenderedImage tiffPage = tiffDecoder.decodeAsRenderedImage();

PNGEncodeParam png = PNGEncodeParam.getDefaultEncodeParam(tiffPage);

// The png stream is outputted to a file. Change the directory
// accordingly.
ByteArrayOutputStream baos = new ByteArrayOutputStream();

// Gets a PNG encoder.
ImageEncoder pngEncoder = ImageCodec.createImageEncoder("PNG", baos,png);

// Encodes the RenderedImage object.
pngEncoder.encode(tiffPage);

byte[] content = baos.toByteArray();
baos.close();
return content;
}


public static void main(String args[]) {
    PDFToPNG p=new PDFToPNG();
    File f=new File("C:\\Users\\nikhilv85\\Desktop\\InspiredLiving\\trialrev6.pdf");
    p.convert(f,"fileoutput");
}


public byte[] convert(File f,String str){
         
File outfile = new File("C:\\Users\\nikhilv85\\Desktop\\InspiredLiving\\x.png");

try {

PDF pdf = (PDF) Behavior.getInstance("AdobePDF", "AdobePDF", null,
null, null);
File file = f;
//File file = new File("C:\\Users\\nikhilv85\\Desktop\\InspiredLiving\\Form entry1.pdf");
pdf.setInput(file);

Document doc = new Document("doc", null, null);
pdf.parse(doc);
doc.clear();

doc.putAttr(Document.ATTR_PAGE, Integer.toString(1));
pdf.parse(doc);

Node top = doc.childAt(0);
doc.formatBeforeAfter(200, 200, null);
int w = top.bbox.width;
int h = top.bbox.height;
BufferedImage img = new BufferedImage(w, h,
BufferedImage.TYPE_INT_RGB);
Graphics2D g = img.createGraphics();
g.setClip(0, 0, w, h);

g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
RenderingHints.VALUE_ANTIALIAS_ON);
g.setRenderingHint(RenderingHints.KEY_RENDERING,
RenderingHints.VALUE_RENDER_QUALITY);
Context cx = doc.getStyleSheet().getContext(g, null);
top.paintBeforeAfter(g.getClipBounds(), cx);

ByteArrayOutputStream baos=new ByteArrayOutputStream();
ImageIO.write(img, "png", baos);
b1=baos.toByteArray();
                 
doc.removeAllChildren();
cx.reset();
g.dispose();

pdf.getReader().close();
outfile = null;

doc = null;
} catch (Exception e) {

}

return b1;
}

public int pageno(File f) throws IOException{
    
    PDDocument doc1 = PDDocument.load(f);
int count = doc1.getNumberOfPages();
    return count;
}

public byte[] convertpages(File f,String str,int i){
         
File outfile = new File("C:\\Users\\nikhilv85\\Desktop\\InspiredLiving\\x.png");

try {

PDF pdf = (PDF) Behavior.getInstance("AdobePDF", "AdobePDF", null,
null, null);
File file = f;
//File file = new File("C:\\Users\\nikhilv85\\Desktop\\InspiredLiving\\Form entry1.pdf");
pdf.setInput(file);


Document doc = new Document("doc", null, null);
pdf.parse(doc);
doc.clear();

doc.putAttr(Document.ATTR_PAGE, Integer.toString(i));
pdf.parse(doc);

Node top = doc.childAt(0);
doc.formatBeforeAfter(200, 200, null);
int w = top.bbox.width;
int h = top.bbox.height;
BufferedImage img = new BufferedImage(w, h,
BufferedImage.TYPE_INT_RGB);
Graphics2D g = img.createGraphics();
g.setClip(0, 0, w, h);

g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
RenderingHints.VALUE_ANTIALIAS_ON);
g.setRenderingHint(RenderingHints.KEY_RENDERING,
RenderingHints.VALUE_RENDER_QUALITY);


Context cx = doc.getStyleSheet().getContext(g, null);
top.paintBeforeAfter(g.getClipBounds(), cx);

ByteArrayOutputStream baos=new ByteArrayOutputStream();
ImageIO.write(img, "png", baos);
b1=baos.toByteArray();
                 
doc.removeAllChildren();
cx.reset();
g.dispose();

pdf.getReader().close();
outfile = null;

doc = null;
} catch (Exception e) {

}

return b1;
}

public byte[] readBytesFromFile(File file,int i) throws IOException {
      InputStream is = new FileInputStream(file);
      
      // Get the size of the file
      long length = file.length();
  
      // You cannot create an array using a long type.
      // It needs to be an int type.
      // Before converting to an int type, check
      // to ensure that file is not larger than Integer.MAX_VALUE.
      if (length > Integer.MAX_VALUE) {
        throw new IOException("Could not completely read file " + file.getName() + " as it is too long (" + length + " bytes, max supported " + Integer.MAX_VALUE + ")");
      }
  
      // Create the byte array to hold the data
      byte[] bytes = new byte[(int)length];
  
      // Read in the bytes
      int offset = 0;
      int numRead = 0;
      while (offset < bytes.length && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
          offset += numRead;
      }
  
      // Ensure all the bytes have been read in
      if (offset < bytes.length) {
          throw new IOException("Could not completely read file " + file.getName());
      }
  
      // Close the input stream and return bytes
      is.close();
      return bytes;
  }


}