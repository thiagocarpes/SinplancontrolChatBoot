package br.usjt.sinplancontrolchatboot;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Chatboot extends AppCompatActivity {
    public static String PERGUNTA = "br.usjt.sinplancontrolchatboot.PERGUNTA";
    String firstMessage, nome, questionStr, answer;
    private EditText questionTxt;
    private ListView listChat;
    private ArrayAdapter <String> adapter;
    private ArrayList<String> conversa = new ArrayList<String>();
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatboot);

        Intent intent = getIntent();

        nome = intent.getStringExtra(MainActivity.NOME);

        firstMessage = "Boot: Olá "+nome+" , como posso ajudar?";

        conversa.add(firstMessage);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, conversa);
        listChat = (ListView) findViewById(R.id.listaConversa);
        listChat.setAdapter(adapter);

    }

    public void sendQuestion(View view){
        questionTxt = (EditText)findViewById(R.id.pergunta);
        questionStr = questionTxt.getText().toString();

        String chat = nome+": "+questionStr;

        new Chat().execute(chat);

        sendAnswer(chat);
    }

    public void sendAnswer(String question){
        System.out.println(question);

        String nomeUsuario = nome;
        String oi = nomeUsuario+": Oi";
        String td = nomeUsuario+": Tudo bem?";
        String chupa = nomeUsuario+": chupa";
        String piroca = nomeUsuario+": piroca";
        System.out.println(oi);

        String cabecalho = "Boot: ";

        if(question.equalsIgnoreCase(oi)){
            answer = cabecalho+"Olá";
        }
        if(question.equalsIgnoreCase(td)){
            answer = cabecalho+"Tudo e você?";
        }
        if(question.equalsIgnoreCase(chupa)){
            answer = cabecalho+"Chupo mesmo!!!";
        }
        if(question.equalsIgnoreCase(piroca)){
            answer = cabecalho+"O Vini gosta!!!";
        }
        if(contador != 2) {
            new Chat().execute(answer);
            contador++;
        }else{
            Intent intent = new Intent(this, Dialogo.class);
            startActivity(intent);
        }
    }

    private class Chat extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... strings){
            String chat = strings[0];
            return chat;
        }
        @Override
        protected void onPostExecute(String chat){
            conversa.add(chat);

            listChat = (ListView) findViewById(R.id.listaConversa);
            listChat.setAdapter(adapter);

        }
    }
}
