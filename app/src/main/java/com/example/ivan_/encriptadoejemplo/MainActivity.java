package com.example.ivan_.encriptadoejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private final String abc = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    private int desplazamiento = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin1 = (Spinner)findViewById(R.id.spin1);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.desplazamiento,
                android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adaptador);


        Button btnConvertir = (Button)findViewById(R.id.btnConvertir);
        Button btnLimpiar = (Button)findViewById(R.id.btnLimpiar);

        final EditText etPlano = (EditText)findViewById(R.id.etPlano);
        final EditText etCifrado = (EditText)findViewById(R.id.etCifrado);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                etPlano.setText("");
                etCifrado.setText("");
            }
        });

        etCifrado.setOnKeyListener(new EditText.OnKeyListener() {
            @Override
            public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
                if (etPlano.getText().toString().compareTo("") != 0)
                {
                    etPlano.setText("");
                }
                return false;
            }
        });

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                desplazamiento = pos;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                desplazamiento = 0;
            }

        });

        btnConvertir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String textoPlano = etPlano.getText().toString();
                String textoCifrado = etCifrado.getText().toString();
                int txtLen = etPlano.length();
                int cifrLen = etCifrado.length();
                CifradorDescifradorSustitucion cifDecif = new CifradorDescifradorSustitucion(desplazamiento);

                if ((txtLen != 0) || (cifrLen !=0))
                {
                    if (txtLen > 0)
                    {
                        String contenidoCifrado = cifDecif.cifrar(textoPlano);
                        etCifrado.setText(contenidoCifrado);
                    }
                    else
                    {
                        String contenidoPlano = cifDecif.descifrar(textoCifrado);
                        etPlano.setText(contenidoPlano);
                    }
                }
            }
        });
    }

}
