package thompus.diceroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class DiceRollActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonRoll;
    private TextView textViewResult;
    private SeekBar seekBarAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll);

        buttonRoll = (Button)this.findViewById(R.id.buttonRoll);
        buttonRoll.setOnClickListener(this);

        textViewResult = (TextView)this.findViewById(R.id.textViewResult);

        seekBarAmount = (SeekBar)this.findViewById(R.id.seekBarAmount);
    }

    public void onClick(View v){
        Dice dice = new Dice(6);
        String str = "";
        for(int i = 0; i <= seekBarAmount.getProgress(); i++){
            str += roll(dice);
        }
        textViewResult.setText(str);
    }

    private String roll(Dice dice){
        String uni = null;
        switch(dice.roll()){
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
