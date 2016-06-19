package com.shifen.cloud.name.server.repository.host;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shifen.cloud.name.common.entity.CloudHost;
import com.shifen.cloud.name.server.repository.CloudHostDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class CloudHostDaoImplTest {

  @Autowired
  CloudHostDaoImpl daoImpl;
  
  @Test
  public void test() {
    CloudHost host = daoImpl.selectByPrimaryKey(1);
    System.err.println(host);
    System.err.println("hahahahaha");
  }

}
