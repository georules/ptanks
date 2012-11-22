import java.util.HashMap;

public class ID	{
	private static long count = 0;
	private ID(){}
	private static HashMap<Object,String> ids = new HashMap<Object,String>();
	
	public static String getID(Object o) {
		if (!ids.containsKey(o))	{
			String x = new Long(count++).toString();
			ids.put(o, x);
		}
		System.out.println("hi");
		return ids.get(o);
	}
}