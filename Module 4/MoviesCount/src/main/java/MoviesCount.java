import com.rodenski.avro.actors_schema;
import com.rodenski.avro.movies_schema;
import org.apache.avro.mapreduce.AvroKeyInputFormat;
import org.apache.avro.mapreduce.AvroKeyOutputFormat;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.avro.mapreduce.AvroJob;

/**
 * Created by roadan on 4/28/15.
 */
public class MoviesCount extends Configured implements Tool {

    public static void main(String[] args) throws Exception {
        int res = ToolRunner.run(new Configuration(), new MoviesCount(), args);
        System.exit(res);
    }

    public int run(String[] args) throws Exception {

        if (args.length != 2) {
            System.err.println("Usage: hadoop jar MoviesCount-1.0-SNAPSHOT-job.jar"
                    + " [generic options] <in> <out>");

            return 1;
        }

        Job job = new Job();
        job.setJarByClass(MoviesCount.class);

        job.setMapperClass(MoviesMapper.class);
        job.setReducerClass(MoviesReducer.class);

        // setting the input and output formats to Avro
        job.setInputFormatClass(AvroKeyInputFormat.class);
        job.setOutputFormatClass(AvroKeyOutputFormat.class);

        // Note: we need to specify the Avro input and output schemas
        AvroJob.setInputKeySchema(job, actors_schema.getClassSchema());
        AvroJob.setOutputKeySchema(job, movies_schema.getClassSchema());

        // setting the output format for the Mapper
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        // setting the output format for the Job
//        job.setOutputKeyClass(AvroKey.class);
//        job.setOutputValueClass(NullWritable.class);

        AvroKeyInputFormat.addInputPath(job, new Path(args[0]));
        AvroKeyOutputFormat.setOutputPath(job, new Path(args[1]));

        return job.waitForCompletion(true) ? 0 : 1;
    }
}