package com.example.user.tictactoe;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvGameStatus;
    Button b00;
    Button b01;
    Button b02;

    Button b10;
    Button b11;
    Button b12;

    Button b20;
    Button b21;
    Button b22;

    Button reset;
    int count;
    boolean resetPressed;
    String Player_X="X";
    String Player_Y="0";
    int[][] boardStatus = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i= getIntent();

        Player_X=i.getStringExtra("PLAYER_1");
        Player_Y=i.getStringExtra("PLAYER_2");

        b00 = (Button) findViewById(R.id.b00);
        b01 = (Button) findViewById(R.id.b01);
        b02 = (Button) findViewById(R.id.b02);

        b10 = (Button) findViewById(R.id.b10);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);

        b20 = (Button) findViewById(R.id.b20);
        b21 = (Button) findViewById(R.id.b21);
        b22 = (Button) findViewById(R.id.b22);

        reset = (Button) findViewById(R.id.reset);
        tvGameStatus = (TextView) findViewById(R.id.tvGameStatus);
        b00.setOnClickListener(this);
        b01.setOnClickListener(this);
        b02.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b20.setOnClickListener(this);
        b21.setOnClickListener(this);
        b22.setOnClickListener(this);
        reset.setOnClickListener(this);
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardStatus[i][j] = -1;
            }
        }
        count = 0;
    }

    public void resetButtonPressed() {
        setInfo("Start Again");
        initializeBoard();
        enableAllButtons(true);

        Toast.makeText(MainActivity.this,
                "Play Again",
                Toast.LENGTH_SHORT).show();


        b00.setText("");
        b01.setText("");
        b02.setText("");
        b10.setText("");
        b11.setText("");
        b12.setText("");
        b20.setText("");
        b21.setText("");
        b22.setText("");


    }

    public void result(String s){
        setInfo(s);
        enableAllButtons(false);
    }

    public void setInfo(String s) {
        tvGameStatus.setText(s);
    }

    public void checkWinner()
    {
        //Horizontal Rows
           for(int i=0;i<3;i++)
           {
               if(boardStatus[i][0]==boardStatus[i][1] && boardStatus[i][1]==boardStatus[i][2])
               {
                   if (boardStatus[i][0]==1)
                        result(Player_X + "wins!");
                   else if(boardStatus[i][0]==0)
                        result(Player_Y + "wins!");

               }
           }

        //Vertical Columns
           for(int i=0;i<3;i++)
           {
               if(boardStatus[0][i]==boardStatus[1][i] && boardStatus[1][i]==boardStatus[2][i])
               {
                   if(boardStatus[0][i]==1)
                       result(Player_X + " wins!");
                   else if(boardStatus[0][i]==0)
                       result(Player_Y + " wins!");
               }
           }
        //First Diagonal
             if(boardStatus[0][0]== boardStatus[1][1] && boardStatus[1][1]==boardStatus[2][2])
             {
                 if(boardStatus[0][0]==1)
                 {
                     result(Player_X + " wins!");
                 }
                 if(boardStatus[0][0]==0)
                 {
                     result(Player_Y + " wins!");
                 }
             }
        //Second Diagonal
        if(boardStatus[0][2]== boardStatus[1][1] && boardStatus[1][1]==boardStatus[2][0])
        {
            if(boardStatus[0][2]==1)
            {
                result(Player_X + " wins!");
            }
            if(boardStatus[0][2]==0)
            {
                result(Player_Y + " wins!");
            }
        }

    }

    public void enableAllButtons(boolean value) {
        b00.setEnabled(value);
        b01.setEnabled(value);
        b02.setEnabled(value);
        b10.setEnabled(value);
        b11.setEnabled(value);
        b12.setEnabled(value);
        b20.setEnabled(value);
        b21.setEnabled(value);
        b22.setEnabled(value);
    }


    @Override
    public void onClick(View view) {
       int id=view.getId();
        switch (id)
        {
            case R.id.b00:
                if(count%2 == 0)
                {
                    boardStatus[0][0] = 1;
                    b00.setText("X");
                }
                else
                {
                    boardStatus[0][0] = 0;
                    b00.setText("0");
                }
                b00.setEnabled(false);
                break;

            case R.id.b01:
                if(count%2 == 0)
                {
                    boardStatus[0][1] = 1;
                    b01.setText("X");
                }
                else
                {
                    boardStatus[0][1] = 0;
                    b01.setText("0");
                }
                b01.setEnabled(false);
                break;


            case R.id.b02:
                if(count%2 == 0)
                {
                    boardStatus[0][2] = 1;
                    b02.setText("X");
                }
                else
                {
                    boardStatus[0][2] = 0;
                    b02.setText("0");
                }
                b02.setEnabled(false);
                break;

            case R.id.b10:
                if(count%2 == 0)
                {
                    boardStatus[1][0] = 1;
                    b10.setText("X");
                }
                else
                {
                    boardStatus[1][0] = 0;
                    b10.setText("0");
                }
                b10.setEnabled(false);
                break;

            case R.id.b11:
                if(count%2 == 0)
                {
                    boardStatus[1][1] = 1;
                    b11.setText("X");
                }
                else
                {
                    boardStatus[1][1] = 0;
                    b11.setText("0");
                }
                b11.setEnabled(false);
                break;

            case R.id.b12:
                if(count%2 == 0)
                {
                    boardStatus[1][2] = 1;
                    b12.setText("X");
                }
                else
                {
                    boardStatus[1][2] = 0;
                    b12.setText("0");
                }
                b12.setEnabled(false);
                break;

            case R.id.b20:
                if(count%2 == 0)
                {
                    boardStatus[2][0] = 1;
                    b20.setText("X");
                }
                else
                {
                    boardStatus[2][0] = 0;
                    b20.setText("0");
                }
                b20.setEnabled(false);
                break;

            case R.id.b21:
                if(count%2 == 0)
                {
                    boardStatus[2][1] = 1;
                    b21.setText("X");
                }
                else
                {
                    boardStatus[2][1] = 0;
                    b21.setText("0");
                }
                b21.setEnabled(false);
                break;

            case R.id.b22:
                if(count%2 == 0)
                {
                    boardStatus[2][2] = 1;
                    b22.setText("X");
                }
                else
                {
                    boardStatus[2][2] = 0;
                    b22.setText("0");
                }
                b22.setEnabled(false);
                break;

            case R.id.reset:
                resetPressed=true;
                break;

            default:
                break;

        }
        if(!resetPressed)
        {

            count++;
            if(count%2==0)
            {

                setInfo(Player_X + " turn");}
            else
            {
                setInfo(Player_Y + " turn");}
            if(count==9)
                result("Draw");

            checkWinner();
        }
        else
        {
            resetButtonPressed();
        }

    }
}

