/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.rodenski.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class movies_schema extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"movies_schema\",\"namespace\":\"com.rodenski.avro\",\"fields\":[{\"name\":\"movie_id\",\"type\":\"string\",\"doc\":\"The movies id in IMDB\"},{\"name\":\"actors\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"an array with the actors who played in this movie\"}],\"doc:\":\"A basic schema for storing IMDB actors\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** The movies id in IMDB */
  @Deprecated public java.lang.CharSequence movie_id;
  /** an array with the actors who played in this movie */
  @Deprecated public java.util.List<java.lang.CharSequence> actors;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public movies_schema() {}

  /**
   * All-args constructor.
   */
  public movies_schema(java.lang.CharSequence movie_id, java.util.List<java.lang.CharSequence> actors) {
    this.movie_id = movie_id;
    this.actors = actors;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return movie_id;
    case 1: return actors;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: movie_id = (java.lang.CharSequence)value$; break;
    case 1: actors = (java.util.List<java.lang.CharSequence>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'movie_id' field.
   * The movies id in IMDB   */
  public java.lang.CharSequence getMovieId() {
    return movie_id;
  }

  /**
   * Sets the value of the 'movie_id' field.
   * The movies id in IMDB   * @param value the value to set.
   */
  public void setMovieId(java.lang.CharSequence value) {
    this.movie_id = value;
  }

  /**
   * Gets the value of the 'actors' field.
   * an array with the actors who played in this movie   */
  public java.util.List<java.lang.CharSequence> getActors() {
    return actors;
  }

  /**
   * Sets the value of the 'actors' field.
   * an array with the actors who played in this movie   * @param value the value to set.
   */
  public void setActors(java.util.List<java.lang.CharSequence> value) {
    this.actors = value;
  }

  /** Creates a new movies_schema RecordBuilder */
  public static com.rodenski.avro.movies_schema.Builder newBuilder() {
    return new com.rodenski.avro.movies_schema.Builder();
  }
  
  /** Creates a new movies_schema RecordBuilder by copying an existing Builder */
  public static com.rodenski.avro.movies_schema.Builder newBuilder(com.rodenski.avro.movies_schema.Builder other) {
    return new com.rodenski.avro.movies_schema.Builder(other);
  }
  
  /** Creates a new movies_schema RecordBuilder by copying an existing movies_schema instance */
  public static com.rodenski.avro.movies_schema.Builder newBuilder(com.rodenski.avro.movies_schema other) {
    return new com.rodenski.avro.movies_schema.Builder(other);
  }
  
  /**
   * RecordBuilder for movies_schema instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<movies_schema>
    implements org.apache.avro.data.RecordBuilder<movies_schema> {

    private java.lang.CharSequence movie_id;
    private java.util.List<java.lang.CharSequence> actors;

    /** Creates a new Builder */
    private Builder() {
      super(com.rodenski.avro.movies_schema.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.rodenski.avro.movies_schema.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.movie_id)) {
        this.movie_id = data().deepCopy(fields()[0].schema(), other.movie_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.actors)) {
        this.actors = data().deepCopy(fields()[1].schema(), other.actors);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing movies_schema instance */
    private Builder(com.rodenski.avro.movies_schema other) {
            super(com.rodenski.avro.movies_schema.SCHEMA$);
      if (isValidValue(fields()[0], other.movie_id)) {
        this.movie_id = data().deepCopy(fields()[0].schema(), other.movie_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.actors)) {
        this.actors = data().deepCopy(fields()[1].schema(), other.actors);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'movie_id' field */
    public java.lang.CharSequence getMovieId() {
      return movie_id;
    }
    
    /** Sets the value of the 'movie_id' field */
    public com.rodenski.avro.movies_schema.Builder setMovieId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.movie_id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'movie_id' field has been set */
    public boolean hasMovieId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'movie_id' field */
    public com.rodenski.avro.movies_schema.Builder clearMovieId() {
      movie_id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'actors' field */
    public java.util.List<java.lang.CharSequence> getActors() {
      return actors;
    }
    
    /** Sets the value of the 'actors' field */
    public com.rodenski.avro.movies_schema.Builder setActors(java.util.List<java.lang.CharSequence> value) {
      validate(fields()[1], value);
      this.actors = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'actors' field has been set */
    public boolean hasActors() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'actors' field */
    public com.rodenski.avro.movies_schema.Builder clearActors() {
      actors = null;
      fieldSetFlags()[1] = false;
      return this;
    }

   // @Override
    public movies_schema build() {
      try {
        movies_schema record = new movies_schema();
        record.movie_id = fieldSetFlags()[0] ? this.movie_id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.actors = fieldSetFlags()[1] ? this.actors : (java.util.List<java.lang.CharSequence>) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
