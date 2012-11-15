Redmine/Chiliproject Java API
=============================

A fork of https://github.com/taskadapter/redmine-java-api (previously [this 404][1] and before that [another 404][2])

The https://github.com/redminedev/redmine-java-api

 - Uses Redmine REST API
 - Does not require any plugins installed to Redmine/Chiliproject server.
 - Runs on any standard Java platform as well as Android OS (version 2.2 or newer)
 - Supports HTTP proxy
 - Supports GZipped responses from servers

This fork makes the following changes:

 - Uses [slf4j] for logging
 - Has the entire history using LF in the repository

Maven Central dependency:
    
    <dependency>
        <groupId>com.github.stephenc.connectors</groupId>
        <artifactId>redmine-java-api</artifactId>
        <version>1.11.0</version>
    </dependency>

 [slf4j]: http://slf4j.org/
 [1]: https://github.com/redminedev/redmine-java-api
 [2]: http://redmine-java-api.googlecode.com
