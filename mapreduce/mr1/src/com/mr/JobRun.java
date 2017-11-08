package com.mr;



import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



public class JobRun  {
    public static void main(String [] ages) throws Exception{
        Configuration conf = new Configuration();
        conf.set("yarn.resourcemanager.hostname","192.168.240.133");
        System.setProperty("hadoop.home.dir", "D:\\Workspace\\hadoop-2.7.4");
        try{
            Job job = new Job(conf);
            job.setJarByClass(JobRun.class);
            job.setMapperClass(WcMapper.class);
            job.setReducerClass(WcReducer.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(IntWritable.class);

//            job.setNumReduceTasks(1);//设置reduce的任务个数
            FileInputFormat.addInputPath(job, new Path("/usr/input/wc"));
            FileOutputFormat.setOutputPath(job, new Path("/usr/output/wc"));

            System.exit(job.waitForCompletion(true) ? 0 : 1);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
