import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anagrams {
    private String initialValue;
    private String result = "";

    public Anagrams(String initialValue) {
        this.initialValue = initialValue;
        this.workWithInitialValue();
    }

    private void workWithInitialValue () {
        String[] boxForWords = initialValue.split(" ");
        for (int i = 0; i < boxForWords.length; i++) {
            boxForWords[i] = reverseWord(boxForWords[i].trim());
        }
        for (int i = 0; i < boxForWords.length; i++) {
            if (i == boxForWords.length-1) {
                this.result = result + boxForWords[i];
                break;
            }
            this.result = result + boxForWords[i] + " ";
        }
    }

    private String  reverseWord (String value){
        Pattern pattern = Pattern.compile("[^a-z^A-Z]");
        Matcher matcher = pattern.matcher(value);
        ArrayList<String> arrayNotLetter = new ArrayList<>();
        while (matcher.find()) {
            arrayNotLetter.add(matcher.group() + " " + matcher.start() + " " + matcher.end());
        }
        String [] arrayForLetter = value.split(pattern.toString());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arrayForLetter.length; i++) {
            result.append(arrayForLetter[i]);
        }
        result.reverse();
        for (int i = 0; i < arrayNotLetter.size(); i++) {
            String[] valueNew = arrayNotLetter.get(i).split(" ");
            Integer index = Integer.parseInt(valueNew[1].trim());
            result.insert(index, valueNew[0]);
        }
        return result.toString().trim();
    }

    public String getResult() {
        return result;
    }

    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams("a1bcd efgh");
        System.out.println(anagrams.getResult());
    }

}