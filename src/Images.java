import java.io.*;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


public class Images {
	  
   
 
    public static void main(String[] args) {
    	String URL = "";
    		for(int i=1; i<1103831;i++) {
    	URL="http://nova.astrometry.net/user_images?page="+i;
    
        try {
 
            
            Document d = Jsoup.connect(URL).get();
 
        
            Elements tag = d.getElementsByTag("img");
 
            for (Element e : tag) {
 
                
                String src = e.absUrl("src");
 
               
                System.out.println(src);
 
                downloadImages(src);
 
            }
 
        } 
        catch (IOException ex) {
            System.err.println("Error" + ex);
            
        }
    }
    }
 
    private static void downloadImages(String src) throws IOException {
 
       
        String path = "/home/ayyuce/Desktop/space/";
 
        
        int indx = src.lastIndexOf("/");
 
        if (indx == src.length()) {
            src = src.substring(1, indx);
        }
 
        indx = src.lastIndexOf("/");
        String file = src.substring(indx, src.length());
 
      //  System.out.println(file);
 
      
        URL url = new URL(src);
        InputStream in = url.openStream();
 
        OutputStream os = new BufferedOutputStream(new FileOutputStream( path+ file));
 
        for (int b; (b = in.read()) != -1;) {
            os.write(b);
        }
        
        in.close();
        os.close();
 
    }
}
