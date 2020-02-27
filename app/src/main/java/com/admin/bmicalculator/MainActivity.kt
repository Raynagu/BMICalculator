package com.admin.bmicalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       btn_calculateBMI.setOnClickListener {
           val weight = editTextWeight.text.toString().toDouble()
           val height = editTextHeight.text.toString().toDouble()
           var bmi: Float = 0.0F

           bmi = calculateBMI(weight, height/3.281)

           textView.text = "Your BMI: $bmi"

           if(bmi < 18.5){
                imageView.setImageResource(R.drawable.underweight)
           }else if(bmi > 18.5&& bmi < 24.9){
                imageView.setImageResource(R.drawable.healthy)
           }else if(bmi > 24.9 && bmi < 29.9){
                imageView.setImageResource(R.drawable.overweight)
           }else{
               imageView.setImageResource(R.drawable.obesity)
           }
           btn_calculateBMI.hideKeyboard()
       }
    }

    private fun calculateBMI(weight: Double, height: Double): Float {
            val bmi = ((weight)/((height)*(height))).toFloat()
        return String.format("%.3f", bmi).toFloat()
    }
    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}
