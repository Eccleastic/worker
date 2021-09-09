package com.awslab.worker;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/getAllItems")
    String getItem(){
        BasicSessionCredentials credentials = new BasicSessionCredentials(
                "ASIAZIRZVOXW6YPT5DMQ",
                "Qj9YKYHcjCFtcjKI98Mqs+IxDgwJ3IKYpqNYe/hK",
                "FwoGZXIvYXdzEIr//////////wEaDIgnTx+xI2pMNaaXpSLEAYhYRleLifG6uB/2UtH6aVnXYvhcCPCNQSZYozGdrvPnwS7VmSUuDj4rvXXq6mLnz69vumaWYiw00VLUHePOGTVK4zKkg3fTYSYDBADjfJppqhoxMKw59/95ILQcuU+rdk0NmITtHn7dVAidDZ49YvpdFwCMgyyQxCz+gh+dar7fjfy7snBNOqAHc0OggDaidTZnPL5NQK/DU/8uyTRvSc/gAvkpFJZLEhOCe/F2Gnxe4qk1IwzI4A3w0NKRCZhOgli0kI4opPnoiQYyLXt1Sg/doieJCUgZc2xyHTjG+Fd9MzaK+3c9zA+x4gKitIX8vOpZqyGXGbRCcQ=="
        );
        final AmazonS3 s3 =
                AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_1)
                .build();
        StringBuilder list = new StringBuilder();
        for(Bucket bucket : s3.listBuckets()){
            System.out.println(bucket.getName());
            list.append(bucket.getName()).append("\n");
        }
        return list.toString();
    }
}
