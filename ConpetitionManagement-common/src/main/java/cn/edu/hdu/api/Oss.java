package cn.edu.hdu.api;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Oss {
    private static String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
    private static String accessKeyId = "LTAI4G6SpuEtabTheyKUDd1W";
    private static String accessKeySecret = "S0XHqVwF1NBlLYubA9g1tplpTMkDYN";
    private static String bucketName = "fileshare-123";
    // 创建OSSClient实例
    private static OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

    /**
     * 上传文件
     *
     */
    public static void PutFile(File file,String path){
        //文件名
        String objname = path + file.getName();
        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objname,file);
        // 上传文件。
        ossClient.putObject(putObjectRequest);
        // 关闭OSSClient。
        ossClient.shutdown();

    }

    /**
     * 下载文件
     *
     */
    public static void GetFile(String objectName){
        // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File(objectName));
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    /**
     * 获取文件列表
     *
     */
    public static List<String> GetFileList(){
        // ossClient.listObjects返回ObjectListing实例，包含此次listObject请求的返回结果。
        ObjectListing objectListing = ossClient.listObjects(bucketName);
        List<String> list = new ArrayList<>();
        // objectListing.getObjectSummaries获取所有文件的描述信息。
        for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            list.add(objectSummary.getKey());
        }
        // 关闭OSSClient
        ossClient.shutdown();
        return list;
    }
}
