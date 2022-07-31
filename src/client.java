import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client extends Thread{
    static int portNum;
    Socket s = null;
    public client(int portNum){
        this.portNum = portNum;
    }

    @Override
    public void run() {
        String str = "";
        DataOutputStream dout =null;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("ENTER A NEW MESSAGE");
            str = sc.nextLine();
            if (str.equals("over"))
                break;
            try {
                if(s == null) {
                    s = new Socket("localhost", portNum);
                    dout = new DataOutputStream(s.getOutputStream());
                }
                dout.writeUTF(str);
                dout.flush();
                //dout.close();
              //  s.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}