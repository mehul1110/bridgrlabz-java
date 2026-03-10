package jsondata;

import org.junit.Test;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IplCensorAnalyzerTest {

    @Test
    public void testCensorTeamName() {
        assertEquals("Mumbai ***", IplCensorAnalyzer.censorTeamName("Mumbai Indians"));
        assertEquals("Royal ***", IplCensorAnalyzer.censorTeamName("Royal Challengers Bangalore"));
        assertEquals("Chennai ***", IplCensorAnalyzer.censorTeamName("Chennai Super Kings"));
        assertEquals("Delhi ***", IplCensorAnalyzer.censorTeamName("Delhi Capitals"));
        assertEquals("SingleWord ***", IplCensorAnalyzer.censorTeamName("SingleWord"));
    }

    @Test
    public void testJsonProcessingOutputExists() {
        String inputJson = "jsondata/ipl.json";
        String outputJson = "jsondata/censored_ipl_test.json";

        File inFile = new File(inputJson);
        if (inFile.exists()) {
            IplCensorAnalyzer.processJsonFile(inputJson, outputJson);
            File outFile = new File(outputJson);
            assertTrue("JSON output file should be generated", outFile.exists());
        }
    }

    @Test
    public void testCsvProcessingOutputExists() {
        String inputCsv = "jsondata/ipl.csv";
        String outputCsv = "jsondata/censored_ipl_test.csv";

        File inFile = new File(inputCsv);
        if (inFile.exists()) {
            IplCensorAnalyzer.processCsvFile(inputCsv, outputCsv);
            File outFile = new File(outputCsv);
            assertTrue("CSV output file should be generated", outFile.exists());
        }
    }
}
