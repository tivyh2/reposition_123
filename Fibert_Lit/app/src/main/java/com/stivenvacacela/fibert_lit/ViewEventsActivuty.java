package com.stivenvacacela.fibert_lit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewEventsActivuty extends AppCompatActivity implements View.OnLongClickListener {

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_events_activuty);

        listView=(ListView) findViewById(R.id.ltvListaEventos);
        listView.setOnLongClickListener(this);


        Bundle bundle = getIntent().getExtras();
        int dia, mes , anio;
        dia=mes=anio=0 ;

        dia= bundle.getInt("dia");
        mes= bundle.getInt("mes");
        anio= bundle.getInt("anio");
        String cadena =dia+" - " + mes +"-"+anio;

        BDSQLite bd =new BDSQLite(getApplicationContext(), "Agenda",null,1);
        SQLiteDatabase db = bd.getReadableDatabase();

        String sql="select * from eventos where fechadesde='"+cadena+"'";
        Cursor c;

        String nombre, fechadesde, fechahasta, descripcion, ubicacion;
        try {
            c=db.rawQuery(sql, null);
        }catch (Exception ex) (

                )

    }



    @Override
    public boolean onLongClick(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        CharSequence []items = new CharSequence[2];
        items [0] ="Eliminar evento";
        items [2] = "Cancelar";
        builder.setTitle("Eliminar evento")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if(i==0){
                            //eliminar evento
                        }
                    }
                });
        AlertDialog dialog= builder.create();
        dialog.show();
        return false;
    }
}