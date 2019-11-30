package com.pakdev.distancematrix;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pakdev.distancematrix.model.GoogleApiResponse;
import com.pakdev.distancematrix.retrofit.WebServiceConstants;
import com.pakdev.distancematrix.retrofit.WebServiceFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edtSource)
    EditText edtSource;
    @BindView(R.id.edtDestination)
    EditText edtDestination;
    @BindView(R.id.btnCalculate)
    Button btnCalculate;
    @BindView(R.id.txtResult)
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



    }

    private void calculateDistance(String source, String destination) {
        WebServiceFactory.getInstance(getApplicationContext()).calculateDistance(
                "km", source, destination, WebServiceConstants.API_KEY).enqueue(new Callback<GoogleApiResponse>() {
            @Override
            public void onResponse(Call<GoogleApiResponse> call, Response<GoogleApiResponse> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Distance" + response.body().getRows().get(0).getElements().get(0).getDistance(), Toast.LENGTH_SHORT).show();
                txtResult.setText("Distance "+response.body().getRows().get(0).getElements().get(0).getDistance().getText()
                +"\nTime "+response.body().getRows().get(0).getElements().get(0).getDuration().getText()
                );
                }
            }

            @Override
            public void onFailure(Call<GoogleApiResponse> call, Throwable t) {

            }
        });
    }

    @OnClick(R.id.btnCalculate)
    public void onViewClicked() {

        if (TextUtils.isEmpty(edtSource.getText().toString())) {
            Toast.makeText(this, "Source Required", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(edtDestination.getText().toString())) {
            Toast.makeText(this, "Destination Required", Toast.LENGTH_SHORT).show();

            return;
        }

        calculateDistance(edtSource.getText().toString(),edtDestination.getText().toString());

    }
}
