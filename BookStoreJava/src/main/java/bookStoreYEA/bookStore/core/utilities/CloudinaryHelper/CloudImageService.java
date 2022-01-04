package bookStoreYEA.bookStore.core.utilities.CloudinaryHelper;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import bookStoreYEA.bookStore.core.utilities.results.DataResult;

public interface CloudImageService {
	
	DataResult<Map> upload(MultipartFile multipartFile) throws IOException;
	DataResult<Map> delete(String id) throws IOException;
}
