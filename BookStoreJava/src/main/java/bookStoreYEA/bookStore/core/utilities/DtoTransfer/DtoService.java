package bookStoreYEA.bookStore.core.utilities.DtoTransfer;

import java.util.List;

public interface DtoService {
	
	<S, T> List<T> dtoConverter(List<S> s, Class<T> targetClass);
	public <T> Object dtoClassConverter(Object source,Class<T> baseClass);
}
