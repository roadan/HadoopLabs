/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.rodenski.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class actors_schema extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"actors_schema\",\"namespace\":\"com.rodenski.avro\",\"fields\":[{\"name\":\"id\",\"type\":\"string\",\"doc\":\"The actore id in IMDB\"},{\"name\":\"name\",\"type\":\"string\",\"doc\":\"The name of the actor\"},{\"name\":\"titles\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"an array with the ids of all the titles the actor was in\"}],\"doc:\":\"A basic schema for storing IMDB actors\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** The actore id in IMDB */
  @Deprecated public java.lang.CharSequence id;
  /** The name of the actor */
  @Deprecated public java.lang.CharSequence name;
  /** an array with the ids of all the titles the actor was in */
  @Deprecated public java.util.List<java.lang.CharSequence> titles;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public actors_schema() {}

  /**
   * All-args constructor.
   */
  public actors_schema(java.lang.CharSequence id, java.lang.CharSequence name, java.util.List<java.lang.CharSequence> titles) {
    this.id = id;
    this.name = name;
    this.titles = titles;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return name;
    case 2: return titles;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: name = (java.lang.CharSequence)value$; break;
    case 2: titles = (java.util.List<java.lang.CharSequence>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * The actore id in IMDB   */
  public java.lang.CharSequence getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * The actore id in IMDB   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'name' field.
   * The name of the actor   */
  public java.lang.CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * The name of the actor   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'titles' field.
   * an array with the ids of all the titles the actor was in   */
  public java.util.List<java.lang.CharSequence> getTitles() {
    return titles;
  }

  /**
   * Sets the value of the 'titles' field.
   * an array with the ids of all the titles the actor was in   * @param value the value to set.
   */
  public void setTitles(java.util.List<java.lang.CharSequence> value) {
    this.titles = value;
  }

  /** Creates a new actors_schema RecordBuilder */
  public static com.rodenski.avro.actors_schema.Builder newBuilder() {
    return new com.rodenski.avro.actors_schema.Builder();
  }
  
  /** Creates a new actors_schema RecordBuilder by copying an existing Builder */
  public static com.rodenski.avro.actors_schema.Builder newBuilder(com.rodenski.avro.actors_schema.Builder other) {
    return new com.rodenski.avro.actors_schema.Builder(other);
  }
  
  /** Creates a new actors_schema RecordBuilder by copying an existing actors_schema instance */
  public static com.rodenski.avro.actors_schema.Builder newBuilder(com.rodenski.avro.actors_schema other) {
    return new com.rodenski.avro.actors_schema.Builder(other);
  }
  
  /**
   * RecordBuilder for actors_schema instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<actors_schema>
    implements org.apache.avro.data.RecordBuilder<actors_schema> {

    private java.lang.CharSequence id;
    private java.lang.CharSequence name;
    private java.util.List<java.lang.CharSequence> titles;

    /** Creates a new Builder */
    private Builder() {
      super(com.rodenski.avro.actors_schema.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.rodenski.avro.actors_schema.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.titles)) {
        this.titles = data().deepCopy(fields()[2].schema(), other.titles);
        fieldSetFlags()[2] = true;
      }
    }
    
    /** Creates a Builder by copying an existing actors_schema instance */
    private Builder(com.rodenski.avro.actors_schema other) {
            super(com.rodenski.avro.actors_schema.SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.titles)) {
        this.titles = data().deepCopy(fields()[2].schema(), other.titles);
        fieldSetFlags()[2] = true;
      }
    }

    /** Gets the value of the 'id' field */
    public java.lang.CharSequence getId() {
      return id;
    }
    
    /** Sets the value of the 'id' field */
    public com.rodenski.avro.actors_schema.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'id' field has been set */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'id' field */
    public com.rodenski.avro.actors_schema.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'name' field */
    public java.lang.CharSequence getName() {
      return name;
    }
    
    /** Sets the value of the 'name' field */
    public com.rodenski.avro.actors_schema.Builder setName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'name' field has been set */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'name' field */
    public com.rodenski.avro.actors_schema.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'titles' field */
    public java.util.List<java.lang.CharSequence> getTitles() {
      return titles;
    }
    
    /** Sets the value of the 'titles' field */
    public com.rodenski.avro.actors_schema.Builder setTitles(java.util.List<java.lang.CharSequence> value) {
      validate(fields()[2], value);
      this.titles = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'titles' field has been set */
    public boolean hasTitles() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'titles' field */
    public com.rodenski.avro.actors_schema.Builder clearTitles() {
      titles = null;
      fieldSetFlags()[2] = false;
      return this;
    }

   // @Override
    public actors_schema build() {
      try {
        actors_schema record = new actors_schema();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.titles = fieldSetFlags()[2] ? this.titles : (java.util.List<java.lang.CharSequence>) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
