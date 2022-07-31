import java.util.Date;

public class protocol {
    static String msg="";
    public static void checkProtocol(String line) {

        if (line.equals("over")) {
            System.out.println("Connection disabled");


        } else {
            if (line.length() >= 4) {
                //msg = line.substring(2, 6);
                msg = line.contains("name") ? "name" : line.contains("age") ? "age" : line.contains("date") ? "date" : "";
                // System.out.println("Entered server try to print val");
                switch (msg) {
                    case "name":
                        System.out.println("Hello " + line.substring(6, line.length()));
                        break;
                    case "date":
                        System.out.println(new Date());
                        break;
                    case "age":
                        int age = Integer.parseInt(line.substring(5, line.length()));
                        //System.out.println("Age " + age);
                        String ageMsg = age < 20 ? "Hello kido" : (age > 40 ? "Hello Senior" : "Hello Mr");
                        System.out.println(ageMsg);
                        break;
                    default:
                        System.out.println("ERROR " + line);
                        break;
                }
            } else
                System.out.println("ERROR " + line);
        }

    }

}
