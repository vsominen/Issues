package issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;


public class IssueTest {

    @Test
   public void testEqualsReflexive() {
        Issue issue1 =new Issue();
        issue1.setId(1);
        assertTrue(issue1.equals(issue1));
    }
    
    @Test
    public void testEqualsTwoWithSameId() {
        Issue issueA =new Issue();
        issueA.setId(1);
        Issue issueB =new Issue();
        issueB.setId(1);        
        assertTrue(issueA.equals(issueB));
        assertEquals(1, issueA.getId());
    }
    @Test
    public void testHashCodeWithSameId()
    {
        Issue one=new Issue();
        one.setId(5);
        Issue two=new Issue();
        two.setId(5);
        assertEquals(one.hashCode(),two.hashCode());
    }
    @Test
   public  void testToString() throws ParseException, IOException
    {
        SimpleDateFormat d = new SimpleDateFormat("mm-dd-yyyy");
        Issue obj=new Issue();
        IssuesExporter i=new IssuesExporter();
        System.out.println(i);
        int q=0,j=0;
        User u=new User();
        String l="somineni";
        u.setLogin(l);
        u.setId(4);
        u.getLogin();
        assertEquals(4,u.getId());
        assertTrue(u.equals(u));
        assertEquals(4, u.getId());
        assertEquals(u.hashCode(),u.hashCode());
        
        
        obj.setId(4);
        obj.setState("closed");
        obj.setTitle("New Issue");
        obj.setCreatedAt(d.parse("08-17-2017"));
        obj.setBody("Hello");
        obj.setNumber(5);
        obj.setUser(u);
        obj.setAssignee(u);
        obj.setClosedAt(d.parse("02-19-2018"));
        String s=obj.toString();
        q=obj.getId();
        j=obj.getNumber();
        String a=obj.getState();
        String b=obj.getTitle();
        String x=obj.getBody();
        obj.getAssignee();
        obj.getClass();
        obj.getClosedAt();
        obj.getCreatedAt();
        obj.getUser();
        obj.getAssignee();
        System.out.println(s);
        IssuesExporter ieobj=new IssuesExporter();
        IssuesExporter.main();
        assertEquals("Issue [number=5, id=4, state=closed, title=New Issue, body=Hello, createdAt=Tue Jan 17 00:08:00 EST 2017, closedAt=Fri Jan 19 00:02:00 EST 2018, user=User [login=somineni, id=4], assignee=User [login=somineni, id=4]]",s); 
    }
}
