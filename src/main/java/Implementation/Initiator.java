package Implementation;

import Model.Message;
import Rules.ReplacementRule;
import Rules.ReversalRule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Initiator {
    public static void main(String[] args) {
        try {
            Path readpath= Paths.get("./src/main/resources/messageread.txt");
            Path writepath= Paths.get("./src/main/resources/messagewrite.txt");
            String fileContent= Files.readString(readpath);
            Message message= MessageController.getMessage(fileContent);

            message=MessageController.applyRules(message);




            Files.writeString(writepath,message.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


/* Algorithm
1. Accept File Name
2. Validate if the File Exists
3. Validate if File has correct Format, if correct, then save as model.Message Body
4. Declare Reversal Rule Class
5. Declare Replacement Rule
6. Apply To to Replacement Rule
7. Apply Subject-- Reversal Rule
8. Body rules
*/