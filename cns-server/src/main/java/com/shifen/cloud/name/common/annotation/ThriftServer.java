package com.shifen.cloud.name.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Thrift Server注解
 * 
 * @author subo
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ThriftServer {

  /**
   * 名称
   * 
   * @return
   */
  public abstract String name() default "";

  /**
   * 处理器
   * 
   * @return
   */
  public abstract Class<?> processor() default ThriftServer.class;
}
