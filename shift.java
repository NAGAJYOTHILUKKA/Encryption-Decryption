import java.lang.*;
public class shift{
  String g="";
  String k="";
 String encrypt(String s,int n){
	 for(int i = 0; i < s.length(); ++i){
      char ch = s.charAt(i);
      
      if(ch >= 'a' && ch <= 'z'){
              ch = (char)(ch + n);
              
              if(ch > 'z'){
                  ch = (char)(ch - 'z' + 'a' - 1);
              }
              
              k += ch;
          }
          else if(ch >= 'A' && ch <= 'Z'){
              ch = (char)(ch + n);
              
              if(ch > 'Z'){
                  ch = (char)(ch - 'Z' + 'A' - 1);
              }
              
              k+= ch;
          }
          else {
            k += ch;
          }
    }
    return k;
	}
 String decrypt(String m,int l){
    for(int i = 0; i < m.length(); ++i){
      char ch = m.charAt(i);
      
      if(ch >= 'a' && ch <= 'z'){
              ch = (char)(ch - l);
              
              if(ch < 'a'){
                  ch = (char)(ch + 'z' - 'a' + 1);
              }
              
              g += ch;
          }
          else if(ch >= 'A' && ch <= 'Z'){
              ch = (char)(ch - l);
              
              if(ch < 'A'){
                  ch = (char)(ch + 'Z' - 'A' + 1);
              }
              
              g+= ch;
          }
          else {
            g += ch;
          }
    }
     return g;
	}
}