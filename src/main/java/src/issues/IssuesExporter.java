package issues;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IssuesExporter {

    public static void main(String[] args) throws IOException {
        IssuesExporter obj = new IssuesExporter();
        obj.exportMethodIssue();
    }

    public void exportMethodIssue() throws IOException {
        PrintWriter o = new PrintWriter(new File("issues.txt"));
        System.out.println("Username");
        Scanner cin = new Scanner(System.in);
        String username = cin.nextLine();
        System.out.println("Password");
        String password = cin.nextLine();
        GitHubRestClient client = new GitHubRestClient();

        String json = client.requestIssues(username, password, "open");
        String jsonNew = client.requestIssues(username, password, "closed");
        IssueParser parser = new IssueParser();

        List<Issue> closed = parser.parseIssues(jsonNew);
        List<Issue> open = parser.parseIssues(json);
        open.addAll(closed);
        Collections.sort(open);

        for (Issue i : open) {
            o.println(i.toString());
        }
        System.out.println("the size is : " + open.size());

    }

}
