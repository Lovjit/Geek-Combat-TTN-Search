package com.ttn.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.GetBucketLocationRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class UploadObjectMultipartUploadUsingHighLevelAPI {
	
    public static void main(String[] args) throws Exception {
    	uploadFileStream(null, null, null, null, null);
    }
    
    // region name us-west-2
    // https://s3-us-west-2.amazonaws.com/untameable-root-folder/Sample-Xls
    @SuppressWarnings("deprecation")
	public static int uploadFileStream(InputStream stream, String bucketName, String keyName, String fileName,String region) throws IOException {
    	BasicAWSCredentials creds=new BasicAWSCredentials("", "");
    	AmazonS3Client s3client = new AmazonS3Client(creds);
    	s3client.setRegion(Region.getRegion(Regions.US_WEST_2));
    	bucketName = "untameable-root-folder";
    	keyName = "Sample-Xls";
    	//name="Temp-Name";
    	Path path = Paths.get("/Users/lovjitsingh/Documents/TTN/Docs/FORM-NO.12BB.xls");
    	stream = new ByteArrayInputStream(Files.readAllBytes(path));
//    	if(!(s3client.doesBucketExist(bucketName)))
//        {
//        	// Note that CreateBucketRequest does not specify region. So bucket is 
//        	// created in the region specified in the client.
//        	s3client.createBucket(new CreateBucketRequest(
//					bucketName));
//        }
//    	String bucketLocation = s3client.getBucketLocation(new GetBucketLocationRequest(bucketName));
//        System.out.println("bucket location = " + bucketLocation);
//        return 0;
    	try {
    		//s3client.setRegion(Region.getRegion(Regions.valueOf(region)));
    		ObjectMetadata meta = new ObjectMetadata();
    		s3client.putObject(new PutObjectRequest(bucketName, keyName, stream, meta));
    		return 1;
    	} 
    	catch (AmazonServiceException ase) {
    		return 0;
    	} 
    	catch (AmazonClientException ace) {
    		return 0;
    	}
    }
}
