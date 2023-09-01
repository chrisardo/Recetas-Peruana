package co.eduardo.apprecetasperuana;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    String articulos = "create table articulos(imagen int primary key, texto text, persona texto, tiempo text, plato text, ingredien int, prepara int/*, btnagregar int*/)";
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {//Creando la base ce datos llamada "BaseDeDatos"
        BaseDeDatos.execSQL(articulos);
        //BaseDeDatos.execSQL("Create table precio(codigo int primary key, descripcion text, precio real) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS articulos");
        onCreate(sqLiteDatabase);
    }
}
