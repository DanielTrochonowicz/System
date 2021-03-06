package system;

import system.Issue.Issue;
import system.users.User;

import java.util.ArrayList;
import java.util.List;


public class IssueSystem {

    private static class IssueSystemSingleton{

        private static IssueSystem INSTANCE = new IssueSystem();
}
    private IssueSystem(){
        this.issueList = new ArrayList<Issue>();
        this.userList = new ArrayList<User>();
    }

    public static IssueSystem getInstance(){
        return IssueSystemSingleton.INSTANCE;
    }

    List<User> userList;
    List<Issue> issueList;

    public List<User> getUserList() {
        return userList;
    }

    public List<Issue> getIssueList() {
        return issueList;
    }
}
