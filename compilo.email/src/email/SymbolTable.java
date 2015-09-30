package email;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

	private Map<String, Integer> map;

	public SymbolTable () {
		map = new HashMap <String, Integer> ();
	}

	public int getValue (String name) {
		Object o = map.get(name);
		if (o == null) {
			map.put(name, new Integer(0));
			return 0;
		} else {
			return ((Integer)o).intValue();
		}
	}

	public void setValue (String name, int value) {
		map.put(name, new Integer(value));
	}
}
