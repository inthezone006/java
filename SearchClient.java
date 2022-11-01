import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.*;

public class SearchClient {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to the program!", "Client", JOptionPane.INFORMATION_MESSAGE);
        String hostName = JOptionPane.showInputDialog(null, "Please enter the hostname: ", "Client", JOptionPane.QUESTION_MESSAGE);
        boolean toContinue = true;
        int portNum = 0;
        if (hostName != null) {
            String portNumString = JOptionPane.showInputDialog(null, "Please enter the port number: ", "Client", JOptionPane.QUESTION_MESSAGE);
            if (portNumString == null) {
                JOptionPane.showMessageDialog(null, "Goodbye!", "Client", JOptionPane.INFORMATION_MESSAGE);
                toContinue = false;
            } else {
                portNum = Integer.parseInt(portNumString);
            }    
        } else {
            JOptionPane.showMessageDialog(null, "Goodbye!", "Client", JOptionPane.INFORMATION_MESSAGE);
            toContinue = false;
        }

        try {
            if (toContinue) {
                Socket socket = new Socket(hostName, portNum);
                JOptionPane.showMessageDialog(null, "Connection established!", "Client", JOptionPane.INFORMATION_MESSAGE);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                do {
                    String term = JOptionPane.showInputDialog(null, "Enter search term: ", "Client", JOptionPane.QUESTION_MESSAGE);
                    if (term == null) {
                        JOptionPane.showMessageDialog(null, "Goodbye!", "Client", JOptionPane.INFORMATION_MESSAGE);
                        toContinue = false;
                        break;
                    }
                    writer.write(term);
                    writer.println();
                    writer.flush();

                    ArrayList<String> allTerms = new ArrayList<>();
                    String line = reader.readLine();
                    while (line != null) {
                        allTerms.add(line);
                        line = reader.readLine();
                    }
                    if (allTerms.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No results found", "Client", JOptionPane.INFORMATION_MESSAGE); 
                    } else {
                        String[] searchTerms = new String[allTerms.size()];
                        String[] currentSearchTerm;
                        for (int i = 0; i < allTerms.size(); i++) {
                            currentSearchTerm = allTerms.get(i).split(";");
                            searchTerms[i] = currentSearchTerm[1];
                        }

                        String selectedSearch = (String) JOptionPane.showInputDialog(null, "Please select a search term: ", "Client", JOptionPane.PLAIN_MESSAGE, null, searchTerms, searchTerms[0]);
                        if (selectedSearch == null) {
                            JOptionPane.showMessageDialog(null, "Goodbye!", "Client", JOptionPane.INFORMATION_MESSAGE); 
                            toContinue = false;
                            break;
                        } else {
                            int intendedSearchLine = 0;
                            for (int k = 0; k < searchTerms.length; k++) {
                                if (searchTerms[k].equals(selectedSearch)) {
                                    intendedSearchLine = k;
                                }
                            } 

                            String fullSearchLine = allTerms.get(intendedSearchLine);
                            String[] fullStringList = fullSearchLine.split(";");
                            String stringToReturn = fullStringList[2];
                            JOptionPane.showMessageDialog(null, stringToReturn, "Client", JOptionPane.INFORMATION_MESSAGE);
                        } 
                    }

                    int continueOrder = JOptionPane.showConfirmDialog(null, "Would you like to search again?", "Client", JOptionPane.YES_NO_OPTION);

                    if (continueOrder == JOptionPane.NO_OPTION) {
                        toContinue = false;
                        break;
                    }
                } while (toContinue);
                JOptionPane.showMessageDialog(null, "Goodbye!", "Client", JOptionPane.INFORMATION_MESSAGE); 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error!", "Client", JOptionPane.INFORMATION_MESSAGE);
            toContinue = false;
        }
    }
}
