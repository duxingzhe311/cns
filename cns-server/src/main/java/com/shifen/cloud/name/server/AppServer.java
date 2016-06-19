package com.shifen.cloud.name.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guofengzhao
 *
 */
public class AppServer {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
  }

}
