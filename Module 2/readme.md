# HDFS Basics

![Hadoop Logo](http://www.datameer.com/images/technology/hadoop-pic1.png)

## Overview

**These are the labs for module 2 in the Hadoop courese**,  *these labs will take you through the process using the HDFS cli for viewing and administering the Hadoop Distributed File-system*.

### Lab 1 - The HDFS Shell

#### Exercise 1 - File-system operations using the HDFS Shell  
	
- Download the books dataset from [https://s3-ap-southeast-2.amazonaws.com/uxcpshadoop/books.zip](https://s3-ap-southeast-2.amazonaws.com/uxcpshadoop/books.zip) to the home directory on the Cloudera quickstart VM.
- Extract the zip file.
- Perform the following actions using the HDFS shell, when needed use the [HDFS shell documentation](http://hadoop.apache.org/docs/current/hadoop-project-dist/hadoop-common/FileSystemShell.html):
  - Upload the content of the books folder to the following HDFS location: **/user/cloudera/books**.
  - Print out to the console the number of files in the **/user/cloudera/books** directory.
  - Move all the books starting with the letter t to **/user/cloudera/t-books**.
  - Merge **/user/cloudera/books** and **/user/cloudera/t-books** 
  - Check if the following files exist:
    - /user/cloudera/books/Metamorphosis by Franz Kafka.txt
    - /user/cloudera/t-books/The Art of War by Sunzi.txt
    - /user/cloudera/books/Pro Couchbase Server.txt
  - Create an empty file called **<your_name>.txt** in /user/couldera 

#### Exercise 2 - Set Up HDFS Caching

**Note:** We recommend  you use the [Centralized Cache Management in HDFS](https://hadoop.apache.org/docs/r2.3.0/hadoop-project-dist/hadoop-hdfs/CentralizedCacheManagement.html#Cache_pool_commands) guide, to find the relevant cacheadmin commands as well as expand your understanding of HDFS  Caching.

- Setup a cache pool with TTL of 90 minutes
- Make sure all the content of **/user/cloudera/t-books/** is cached using the above pool