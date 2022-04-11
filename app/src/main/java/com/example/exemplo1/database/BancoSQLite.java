package com.example.exemplo1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.exemplo1.Modelos.Usuario;

public class BancoSQLite extends SQLiteOpenHelper{

    private static final String NOME_BANCO="Dados_Usuario.db";
    private static final String ID="id";
    private static final String LOGIN="login";
    private static final String  SENHA="senha";

    private static final String TABELA="usuarios";
    private static final int VERSAO = 1;

    public BancoSQLite(Context context){
      super (context, NOME_BANCO,null, VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase db){

        // CREATE TABLE usuarios ( ID INTEGER PRIMARY KEY AUTOINCREMENT, login TEXT, senha TEXT )

        String CREATE_USUARIOS_TABLE = "CREATE TABLE "+ TABELA + " ( " +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                LOGIN + " TEXT , "+
                SENHA + " TEXT )";

        db.execSQL(CREATE_USUARIOS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db , int oldVersion , int newVersion){
     db.execSQL("DROP TABLE IF EXISTS " + TABELA);
     onCreate(db);
    }

    public boolean inserirUsuario(Usuario u){
        long result;
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(LOGIN, u.getLogin());
        values.put(SENHA, u.getSenha());
        result= db.insert(TABELA,null,values);
        db.close();

        if (result ==-1)
            return false;
        else
            return true;
    }
    public  Usuario selecionarUsuario(String login){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
            TABELA,
                new String[]{ID,LOGIN,SENHA},
                LOGIN + " = ?",
                 new String[]{String.valueOf(login) },null,null,null,null);
                if(cursor!= null){
                    cursor.moveToFirst();
                    Usuario user = new Usuario(
                            Integer.parseInt(cursor.getString(0)),
                            cursor.getString(1),
                            cursor.getString(2));
                            return (Usuario) user.clone();
                } else
                    return null;
    }
    public Usuario selecionarUsuarioporID (String id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =db.query(
                TABELA,
                new String[]{ID,LOGIN,SENHA},
                ID + " = ?",
                new String[]{String.valueOf(id)},null,null,null,null);
        if (cursor != null){
            cursor.moveToFirst();

            Usuario user = new Usuario(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2));

            return (Usuario) user.clone();

        }else
            return null;

    }
   /* public  Usuario selecionarUsuariopoEmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABELA,
                new String[]{ID,LOGIN,SENHA},
                EMAIL + " = ?",
                new String[]{String.valueOf(email) },null,null,null,null);
        if(cursor!= null){
            cursor.moveToFirst();
            Usuario user = new Usuario(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2));
            return (Usuario) user.clone();
        } else
            return null;
    }*/

}
