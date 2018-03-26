package urdj.automaticamusements.com.paypaltest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetails extends AppCompatActivity {

    TextView tId, tAmount, tStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        tId = (TextView) findViewById(R.id.textId);
        tAmount = (TextView) findViewById(R.id.textAmount);
        tStatus = (TextView) findViewById(R.id.textStatus);


        Intent intent = getIntent();

        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("paymentDetails"));
            showDetails(jsonObject.getJSONObject("response"), intent.getStringExtra("paymentAmount"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void showDetails(JSONObject response, String paymentAmount) {
        try {
            tId.setText(response.getString("id"));
            tStatus.setText(response.getString("state"));
            tAmount.setText("$" + paymentAmount);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
