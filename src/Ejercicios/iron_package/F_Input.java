package iron_package;

import java.util.Scanner;

public class F_Input {
    static boolean primitive_is_read = false;
    static Scanner sc = new Scanner(System.in);
    public static int Int_mode(){

        primitive_is_read = true;

        return sc.nextInt();
    }

    public static String String_mode(){
        if (primitive_is_read){
            primitive_is_read = false;
            sc.nextLine();
        }

        return sc.nextLine();
    }
}