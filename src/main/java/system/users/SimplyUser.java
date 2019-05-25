package system.users;

import com.sun.javafx.binding.StringFormatter;
import javafx.beans.binding.StringExpression;
import system.observers.ObserverMethod;
import system.users.exceptions.WrongRoleException;

public class SimplyUser extends User {

    public SimplyUser(String name, String surname, RoleType role, UserBehavior behavior) {

        super(name, surname, role, behavior);

        if (RoleType.ADMIN.equals(role)) {
            throw new WrongRoleException("Zła rola");
        }
    }

    @Override
    public void notify(ObserverMethod p) {
        StringExpression msg = StringFormatter.format("User name = [%s] is notify", this.getName());
        System.out.println(msg.getValue());
        p.execute();
    }
}
