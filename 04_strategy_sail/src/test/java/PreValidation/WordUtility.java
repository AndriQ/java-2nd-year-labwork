package PreValidation;

public class WordUtility {

    public static String[] separateWords(String line){
        return line.strip().split("\\W+");
    }
}
