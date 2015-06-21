# HDFS Basics

![Hadoop Logo](http://www.datameer.com/images/technology/hadoop-pic1.png)

## Overview

**This is the labs for module 1 in the Hadoop courese**,  *this lab will take you through the process building and running the Word Count map reduce job demonstrated in class.*.

### Lab 1 - Word Count

#### Exercise 1 - Observe the WordCount map reduce job code  

- Open IntelliJ IDEA.
- Use the **File->Open** menu item and open the WordCount folder under Module 1 in the labs repository.	
- Open the TokenizingMapper class, located under **src->main->java->com.hadoop.example** and observe the code. This class's main method is the map method which receives lines from the input files and generates key-value pairs containing each and every word as key, and the number 1 as value.
- Open the WordCount class located next to the TokenizingMapper class and observe the code. This class configures the map reduce job.

#### Exercise 2 - Build and run the WordCount map reduce job code

- Open the command-prompt and navigate to the WordCount folder under Module 1 in the labs repository.
- Run the following command to build the map reduce job jar file:

```
mvn package
```

- Copy or drag the jar file from the *target* folder inside the WordCount folder, to the cloudera home directory on your Hadoop cluster.
- Open the terminal on your Hadoop cluster, and run the following command to copy the dataset to your cluster:

```
hadoop distcp s3n://AKIAIHB4PMQIQZ73MHKQ:4gueMcQoQ0Wh9jGdZnA5zU4IUOD5O49Z2cBGnsiY@uxcpshadoop/books/* hdfs://localhost/user/cloudera/books
```
- Run the following command from the terminal on your Hadoop cluster to execute the map reduce job on the cluster:

```
hadoop jar WordCount-1.0-SNAPSHOT-job.jar /user/cloudera/books /user/cloudera/output/wordcount
```
- Once the job completes successfully open the HUE we UI by opening firefox on your Hadoop cluster and clicking on the Launch HUE UI button.
- Login using the following credentials:
	- **Username:** cloudera
	- **Password:** cloudera
-  On the righthand top bar click the **Manage HDFS** link. and than click **output** than **wordcount** and **part-r-00000** to review the jobs result.	