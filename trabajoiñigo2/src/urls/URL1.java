package urls;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URL1 {

	public static void main(String[] args) {
		System.out.println("URL:");
		Scanner sc = new Scanner (System.in);
		String pagina;
		String linea;
		try{
			pagina = sc.nextLine();
			URL u = new URL(pagina);
		}catch (MalformedURLException e){
			System.out.println("URL error" +args[0]);
		}catch (Exception e) {
			System.out.println("error"+e.getMessage());
		}

	}	

	

}
