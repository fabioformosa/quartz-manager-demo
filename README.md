# QUARTZ-MANAGER DEMO

This project is to demonstrate how to import [QUARTZ-MANAGER](https://github.com/fabioformosa/quartz-manager) as a library into your webapp.  

If you have a job to be scheduled, importing `quartz-manager-api`, your project has got the REST API layer to interact with Quartz Scheduler through the `quartz-manager-frontend` (in angular).
 
 
**NOTICE** This Demo Project in under development and it follows the [roadmap](https://github.com/fabioformosa/quartz-manager/projects) of the project [quartz-manager](https://github.com/fabioformosa/quartz-manager).
Currently we are striving to convert `quartz-manager` in a library that can be easily imported.
   

### QUICK START
If you have to import the [quartz-manager](https://github.com/fabioformosa/quartz-manager) like done in this demo project, follow these steps in your project:

* add the maven dependency in the `pom.xml`

```
<dependency>
  <groupId>it.fabioformosa.quartz-manager</groupId>
  <artifactId>quartz-manager-api</artifactId>
  <version>2.2.2-SNAPSHOT</version>
</dependency>

<dependency>
  <groupId>it.fabioformosa.quartz-manager</groupId>
  <artifactId>quartz-manager-ui-webjar</artifactId>
  <version>2.2.2-SNAPSHOT</version>
</dependency>
```

* add a `quartz.properties` file in the classpath (`src/main/resources`):

```
org.quartz.scheduler.instanceName=example
org.quartz.scheduler.instanceId=AUTO
org.quartz.threadPool.threadCount=1
```


* Add the job that you want to schedule
 
 ```
 public class SampleJob extends AbstractLoggingJob {

    @Override
    public LogRecord doIt(JobExecutionContext jobExecutionContext) {
        return new LogRecord(LogType.INFO, "Hello from QuartManagerDemo!");
    }

}
```

* Enable quartz-manager adding into the application.yml:

```
quartz:
  enabled: true

job: 
  frequency: 4000
  repeatCount: 19

quartz-manager:
  jobClass: <QUALIFIED NAME OF THE JOB CLASS>
```



* frontend
Open it: [http://localhost:8080/quartz-manager-ui/index.html](http://localhost:8080/quartz-manager-ui/index.html)

* security
If you want enable a security layer, add to the `pom.xml`:

```
<dependency>
  <groupId>it.fabioformosa.quartz-manager</groupId>
  <artifactId>quartz-manager-security</artifactId>
  <version>2.2.2-SNAPSHOT</version>
</dependency>
```

and in application.yml:

```
quartz-manager:
  security:
    login-model:
      form-login-enabled: true
      userpwd-filter-enabled : false
    jwt:
      enabled: true
      secret: "PLEASE_TYPE_HERE_A_SECRET"
      expiration-in-sec: 28800  # 8 hours
      header-strategy:
        enabled: false
        header: "Authorization"
      cookie-strategy:
        enabled: true
        cookie: AUTH-TOKEN
  accounts:
    in-memory:
      enabled: true
      users:
        - name: admin
          password: admin
          roles:
            - ADMIN      

```

## Roadmap
In the roadmap:

* we're going to publish the quartz-manager into the maven central repo. 

NB: At the moment, you have to pull the quartz-manager repo and install it locally with `mvn install`

## Contributes

Every contribution is welcome! Open an issue, so we can discuss about new features and implement them.


