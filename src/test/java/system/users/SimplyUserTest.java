package system.users;

import org.junit.Assert;
import org.junit.Test;
import system.Issue.Issue;
import system.users.behaveImp.DefaultBehavior;
import system.users.behaveImp.IssueCommentReader;

public class SimplyUserTest {

    @Test(expected = RuntimeException.class)
    public void createSimplyWithAdminRole() {
        SimplyUser simplyUser = new SimplyUser("Janek", "Kowalski", RoleType.ADMIN, new DefaultBehavior());

        Assert.assertNull(simplyUser);
    }

    @Test
    public void createSimplyWithUserRole() {
        SimplyUser simplyUser = new SimplyUser("Janek", "Kowalski",
                RoleType.USER, new IssueCommentReader());

        Assert.assertNotNull(simplyUser);
        Issue newIssue = Issue.builder()
                .assingUser(simplyUser)
                .creator(simplyUser)
                .build();

        simplyUser.behave(newIssue);
        simplyUser.setBehavior(new DefaultBehavior());
        simplyUser.behave(newIssue);
    }

    @Test
    public void testId() {
        SimplyUser firstUser = new SimplyUser("Janek", "Kowalski",
                RoleType.USER, new IssueCommentReader());

        Assert.assertEquals(firstUser.getUserId(),User.idGenerator.intValue());

        SimplyUser secondUser = new SimplyUser("Marek", "Kowalski",
                RoleType.USER, new IssueCommentReader());

        Assert.assertEquals(secondUser.getUserId(),User.idGenerator.intValue());


        System.out.println("FisrtUser id = " + firstUser.getUserId());
        System.out.println("SecondUser id = " + secondUser.getUserId());
    }
}