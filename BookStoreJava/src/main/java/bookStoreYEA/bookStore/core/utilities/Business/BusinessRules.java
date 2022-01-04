package bookStoreYEA.bookStore.core.utilities.Business;

import bookStoreYEA.bookStore.core.utilities.results.Result;
import bookStoreYEA.bookStore.core.utilities.results.SuccessResult;

public class BusinessRules {
	
	 public static Result run(Result... results) {
	        for (Result result : results) {
	            if (!result.isSuccess()){
	                return result;
	            }
	        }
	        return new SuccessResult();
	    }
}
