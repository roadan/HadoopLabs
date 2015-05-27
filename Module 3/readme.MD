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

```XML
<repositories>
    <repository>
        <id>cloudera</id>
        <url>https://repository.cloudera.com/artifactory/cloudera-repos/</url>
    </repository>
</repositories>

```

- Add a **dependencies** section containing the hadoop-client dependency using the following code. Use the **2.5.0-cdh5.3.2** version.

```XML
<dependencies>
    <dependency>
        <groupId>org.apache.hadoop</groupId>
        <artifactId>hadoop-client</artifactId>
        <version>{version}</version>
    </dependency>
</dependencies>   
```

### Lab 2 - Developing a Map Reduce Job

**Note:** the exercise in this lab are based on the NOAA weather dataset, please familiarize yourself with the data structure, by reading the "A Weather Dataset" topic in the book. The topic can be found under **I. Hadoop Fundamentals -> 2. MapReduce -> A Weather Dataset**.

#### Exercise 1 - Creating a Mapper

The first mapper implementation will emit key-value pairs containing the station identifier where the temperature was recorder and the value (temperature) that was recorded.- create a new Java class called "StationTemperatureMapper" using the following definition:

```Java
public class StationTemperatureMapper
  extends Mapper<LongWritable, Text, Text, IntWritable> {
}
```

- Override the map function using the following definition:

```Java
@Override
public void map(LongWritable key, Text value, Context context)
   throws IOException, InterruptedException {
}
```

- Implement the map function to emit key-value pairs of station identifiers and temperature. The following instructions should be used in the map function code:  - The key is the combination of the USAF + WBAN weather station identifiers.  - The temperature value starts at the 87th char unless a leading + is used, in that case it starts the 88th char.  - In both cases temperature value ends at the 92nd char.  - Only rows where the temperature is not 9999 and the quality code is 0,1,4,5 or 9 should be included.  - Make sure you use the Hadoop writable types for serialization.

#### Exercise 2 - Creating a Reducer

This reducer implementation will emit the avarage temperature (type of double) per station.- create a new Java class called "AvgTemperatureReducer" using the following definition:

```Java
public class AvgTemperatureReducer
  extends Reducer<Text, IntWritable, Text, DoubleWritable> {
}
```

- Override the reduce function using the following definition:

```Java
@Override
public void reduce(Text key, Iterable<IntWritable> values, Context context)
  throws IOException, InterruptedException {
}
```

- Implement the reduce function to emit key-value pairs of station identifiers and avarage temperature. 

#### Exercise 3 - Creating a Map Reduce Job and Executing it on the Cluster

In this exercise we will create an additional utility class known as the main class or driver that will create the Map Reduce Job object, configure it and execute the job

- create a new Java class called "AvgTemperature" using the following definition:

```Java
public class AvgTemperature extends Configured implements Tool {

    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new AvgTemperature(), args);
        System.exit(res);
    }

     public int run(String[] args) throws Exception {
     
     }

}
```
- Implement the run method to do the following:  - Validates that the user provides two parameters (an inputpath and outputpath.  - Creates a new instance of the org.apache.hadoop.mapreduce.Job cla	ss.  - configure the job's jar and name.  - Configure the job's mapper and reducers classes.  - Set the map key and value types  - Set the reduce key and value types
  - Set the input and output path using the following code:
  ```Java
  FileInputFormat.addInputPath(job, new Path(args[0]));
  FileOutputFormat.setOutputPath(job, new Path(args[1]));
  ```  - Execute the job and report 0 for success and -1 for failure- build the jar file using the following Maven command:
```
mvn package```

- Copy the weather dataset using the hadoop distributed copy command
 
 ```
 hadoop distcp s3n://AKIAIHB4PMQIQZ73MHKQ:4gueMcQoQ0Wh9jGdZnA5zU4IUOD5O49Z2cBGnsiY@uxcpshadoop/weatherdatasetsmall/* hdfs://localhost/user/cloudera/weather

 ```- execute the map reduce job using the following command:
```
hadoop jar <jar_file_name> <main_class_name> <input_path> <output_path>```#### Exercise 4 - Add filtering using configuration
In this exercise we will add a maxYear and minYear configuration and filter the input data using those parameters ***Note:*** in order to run this exercise, you need to make sure you have extended the Configured calss and implemented the Tool interface in the AvgTemperature calss- In your map function, use the *context.getConfiguration* method to create a configuration object```Java
Configuration conf = context.getConfiguration();```
- Use the *conf.getInt* method to read two configuration values maxYear and minYear, use the value 1900 as the default for minYear and and the value 3000 for the maxYear.
- Use the values if maxYear and minYear to filter data from years grater than the maxYear and smaller than the minYear in your code.
- Re-build the Jar file.- execute the map reduce job using the following command:
```
hadoop jar <jar_file_name> <main_class_name> -DminYear=1910 -DmaxYear=1915 <input_path> <output_path>```