package com.shifen.cloud.naming.common.entity;

/**
 * @author guofengzhao
 *
 */
public class CloudInstance {

  private long id; // required
  private int index; // required
  private long serviceId; // required
  private long hostId; // required
  private String ip; // required
  private int port; // required
  private int status; // required
  private String tag; // required
  
  public int getIndex() {
    return index;
  }
  public void setIndex(int index) {
    this.index = index;
  }

  public String getIp() {
    return ip;
  }
  public void setIp(String ip) {
    this.ip = ip;
  }
  public int getPort() {
    return port;
  }
  public void setPort(int port) {
    this.port = port;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public String getTag() {
    return tag;
  }
  public void setTag(String tag) {
    this.tag = tag;
  }
  public long getServiceId() {
    return serviceId;
  }
  public void setServiceId(long serviceId) {
    this.serviceId = serviceId;
  }
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public long getHostId() {
    return hostId;
  }
  public void setHostId(long hostId) {
    this.hostId = hostId;
  }
  
  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    
    stringBuilder.append(id + "," + index + "," + serviceId + ",");
    stringBuilder.append(hostId + "," + ip + ":" + port + ",");
    stringBuilder.append(status + ",");
    stringBuilder.append(tag);
    
    return stringBuilder.toString();
  }
}
