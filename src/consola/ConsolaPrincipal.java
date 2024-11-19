package consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.LearningPath;
import model.Recurso;
import model.Tarea;

public class ConsolaPrincipal extends ConsolaBasica {

    private final String[] opcionesMenuPrincipal = new String[]{ "Cargar información de un archivo","Mostrar informacion basica", "Salir" };

    protected List<LearningPath> theLPS;

	private void mostrarMenuPrincipal()
    {
        int opcionSeleccionada = mostrarMenu( "Menú principal", opcionesMenuPrincipal );
        
        
        if( opcionSeleccionada == 1 )
        {
            cargarDatos();
        }

        else if( opcionSeleccionada == 2 )
        {	
        	
        	if ( theLPS == null){
        		System.out.println( "No hay en este momento datos que puedan usarse" );
        	}
        	else {
        		MostrarInfo( );
        	}
        }
        
        else if( opcionSeleccionada == 3 )
        {
            System.out.println( "Saliendo ..." );
            System.exit( 0 );
        }
        mostrarMenuPrincipal( );
    }
	
	private void MostrarInfo( )
    {
        if( theLPS != null )
        {
            
        }
        else
        {
            System.out.println( "No hay en este momento una galeria que pueda usarse" );
        }
    }
	
	
	
	
	private void cargarDatos() 
    {
        String nombreArchivo = pedirCadenaAlUsuario( "Indique el archivo con la información de la gasolinera. El archivo debe estar dentro de la carpeta 'datos'" );
        
        if( !nombreArchivo.trim( ).equals( "" ) )
        {
            File archivo = new File( "./datos/" + nombreArchivo );
          
            
            if( !archivo.exists( ) )
            {
                System.out.println( "El archivo indicado no existe" );
            }
            else
            {
                try
                {
                    List<LearningPath> LPSinUsuarios = cargarEstadoLP( archivo );
                    System.out.println( "Se cargaron los learning paths a partir del archivo " + archivo.getAbsolutePath( ) );
                    mostrarInfo m = new mostrarInfo( LPSinUsuarios );
                    m.mostrarMenu( );
                    
                }
                catch( NumberFormatException e )
                {
                    System.out.println( "Hubo un error leyendo el archivo: hay números con un formato incorrecto" );
                    System.out.println( e.getMessage( ) );
                    e.printStackTrace( );
                }
                catch( FileNotFoundException e )
                {
                    System.out.println( "No se encontró el archivo indicado" );
                    System.out.println( e.getMessage( ) );
                    e.printStackTrace( );
                }
                catch( IOException e )
                {
                    System.out.println( "No se pudo leer el archivo indicado" );
                    System.out.println( e.getMessage( ) );
                    e.printStackTrace( );
                }
            }
        }

    }
	
    public static List<LearningPath> cargarEstadoLP( File archivo) throws FileNotFoundException, IOException, NumberFormatException{

        List<LearningPath> learningPaths = new ArrayList<>();

        BufferedReader br = new BufferedReader( new FileReader( archivo ) );
        String line = br.readLine( );
        while( line != null )
        {
            String[] partes = line.split( "," );
            if( partes[ 0 ].equals( "Tarea" ) )
            {
                

                int id_actividad = Integer.parseInt(partes[1]);
                String descripcion = partes[2];
                String objetivo = partes [3];
                int duracion_esperada = Integer.parseInt(partes[4]);
                boolean esObligatoria = Boolean.parseBoolean( partes[5]);          
                //Para cualquier activiidad
                String instrucciones = partes[6];
                int id_learningPath =  Integer.parseInt(partes[7]);


                Tarea nuevaTarea = new Tarea(id_actividad, descripcion, objetivo, duracion_esperada,instrucciones,esObligatoria);

                for (LearningPath lp : learningPaths){
                
                    if (lp.getId() == id_learningPath){
                        lp.agregarActividad(nuevaTarea);
                    }
               }
                
            }
            else if( partes[ 0 ].equals( "Recurso" ) )
            {
                

                int id_actividad = Integer.parseInt(partes[1]);
                String descripcion = partes[2];
                String objetivo = partes [3];
                int duracion_esperada = Integer.parseInt(partes[4]);
                boolean esObligatoria = Boolean.parseBoolean( partes[5]);          
                //Para cualquier activiidad
                String tipo = partes[6];
                String fuente = partes[7];
                int id_learningPath =  Integer.parseInt(partes[8]);


                Recurso nuevoRecurso = new Recurso(id_actividad, descripcion, objetivo, duracion_esperada,tipo,fuente,esObligatoria);

                for (LearningPath lp : learningPaths){
                    if (lp.getId() == id_learningPath){
                        lp.agregarActividad(nuevoRecurso);
                    }
                }
                
            }
            else if( partes[ 0 ].equals( "LearningPath" ) )
            {
                

                int id = Integer.parseInt(partes[1]);
                String titulo = partes[2];
                String descripcion = partes [3];
                String nivelDificultad=partes[4];
                int duracionMinutos=Integer.parseInt(partes[5]);
                double rating= Double.parseDouble(partes[5]);

                String version=partes[7];
              
                LearningPath nuevoLP = new LearningPath(id, titulo, descripcion, nivelDificultad, duracionMinutos, rating, version);
               
                learningPaths.add(nuevoLP);
                
            }

            line = br.readLine( );
        }
        br.close( );

        return learningPaths;
    }
    


	public static void main( String[] args )
    {
        ConsolaPrincipal c = new ConsolaPrincipal( );
        c.mostrarMenuPrincipal( );
    }



}
