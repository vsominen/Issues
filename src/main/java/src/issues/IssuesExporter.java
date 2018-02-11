package issues;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IssuesExporter {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        
        PrintWriter out=new PrintWriter(new File("issues.txt"));
        Scanner cin=new Scanner(System.in);
        System.out.println("Enter Username:");
        String un=cin.next();
        System.out.println("Enter Password");
        String pwd=cin.next();
        
        Issue one=new Issue();
        Issue two=new Issue();
        Issue three=new Issue();
        User u=new User();
        
        one.state="closed";
        two.state="open";
        three.id=45;
        
        List<Issue> obj=new ArrayList<Issue>();
        
        obj.add(one);
        obj.add(two);
        obj.add(three);
        System.out.println("No.of Issues "+obj.size());
        for(Issue i:obj)
        {
            out.println(i.toString());
        }
       
        out.close();
        cin.close();
        
    }

}
