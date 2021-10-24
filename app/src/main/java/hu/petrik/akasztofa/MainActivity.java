package hu.petrik.akasztofa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

        gombPlusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hanyadikBetu++;
                if (hanyadikBetu > betuTomb.length-1) {
                    hanyadikBetu = 0;
                }
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
                String melyikBetu = betuTomb[hanyadikBetu];
                tippelBetu.setText(melyikBetu);
            }
        });
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