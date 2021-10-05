import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> characterList = new ArrayList<>();
        String example1 = "and(sky)Blue";
        String example2 = "Barber(Shop)cooL";
        characterList.add(example1);
        characterList.add(example2);
        for (String character : characterList) {
            int position1 = 0;
            int position2 = 0;
            String initialReverse = "";
            String finalReverse = "";
            for (int i = 0; i < character.length(); i++) {
                if (character.toCharArray()[i] == '(') {
                    position1 = i;
                } else if (character.toCharArray()[i] == ')') {
                    position2 = i;
                }
            }
            String data = character.substring(position1 + 1, position2);
            for (int j = data.length() - 1; j >= 0; j--) {
                initialReverse += data.charAt(j);
            }
            finalReverse = character.substring(0, position1 + 1) + initialReverse + character.substring(position2);
            System.out.println(character);
            System.out.println(finalReverse);
            System.out.println("----------------------");
        }
    }
}
