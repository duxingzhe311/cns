namespace java com.shifen.cloud.name.common.thrift.define

struct TCloudInstance {
  1:i64 id;
  // instance index, begin from 0
  2:i32 index,
  // online, preonline
  3:i64 serviceId,
  // host id
  4:i64 hostId,
  // ip
  5:string ip,
  // port
  6:i32 port,
  // 0: available
  // 1: unavailable
  7:i32 status,
  // other infomation
  8:string tag
}