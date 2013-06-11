package gilbert.newsinternational;

/**
 * Exception which can be throw when a required parameter is null
 * 
 */
public class NullParamterException extends RuntimeException {

	private static final long serialVersionUID = 3272839420512602102L;

	/**
	 * Throw a new instance of NullParamterException when the passed in paramter
	 * is null
	 * 
	 * @param o
	 *            parameter to be checked.
	 */
	public static void throwIfNull(Object o) {
		if (o == null) {
			throw new NullParamterException();
		}
	}

}
