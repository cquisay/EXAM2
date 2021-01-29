package com.amst.theheroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amst.theheroproject.heroes.heroe;
import com.amst.theheroproject.interfaces.heroeAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    TextView tvIntelligence;
    TextView tvStrength;
    TextView tvSpeed;
    TextView tvDurability;
    TextView tvPower;
    TextView tvCombat;
    Button btnBuscar;






    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName=findViewById(R.id.editNombreHeroe);
        tvIntelligence=findViewById(R.id.tvIntelligence);
        tvStrength=findViewById(R.id.tvStrength);
        tvSpeed=findViewById(R.id.tvSpeed);
        tvDurability=findViewById(R.id.tvDurability);
        tvPower=findViewById(R.id.tvPower);
        tvCombat=findViewById(R.id.tvCombat);

    }



    private void find(String name){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://superheroapi.com/api/3868643479833025/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        heroeAPI heroeApi=retrofit.create(heroeAPI.class);
        Call<heroe> call=heroeApi.find(name);
        call.enqueue(new Callback<heroe>() {
            @Override
            public void onResponse(Call<heroe> call, Response<heroe> response) {
                try{

                    if(response.isSuccessful()){
                        heroe p=response.body();
                        tvIntelligence.setText(p.getIntelligence());
                        tvStrength.setText(p.getStrength());
                        tvSpeed.setText(p.getSpeed());
                        tvDurability.setText(p.getDurability());
                        tvCombat.setText(p.getPower());






                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<heroe> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error de conexión",Toast.LENGTH_SHORT);

            }
        });






    }

}