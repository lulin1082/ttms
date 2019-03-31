package cn.tedu.ttms.system.entity;

import java.util.Date;

public class User {
  private Long id;
  private String username;
  private String password;
  private String salt;
  private String email;
  private String mobile;
  private Long valId;
  private Date createdTime;
  private Date modifiedTime;
  private String createdUser;
  private String modifiedUser;

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", salt='" + salt + '\'' +
            ", email='" + email + '\'' +
            ", mobile='" + mobile + '\'' +
            ", valId=" + valId +
            ", createdTime=" + createdTime +
            ", modifiedTime=" + modifiedTime +
            ", createdUser='" + createdUser + '\'' +
            ", modifiedUser='" + modifiedUser + '\'' +
            '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public Long getValId() {
    return valId;
  }

  public void setValId(Long valId) {
    this.valId = valId;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Date getModifiedTime() {
    return modifiedTime;
  }

  public void setModifiedTime(Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  public String getCreatedUser() {
    return createdUser;
  }

  public void setCreatedUser(String createdUser) {
    this.createdUser = createdUser;
  }

  public String getModifiedUser() {
    return modifiedUser;
  }

  public void setModifiedUser(String modifiedUser) {
    this.modifiedUser = modifiedUser;
  }
}
