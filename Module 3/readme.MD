# Map Reduce Development Basics

![Hadoop Logo](http://www.datameer.com/images/technology/hadoop-pic1.png)

## Overview

**These are the labs for module 3 in the Hadoop courese**,  *the labs will take you through the process of developing map reduce jobs, the data used is the NOAA wheather dataset described in the book "Hadoop: The Definitive Guide" (you will need the book for this lab)*.

### Lab 1 - Setting Up a New Project

#### Exercise 1 - Create a New Maven Project in IntelliJ IDEA  
	
- Open IntelliJ IDEA and

![](images/1.png)
 
- Select the Maven option and click Next

![](images/2.png)

- Fill the GroupId and ArtifactId fields. For the duration of the course you can use the GroupId of **com.hadoop.example**. For this Lab use *SimpleMR* for the ArtifactId

![](images/3.png)

- Give the project a name (can be the artifact id or any other value)

![](images/4.png)

- Click the **Enable Auto-Import** link when prompted

![](images/5.png)

#### Exercise 2 - Set Up Maven

- Locate and open the pom.xml file under the project folder

![](images/2_1.png)

- Add a **repositories** section containing the Cloudera Maven repository to the pom.xml file using the following code:

```
<repositories>
    <repository>
        <id>cloudera</id>
        <url>https://repository.cloudera.com/artifactory/cloudera-repos/</url>
    </repository>
</repositories>

```

- Add a **dependencies** section containing the hadoop-client dependency using the following code. Use the **2.5.0-cdh5.3.2** version.

```
<dependencies>
    <dependency>
        <groupId>org.apache.hadoop</groupId>
        <artifactId>hadoop-client</artifactId>
        <version>{version}</version>
    </dependency>
</dependencies>   
```

### Lab 2 - Developing a Map Reduce Job

**Note:** the exercise in this lab are based on the NOAA weather dataset, please familiarize yourself with the data structure, by reading the "A Weather Dataset" topic in the book. The topic can be fund under **I. Hadoop Fundamentals -> 2. MapReduce -> A Weather Dataset**.

#### Exercise 1 - Creating a Mapper

The first mapper implementation will emit key-value pairs containing the station identifier where the temperature was recorder and the value (temperature) that was recorded.- create a new Java class called "StationTemperatureMapper" using the following definition:

```
public class StationTemperatureMapper
  extends Mapper<LongWritable, Text, Text, IntWritable> {
}
```

- Override the map function using the following definition:

```
@Override
public void map(LongWritable key, Text value, Context context)
   throws IOException, InterruptedException {
}
```

- Implement the map function to emit key-value pairs of station identifiers and temperature. The following instructions should be used in the map function code:  - The key is the combination of the USAF + WBAN weather station identifiers.  - The temperature value starts at the 87th char unless a leading + is used, in that case it starts the 88th char.  - In both cases temperature value ends at the 92nd char.  - Rows where the temperature is 9999 and the quality code is either 0,1,4,5 or 9 should be ignored.  - Make sure you use the Hadoop writable types for serialization.

#### Exercise 2 - Creating a Reducer

This reducer implementation will emit the avarage temperature (type of double) per station.- create a new Java class called "AvgTemperatureReducer" using the following definition:

```
public class AvgTemperatureReducer
  extends Reducer<Text, IntWritable, Text, IntWritable> {
}
```

- Override the reduce function using the following definition:

```
@Override
public void reduce(Text key, Iterable<IntWritable> values, Context context)
  throws IOException, InterruptedException {
}
```

- Implement the reduce function to emit key-value pairs of station identifiers and avarage temperature. 

#### Exercise 3 - Creating a Map Reduce Job and Executing it on the Cluster

In this exercise we will create an additional utility class known as the main class or driver that will create the Map Reduce Job object, configure it and execute the job

- create a new Java class called "AvgTemperature" containing a public static method called main using the following definition:

```
public class AvgTemperature {

  public static void main(String[] args) throws Exception {
  }

}
```
- Implement the main method to do the following:  - Validates that the user provides an inputpath and outputpat parameters.  - Creates a new instance of the org.apache.hadoop.mapreduce.Job cla	ss.  - configure the job's jar and name.  - Configure the job's mapper and reducers classes.  - Set the map key and value types  - Set the reduce key and value types
  - Set the input and output path  - Execute the job and report 0 for success and -1 for failure- build the jar file using the following Maven command:
```
mvn package```
- execute the map reduce job using the following command:
```
hadoop jar <jar_file_name> <main_class_name> <input_path> <output_path>```