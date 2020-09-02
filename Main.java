package encryptdecrypt;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.File;
public class Main{
    public static String readString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
    public static void main(String[] args) throws IOException {
        int l=0,flag=0,check=0,i=0;
        String mode="enc",data="",input="",result,out="",al="shift";
        unicode obj1=new unicode();
        shift obj2=new shift();
        for(i=0;i<args.length;i++){
            if(args[i].equals("-key")){
                l=Integer.parseInt(args[i+1]);
            }
            if(args[i].equals("-alg")){
                al=args[i+1];
            }
            if(args[i].equals("-mode")){
                mode=args[i+1];
            }
            if(args[i].equals("-data")&& check==2){
                data=args[i+1];
            }
            if(args[i].equals("-out")){
                flag=flag+1;
                out=args[i+1];
            }
            if(args[i].equals("-in")){
                check=check+1;
                input=args[i+1];
                try {
                    data=readString(input);
                } catch (IOException e) {
                    System.out.println("Cannot read file: " + e.getMessage());
                }
            }
            if(args[i].equals("-data")){
                check=check+1;
                data=args[i+1];
            }
        }
        if(al.equals("unicode")){
            if(mode.equals("dec")){
                if(flag==1){
                    FileWriter writer = new FileWriter(out);
                    writer.write(obj1.decrypt(data,l));
                    writer.flush();
                    writer.close();
                }
                else
                    System.out.println(obj1.decrypt(data,l));
            }
            if(mode.equals("enc")) {
                if(flag==1){
                    File file = new File(out);
                    FileWriter writer = new FileWriter(file);
                    writer.write(obj1.encrypt(data,l));
                    writer.flush();
                    writer.close();
                }
                else
                    System.out.println(obj1.encrypt(data,l));
            }
        }
        if(al.equals("shift")){
            if(mode.equals("dec")){
                if(flag==1){
                    FileWriter writer = new FileWriter(out);
                    writer.write(obj2.decrypt(data,l));
                    writer.flush();
                    writer.close();
                }
                else
                    System.out.println(obj2.decrypt(data,l));
            }
            if(mode.equals("enc")) {
                if(flag==1){
                    File file = new File(out);
                    FileWriter writer = new FileWriter(file);
                    writer.write(obj2.encrypt(data,l));
                    writer.flush();
                    writer.close();
                }
                else
                    System.out.println(obj2.encrypt(data,l));
            }
        }
    }
}