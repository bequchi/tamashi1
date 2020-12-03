package com.example.a1tamashi

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.a1tamashi.R.*
import java.util.*

class MainActivity() : AppCompatActivity(),View.OnClicklistener, Parcelable {

   private lateinit var button1: Button
   private lateinit var button2: Button
   private lateinit var button3: Button
   private lateinit var button4: Button
    private lateinit var button5:Button
   private lateinit var button6: Button
   private lateinit var button7: Button
   private lateinit var button8: Button
   private lateinit var button9: Button

    private lateinit var resetButton: Button

    private var activeplayer = 1

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    constructor(parcel: Parcel) : this() {
        activeplayer = parcel.readInt()
    }

    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
    }
    private fun init() {

       button1 = findViewById(id.button1)
       button2 = findViewById(id.button2)
       button3 = findViewById(id.button3)
       button4 = findViewById(id.button4)
       button5 = findViewById(id.button5)
       button6 = findViewById(id.button6)
       button7 = findViewById(id.button7)
       button8 = findViewById(id.button8)
       button9 = findViewById(id.button9)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)


    }
    override fun onClick(clickedView: View?) {

        if (clickedView is Button) {

            var buttonNumber = 0

            when (clickedView.id){
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }

            if (buttonNumber !=0){
                playgame(buttonNumber, clickedView)
            }
        }



    }

    private fun playgame(buttonNumber: Int, clickedView: Button) {
        if (activeplayer == 1){
            clickedView = "X"
            clickedView.setBackgroundColor(Color.RED)
            firstPlayer.add(buttonNumber)
            activeplayer = 2
        }else{
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.BLUE)
            secondPlayer.add(buttonNumber)
            activeplayer = 1
        }
        clickedView.isEnabled = false
        check()

    }

    private fun check(){

        var winnerPlayer = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }

        if (winnerPlayer ! = 0){
            if (winnerPlayer == 1){
                Toast.makeText(this, "X wins!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "0 wins!", Toast.LENGTH_LONG).show()
            }

        }

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(activeplayer)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }


}