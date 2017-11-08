package com.mr;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WcReducer extends Reducer<Text,IntWritable,Text,IntWritable>{

    protected  void reduce(Text key,Iterable<IntWritable> iterable,
                           Context context)
                throws IOException,InterruptedException{
        int sum = 0;
        for (IntWritable i: iterable){
            sum = sum+i.get();
        }
        context.write(key,new IntWritable(sum));

    }
}
