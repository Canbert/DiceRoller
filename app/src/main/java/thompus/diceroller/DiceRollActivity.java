package thompus.diceroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class DiceRollActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonRoll;
    private TextView textViewResult, textViewTotal;
    private SeekBar seekBarAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll);

        buttonRoll = (Button)this.findViewById(R.id.buttonRoll);
        buttonRoll.setOnClickListener(this);

        textViewResult = (TextView)this.findViewById(R.id.textViewResult);
        seekBarAmount = (SeekBar)this.findViewById(R.id.seekBarAmount);
        textViewTotal = (TextView)this.findViewById(R.id.textViewTotal);
    }

    public void onClick(View v){
        Dice dice = new Dice(6);
        String str = "";
        int total = 0;
        for(int i = 0; i <= seekBarAmount.getProgress(); i++){
            int num = dice.roll();
            str += roll(num);
            total += num;
        }
        textViewResult.setText(str);
        textViewTotal.setText(getResources().getString(R.string.dice_total) + " " + String.valueOf(total));
    }

    private String roll(int num){
        String uni = null;
        switch(num){
            case 1:
                uni = "\u2680";
                break;
            case 2:
                uni = "\u2681";
                break;
            case 3:
                uni = "\u2682";
                break;
            case 4:
                uni = "\u2683";
                break;
            case 5:
                uni = "\u2684";
                break;
            case 6:
                uni = "\u2685";
                break;
        }
        return uni;
    }
}
