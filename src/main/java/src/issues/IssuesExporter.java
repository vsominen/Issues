package issues;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class IssuesExporter {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        
        PrintWriter out=new PrintWriter(new File("issues.txt"));
        try {     
        Issue one=new Issue();
        Issue two=new Issue();
        Issue three=new Issue();
        one.setState("closed");
        two.setState("open");
        List<Issue> obj=new ArrayList<Issue>();
        obj.add(one);
        obj.add(two);
        obj.add(three);
        System.out.println("No.of Issues "+obj.size());
            for(Issue i:obj){
                out.println(i.toString());
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally {
            out.close();
        } 
    }

}
