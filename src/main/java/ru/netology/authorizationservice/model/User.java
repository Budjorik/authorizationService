package ru.netology.authorizationservice.model;

import ru.netology.authorizationservice.enumeration.Authorities;
import java.util.List;
import java.util.Objects;

public class User {
    private String user;
    private String password;
    private List<Authorities> authorities;

    public User(String user, String password, List<Authorities> authorities) {
        this.user = user;
        this.password = password;
        this.authorities = authorities;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        User other = (User) obj;
        return this.user == other.user || (this.user != null && this.user.equals(other.getUser()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }

}
