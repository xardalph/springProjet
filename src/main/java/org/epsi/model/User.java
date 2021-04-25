package org.epsi.model;
import javax.persistence.*;

@Entity
@Table(name = "User")
public class User
{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String login;
    private String name;
    private String username;
    private String password;
    private String address;

    public User() {}

    public User(String login, String name, String username, String password, String address)
    {
        this.login = login;
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
}
