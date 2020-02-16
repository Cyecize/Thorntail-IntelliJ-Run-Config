package com.cyecize.demo;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.wildfly.swarm.runner.Runner;

@ApplicationPath("/api")
public class RestApplication extends Application {

  public static void main(String[] args) throws Exception {
    Runner.main(args);
  }
}