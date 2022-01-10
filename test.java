import java.util.*;

public class test{
   public static void main(String[] args){
      Game();
      /*
      Lenta lenta = new Lenta();
      System.out.println(lenta);
      System.out.println("Laimetojas: " + lenta.laimetojas().toString() );*/
   }
   
   public static void Game(){
      XO kienoEile = XO.O;
      Scanner skeneris = new Scanner(System.in);
      Lenta lenta = new Lenta();
      while(true){
         kienoEile = apkeisk(kienoEile);
         System.out.println(lenta);
         System.out.println("X arba O padejimas virsutiniame desiniam kampe atrodytu taip: 1 3");
         System.out.println(kienoEile + " eile");
         int duomenys[] = {0,0};
    try{ duomenys[0] = skeneris.nextInt();
         duomenys[1] = skeneris.nextInt();
       }
    catch(java.util.InputMismatchException ex){
         System.out.println("Prasau ziureti, ar tikrai skaicius rasote atskirtus tarpu! ");
         kienoEile = apkeisk(kienoEile); //du kartus apkeitus lieka to pacio eile
         skeneris.nextLine();
         continue;
       }
         int eile = duomenys[0];
         int stulp = duomenys[1];
         //bandom prideti
         if (! lenta.pridek(eile-1,stulp-1,kienoEile) ){
            System.out.println("Nepavyko ten padeti " + kienoEile + "! Bandykite kitur.");
            kienoEile = apkeisk(kienoEile); //du kartus apkeitus lieka to pacio eile
            continue;
         }
         //ar yra laimetojas
         XO laimetojas = lenta.laimetojas();
         if (laimetojas != XO.T){
            System.out.println(lenta);
            System.out.println("Zaidima laimejo " + laimetojas);
            lenta = new Lenta();
            kienoEile = laimetojas;
            if(arBaigti() )
               break;
            continue;
         }
         //ar pilna lenta
         if (lenta.pilnaLenta() ){
            System.out.println("Niekas nelaimejo");
            if(arBaigti() )
               break;
         continue;
         }//if
      }//while
   }
   private static XO apkeisk(XO xo){
      xo = (xo == XO.X)? XO.O:XO.X;
      return xo;
   }
   public static boolean arBaigti(){
      System.out.println("Noredami baigti zaidima parasykite: b");
      Scanner skeneris = new Scanner(System.in);
      if (skeneris.nextLine().equals("b") )
         return true;
      return false;
   }
}