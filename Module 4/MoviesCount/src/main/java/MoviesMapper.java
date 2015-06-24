import com.rodenski.avro.actors_schema;
import org.apache.avro.mapred.AvroKey;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.List;

/**
 * Created by roadan on 4/27/15.
 */
public class MoviesMapper extends Mapper<AvroKey<actors_schema>, NullWritable, Text, Text> {

    @Override
    public void map(AvroKey<actors_schema> actor, NullWritable value, Context context) throws
            IOException, InterruptedException {

        Text name = new Text(actor.datum().getName().toString());


    }

}
