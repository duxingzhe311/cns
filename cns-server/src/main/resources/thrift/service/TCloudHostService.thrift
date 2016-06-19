namespace java com.shifen.cloud.name.common.thrift.service

include "../define/TCloudHost.thrift"
include "../exception/Exception.thrift"

service TCloudHostService {
  /**
   * get
   */
  TCloudHost.TCloudHost getByPrimaryKey(1:i64 id) throws (1:Exception.ThriftException ex),
  TCloudHost.TCloudHost getByIp(1:string ip) throws (1:Exception.ThriftException ex),
  
  /**
   * update
   */
  i32 updateHost(1:TCloudHost.TCloudHost host) throws (1:Exception.ThriftException ex),

  /** 
   * add
   */
  i32 addHost(1:TCloudHost.TCloudHost host) throws (1:Exception.ThriftException ex),
  
  /**
   * delete
   */
  i32 deleteHost(1:TCloudHost.TCloudHost host) throws (1:Exception.ThriftException ex),
}
