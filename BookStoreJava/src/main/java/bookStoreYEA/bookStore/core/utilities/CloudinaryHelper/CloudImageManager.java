package bookStoreYEA.bookStore.core.utilities.CloudinaryHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import bookStoreYEA.bookStore.core.utilities.results.DataResult;
import bookStoreYEA.bookStore.core.utilities.results.ErrorDataResult;
import bookStoreYEA.bookStore.core.utilities.results.SuccessDataResult;

@Service
public class CloudImageManager implements CloudImageService {
	
	private Cloudinary cloudinary;
	
	public CloudImageManager() {
		cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "mycloudimageyea",
				"api_key", "921939885472173", 
				"api_secret", "7I1L5_L7xsE5gPvsldLmVp597l4")); 
	}
	
	@Override
	public DataResult<Map> upload(MultipartFile multipartFile) throws IOException {
		
		Map<String , Object> options = new HashMap<>();
        var allowedFormats = Arrays.asList("png","jpg","jpeg");
        options.put("allowed_formats",allowedFormats);
        File file = convertToFile(multipartFile);
        Map uploader  = null;
        try {
        	uploader = cloudinary.uploader().upload(file, options);
        }
        catch(Exception e) {
        	return new ErrorDataResult<>(e.getMessage());
        }
        
		return new SuccessDataResult<>(uploader);
	}
	
	@Override
	public DataResult<Map> delete(String id) throws IOException {
		
		return null;
	}
	
	 private File convertToFile(MultipartFile multipartFile) throws IOException {
	        File file = new File(multipartFile.getOriginalFilename());
	        FileOutputStream stream = new FileOutputStream(file);
	        stream.write(multipartFile.getBytes());
	        stream.close();

	        return file;
	    }
}
