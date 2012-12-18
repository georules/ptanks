import org.python.util.PythonInterpreter;
import org.python.core.*;
public class Test	{
	public static void main(String[] args) throws PyException	{
		PythonInterpreter py = new PythonInterpreter();
		System.out.println("Python?");
		py.exec("a = 10");
		py.exec("print a*a");
		PyObject a = py.get("a");
		System.out.println("Python a:" + a);
	}
}
