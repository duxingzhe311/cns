namespace java com.shifen.cloud.service

struct CloudInstance {
  // instance index, begin from 0
  1:i32 index,
  // online, preonline
  2:string platform,
  // module name
  3:string moduleName,
  // ecs, rds, slb.. etc
  4:string type,
  // data center name
  5:string idc,
  // ip
  6:string ip,
  // port
  7:i32 port,
  // 0: available
  // 1: unavailable
  8:i32 status,
  // other infomation
  9:string tag
}

/**
 * core service defination
 */
service CloudInstanceService {
  /**
   * get
   */
  list<CloudInstance> getInstanceByService(1:string serviceName),
  list<CloudInstance> getInstanceByHost(1:string host),
  
  /**
   * update
   */
  i32 updateInstancePlatform(1:CloudInstance instance, 2:string platform),
  i32 updateInstanceModuleName(1:CloudInstance instance, 2:string moduleName),
  i32 updateInstanceType(1:CloudInstance instance, 2:string type),
  i32 updateInstanceIdc(1:CloudInstance instance, 2:string idc),
  i32 updateInstanceIp(1:CloudInstance instance, 2:string ip),
  i32 updateInstancePort(1:CloudInstance instance, 2:string port),
  i32 updateInstanceStatus(1:CloudInstance instance, 2:i32 status),
  i32 updateInstanceTag(1:CloudInstance instance, 2:string tag),

  /** 
   * add
   */
  i32 addInstance(1:CloudInstance instance),
  
  /**
   * delete
   */
  i32 deleteInstance(1:CloudInstance instance),
}