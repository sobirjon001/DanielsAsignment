package com.daniel.s3;


import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.daniel.utils.ConfigurationReader;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class CreateBucket {

  // get your own keys and save in root folder as aws.properties
  private static final String AccessKey = ConfigurationReader.getProperty("accessKey");
  private static final String SecretAccessKey = ConfigurationReader.getProperty("secretAccessKey");

  public static void main(String[] args) {
    AWSCredentials credentials = new BasicAWSCredentials(
      AccessKey, SecretAccessKey
    );

    final AmazonS3 s3client = AmazonS3ClientBuilder
            .standard()
            .withCredentials(new AWSStaticCredentialsProvider(credentials))
            .withRegion(Regions.US_EAST_1)
            .build()
    ;
    String bucket_name = "sobirtest2";

    if(s3client.doesBucketExistV2(bucket_name))
      System.out.println("Bucket name is not available, try again with different Bucket name");
    else s3client.createBucket(bucket_name);

    List<Bucket> buckets = s3client.listBuckets();
    for (Bucket bucket : buckets) {
      System.out.println(bucket.getName());
    }

//    try {
//      s3client.deleteBucket(buckets.get(buckets.size()-1).getName());
//    } catch (AmazonServiceException e) {
//      System.out.println(e.getMessage());
//    }

//    s3client.putObject(
//            buckets.get(buckets.size()-1).getName(),
//            "Document/hello.txt",
//            new File("/home/sobir/Documents/Cybertek/Automation/my_projects/DanielsAsignment/src/main/java/com/daniel/s3/hello.text")
//    );

    ObjectListing objectListing = s3client.listObjects(
            buckets.get(buckets.size()-1).getName()
    );
    for (S3ObjectSummary os : objectListing.getObjectSummaries()) {
      System.out.println(os.getKey());
    }

    S3Object s3Object = s3client.getObject(
            buckets.get(buckets.size()-1).getName(),
            "Document/hello.txt"
    );
    S3ObjectInputStream inputStream = s3Object.getObjectContent();
    try {
      FileUtils.copyInputStreamToFile(inputStream, new File(
              "/home/sobir/Documents/Cybertek/Automation/my_projects/DanielsAsignment/src/main/java/com/daniel/s3/hello2.text"
      ));
    } catch (IOException e) {
      e.printStackTrace();
    }

    s3client.deleteObject(
            buckets.get(buckets.size()-1).getName(),
            "Document/hello.txt"
    );
  }
}
