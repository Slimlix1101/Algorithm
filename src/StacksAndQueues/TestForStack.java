package StacksAndQueues;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestForStack extends LinkedStackOfStrings {
    public static void main(String[] args) {
        try {
            LinkedStackOfStrings stack = new LinkedStackOfStrings();
            String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\User\\Desktop\\StackTest\\article1.txt")));
            String[] words = content.split(" "); // spilt the content of file
            for (String word : words)
            {
                if (word.equals("-")) System.out.print(stack.pop() + ' ');
                else stack.push(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}