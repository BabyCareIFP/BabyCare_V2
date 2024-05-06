package com.example.babycarev1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.telephony.CellSignalStrength;

import java.util.ArrayList;

public class DataBaseSQL extends SQLiteOpenHelper {

    /*TODO propagar foraneas idUsuario a tutores y cuidadores
      TODO Como almacenamos el array de hijos

     */


    protected SQLiteDatabase db;

    //CONSTRUCTOR
    public DataBaseSQL(Context context) {
        super(context, "babycareDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE table usuario (idUsuario integer primary key autoincrement not null, nombre TEXT, apellidos TEXT, dni TEXT, telefono TEXT, fechaNacimiento TEXT, sexo TEXT, nombreUsuario TEXT, contraseniaUsuario TEXT, correo TEXT, nacionalidad TEXT, direccion TEXT)");
        /*db.execSQL("CREATE table tutores (idTutor integer primary key autoincrement not null, numeroHijos integer, hijos text)");
        db.execSQL("CREATE table cuidadores (idCuidador integer primary key autoincrement not null, experiencia text, disponibilidad)");
        db.execSQL("CREATE table hijos (idHijo integer primary key autoincrement not null, nota text)");
        db.execSQL("CREATE table reservas (idReserva integer primary key autoincrement not null, nota text)");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuario");
    }

    //lo utilizaremos en el momento de introducir los datos en el signIn
    public boolean insertarUsuario(String nombreUsuario, String correoUsuario, String contraseniaUsuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO usuarioTest VALUES (null, '" + nombreUsuario + "', '" + correoUsuario + "', '" + contraseniaUsuario + "')");
        return true;
    }

    public boolean insertarPerfil(String nombre, String apellidos, String dni, String telefono, String fechaNacimiento, String sexo, String nombreUsuario, String contraseniaUsuario, String correo, String nacionalidad, String direccion) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO usuario VALUES (null, '" + nombre + "', '" + apellidos + "', '"+dni+"', '"+telefono+"', '"+fechaNacimiento+"', '"+sexo+"', '"+nombreUsuario + "', '"+contraseniaUsuario+"', '"+correo+"', '"+nacionalidad+"', '"+direccion+"')");
        return true;
    }

    /*public ArrayList<String> getDatos(){

        ArrayList<String> datos = new ArrayList<String>();

        //Abro la BBDD en modo lectura
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = null;
        res = db.rawQuery("SELECT * FROM notas", null);
        res.moveToLast();

        if (res.getCount() > 0){
            res.moveToFirst();
            while (!res.isAfterLast()){

                lista.add(res.getString(0) + ".-" + res.getString(1));
                res.moveToNext();
            }
        }

        return lista;
    }*/
    @SuppressLint("Range")
    public boolean contraseniaCorrecta(String correoIntroducido, String contraseniaIntroducida) {

        String contraseniaUsuario = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = null;
        res = db.rawQuery("SELECT contraseniaUsuario FROM usuario WHERE correoUsuario = '" + correoIntroducido + "'", null);
        res.moveToLast();
        if (res.getCount() > 0) {
            res.moveToFirst();
            while (!res.isAfterLast()) {

                contraseniaUsuario = res.getString(res.getColumnIndex("contraseniaUsuario"));
                res.moveToNext();
            }

        }
        if(contraseniaUsuario.equals(contraseniaIntroducida)){
            return true;
        }
        else{
            return false;
        }
    }
}