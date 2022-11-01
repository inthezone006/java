import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class SearchServer {
    public static void main(String[] args) throws IOException{

        ServerSocket serverSocket = new ServerSocket(4242);
        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream()); 
        while (true) {
            String message = reader.readLine();
            File myFile = new File("searchDatabase.txt");
            FileReader fr = new FileReader(myFile);
            BufferedReader bfr = new BufferedReader(fr);
            ArrayList<String> allLines = new ArrayList<>();
            String line = bfr.readLine();
            while (line != null) {
                allLines.add(line);
                line = bfr.readLine();
            }
            ArrayList<String> searchTerms = new ArrayList<>();
            for (int i = 0; i < allLines.size(); i++) {
                if (allLines.get(i).contains(message)) {
                    searchTerms.add(allLines.get(i));
                }
            } 
            bfr.close();
            for (int j = 0; j < searchTerms.size(); j++) {
                writer.write(searchTerms.get(j));
                writer.println();
            }
            writer.flush();
            writer.close();
            reader.close();
            if (line == null) {
                serverSocket.close();
            }
        }

        
    }
    
}
