package urdj.automaticamusements.com.paypaltest.stripe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.model.Card;
import com.stripe.android.model.Source;
import com.stripe.android.model.SourceParams;
import com.stripe.android.model.Token;
import com.stripe.android.view.CardInputWidget;

import java.util.HashMap;
import java.util.Map;

import urdj.automaticamusements.com.paypaltest.R;

public class StripeActivity extends AppCompatActivity {

    CardInputWidget mCardInputWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stripe);

        setupCard();
    }

    private void setupCard() {
        CardInputWidget mCardInputWidget = (CardInputWidget) findViewById(R.id.card_input_widget);

        Card cardToSave = mCardInputWidget.getCard();
        if (cardToSave == null) {
            Log.e("CE", "Invalid Card Data");
        }

//        cardToSave.setName("Customer Name");
        //      cardToSave.setAddressZip("12345");
    }


   /* public void onClickSomething(String cardNumber, Integer cardExpMonth, Integer cardExpYear, String cardCVC) {
        Card card = new Card(
                cardNumber,
                cardExpMonth,
                cardExpYear,
                cardCVC
        );

        card.validateNumber();
        card.validateCVC();

        SourceParams giropayParams = SourceParams.createGiropayParams(
                100,
                "Customer Name",
                "yourcompany://yourpath",
                "a purchase description");
// Note: this is a synchronous method -- you should not run it on the UI thread
        Source giropaySource = mStripe.createSourceSynchronous(giropayParams);
        if (Source.REDIRECT.equals(giropaySource.getFlow())) {
            String redirectUrl = giropaySource.getRedirect().getUrl();
            // then go to this URL, as shown below.
        }

    }
*/

}
