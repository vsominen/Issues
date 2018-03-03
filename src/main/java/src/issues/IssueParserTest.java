package issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class IssueParserTest {
    private String fileAsString;
    
    @Before
    public void setUp() throws Exception {
       BufferedReader reader = new BufferedReader(new FileReader("C:\\github-repos\\githubapi-issues-vsominen\\src\\main\\java\\src\\issues\\sample-output.txt"));
       StringBuilder sb=new StringBuilder();
       String line=reader.readLine();
       while(line != null) { 
           sb.append(line).append("\n"); 
           line = reader.readLine();    
       }
        fileAsString = sb.toString(); 
        reader.close();
    }
    
    @Test
    public void testParseIssues() throws ParseException, IOException {
        IssueParser issueParserObject=new IssueParser();
        IssuesExporter exp=new IssuesExporter();
        IssueTest is=new IssueTest();
        is.testEqualsReflexive();
        is.testEqualsTwoWithSameId();
        is.testHashCodeWithSameId();
        is.testToString();
        System.out.println(fileAsString);
        List<Issue> al = issueParserObject.parseIssues(fileAsString);
        assertNotNull(al);
        assertEquals(3, al.size());
        Issue issue0 = al.get(0);
        assertEquals(295014135,issue0.getId());
    }
    
}