package jsondata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.util.Iterator;
import java.util.Map;

public class IplCensorAnalyzer {
    public static void main(String[] args) {
        String inputJsonFile = "jsondata/ipl.json";
        String outputJsonFile = "jsondata/censored_ipl.json";

        String inputCsvFile = "jsondata/ipl.csv";
        String outputCsvFile = "jsondata/censored_ipl.csv";

        System.out.println("Processing IPL JSON Data...");
        processJsonFile(inputJsonFile, outputJsonFile);

        System.out.println("Processing IPL CSV Data...");
        processCsvFile(inputCsvFile, outputCsvFile);

        System.out.println("IPL Data Censorship Completed Successfully.");
    }

    // Process JSON File (Censorship)
    static void processJsonFile(String inputFile, String outputFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootArray = objectMapper.readTree(new File(inputFile));

            if (rootArray.isArray()) {
                for (JsonNode node : rootArray) {
                    if (node.isObject()) {
                        ObjectNode matchObj = (ObjectNode) node;

                        // Censor Team 1 and Team 2
                        if (matchObj.has("team1")) {
                            matchObj.put("team1", censorTeamName(matchObj.get("team1").asText()));
                        }
                        if (matchObj.has("team2")) {
                            matchObj.put("team2", censorTeamName(matchObj.get("team2").asText()));
                        }

                        // Censor Winner
                        if (matchObj.has("winner")) {
                            matchObj.put("winner", censorTeamName(matchObj.get("winner").asText()));
                        }

                        // Censor Player of the Match
                        if (matchObj.has("player_of_match")) {
                            matchObj.put("player_of_match", "REDACTED");
                        }

                        // Censor Score Object
                        if (matchObj.has("score") && matchObj.get("score").isObject()) {
                            ObjectNode scoreObj = (ObjectNode) matchObj.get("score");
                            ObjectNode newScoreObj = objectMapper.createObjectNode();

                            Iterator<Map.Entry<String, JsonNode>> fields = scoreObj.fields();
                            while (fields.hasNext()) {
                                Map.Entry<String, JsonNode> field = fields.next();
                                String censoredKey = censorTeamName(field.getKey());
                                newScoreObj.set(censoredKey, field.getValue());
                            }
                            matchObj.set("score", newScoreObj);
                        }
                    }
                }

                // Write Censored output JSON
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), rootArray);
                System.out.println("Censored JSON saved to: " + outputFile);
            }
        } catch (IOException e) {
            System.err.println("JSON Error: " + e.getMessage());
        }
    }

    // Process CSV File (Censorship)
    static void processCsvFile(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String headerLine = br.readLine();
            if (headerLine != null) {
                bw.write(headerLine);
                bw.newLine();

                String line;
                while ((line = br.readLine()) != null) {
                    // Csv structure:
                    // match_id,team1,team2,score_team1,score_team2,winner,player_of_match
                    String[] tokens = line.split(",");

                    if (tokens.length >= 7) {
                        tokens[1] = censorTeamName(tokens[1]); // team1
                        tokens[2] = censorTeamName(tokens[2]); // team2
                        // score_team1 and score_team2 are numbers (tokens 3, 4)
                        tokens[5] = censorTeamName(tokens[5]); // winner
                        tokens[6] = "REDACTED"; // player_of_match

                        String censoredLine = String.join(",", tokens);
                        bw.write(censoredLine);
                        bw.newLine();
                    }
                }
                System.out.println("Censored CSV saved to: " + outputFile);
            }

        } catch (IOException e) {
            System.err.println("CSV Error: " + e.getMessage());
        }
    }

    // Helper method to apply censorship logic to Team Names
    static String censorTeamName(String teamName) {
        if (teamName == null || teamName.trim().isEmpty()) {
            return teamName;
        }

        String[] parts = teamName.split(" ", 2); // Split by first space
        if (parts.length > 1) {
            return parts[0] + " ***"; // Mask part of team name
        }
        return teamName + " ***"; // Fallback for single-word names if needed
    }
}
