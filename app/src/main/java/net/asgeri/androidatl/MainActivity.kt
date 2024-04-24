package net.asgeri.androidatl

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import net.asgeri.androidatl.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            val hesab = binding.editTextPrice.text.toString().trim()

            if (hesab.isNotEmpty()) {

                var toplam = 0.0

                val hesabReqem = hesab.toInt()

                val secilenRadioButtonId = binding.radioGroup.checkedRadioButtonId

                when (secilenRadioButtonId) {
                    R.id.radioButton15 -> toplam = hesabReqem * 0.15
                    R.id.radioButton18 -> toplam = hesabReqem * 0.18
                    else -> toplam = hesabReqem * 0.2
                }

                if (binding.switch1.isChecked) {
                    toplam = kotlin.math.ceil(toplam)
                }

                binding.textView2.text = toplam.toString()

            } else {
                binding.textView2.text = "Hesab boş ola bilmez"
            }
        }

    }
}