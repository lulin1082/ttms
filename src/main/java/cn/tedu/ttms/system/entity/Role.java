package cn.tedu.ttms.system.entity;

import java.util.Date;

public class Role {
  private Long id;
  private String name;
  private String note;
  private Date createdtime;
  private Date modifiedtime;
  private String createduser;
  private String modifieduser;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Date getCreatedtime() {
    return createdtime;
  }

  public void setCreatedtime(Date createdtime) {
    this.createdtime = createdtime;
  }

  public Date getModifiedtime() {
    return modifiedtime;
  }

  public void setModifiedtime(Date modifiedtime) {
    this.modifiedtime = modifiedtime;
  }

  public String getCreateduser() {
    return createduser;
  }

  public void setCreateduser(String createduser) {
    this.createduser = createduser;
  }

  public String getModifieduser() {
    return modifieduser;
  }

  public void setModifieduser(String modifieduser) {
    this.modifieduser = modifieduser;
  }
}
