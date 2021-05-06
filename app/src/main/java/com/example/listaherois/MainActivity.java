package com.example.listaherois;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     ListView listView;

     String nomeHero[]={"Mulher Maravilha", "Meninas Superpoderosas", "Hinata", "Capitã Marvel","Jean Grey","Xena","Viúva Negra", "Mulher Elástica", "Mulher Gavião", "Tsunade","Tempestade"};
     int imghero[]={R.drawable.mulherm, R.drawable.powerpuff, R.drawable.hinata, R.drawable.captainm,R.drawable.jeangrey,R.drawable.xena,R.drawable.viuvanegra,R.drawable.mulherelastica,R.drawable.mulhergaviao,R.drawable.tsunade,R.drawable.tempestade};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.idListahero);
        CustomAdapter adapter = new CustomAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> AdapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Você selecionou a heroína:"+nomeHero[i], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), visualiza_heroi_layout.class);
                intent.putExtra("nomehero", nomeHero[i]);
                intent.putExtra("imghero", imghero[i]);
                startActivity(intent);
            }
        });
    }

public class CustomAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return imghero.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView TxtNomeHero;
        ImageView imagemhero;

        View carregaView = getLayoutInflater().inflate(R.layout.relativelayouthero, null);

        TxtNomeHero = carregaView.findViewById(R.id.txtListaHero);
        imagemhero = carregaView.findViewById(R.id.imglistahero);

        //Carregando os valores nos componentes

        TxtNomeHero.setText(nomeHero[i]);
        imagemhero.setImageResource(imghero[i]);

        return carregaView;
    }
}
}