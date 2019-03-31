package cn.tedu.ttms.system.entity;

public class Companie {
  private Long id;
  private String name;
  private String category;
  private String phone;
  private String email;
  private String address;
  private String note;
  private Long valid;
  private java.sql.Timestamp createdtime;
  private java.sql.Timestamp modifiedtime;
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

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Long getValid() {
    return valid;
  }

  public void setValid(Long valid) {
    this.valid = valid;
  }

  public java.sql.Timestamp getCreatedtime() {
    return createdtime;
  }

  public void setCreatedtime(java.sql.Timestamp createdtime) {
    this.createdtime = createdtime;
  }

  public java.sql.Timestamp getModifiedtime() {
    return modifiedtime;
  }

  public void setModifiedtime(java.sql.Timestamp modifiedtime) {
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
