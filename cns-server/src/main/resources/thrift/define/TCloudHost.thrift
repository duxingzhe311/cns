namespace java com.shifen.cloud.name.common.thrift.define

struct TCloudHost {
  // Host id 
  1:i64 id,
  // online, preonline
  2:string hostname,
  // cpu quota(core number)
  3:i32 cpuQuota,
  // mem quota(MB)
  4:i32 memQuota,
  // disk quota(MB)
  5:i32 systemDiskQuota,
  6:i32 homeDiskQuota,
  // inner ip
  7:string ip,
  // WAN ip
  8:string wanIp,
  // idc
  9:string idc
}