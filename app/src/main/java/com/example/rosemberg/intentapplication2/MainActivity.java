package com.example.rosemberg.intentapplication2;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    MediaPlayer musica;
    EditText busca;
    EditText hora, minuto;
    EditText nCell, mensagemm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void configuracoes(View view){
        Intent intent = new Intent();
        startActivityForResult(new Intent(Settings.ACTION_SETTINGS), 0);
    }

    public void googleMaps(View view){
        Intent maps = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.br/maps"));
        startActivity(maps);
    }

    public void musica(View view){
        musica = MediaPlayer.create(this, R.raw.malandramente);
        musica.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        musica.release();
    }

    public void sms(View view){
        nCell = (EditText) findViewById(R.id.nCell);
        mensagemm = (EditText) findViewById(R.id.mensagem);
        Intent smss = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", nCell.getText().toString(), null));
        smss.putExtra("sms_body", mensagemm.getText().toString());
        startActivity(smss);
    }

    public void alarme(View view){
        hora = (EditText) findViewById(R.id.hora);
        minuto = (EditText) findViewById(R.id.minuto);
        Intent alarm = new Intent(AlarmClock.ACTION_SET_ALARM);
        alarm.putExtra(AlarmClock.EXTRA_MESSAGE, "Alarme");
        alarm.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(hora.getText().toString()));
        alarm.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(minuto.getText().toString()));
        startActivity(alarm);
    }

    public void buscaNaWeb(View view){
        busca = (EditText) findViewById(R.id.editBusca);
        Intent buscaa = new Intent(Intent.ACTION_WEB_SEARCH);
        buscaa.putExtra(SearchManager.QUERY, busca.getText().toString());
        startActivity(buscaa);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
