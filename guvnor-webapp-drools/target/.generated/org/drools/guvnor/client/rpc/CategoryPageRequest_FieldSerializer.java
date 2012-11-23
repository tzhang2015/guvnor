package org.drools.guvnor.client.rpc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CategoryPageRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getCategoryPath(org.drools.guvnor.client.rpc.CategoryPageRequest instance) /*-{
    return instance.@org.drools.guvnor.client.rpc.CategoryPageRequest::categoryPath;
  }-*/;
  
  private static native void setCategoryPath(org.drools.guvnor.client.rpc.CategoryPageRequest instance, java.lang.String value) 
  /*-{
    instance.@org.drools.guvnor.client.rpc.CategoryPageRequest::categoryPath = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, org.drools.guvnor.client.rpc.CategoryPageRequest instance) throws SerializationException {
    setCategoryPath(instance, streamReader.readString());
    
    org.drools.guvnor.client.rpc.PageRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static org.drools.guvnor.client.rpc.CategoryPageRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.drools.guvnor.client.rpc.CategoryPageRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.drools.guvnor.client.rpc.CategoryPageRequest instance) throws SerializationException {
    streamWriter.writeString(getCategoryPath(instance));
    
    org.drools.guvnor.client.rpc.PageRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.drools.guvnor.client.rpc.CategoryPageRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.drools.guvnor.client.rpc.CategoryPageRequest_FieldSerializer.deserialize(reader, (org.drools.guvnor.client.rpc.CategoryPageRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.drools.guvnor.client.rpc.CategoryPageRequest_FieldSerializer.serialize(writer, (org.drools.guvnor.client.rpc.CategoryPageRequest)object);
  }
  
}