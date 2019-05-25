package system.users.behaveImp;

import system.Issue.Issue;
import system.users.UserBehavior;

public class IssueCommentReader implements UserBehavior<Issue> {

    public void doSomthing(Issue obj) {
        System.out.println("Jestem IssueCommentReader");
        System.out.println(obj);
    }
}
