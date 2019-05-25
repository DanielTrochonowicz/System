package system.users;

import org.junit.Before;
import org.junit.Test;
import system.Issue.Issue;
import system.Issue.IssuePriority;
import system.Issue.IssueType;
import system.users.behaveImp.DefaultBehavior;
import system.users.behaveImp.IssueCommentReader;

public class ObserverTest {

    private SimplyUser s1;
    private SimplyUser s2;
    private SimplyUser s3;

    private Issue issueOne;
    private Issue issueTwo;
    private Issue issueThree;

    @Before
    public void prepareUsers() {
        s1 = new SimplyUser("Rafał","Siergiej",
                RoleType.USER, new DefaultBehavior());

        s2 = new SimplyUser("Daniel","Kowalski",
                RoleType.USER, new IssueCommentReader());

        s3 = new SimplyUser("Patryk","Nowak",
                RoleType.USER, new DefaultBehavior());
    }
    @Before
    public void prepareIssues(){
        issueOne = Issue.builder()
                .assingUser(s1)
                .creator(s2)
                .description("Opis Pierwszego Issue")
                .priority(IssuePriority.HIGH)
                .title("Potrzebne na wczoraj")
                .type(IssueType.ERROR)
                .build();

        issueTwo = Issue.builder()
                .assingUser(s1)
                .creator(s2)
                .description("OpisDrugiego Issue")
                .priority(IssuePriority.LOW)
                .title("Nie zrobimy tego nigdy")
                .type(IssueType.WORK)
                .build();

        issueThree = Issue.builder()
                .assingUser(s2)
                .creator(s1)
                .description("Opis Trzeciego Issue jest bardziej nudny")
                .priority(IssuePriority.LOW)
                .title("To jest tytuł 3 issue")
                .type(IssueType.WORK)
                .build();
    }

    @Test
    public void checkObserver() {
        issueOne.assingToSubject(s1);
        issueOne.assingToSubject(s2);

        issueTwo.assingToSubject(s3);

        issueThree.assingToSubject(s2);
        issueThree.assingToSubject(s3);

        issueThree.changeDescription("Zmiana opisu issueThree");
        issueOne.notifyObservers();
        issueTwo.notifyObservers();
    }
}

