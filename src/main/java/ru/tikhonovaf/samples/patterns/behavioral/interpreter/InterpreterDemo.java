package ru.tikhonovaf.samples.patterns.behavioral.interpreter;

import java.util.HashSet;
import java.util.Set;

// --------- Expression ----------
interface PermissionExpression {
    boolean interpret(Set<String> userRoles);
}

// --------- Terminal Expression ----------
class Role implements PermissionExpression {
    private final String role;

    public Role(String role) {
        this.role = role;
    }

    @Override
    public boolean interpret(Set<String> userRoles) {
        return userRoles.contains(role);
    }
}

// --------- Non-Terminal Expressions ----------
class AndExpression implements PermissionExpression {
    private final PermissionExpression expr1;
    private final PermissionExpression expr2;

    public AndExpression(PermissionExpression expr1, PermissionExpression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(Set<String> userRoles) {
        return expr1.interpret(userRoles) && expr2.interpret(userRoles);
    }
}

class OrExpression implements PermissionExpression {
    private final PermissionExpression expr1;
    private final PermissionExpression expr2;

    public OrExpression(PermissionExpression expr1, PermissionExpression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(Set<String> userRoles) {
        return expr1.interpret(userRoles) || expr2.interpret(userRoles);
    }
}

// --------- Main ----------
public class InterpreterDemo {
    public static void main(String[] args) {
        Set<String> rolesAlice = new HashSet<>();
        rolesAlice.add("USER");
        rolesAlice.add("ADMIN");

        Set<String> rolesBob = new HashSet<>();
        rolesBob.add("USER");

        // Создаем правила доступа
        PermissionExpression adminRole = new Role("ADMIN");
        PermissionExpression userRole = new Role("USER");
        PermissionExpression adminOrUser = new OrExpression(adminRole, userRole);
        PermissionExpression adminAndUser = new AndExpression(adminRole, userRole);

        System.out.println("Alice has adminOrUser? " + adminOrUser.interpret(rolesAlice)); // true
        System.out.println("Bob has adminOrUser? " + adminOrUser.interpret(rolesBob));     // true

        System.out.println("Alice has adminAndUser? " + adminAndUser.interpret(rolesAlice)); // true
        System.out.println("Bob has adminAndUser? " + adminAndUser.interpret(rolesBob));     // false
    }
}
