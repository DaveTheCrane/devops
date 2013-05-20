devops
======

Dumping ground for useful small tools that I use when doing sysadmin/housekeeping, that others might find useful. Don't expect anything earth-shatteringly clever in here, but it might help your day to flow a little more smoothly.

JDBC Ping
=========

Simple java class for checking whether a JDBC connection URL/username/password combo is valid. I often find myself entering these into webapp server config, and wanting to check that the database is visible from a given location.

Usage
-----
It's just one class, no package names, so compile in situ and run. Real stone-age java dev circa 1994! Note the need to add the relevant JDBC driver library to the classpath. Example below is for postgres, but should work with any JDBC-supported database.

````
sudo javac JdbcPing.java
java -cp lib/postgresql-9.2-1002.jdbc4.jar:. JdbcPing org.postgresql.Driver jdbc:postgresql://localhost/mydata username password
````
