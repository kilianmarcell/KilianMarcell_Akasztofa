package hu.petrik.akasztofa;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button gombMinusz, gombPlusz, gombTippel;
    private TextView tippelBetu, kitalalSzo;
    private ImageView kepAkasztofa;

    private String[] szoTomb = {
            "implementálás", "objektum", "rekurzió", "testnevelés", "számítástechnika",
            "pendrive", "mérnökinformatikus", "feladatok", "depresszió", "túlóra"
    };

    private String[] betuTomb = {
            "A", "Á", "B", "C", "D", "E", "É", "F", "G", "H", "I", "Í", "J",
            "K", "L", "M", "N", "O", "Ó", "Ö", "Ő", "P", "Q", "R", "S", "T",
            "U", "Ú", "Ü", "Ű", "V", "W", "X", "Y", "Z"
    };

    private List<String> tippeltBetuk = new ArrayList();

    private int hanyadikBetu = 0;
    private String melyikBetu = betuTomb[hanyadikBetu];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        int randomSzo = (int)(Math.random() * szoTomb.length);
        String kivalasztottSzo = szoTomb[randomSzo];
        String beallitasKitalalSzo = "";
        for (int i = 0; i < kivalasztottSzo.length(); i++) {
            beallitasKitalalSzo += "_ ";
        }
        kitalalSzo.setText(beallitasKitalalSzo);

        tippelBetu.setText(melyikBetu);
        tippelBetu.setTextColor(Color.RED);

        gombPlusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hanyadikBetu++;
                if (hanyadikBetu > betuTomb.length-1) {
                    hanyadikBetu = 0;
                }
                vizsgalSzin();
                String melyikBetu = betuTomb[hanyadikBetu];
                tippelBetu.setText(melyikBetu);
            }
        });

        gombMinusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hanyadikBetu--;
                if (hanyadikBetu < 0) {
                    hanyadikBetu = betuTomb.length-1;
                }
                vizsgalSzin();
                String melyikBetu = betuTomb[hanyadikBetu];
                tippelBetu.setText(melyikBetu);
            }
        });

        gombTippel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tippeltBetuk.add(betuTomb[hanyadikBetu]);
                tippelBetu.setTextColor(Color.BLACK);
            }
        });
    }

    public void vizsgalSzin() {
        boolean vanE = false;
        for (int i = 0; i < tippeltBetuk.size(); i++) {
            if (tippeltBetuk.get(i) == betuTomb[hanyadikBetu]) {
                vanE = true;
            }
        }
        if (!vanE) {
            tippelBetu.setTextColor(Color.RED);
        } else {
            tippelBetu.setTextColor(Color.BLACK);
        }
    }

    public void init() {
        gombMinusz = findViewById(R.id.gombMinusz);
        gombPlusz = findViewById(R.id.gombPlusz);
        gombTippel = findViewById(R.id.gombTippel);
        tippelBetu = findViewById(R.id.tippelBetu);
        kitalalSzo = findViewById(R.id.kitalalSzo);
        kepAkasztofa = findViewById(R.id.kepAkasztofa);
    }
}