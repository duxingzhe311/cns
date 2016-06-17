namespace java com.shifen.cloud.naming.common.thrift.service

include "../define/TCloudInstance.thrift"
include "../exception/Exception.thrift"

service TCloudInstanceService {
  /**
   * get
   */
  list<TCloudInstance.TCloudInstance> getCloudInstanceByService(1:string serviceName) throws (1:Exception.ThriftException ex),
  list<TCloudInstance.TCloudInstance> getCloudInstanceByHost(1:string host) throws (1:Exception.ThriftException ex),
  list<TCloudInstance.TCloudInstance> getCloudInstanceByIp(1:string ip) throws (1:Exception.ThriftException ex),
  
  /**
   * update
   */
  i32 updateInstance(1:TCloudInstance.TCloudInstance instance) throws (1:Exception.ThriftException ex),
  i32 updateInstanceStatus(1:TCloudInstance.TCloudInstance instance, 2:i32 status) throws (1:Exception.ThriftException ex),

  /** 
   * add
   */
  i32 addInstance(1:TCloudInstance.TCloudInstance instance) throws (1:Exception.ThriftException ex),
  
  /**
   * delete
   */
  i32 deleteInstance(1:TCloudInstance.TCloudInstance instance) throws (1:Exception.ThriftException ex),
}
