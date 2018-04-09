import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Issue implements Comparable<Issue> {

    public int number;
    public int id;
    public String state;
    public String title;
    public String body;
    public Date createdAt;
    public Date closedAt;
    public User user;
    public User assignee;

    public void setUser(User user) {
        this.user = user;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        Issue other = (Issue) obj;
        if (this.id == other.id) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Issue [number=" + number + ", id=" + id + ", state=" + state
                + ", title=" + title + ", body=" + body + ", createdAt="
                + createdAt + ", closedAt=" + closedAt + ", user=" + user
                + ", assignee=" + assignee + "]";
    }

    public Issue() {
        super();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

    public User getUser() {
        return user;
    }

    public User getAssignee() {
        return assignee;
    }

    public int compareTo(Issue i) {
        List<Issue> al = new ArrayList<Issue>();
        Collections.sort(al);
        int x = 0;
        if (this.id > i.id) {
            x = 1;
        }
        else if (this.id < i.id) {
            x = -1;
        }
        else {
            x = 0;
        }
        return x;
    }
}
