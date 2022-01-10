public class Lenta {
   public XO eile[][];
   public int laisvuLangeliu;
   
   public Lenta(){
      eile = svariLenta();
   }
   
   private XO[][] svariLenta(){
      XO eile[][] = new XO[3][];
      eile[0] = svariEile(new XO[3]);
      eile[1] = svariEile(new XO[3]);
      eile[2] = svariEile(new XO[3]);
      this.laisvuLangeliu = 9;
      return eile;
   }
   
   private XO[] svariEile(XO eile[]){
      for(int i=0; i<eile.length; i++){
         eile[i] = XO.T;
      }
      return eile;
   }
   
   public String toString(){
      String ans = "";
      ans += " ___________ \n";
      for(XO eile[] : this.eile){
         ans += "| " + simbolis(eile[0]) + " | " + simbolis(eile[1]) + " | " + simbolis(eile[2]) + " | \n" ;
         ans += "|---|---|---|\n" ;
      }
      return ans;
   }
   
   public String simbolis(XO xo){
      if(xo == XO.T) {
         return ".";
      }
      return (xo != null)? xo.toString():"?";
   }
   public boolean pridek(int eilute, int stulp, XO xo){
      if(eilute < 0 || eilute > 2)
         return false;
      if(stulp < 0 || stulp > 2)
         return false;
      if(eile[eilute][stulp] != XO.T)
         return false;
      eile[eilute][stulp] = xo;
      laisvuLangeliu -= 1;
      return true;
   }
   public boolean pilnaLenta(){
      return (laisvuLangeliu == 0)? true:false;
   }
   public XO laimetojas(){
      for(int eil=0; eil<3; eil++){
         for(int stul=0; stul<3; stul++){
            XO sitas = eile[eil][stul];
            if (sitas == XO.T)
               continue;
            //int rasta;
            //tikrinam desine
            for(int stul2=stul+1, rasta=1; stul2<3; stul2++){
               if (eile[eil][stul2] == sitas)
                  rasta += 1;
               if (rasta == 3)
                  return sitas;
            }
            //tikrinam apacia
            for(int eil2=eil+1, rasta=1; eil2<3; eil2++){
               if (eile[eil2][stul] == sitas)
                  rasta += 1;
               if (rasta == 3)
                  return sitas;
            }
            //tikrinam apacia desine istrizaine
            for(int stul2=stul+1, eil2=eil+1, rasta=1; stul2<3 && eil2<3; stul2++, eil2++){
               if (eile[eil2][stul2] == sitas)
                  rasta += 1;
               if (rasta == 3)
                  return sitas;
            }
            //tikrinam apacia kaire istrizaine
            for(int stul2=stul-1, eil2=eil+1, rasta=1; stul2>=0 && eil2<3; stul2--, eil2++){
               if (eile[eil2][stul2] == sitas)
                  rasta += 1;
               if (rasta == 3)
                  return sitas;
            }//for
         }//stulp
      }//eil
      return XO.T;
   }//laimetojas
}