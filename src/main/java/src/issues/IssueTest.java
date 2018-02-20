package issues;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

class IssueTest {

    @Test
    void testEqualsReflexive() {
        Issue issue1 =new Issue();
        issue1.setId(1);
        assertTrue(issue1.equals(issue1));
    }
    
    @Test
    void testEqualsTwoWithSameId() {
        Issue issueA =new Issue();
        issueA.setId(1);
        Issue issueB =new Issue();
        issueB.setId(1);        
        assertTrue(issueA.equals(issueB));
        assertEquals(1, issueA.getId());
    }
    @Test
    void testHashCodeWithSameId()
    {
        Issue one=new Issue();
        one.setId(5);
        Issue two=new Issue();
        two.setId(5);
        assertEquals(one.hashCode(),two.hashCode());
    }
    @Test
    void testToString() throws ParseException
    {
        SimpleDateFormat d = new SimpleDateFormat("mm-dd-yyyy");
        Issue obj=new Issue();
        IssuesExporter i=new IssuesExporter();
        System.out.println(i);
        int q=0,j=0;
        User u=new User();
        Login l=new Login();
        l.username="vydehi";
        l.password="somineni";
        u.setLogin(l);
        u.setId(4);
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
        System.out.println(s);
        
        assertEquals(s,"Issue [number=5, id=4, state=closed, title=New Issue, body=Hello, createdAt=Tue Jan 17 00:08:00 EST 2017, closedAt=Fri Jan 19 00:02:00 EST 2018, user=issues.User@448c8166, assignee=issues.User@448c8166]"); 
    }
}
