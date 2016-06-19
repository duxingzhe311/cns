package com.shifen.cloud.name.common.entity;

/**
 * @author guofengzhao
 *
 */
public class CloudName {
  private long id; // required
  private String platform; // required
  private String moduleName; // required
  private String type; // required
  private String idc; // required
  
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getPlatform() {
    return platform;
  }
  public void setPlatform(String platform) {
    this.platform = platform;
  }
  public String getModuleName() {
    return moduleName;
  }
  public void setModuleName(String moduleName) {
    this.moduleName = moduleName;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public String getIdc() {
    return idc;
  }
  public void setIdc(String idc) {
    this.idc = idc;
  }
  
  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    
    stringBuilder.append(id + "," + platform + ".");
    stringBuilder.append(moduleName + "." + type + "." + idc);

    return stringBuilder.toString();
  }
}
