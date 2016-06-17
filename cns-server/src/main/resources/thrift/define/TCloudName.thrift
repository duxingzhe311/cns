namespace java com.shifen.cloud.naming.common.thrift.define

struct TCloudName {
  
  1:i64 id;
  // online, preonline
  2:string platform,
  // module name
  3:string moduleName,
  // ecs, rds, slb.. etc
  4:string type,
  // data center name
  5:string idc

}