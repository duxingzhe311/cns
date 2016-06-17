namespace java com.shifen.cloud.naming.common.thrift.service

include "../define/TCloudName.thrift"
include "../exception/Exception.thrift"

service TCloudNameService {
  /**
   * get
   */
  TCloudName.TCloudName getByPrimaryKey(1:i64 id) throws (1:Exception.ThriftException ex),
  
  /**
   * update
   */
  i32 updateServiceName(1:TCloudName.TCloudName serviceName) throws (1:Exception.ThriftException ex),

  /** 
   * add
   */
  i32 addServiceName(1:TCloudName.TCloudName serviceName) throws (1:Exception.ThriftException ex),
  
  /**
   * delete
   */
  i32 deleteServiceName(1:TCloudName.TCloudName serviceName) throws (1:Exception.ThriftException ex),
}
