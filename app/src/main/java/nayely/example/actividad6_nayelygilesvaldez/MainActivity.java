package nayely.example.actividad6_nayelygilesvaldez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    CGoles Obj2=new CGoles();

    Spinner Loc;
    EditText golLoc;
    Spinner Vis;
    ImageView Img1;
    ImageView Img2;
    EditText golVis;
    GridView Gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Loc=findViewById(R.id.Local);
        golLoc=findViewById(R.id.GolesLocal);
        Vis=findViewById(R.id.Visitante);
        golVis=findViewById(R.id.GolesVisitante);
        Gv=findViewById(R.id.Grid);
        Img1=findViewById(R.id.ImgLocal);
        Img2=findViewById(R.id.ImgVisitante);

        Obj2.Archivo_Vector(this);
        Obj2.Mostrar(this,Gv);

        String[] Local={"BOLIVAR","ORIENTE","BLOOMING","THE STRONGEST","AURORA"};
        ArrayAdapter<String> Obj=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,Local);
        Loc.setAdapter(Obj);

        Loc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String LocEleg=Loc.getSelectedItem().toString();
                switch (LocEleg)
                {
                    case"BOLIVAR":
                        Img1.setImageResource(R.drawable.bolivar);
                        break;
                    case "ORIENTE":
                        Img1.setImageResource(R.drawable.oriente);
                        break;
                    case "BLOOMING":
                        Img1.setImageResource(R.drawable.blooming);
                        break;
                    case "THE STRONGEST":
                        Img1.setImageResource(R.drawable.strongest);
                        break;
                    case"AURORA":
                        Img1.setImageResource(R.drawable.aurora);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        String[] Visitante={"CICLON","GUABIRA","PARI","DESTROYERS","TOMAYAPO"};
        ArrayAdapter<String> Obj1=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,Visitante);
        Vis.setAdapter(Obj1);
        Vis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String VisEleg=Vis.getSelectedItem().toString();
                switch (VisEleg)
                {
                    case"CICLON":
                        Img2.setImageResource(R.drawable.ciclon);
                        break;
                    case "GUABIRA":
                        Img2.setImageResource(R.drawable.guabira);
                        break;
                    case "PARI":
                        Img2.setImageResource(R.drawable.pari);
                        break;
                    case "DESTROYERS":
                        Img2.setImageResource(R.drawable.destroyers);
                        break;
                    case"TOMAYAPO":
                        Img2.setImageResource(R.drawable.tomayapo);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void Guardar(View vista)
    {

        Obj2.Vector_Archivo(this,Loc.getSelectedItem().toString(),golLoc.getText().toString(),Vis.getSelectedItem().toString(),golVis.getText().toString());
        Obj2.Mostrar(this,Gv);
    }
}