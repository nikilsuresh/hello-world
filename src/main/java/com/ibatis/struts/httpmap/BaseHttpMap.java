package com.ibatis.struts.httpmap;

import java.util.*;

/**
 * <p/>
 * Date: Mar 11, 2004 10:39:51 PM
 * 
 * @author Clinton Begin
 */
public abstract class BaseHttpMap implements Map {

  public int size() {
    return keySet().size();
  }

  public boolean isEmpty() {
    return keySet().size() == 0;
  }

  public boolean containsKey(Object key) {
    return keySet().contains(key);
  }

  public boolean containsValue(Object value) {
    return values().contains(value);
  }

  public Object get(Object key) {
    return getValue(key);
  }

  public Object put(Object key, Object value) {
    Object old = getValue(key);
    putValue(key, value);
    return old;
  }

  public Object remove(Object key) {
    Object old = getValue(key);
    removeValue(key);
    return old;
  }

  public void putAll(Map map) {
    Iterator i = map.keySet().iterator();
    while (i.hasNext()) {
      Object key = i.next();
      putValue(key, map.get(key));
    }
  }

  public void clear() {
    Iterator i = keySet().iterator();
    while (i.hasNext()) {
      removeValue(i.next());
    }
  }

  public Set keySet() {
    Set keySet = new HashSet();
    Enumeration enumeration = getNames();
    while (enumeration.hasMoreElements()) {
      keySet.add(enumeration.nextElement());
    }
    return keySet;
  }

  public Collection values() {
    List list = new ArrayList();
    Enumeration enumeration = getNames();
    while (enumeration.hasMoreElements()) {
      list.add(getValue(enumeration.nextElement()));
    }
    return list;
  }

  public Set entrySet() {
    return new HashSet();
  }


  protected abstract Enumeration getNames();

  protected abstract Object getValue(Object key);

  protected abstract void putValue(Object key, Object value);

  protected abstract void removeValue(Object key);

}
