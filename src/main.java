import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class main {
    public static void main (String [] args) throws FileNotFoundException {
        System.out.println("Start");
        System.out.println("Wpisz nazwe pliku, który chcesz wczytac" +
                "(pamietaj aby znajdowal sie w glownym folderze programu):");
        String t;
        try (Scanner tekst = new Scanner(System.in)) {
            t = tekst.next();
        } 
        String file = t ;
        int znaki[] = new int[3];
        znaki[0] = ileznakow(file);
        znaki[1] = biale(file);
        znaki[2] = slowa(file);
        System.out.println("W pliku " + file + " jest:");
        System.out.println(znaki[0] + " znakow");
        System.out.println(znaki[1] + " znakow bialych");
        System.out.println("ilosc slow:" + znaki[2]);
        System.out.println("Koniec programu.");
    }
    public static int slowa(String plik) throws FileNotFoundException {
        int s;
        try ( 
         Scanner slowa = new Scanner(new File(plik))) {
            s = 0;
            while (slowa.hasNext()) {
                slowa.next();
                s++;
            }
        }
        return s;
    }
     public static int biale(String plik) throws FileNotFoundException{
        int b;
        try (Scanner bz = new Scanner(new File(plik)).useDelimiter("[ \\s]")) {
            b = 0;
            while (bz.hasNext()){
                bz.next();
                b++;
            }
        }
        return b;
    }

        public static int ileznakow(String plik) throws FileNotFoundException{

        int z;
        try (Scanner znaki = new Scanner(new File(plik)).useDelimiter("[^\\s]")) 
        {
            z = 0;
            while (znaki.hasNext()) {
                znaki.next();
                z++;
            }
        }
        return z;
    }
}