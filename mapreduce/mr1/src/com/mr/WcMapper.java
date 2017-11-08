package com.mr;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
import java.util.StringTokenizer;

public class WcMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    //每次调用map方法传入split中的数据key,改数据所在文件中的位置下标，value：这行数据
    protected void map(LongWritable key, Text value,
                       Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        StringTokenizer st = new StringTokenizer(line);

        while (st.hasMoreElements()){
            String world = st.nextToken();
            context.write(new Text(world),new IntWritable(1));//map输出
        }

    }
}
