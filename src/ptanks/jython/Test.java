package ptanks.jython;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.python.core.PyCode;
import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
public class Test {
	public static void main(String[] args) throws PyException	{
		PythonInterpreter py = new PythonInterpreter();
		System.out.println("Python?");
		py.exec("a = 2");
		py.exec("b=a*a");
		py.exec("for i in range(b):\n\tprint i");
		PyObject a = py.get("a");
		System.out.println("Python a:" + a);
		PyObject b = py.get("b");
		System.out.println("Python b:" + b);
		
		String s = "z = 100\nprint z";
		PyCode code = py.compile(s);
		py.eval(code);
		
		try {
			py.exec("z = 100\nprint h");
		}
		catch(PyException pye)	{
			pye.printStackTrace();
		}
		
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet("http://bleegfeed.com/ptanks/codeserver/1");
			HttpResponse r = client.execute(get);
			HttpEntity data = r.getEntity();
			BufferedReader read = new BufferedReader(new InputStreamReader(data.getContent()));
			String line = ""; String codes = "";
			while ((line = read.readLine()) != null)	{
				codes += line + "\n";
			}
			System.out.println("Code downloaded from server\n" + codes);
			py.exec(codes);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		py.exec("import sys\nprint sys.path\nfrom RestrictedPython.PrintCollector import PrintCollector");
		
		System.out.println("Python!");
	}
}
