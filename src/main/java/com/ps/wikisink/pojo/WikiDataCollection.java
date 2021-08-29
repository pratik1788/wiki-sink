/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.ps.wikisink.pojo;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class WikiDataCollection extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6548721865850036091L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"WikiDataCollection\",\"namespace\":\"com.ps.wikisink.pojo\",\"fields\":[{\"name\":\"wikiDataList\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"WikiData\",\"fields\":[{\"name\":\"yearMonthDay\",\"type\":\"int\"},{\"name\":\"hourOfDay\",\"type\":\"int\"},{\"name\":\"language\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pageName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"nonUniqueViews\",\"type\":\"int\"},{\"name\":\"bytesTransferred\",\"type\":\"long\"}]}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<WikiDataCollection> ENCODER =
      new BinaryMessageEncoder<WikiDataCollection>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<WikiDataCollection> DECODER =
      new BinaryMessageDecoder<WikiDataCollection>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<WikiDataCollection> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<WikiDataCollection> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<WikiDataCollection> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<WikiDataCollection>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this WikiDataCollection to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a WikiDataCollection from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a WikiDataCollection instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static WikiDataCollection fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.util.List<com.ps.wikisink.pojo.WikiData> wikiDataList;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public WikiDataCollection() {}

  /**
   * All-args constructor.
   * @param wikiDataList The new value for wikiDataList
   */
  public WikiDataCollection(java.util.List<com.ps.wikisink.pojo.WikiData> wikiDataList) {
    this.wikiDataList = wikiDataList;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return wikiDataList;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: wikiDataList = (java.util.List<com.ps.wikisink.pojo.WikiData>)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'wikiDataList' field.
   * @return The value of the 'wikiDataList' field.
   */
  public java.util.List<com.ps.wikisink.pojo.WikiData> getWikiDataList() {
    return wikiDataList;
  }


  /**
   * Sets the value of the 'wikiDataList' field.
   * @param value the value to set.
   */
  public void setWikiDataList(java.util.List<com.ps.wikisink.pojo.WikiData> value) {
    this.wikiDataList = value;
  }

  /**
   * Creates a new WikiDataCollection RecordBuilder.
   * @return A new WikiDataCollection RecordBuilder
   */
  public static com.ps.wikisink.pojo.WikiDataCollection.Builder newBuilder() {
    return new com.ps.wikisink.pojo.WikiDataCollection.Builder();
  }

  /**
   * Creates a new WikiDataCollection RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new WikiDataCollection RecordBuilder
   */
  public static com.ps.wikisink.pojo.WikiDataCollection.Builder newBuilder(com.ps.wikisink.pojo.WikiDataCollection.Builder other) {
    if (other == null) {
      return new com.ps.wikisink.pojo.WikiDataCollection.Builder();
    } else {
      return new com.ps.wikisink.pojo.WikiDataCollection.Builder(other);
    }
  }

  /**
   * Creates a new WikiDataCollection RecordBuilder by copying an existing WikiDataCollection instance.
   * @param other The existing instance to copy.
   * @return A new WikiDataCollection RecordBuilder
   */
  public static com.ps.wikisink.pojo.WikiDataCollection.Builder newBuilder(com.ps.wikisink.pojo.WikiDataCollection other) {
    if (other == null) {
      return new com.ps.wikisink.pojo.WikiDataCollection.Builder();
    } else {
      return new com.ps.wikisink.pojo.WikiDataCollection.Builder(other);
    }
  }

  /**
   * RecordBuilder for WikiDataCollection instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<WikiDataCollection>
    implements org.apache.avro.data.RecordBuilder<WikiDataCollection> {

    private java.util.List<com.ps.wikisink.pojo.WikiData> wikiDataList;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.ps.wikisink.pojo.WikiDataCollection.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.wikiDataList)) {
        this.wikiDataList = data().deepCopy(fields()[0].schema(), other.wikiDataList);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
    }

    /**
     * Creates a Builder by copying an existing WikiDataCollection instance
     * @param other The existing instance to copy.
     */
    private Builder(com.ps.wikisink.pojo.WikiDataCollection other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.wikiDataList)) {
        this.wikiDataList = data().deepCopy(fields()[0].schema(), other.wikiDataList);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'wikiDataList' field.
      * @return The value.
      */
    public java.util.List<com.ps.wikisink.pojo.WikiData> getWikiDataList() {
      return wikiDataList;
    }


    /**
      * Sets the value of the 'wikiDataList' field.
      * @param value The value of 'wikiDataList'.
      * @return This builder.
      */
    public com.ps.wikisink.pojo.WikiDataCollection.Builder setWikiDataList(java.util.List<com.ps.wikisink.pojo.WikiData> value) {
      validate(fields()[0], value);
      this.wikiDataList = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'wikiDataList' field has been set.
      * @return True if the 'wikiDataList' field has been set, false otherwise.
      */
    public boolean hasWikiDataList() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'wikiDataList' field.
      * @return This builder.
      */
    public com.ps.wikisink.pojo.WikiDataCollection.Builder clearWikiDataList() {
      wikiDataList = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public WikiDataCollection build() {
      try {
        WikiDataCollection record = new WikiDataCollection();
        record.wikiDataList = fieldSetFlags()[0] ? this.wikiDataList : (java.util.List<com.ps.wikisink.pojo.WikiData>) defaultValue(fields()[0]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<WikiDataCollection>
    WRITER$ = (org.apache.avro.io.DatumWriter<WikiDataCollection>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<WikiDataCollection>
    READER$ = (org.apache.avro.io.DatumReader<WikiDataCollection>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    long size0 = this.wikiDataList.size();
    out.writeArrayStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (com.ps.wikisink.pojo.WikiData e0: this.wikiDataList) {
      actualSize0++;
      out.startItem();
      e0.customEncode(out);
    }
    out.writeArrayEnd();
    if (actualSize0 != size0)
      throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      long size0 = in.readArrayStart();
      java.util.List<com.ps.wikisink.pojo.WikiData> a0 = this.wikiDataList;
      if (a0 == null) {
        a0 = new SpecificData.Array<com.ps.wikisink.pojo.WikiData>((int)size0, SCHEMA$.getField("wikiDataList").schema());
        this.wikiDataList = a0;
      } else a0.clear();
      SpecificData.Array<com.ps.wikisink.pojo.WikiData> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<com.ps.wikisink.pojo.WikiData>)a0 : null);
      for ( ; 0 < size0; size0 = in.arrayNext()) {
        for ( ; size0 != 0; size0--) {
          com.ps.wikisink.pojo.WikiData e0 = (ga0 != null ? ga0.peek() : null);
          if (e0 == null) {
            e0 = new com.ps.wikisink.pojo.WikiData();
          }
          e0.customDecode(in);
          a0.add(e0);
        }
      }

    } else {
      for (int i = 0; i < 1; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          long size0 = in.readArrayStart();
          java.util.List<com.ps.wikisink.pojo.WikiData> a0 = this.wikiDataList;
          if (a0 == null) {
            a0 = new SpecificData.Array<com.ps.wikisink.pojo.WikiData>((int)size0, SCHEMA$.getField("wikiDataList").schema());
            this.wikiDataList = a0;
          } else a0.clear();
          SpecificData.Array<com.ps.wikisink.pojo.WikiData> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<com.ps.wikisink.pojo.WikiData>)a0 : null);
          for ( ; 0 < size0; size0 = in.arrayNext()) {
            for ( ; size0 != 0; size0--) {
              com.ps.wikisink.pojo.WikiData e0 = (ga0 != null ? ga0.peek() : null);
              if (e0 == null) {
                e0 = new com.ps.wikisink.pojo.WikiData();
              }
              e0.customDecode(in);
              a0.add(e0);
            }
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









