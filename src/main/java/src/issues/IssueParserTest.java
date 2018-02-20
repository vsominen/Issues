package issues;

import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class IssueParserTest {
    
    @Before
    public String test() throws Exception {
       BufferedReader reader = new BufferedReader(new FileReader("C:\\github-repos\\githubapi-issues-vsominen\\src\\main\\java\\src\\issues\\sample-output.txt"));
       StringBuilder sb=new StringBuilder();
       String line=reader.readLine();
       while(line != null)
       { 
           sb.append(line).append("\n"); 
           line = reader.readLine();    
       }
       sb.append(reader.readLine());
        String fileAsString = sb.toString(); 
        System.out.println(fileAsString);
        reader.close();
        return fileAsString;
    }
    public static void main(String[] args) throws Exception
    {
        IssueParserTest ob=new IssueParserTest();
        String s=ob.test();
        IssueParser issueParserObject=new IssueParser();
        List<Issue> issues = new ArrayList<Issue>();
        List<Issue> al = new ArrayList<Issue>();
        Type collectionType = new TypeToken<List<Issue>>(){}.getType();
        al=issueParserObject.parseIssues(s);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        issues = gson.fromJson(s, collectionType);

    }
    
}
