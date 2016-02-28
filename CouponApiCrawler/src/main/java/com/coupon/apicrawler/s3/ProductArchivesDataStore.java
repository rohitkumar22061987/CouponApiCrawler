package com.coupon.apicrawler.s3;

public class ProductArchivesDataStore extends S3DataStore{
	
	public ProductArchivesDataStore() {
		super("product-archive","product-archive-store");
	}
}
