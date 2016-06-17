#!/bin/bash
# written by guofengzhao, 20160617
# thrift generator

cd $(dirname $0)
cd ..
workspace=$(pwd)
thrift_dir=$workspace/src/main/resources/thrift/service
src_dir=$workspace/src/main/java/

cd $thrift_dir
for file in *.thrift; do 
  thrift -r --gen java $file
  if [ $? -eq 0 ]; then
    echo "thrift generate $file: success!"
    cp -r gen-java/* $src_dir/
  else 
    echo "thrift generate $file: fail!"
  fi
done
rm -rf gen-java
