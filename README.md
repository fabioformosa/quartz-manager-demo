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

* add a controller `UserController`
  
```
@RestController
@RequestMapping(value = "/quartz-manager/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @GetMapping("/whoami")
    public @ResponseBody String user() {
        return "\"NO_AUTH\"";
    }

}
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

* Enable quartz-manager

```
quartz.enabled=true
quartz-manager.jobClass=<QUALIFIED NAME OF THE JOB CLASS>
job.frequency=4000
job.repeatCount=19
```

* frontend
Open it: [http://localhost:8080/quartz-manager-ui/index.html](http://localhost:8080/quartz-manager-ui/index.html)

## Roadmap
In the roadmap:

* we're going to avoid unuseful properties to be set
* we're going to enable a security for `quartz-manager-api` 

## Contributes

Every contribution is welcome! Open an issue, so we can discuss about new features and implement them.


