package testiky;


public class Utils {

    public static int formatPrice(String inputPrice){

        return Integer.parseInt(inputPrice.replaceAll(" ", ""));
    }

}
