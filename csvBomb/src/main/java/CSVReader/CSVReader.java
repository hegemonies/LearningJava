package CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void toRead(String fileName) throws Exception {
        try {
            FileReader reader = new FileReader(fileName);

            char[] buffer = new char[256];
            while (reader.read(buffer) > 0) {
                
            }

            reader.close();
        } catch (IOException exc) {
            throw new Exception(exc.getMessage());
        }

    }
}
