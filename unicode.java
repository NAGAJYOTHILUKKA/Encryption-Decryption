import java.lang.*;
public class unicode{
    String h="",j="";
	String encrypt(String s,int n){
	 for(int i=0;i<s.length();i++){
         int val=s.charAt(i);
        h+=(char)(val+n);
      }	
      return h;
	}
	 String decrypt(String m,int l){
		for(int i=0;i<m.length();i++){
         int val=m.charAt(i);
        j+=(char)(val-l);
     }
     return j;
	}
}