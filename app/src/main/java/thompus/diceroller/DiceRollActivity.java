package thompus.diceroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class DiceRollActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener{

    private TextView textViewResult, textViewTotal, textViewAmount;
    private SeekBar seekBarAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll);

        textViewResult = (TextView)this.findViewById(R.id.textViewResult);
        textViewResult.setOnClickListener(this);
        textViewResult.setText("Tap here to roll dice");

        seekBarAmount = (SeekBar)this.findViewById(R.id.seekBarAmount);
        seekBarAmount.setOnSeekBarChangeListener(this);

        textViewTotal = (TextView)this.findViewById(R.id.textViewTotal);
        textViewAmount = (TextView)this.findViewById(R.id.textViewAmount);

        //Update the text so that they have numbers values
        textViewTotal.setText(getResources().getString(R.string.dice_total) + " " + String.valueOf(0));
        textViewAmount.setText(getResources().getString(R.string.dice_amount) + " " + String.valueOf(seekBarAmount.getProgress() + 1));
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

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        textViewAmount.setText(getResources().getString(R.string.dice_amount) + " " + String.valueOf(seekBar.getProgress() + 1));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
