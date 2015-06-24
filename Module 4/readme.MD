# Map Reduce IO and File Formats

![Hadoop Logo](http://www.datameer.com/images/technology/hadoop-pic1.png)

## Overview

**This is the lab for module 4 in the Hadoop courese**,  *the labs will take you through the process of developing Avro map reduce job*.


#### Exercise 1 - Preparing the avro input files  
	
- Open the **Module 4/avrodata** folder in the course's git repository, the folder contains two files:
  - **top_actors.json**: aa file containing actors data from IMDB and a list of the IMDB movie id for all the movies the appeared in, in JSON format.
  - **actors.avsc**: an avro schema describing the structure of the JSON data.
- Open the two files in a text editor and observe their content 
- Copy the the **Module 4/avrodata** folder to the cloudera home directory on your Hadoop cluster.
- Open the Terminal window in your Hadoop cluster and run the following command to create an avro file from the JSON data and avro schema files:

```
avro-tools fromjson --schema-file avrodata/actors.avsc  avrodata/top_actors.json > avrodata/top_actors.avro

```
- Make sure a file named **top_actors.avro** was created as a result in the **avrodata** directory.
- Upload the **top_actors.avro** to HDFS and locate it in the /user/cloudera/moviesin/ folder.

#### Exercise 2 - Change the MoviesCount map reduce job to output a file containing Movie objects data 

- Open the **Module 4/MoviesCount** project folder in IntelliJ IDEA.
- Open the MoviesMapper class. The map function extracts the actor's name from the actor object.
- Edit the MoviesMapper adding the following functionality:
  - Extract the list of IMDB movie id's for each actor.
  - For each id emit a key-value pair where the key is the movie id and the value is the actor's name.
- Add a Java class called MoviesReducer, and define the class as follows:

```Java
public class MoviesReducer extends
        Reducer<Text, Text, AvroKey<movies_schema>, NullWritable> {

    @Override
    public void reduce(Text key, Iterable<Text> values,
                       Context context){


    }

}
```

**Note:** The above reducer emits an Avro output with the Movie object as key and Null value

- Implement the reduce using the following steps:
  - create a new instance of the **movies_schema** object.
  - Populate the **movie_id** field.
  - Populate the **actors** field.
  
**Note:** You can easily convert an **Iterable<Text>** to **List<CharSequence>** using the **org.apache.commons.collections.IteratorUtils** class using the following code:

```Java
List<CharSequence> actors = IteratorUtils.toList(values.iterator());
```
  - Use the context class to write the **movies_schema** to the result.
- Open the **MoviesCount** and review the code, follow the comments to focus on the Avro specific parts.
- Use Maven to build the jar file.
- Execute the Jar file using the hadoop jar command.
