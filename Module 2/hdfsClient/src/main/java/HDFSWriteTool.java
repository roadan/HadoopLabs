
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import us.monoid.web.Resty;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

/**
 * Created by roadan on 3/5/15.
 */

public class HDFSWriteTool {
    public static void main(String[] args) throws Exception {

        System.out.println("starting");

        String dst = "hdfs://localhost/user/cloudera/chuck2.json";

        // getting our data from a web service
        Resty r = new Resty();
        InputStream data = r.json("http://api.icndb.com/jokes/").stream();

        Configuration conf = new Configuration();

        FileSystem fs = FileSystem.get(URI.create(dst), conf);

        OutputStream hdfsStream = fs.create(new Path(dst));

        IOUtils.copyBytes(data, hdfsStream, 4096, true);

        System.out.println("done");
    }
}
