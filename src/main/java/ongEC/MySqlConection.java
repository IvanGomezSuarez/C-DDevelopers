package ongEC;

import java . sql . Connection ;
import java . sql . DriverManager ;
import java . sql . SQLException ;
import java . sql . Statement ;

public class MySqlConection {
private static String db_ = " producto3 " ;
private static String login_ = " root" ;
private static String password_ = " " ;
private static String url_ = " jdbc : mysql :// ip_servidor / " + db_ ;
private static Connection connection_ ;
@SuppressWarnings("unused")
private static Statement st_ = null ;

public MySqlConection () {
try {

	Class . forName ( " com . mysql . jdbc . Driver " ) ;
connection_ = DriverManager . getConnection ( url_ ,login_ , password_ ) ;
if ( connection_ != null ) {
st_ = connection_ . createStatement () ;
System . out . println ( " Conexion a base de datos " + db_ + " correcta . " ) ;
}
else
System . out . println ( " Conexion fallida . " ) ;
} catch ( SQLException e ) { e . printStackTrace () ;}
catch ( ClassNotFoundException e ) { e . printStackTrace () ;}
catch ( Exception e ) { e . printStackTrace () ;}
}
}