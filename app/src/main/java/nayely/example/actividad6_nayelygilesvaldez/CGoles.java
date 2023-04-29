package nayely.example.actividad6_nayelygilesvaldez;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CGoles {
    public String[] VLocal=new String[50];
    public String[] VGolLocal=new String[50];
    public String[] VVisitante=new String[50];
    public String[] VGolVisitante=new String[50];
    public String[] VPuntos=new String[50];

    public int Vis=-1;
    public  String Archivo="Goles.txt";
    ArrayAdapter<String> Adaptador;
    public  void Vector_Archivo(Context Contexto, String Loc, String golLoc,String Visi,String golVis)
    {
        try
        {
            Vis++;
            VLocal[Vis]=Loc;
            VGolLocal[Vis]=golLoc;
            VVisitante[Vis]=Visi;
            VGolVisitante[Vis]=golVis;
            String pun;
            if(Integer.parseInt(golLoc)==Integer.parseInt(golVis))
            {
                pun="Ambos "+golLoc;
                //pun="Loc "+golLoc+";"+"Vis "+golVis;
            }
            else{
                pun="Loc "+golLoc+";"+"Vis "+golVis;
                //pun="Ambos"+":"+golLoc;
            }
            VPuntos[Vis]=pun;

            OutputStreamWriter Obj=new OutputStreamWriter(Contexto.openFileOutput(Archivo,Context.MODE_APPEND));
        }
        catch (Exception ex)
        {

        }
    }
    public void Mostrar(Context Contexto, GridView Gv)
    {
        String[] Goles = new String[(Vis + 2) * 5];
        Goles[0]="EQUI. LOCAL";
        Goles[1]="GOL LOCAL";
        Goles[2]="EQUI. VISIT.";
        Goles[3]="GOL VISIT.";
        Goles[4]="PTS. LLEVADOS";

        int VisGol=4;
        for(int V=0;V<=Vis;V++)
        {
            VisGol++;
            Goles[VisGol]=VLocal[V];
            VisGol++;
            Goles[VisGol]=VGolLocal[V];
            VisGol++;
            Goles[VisGol]=VVisitante[V];
            VisGol++;
            Goles[VisGol]=VGolVisitante[V];
            VisGol++;
            Goles[VisGol]=VPuntos[V];
        }

        Adaptador=new ArrayAdapter<>(Contexto,android.R.layout.simple_list_item_1, Goles);
        Gv.setAdapter(Adaptador);
    }
    public void Archivo_Vector(Context Contexto)
    {
        try
        {
            Vis=-1;
            InputStreamReader Obj=new InputStreamReader(Contexto.openFileInput(Archivo));
            BufferedReader Bf=new BufferedReader(Obj);
            String Linea;
            String[] Separados=new String[5];
            while ((Linea=Bf.readLine())!=null)
            {
                Separados=Linea.split("-");
                Vis++;
                VLocal[Vis]=Separados[0];
                VGolLocal[Vis]=Separados[1];
                VVisitante[Vis]=Separados[2];
                VGolVisitante[Vis]=Separados[3];
                VPuntos[Vis]=Separados[4];
                Obj.close();
            }
        }
        catch (Exception Ex)
        {

        }
    }
}
