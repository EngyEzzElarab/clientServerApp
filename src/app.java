import java.io.IOException;
import java.util.Scanner;

public class app {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("PLease enter the server's port number");
        int portServer = Integer.parseInt(sc.nextLine());
        System.out.println("PLease enter the client's port number");
        int portClient = Integer.parseInt(sc.nextLine());
        server s = new server(portServer);
        client c = new client(portClient);
        s.start();
        c.start();
    }
}