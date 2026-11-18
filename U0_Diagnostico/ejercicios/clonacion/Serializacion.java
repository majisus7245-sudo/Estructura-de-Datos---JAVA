package U0_Diagnostico.ejercicios.clonacion;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializacion {
 
  /**
   * Copiar un objeto a través de mecanismos de serialización.
   */
  @SuppressWarnings( "unchecked" )
  public static <T> T Copy( T source )
  {
    try
    {
      ByteArrayOutputStream ostream = new ByteArrayOutputStream();
      ObjectOutputStream oostream = new ObjectOutputStream( ostream );
   
      oostream.writeObject( source );
      oostream.flush();
      oostream.close();
      byte[] bytes = ostream.toByteArray();
       
      InputStream istream = new ByteArrayInputStream( bytes );
      ObjectInputStream oistream = new ObjectInputStream( istream );
   
      return ( T )oistream.readObject();
    }
    catch( RuntimeException e )
      { throw e; }
    catch( Exception e )
      { throw new IllegalArgumentException( source.getClass().getName(), e ); }
  }
 
}




