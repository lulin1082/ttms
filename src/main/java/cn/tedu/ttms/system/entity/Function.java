package cn.tedu.ttms.system.entity;

import java.util.Date;

public class Function {
  private Long id;
  private String name;
  private String url;
  private Long type;
  private Long sort;
  private String note;
  private Long parentid;
  private String permission;
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

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Long getType() {
    return type;
  }

  public void setType(Long type) {
    this.type = type;
  }

  public Long getSort() {
    return sort;
  }

  public void setSort(Long sort) {
    this.sort = sort;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Long getParentid() {
    return parentid;
  }

  public void setParentid(Long parentid) {
    this.parentid = parentid;
  }

  public String getPermission() {
    return permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
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
