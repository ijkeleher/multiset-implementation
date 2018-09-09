import java.util.*;
import java.io.*;
import java.lang.*;

public class Generator {

    private static List<String> data = new ArrayList<>();
    private static List<String> words = new ArrayList<>();

    // adjust this to change dataSize
    private static int dataSize = 100;

    public static void main(String[] args) throws IOException {
        //addWord add words to the word List 
        addWord();
         //these add data to the data List
        addStringDataWithSampling();
//        addIntDataWithSampling();
//        addCharDataWithSampling();
    }
    
    private static void addCharDataWithSampling() throws IOException{
        String file = "TestCustom.in";
        String alphabet = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        int length = alphabet.length();
        Random r = new Random();

        for (int i = 0; i < dataSize; i++) {
            String e = "A " + (alphabet.charAt(r.nextInt(length)));
            data.add(e);
        }
        
        getData().add("P");
        getData().add("Q");
        
        fileWriter(file);
    }

    private static void addIntDataWithSampling() throws IOException {
        String concat = null;
        String file = "TestCustom.in";

        int random = getRandomNumber(1, dataSize);

        while (getData().size() < dataSize) {
            int n = getRandomNumber(1, 9);
            concat = "A " + n;
            getData().add(concat);

        }

        while (getData().size() < dataSize) {

            int n = getRandomNumber(1, 9);
            String operation = getRandomOp(getRandomNumber(1, 3));
            concat = operation + n;
            getData().add(concat);

        }

        getData().add("P");
        getData().add("Q");

        fileWriter(file);

    }

    private static void addWord() {
        String fileName = "words.txt";
        File wordList = new File(fileName);
        Scanner reader = null;

        try {
            reader = new Scanner(wordList);
        } catch (FileNotFoundException e) {
            System.out.println("file \"" + fileName + "\" not found");
            System.exit(0);
        }

        while (reader.hasNextLine()) {
            String word = reader.nextLine();
            words.add(word);
        }
    }

    private static String getRandomOp(int op) {
        String s = null;

        switch (op) {
        case 1:
            s = "A ";
            break;
        case 2:
            s = "S ";
            break;
        case 3:
            s = "RO ";
            break;
        }
        ;
        return s;
    }

    private static List<String> getData() {
        return data;
    }

    private static int getRandomNumber(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void addStringDataWithSampling() throws IOException {
        String file = "TestCustom.in";
        String concat = null;

        int random = getRandomNumber(1, dataSize);
        Random randomizer = new Random();

        while (getData().size() < dataSize) {
            String w = words.get(randomizer.nextInt(words.size()));
            concat = "A " + w;
            getData().add(concat);

        }

        while (getData().size() < dataSize+ random) {

            String w = words.get(randomizer.nextInt(words.size()));
            String operation = getRandomOp(getRandomNumber(1, 3));
            concat = operation + w;
            getData().add(concat);

        }

        getData().add("P");
        getData().add("Q");

        fileWriter(file);

    }

    public static void fileWriter(String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (String s : data) {
            writer.write(s+"\n");
        }
        writer.close();
        //use this index number if you want to check you are generating right amount of items for datasize
        int i = 0;
        for (String s : data) {
            i++;
            System.out.println(i + s);
        }

    }

}
