package pl.sda.programming1.datastructures.domain;

import java.util.Objects;

public class Username implements Comparable<Username> {
    private String login;

    public Username(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public int compareTo(Username o) {
        return getLogin().compareTo(o.getLogin());
    }

    @Override
    public String toString() {
        return "Username{" +
                "login='" + login + '\'' +
                '}';
    }
}
