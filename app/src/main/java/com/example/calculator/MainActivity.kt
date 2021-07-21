package com.example.calculator

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAllclear.setOnClickListener{
            binding.inputtext.text=""
            binding.outputext.text = ""
        }

        binding.btn0.setOnClickListener{
            binding.inputtext.append("0")
        }
        binding.btn1.setOnClickListener{
            binding.inputtext.append("1")
        }
        binding.btn2.setOnClickListener{
            binding.inputtext.append("2")
        }
        binding.btn3.setOnClickListener{
            binding.inputtext.append("3")
        }
        binding.btn4.setOnClickListener{
            binding.inputtext.append("4")
        }
        binding.btn5.setOnClickListener{
            binding.inputtext.append("5")
        }
        binding.btn6.setOnClickListener{
            binding.inputtext.append("6")
        }
        binding.btn7.setOnClickListener{
            binding.inputtext.append("7")
        }
        binding.btn8.setOnClickListener{
            binding.inputtext.append("8")
        }
        binding.btn9.setOnClickListener{
            binding.inputtext.append("9")
        }
        binding.btnPlus.setOnClickListener{
            binding.inputtext.append(" + ")
        }
        binding.btnMultiplication.setOnClickListener{
            binding.inputtext.append(" * ")
        }
        binding.btnMinus.setOnClickListener{
            binding.inputtext.append(" - ")
        }
        binding.btnDivide.setOnClickListener{
            binding.inputtext.append(" / ")
        }
        binding.btnDot.setOnClickListener{
            binding.inputtext.append(".")
        }
        binding.btnStartBracket.setOnClickListener{
            binding.inputtext.append(" ( ")
        }
        binding.btnCloseBracket.setOnClickListener{
            binding.inputtext.append(" ) ")
        }

        binding.btnEqual.setOnClickListener {
//shortclick
            var expression= ExpressionBuilder(binding.inputtext.text.toString()).build()
            val result = expression.evaluate()
            val longresult= result.toLong()

            if(result== longresult.toDouble()){
                binding.outputext.text=longresult.toString()
            }
            else
            {
                binding.outputext.text=result.toString()
            }

        }

        binding.btnEqual.setOnLongClickListener(View.OnLongClickListener {
            Toast.makeText(this, "ButtonLongPressed", Toast.LENGTH_SHORT).show()
            true
            startActivity(Intent(this@MainActivity, ContactActivity::class.java))
            return@OnLongClickListener true
        })

//        binding.btnEqual.setOnClickListener {
//
//            val result
//            receiver_msg = findViewById<View>(R.id.received_value_id) as TextView
//            // create the get Intent object
//
//            // create the get Intent object
//            val intent = intent
//
//            // receive the value by getStringExtra() method
//            // and key must be same which is send by first activity
//
//            // receive the value by getStringExtra() method
//            // and key must be same which is send by first activity
//            val str = intent.getStringExtra("message_key")
//
//            // display the string into textView
//
//            // display the string into textView
//            result.setText(str)
//        }
    }
}