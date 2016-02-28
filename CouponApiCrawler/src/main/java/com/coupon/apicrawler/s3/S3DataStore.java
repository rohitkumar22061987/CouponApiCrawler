package com.coupon.apicrawler.s3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
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
	
	public S3DataStore(String bucketName, String profileName) {
		this.BUCKET_NAME = bucketName;
		try {
            this.credentials = new ProfileCredentialsProvider(profileName).getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (/home/rohit/.aws/credentials), and is in valid format.",
                    e);
        }
		this.s3 = new AmazonS3Client(credentials);
        Region usEast1 = Region.getRegion(Regions.US_EAST_1);
        s3.setRegion(usEast1);
	}
	
	public void putData(String key, File file) {
		this.s3.putObject(new PutObjectRequest(BUCKET_NAME, key, file));
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
