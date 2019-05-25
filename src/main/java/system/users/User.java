package system.users;

import system.Issue.Issue;
import system.observers.Observer;

public abstract class User implements Observer {

   // private static AtomicInteger idGenerator = new AtomicInteger();
    public static Integer idGenerator = 0;

    private final int userId;
    private final String name;
    private final String surname;
    private RoleType role;
    private UserBehavior behavior;

    public User(String name, String surname, RoleType role, UserBehavior behavior) {
        //this.userId = User.idGenerator.incrementAndGet();
        User.idGenerator = User.idGenerator +1;
        this.userId = User.idGenerator;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.behavior = behavior;
    }

    public void behave(Issue issue){
        behavior.doSomthing(issue);
    }
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public RoleType getRole() {
        return role;
    }

    public UserBehavior getBehavior() {
        return behavior;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }
}
