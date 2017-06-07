package test;

import com.mika.credit.common.fastdfs.FastDFSClient;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.InputStream;

@RunWith(SpringJUnit4ClassRunner.class)
public class FastDFS {

//    @Autowired
//    private OrderDetailManagerService orderDetailManagerService;

	@Test
	public void upload() throws Exception {
		String fileName = "aa.jpg";
		String filePath = "D:\\aa.jpg";
		File file = new File(filePath);
		String fileId = FastDFSClient.uploadFile(file, fileName);
		System.out.println("Upload local file " + filePath + " ok, fileid=" + fileId);
		// fileId:	group1/M00/00/00/wKgEfVUYPieAd6a0AAP3btxj__E335.jpg
		// url:	http://192.168.4.125:8888/group1/M00/00/00/wKgEfVUYPieAd6a0AAP3btxj__E335.jpg
	}

	/**
	 * 下载测试
	 * @throws Exception
	 */
//	@Test
	public void download() throws Exception {
		String fileId = "group1/M00/00/00/wKgEfVUYPieAd6a0AAP3btxj__E335.jpg";
		InputStream inputStream = FastDFSClient.downloadFile(fileId);
		File destFile = new File("E:/WorkSpaceSpr10.6/edu-demo-fdfs/TestFile/DownloadTest.jpg");
		FileUtils.copyInputStreamToFile(inputStream, destFile);
	}

	/**
	 * 删除测试
	 * @throws Exception
	 */
	public void delete() throws Exception {
		String fileId = "group1/M00/00/00/wKgEfVUYPieAd6a0AAP3btxj__E335.jpg";
		int result = FastDFSClient.deleteFile(fileId);
		System.out.println(result == 0 ? "删除成功" : "删除失败:" + result);
	}
}
