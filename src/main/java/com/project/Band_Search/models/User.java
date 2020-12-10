package com.project.Band_Search.models;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //  private String userName;
    //  @Column(name = "first_name")
    private String firstName;
    //   @Column(name = "last_name")
    private String lastName;
    private String password;
    //  private String login;
    private String email;
    @Column(name = "reset_password_token")
    private String resetPasswordToken;


    public User() {

    }



    public User(//String userName,
                String firstName,
                String lastName,
                String password,
                //  String login,
                String email) {
        //this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        // this.login = login;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //  public String getUserName() {
    //     return userName;
    // }

    //  public void setUserName(String userName) {
    //   this.userName = userName;
    //  }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*  public String getLogin() {
          return login;
      }

      public void setLogin(String login) {
          this.login = login;
      }
  */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }
}
