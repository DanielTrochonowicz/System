package system.users.behaveImp;

import system.Issue.Issue;
import system.users.UserBehavior;

public class DefaultBehavior implements UserBehavior<Issue> {

    public void doSomthing(Issue obj) {
        System.out.println("Jestem DefaultBehavior");
    }
}
