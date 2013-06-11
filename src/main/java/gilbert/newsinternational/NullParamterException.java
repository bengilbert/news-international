package gilbert.newsinternational;

public class NullParamterException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3272839420512602102L;
	
	public static void throwIfNull(Object o) {
		if (o == null) {
			throw new NullParamterException();
		}
	}

}
