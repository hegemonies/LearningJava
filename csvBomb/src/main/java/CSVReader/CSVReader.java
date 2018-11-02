package CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static String toRead(String fileName) throws Exception {
        try {
            FileReader reader = new FileReader(fileName);

//            char[] buffer = new char[256];
            String buffer = new String();
            char buf;
            try {
                while ((buf = (char) reader.read()) > 0) {
//                    buffer += buf;
                    String tmp = new StringBuilder().append(buf).toString();
                    buffer += tmp;
                }
//                reader.read(buffer);

                return buffer;
            } catch (Exception exc) {

            }

            reader.close();
        } catch (IOException exc) {
            throw new Exception(exc.getMessage());
        }

        return null;
    }

}
