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
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("ENTER A NEW MESSAGE");
            str = sc.nextLine();

            try {
                while(s==null) {
                    s = new Socket("localhost", portNum);
                    dout = new DataOutputStream(s.getOutputStream());
                }
                dout.writeUTF(str);
                dout.flush();
                if (str.equals("over"))
                {
                    break;
//                    try {
//                        s.close();
//
//                    } catch (IOException e) {
//                        System.out.println(e.getMessage());
//                    }

                }
                //dout.close();
              //  s.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        try {
            s.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}