package br.usjt.sinplancontrolchatboot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String NOME = "br.usjt.sinplancontrolchatboot.NOME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviaNome(View view){
        Intent intent = new Intent(this, Chatboot.class);
        EditText nome = (EditText) findViewById(R.id.nome);
        String message = nome.getText().toString();
        intent.putExtra(NOME, message);

        if(nome.length() == 0){
            Toast.makeText(this, "Por favor informe seu nome.", Toast.LENGTH_SHORT).show();
        }else {
            startActivity(intent);
        }

    }
}
