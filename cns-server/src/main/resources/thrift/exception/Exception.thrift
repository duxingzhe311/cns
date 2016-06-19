namespace java com.shifen.cloud.name.common.thrift.exception

exception ThriftException{
	1: i32 errorCode;
	2: string errorName;
	3: string errorInfo;
}