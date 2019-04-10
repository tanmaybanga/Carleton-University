package comp2402a3;

import java.util.List;
import java.util.AbstractList;
import java.util.Map;
import java.util.HashMap;

public class DumbDefaultList<T> extends AbstractList<T> {
  Map<Integer,T> map;

  public DumbDefaultList() {
    map = new HashMap<Integer,T>();
  }

  public int size() {
    return Integer.MAX_VALUE;
  }

  public T get(int i) {
    return map.get(i);
  }

  public T set(int i, T x) {
    return map.put(i, x);
  }

  public void add(int i, T x) {
    Map<Integer, T> map2 = new HashMap<Integer,T>();
    for (Integer k : map.keySet()) {
      if (k >= i) {
        map2.put(k, map.get(k));
      }
    }
    for (Integer k : map2.keySet()) {
      map.remove(k);
    }
    for (Map.Entry<Integer,T> e : map2.entrySet()) {
      map.put(e.getKey()+1, e.getValue());
    }
    map.put(i, x);
  }

  public T remove(int i) {
    Map<Integer, T> map2 = new HashMap<Integer,T>();
    for (Integer k : map.keySet()) {
      if (k >= i) {
        map2.put(k, map.get(k));
      }
    }
    for (Integer k : map2.keySet()) {
      map.remove(k);
    }
    T retval = map2.remove(i);
    for (Map.Entry<Integer,T> e : map2.entrySet()) {
      map.put(e.getKey()-1, e.getValue());
    }
    return retval;
  }

  public static void main(String[] args) {
    Tester.testDefaultList(new DumbDefaultList<Integer>());
  }
}
