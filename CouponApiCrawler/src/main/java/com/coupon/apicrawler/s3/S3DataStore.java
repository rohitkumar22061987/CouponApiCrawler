package com.coupon.apicrawler.s3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class S3DataStore {
	protected String BUCKET_NAME = null;
	protected AWSCredentials credentials = null;
	protected AmazonS3 s3 = null;
	
	
	public void putData(String key, File file) {
		s3.putObject(new PutObjectRequest(BUCKET_NAME, key, file));
	}
	
	public S3Object getData(String key) {
		return s3.getObject(new GetObjectRequest(BUCKET_NAME, key));
	}
	
	public List<String> getObjectNamesList() {
		List<String> objectNamesList = new ArrayList<String>();
		ObjectListing objectListing = s3.listObjects(new ListObjectsRequest()
        .withBucketName(BUCKET_NAME));
		for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
			objectNamesList.add(objectSummary.getKey());
        }
		return objectNamesList;
	}
}
