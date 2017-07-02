package rest;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by programmer on 02/07/17.
 */

@XmlRootElement
public class student {
    private int id;
    private String username ;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
