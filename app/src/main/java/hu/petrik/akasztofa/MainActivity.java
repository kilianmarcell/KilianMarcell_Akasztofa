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

    private char[] betuTomb = {
            'A', 'Á', 'B', 'C', 'D', 'E', 'É', 'F', 'G', 'H', 'I', 'Í', 'J',
            'K', 'L', 'M', 'N', 'O', 'Ó', 'Ö', 'Ő', 'P', 'Q', 'R', 'S', 'T',
            'U', 'Ú', 'Ü', 'Ű', 'V', 'W', 'X', 'Y', 'Z'
    };

    private List<Character> tippeltBetuk = new ArrayList<>();

    private int tippekSzamlalo = 0;
    private int hanyadikBetu = 0;
    private char melyikBetu = betuTomb[hanyadikBetu];
    private String kivalasztottSzo = szoTomb[(int)(Math.random() * szoTomb.length)];
    private String beallitasKitalalSzo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        for (int i = 0; i < kivalasztottSzo.length(); i++) {
            beallitasKitalalSzo += "_ ";
        }
        kitalalSzo.setText(beallitasKitalalSzo);

        tippelBetu.setText(melyikBetu + "");
        tippelBetu.setTextColor(Color.RED);

        gombPlusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hanyadikBetu++;
                if (hanyadikBetu > betuTomb.length-1) {
                    hanyadikBetu = 0;
                }
                vizsgalSzin();
                tippelBetuBeallitas();
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
                tippelBetuBeallitas();
            }
        });

        gombTippel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tippeltBetuk.add(betuTomb[hanyadikBetu]);
                tippelBetu.setTextColor(Color.BLACK);
                vizsgalBetu();
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

    public void vizsgalBetu() {
        StringBuilder kitalalandoSzo = new StringBuilder(beallitasKitalalSzo);
        boolean vanE = false;
        for (int i = 0; i < kivalasztottSzo.length(); i++) {
            if (Character.toUpperCase(kivalasztottSzo.charAt(i)) == betuTomb[hanyadikBetu]) {
                kitalalandoSzo.setCharAt(i * 2, betuTomb[hanyadikBetu]);
                vanE = true;
            }
        }
        if (!vanE) {
            tippekSzamlalo++;
            kepValtas(tippekSzamlalo);
        }
        beallitasKitalalSzo = kitalalandoSzo.toString();
        kitalalSzo.setText(beallitasKitalalSzo);

        //for (int i = 0; i < kivalasztottSzo.length(); i++) {
        //    if (kivalasztottSzo.charAt(i) == Character.toLowerCase(betuTomb[hanyadikBetu])) {
        //        int valtozasHelye = i * 2 - 1;
        //        String elotte = kivalasztottSzo.substring(0, valtozasHelye - 1);
        //        String jelen = kivalasztottSzo.substring(valtozasHelye, valtozasHelye + 1);
        //        String utana = kivalasztottSzo.substring(valtozasHelye + 1, kivalasztottSzo.length());
        //
        //        beallitasKitalalSzo = elotte + Character.toLowerCase(betuTomb[hanyadikBetu]) + utana;
        //    }
        //}
    }

    public void kepValtas(int hanyadikHiba) {
        switch (hanyadikHiba) {
            case 1:
                kepAkasztofa.setImageResource(R.drawable.akasztofa01);
                break;
            case 2:
                kepAkasztofa.setImageResource(R.drawable.akasztofa02);
                break;
            case 3:
                kepAkasztofa.setImageResource(R.drawable.akasztofa03);
                break;
            case 4:
                kepAkasztofa.setImageResource(R.drawable.akasztofa04);
                break;
            case 5:
                kepAkasztofa.setImageResource(R.drawable.akasztofa05);
                break;
            case 6:
                kepAkasztofa.setImageResource(R.drawable.akasztofa06);
                break;
            case 7:
                kepAkasztofa.setImageResource(R.drawable.akasztofa07);
                break;
            case 8:
                kepAkasztofa.setImageResource(R.drawable.akasztofa08);
                break;
            case 9:
                kepAkasztofa.setImageResource(R.drawable.akasztofa09);
                break;
            case 10:
                kepAkasztofa.setImageResource(R.drawable.akasztofa10);
                break;
            case 11:
                kepAkasztofa.setImageResource(R.drawable.akasztofa11);
                break;
            case 12:
                kepAkasztofa.setImageResource(R.drawable.akasztofa12);
                break;
            case 13:
                kepAkasztofa.setImageResource(R.drawable.akasztofa13);
                break;
        }
    }

    public void tippelBetuBeallitas() {
        char melyikBetu = betuTomb[hanyadikBetu];
        tippelBetu.setText(melyikBetu + "");
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