package com.hadoop.example;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.Mapper;


/**
 * Turns lines from a text file into (word, 1) tuples.
 */
public class TokenizingMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private static final IntWritable one = new IntWritable(1);

    private static HashSet<String> stopWords = new HashSet<String>();

    public TokenizingMapper() {
        stopWords.add("i");
        stopWords.add("me");
        stopWords.add("my");
        stopWords.add("myself");
        stopWords.add("we");
        stopWords.add("our");
        stopWords.add("ours");
        stopWords.add("ourselves");
        stopWords.add("you");
        stopWords.add("your");
        stopWords.add("yours");
        stopWords.add(" ");
        stopWords.add("yourselves");
        stopWords.add("he");
        stopWords.add("him");
        stopWords.add("his");
        stopWords.add("himself");
        stopWords.add("she");
        stopWords.add("her");
        stopWords.add("hers");
        stopWords.add("herself");
        stopWords.add("it");
        stopWords.add("its");
        stopWords.add("itself");
        stopWords.add("they");
        stopWords.add("them");
        stopWords.add("their");
        stopWords.add("theirs");
        stopWords.add("themselves");
        stopWords.add("what");
        stopWords.add("which");
        stopWords.add("who");
        stopWords.add("whom");
        stopWords.add("this");
        stopWords.add("that");
        stopWords.add("these");
        stopWords.add("those");
        stopWords.add("am");
        stopWords.add("is");
        stopWords.add("are");
        stopWords.add("was");
        stopWords.add("were");
        stopWords.add("be");
        stopWords.add("been");
        stopWords.add("being");
        stopWords.add("have");
        stopWords.add("has");
        stopWords.add("had");
        stopWords.add("having ");
        stopWords.add("do");
        stopWords.add("does");
        stopWords.add("did");
        stopWords.add("doing  ");
        stopWords.add("a");
        stopWords.add("an");
        stopWords.add("the");
        stopWords.add("and");
        stopWords.add("but");
        stopWords.add("if");
        stopWords.add("or");
        stopWords.add("because");
        stopWords.add("as");
        stopWords.add("until");
        stopWords.add("while");
        stopWords.add("of");
        stopWords.add("at");
        stopWords.add("by");
        stopWords.add("for");
        stopWords.add("with");
        stopWords.add("about");
        stopWords.add("against");
        stopWords.add("between");
        stopWords.add("into");
        stopWords.add("through");
        stopWords.add("during");
        stopWords.add("before");
        stopWords.add("after");
        stopWords.add("above");
        stopWords.add("below");
        stopWords.add("to");
        stopWords.add("from");
        stopWords.add("up");
        stopWords.add("down");
        stopWords.add("in");
        stopWords.add("out");
        stopWords.add("on");
        stopWords.add("off");
        stopWords.add("over");
        stopWords.add("under");
        stopWords.add("again");
        stopWords.add("further");
        stopWords.add("then");
        stopWords.add("once");
        stopWords.add("here");
        stopWords.add("there");
        stopWords.add("when");
        stopWords.add("where");
        stopWords.add("why");
        stopWords.add("how");
        stopWords.add("all");
        stopWords.add("any");
        stopWords.add("both");
        stopWords.add("each");
        stopWords.add("few");
        stopWords.add("more");
        stopWords.add("most");
        stopWords.add("other");
        stopWords.add("some");
        stopWords.add("such");
        stopWords.add("no");
        stopWords.add("nor");
        stopWords.add("not");
        stopWords.add("only");
        stopWords.add("own");
        stopWords.add("same");
        stopWords.add("so");
        stopWords.add("than");
        stopWords.add("too");
        stopWords.add("very");
        stopWords.add("s");
        stopWords.add("t");
        stopWords.add("can");
        stopWords.add("will");
        stopWords.add("just");
        stopWords.add("don");
        stopWords.add("should");
        stopWords.add("now");
    }

    protected void map(LongWritable offset, Text value, Context context)
            throws IOException, InterruptedException {

        if(value == null)
        {
            Counter ctr = context.getCounter("Custom Input", "Null records");
            ctr.increment(1);
        }

        StringTokenizer tok = new StringTokenizer(value.toString().toLowerCase());
        while (tok.hasMoreTokens()) {
            String rawWrod = tok.nextToken();
            Text word = new Text(rawWrod.replaceAll(",", "")
                    .replaceAll("\\.", "")
                    .replaceAll(":", "")
                    .replaceAll(";", "")
                    .replaceAll("\\?", "")
                    .replaceAll("!", "")
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", "")
                    .replaceAll("\\[", "")
                    .replaceAll("\\]", "")
                    .replaceAll("'","")
                    .replaceAll("“", "")
                    .replaceAll("”", "")
                    .replaceAll("\"","")
                    .replaceAll("-", "")
                    .replaceAll("—", "")
                    .replaceAll("_", "")
                    .replaceAll("#", "")
                    .replaceAll("0", "")
                    .replaceAll("1", "")
                    .replaceAll("2", "")
                    .replaceAll("3", "")
                    .replaceAll("4", "")
                    .replaceAll("5", "")
                    .replaceAll("6", "")
                    .replaceAll("7", "")
                    .replaceAll("8", "")
                    .replaceAll("9", "")
                    .replaceAll("$", "")
                    .replaceAll("@", "")
                    .replaceAll("$", "")
                    .replaceAll("%", "")
                    .replaceAll("^", "")
                    .replaceAll("&", "")
                    .replaceAll("\\*", "")
                    .replaceAll("<", "")
                    .replaceAll(">", "")
                    .replaceAll("=", "")
                    .replaceAll("\\+", "")
                    .replaceAll("-", "")
                    .replaceAll("|", "")
                    .replaceAll("‘", ""));

            if(!stopWords.contains(word.toString()))
                context.write(word, one);

        }
    }
}