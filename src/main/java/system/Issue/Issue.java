package system.Issue;

import system.observers.Observer;
import system.observers.Publisher;
import system.observers.Subject;
import system.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class Issue implements Publisher, Subject {

    private static AtomicInteger idGenerator = new AtomicInteger();

    private final int id;
    private final String title;
    private String description;
    private final User creator;
    private User assignUser;
    private IssueType type;
    private IssuePriority priority;


    private List<Observer> observerList;

    public Issue(IssueBuilder builder) {
        this.id = Issue.idGenerator.incrementAndGet();
        this.title = builder.title;
        this.description = builder.description;
        this.creator = builder.creator;
        this.assignUser = builder.assignUser;
        this.type = builder.type;
        this.priority = builder.priority;
        this.observerList = new ArrayList<>();
    }
    public void changeDescription(String newDescription){
        this.description = newDescription;
        this.publish();
    }
    public static IssueBuilder builder(){
        return new IssueBuilder();
    }

    @Override
    public void publish() {
        System.out.println("Descriptions was modified");
        notifyObservers();
    }

    @Override
    public void assingToSubject(Observer o) {
    this.observerList.add(o);
    }

    @Override
    public void unassingFromSubject(Observer o) {
        this.observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        this.observerList.stream()
                .forEach(observer -> {
                    observer.notify(() -> {
                    System.out.println("Issus with title = [" + this.title + "] has  changed");
                });
                });
        Function<String, Integer> f = (String s) ->{
            return Integer.valueOf(s);
        };
    }

    public static class IssueBuilder {
        private int id;
        private String title;
        private String description;
        private User creator;
        private User assignUser;
        private IssueType type;
        private IssuePriority priority;

        public IssueBuilder() {

        }

        public IssueBuilder title(String title) {
            this.title = title;
            return this;
        }

        public IssueBuilder description(String description) {
            this.description = description;
            return this;
        }

        public IssueBuilder creator(User creator) {
            this.creator = creator;
            return this;
        }

        public IssueBuilder assingUser(User assingUser) {
            this.assignUser = assingUser;
            return this;
        }

        public IssueBuilder type(IssueType type) {
            this.type = type;
            return this;
        }

        public IssueBuilder priority(IssuePriority priority) {
            this.priority = priority;
            return this;
        }
        public Issue build(){
            return new Issue(this);
        }
    }
}
