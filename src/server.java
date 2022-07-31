import java.io.*;
import java.io.DataInputStream;
import java.net.*;
public class server extends Thread{
    int portNumber;
    Socket s;
    String str= "";

    public server(int portNumber) throws IOException {
        this.portNumber = portNumber;
    }
    @Override
    public void run() {
        ServerSocket ss= null;
        try {
            ss = new ServerSocket(portNumber);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");

            System.out.println("Client accepted");
            while (true) {
                s = ss.accept();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                str = (String) dis.readUTF();
                System.out.println("message= " + str);
                protocol.checkProtocol(str);

                if (str.equals("over"))
                    break;
            }
            ss.close();

        }
        catch(Exception e)
        {System.out.println(e);
        }

    }
}  