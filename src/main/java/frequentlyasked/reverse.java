package frequentlyasked;

public class reverse {

    public static void main(String[] args){
        String str= "revertheword";
        String result = "";
        char[] ca = str.toCharArray();
        for(char c: ca){
            result = c + result;
        }
        System.out.println(result);

    }
}
