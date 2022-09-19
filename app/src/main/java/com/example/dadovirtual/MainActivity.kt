package com.example.dadovirtual
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButtonToggleGroup


/**
 * Esta activity permite ao usuário rolar um dado e visualizar o resultado
 * na tela.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_VirtualDices)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val diceButtonGroup : MaterialButtonToggleGroup = findViewById(R.id.toggleButtonGroup)

        val rollButton : Button = findViewById(R.id.diceButton)

        diceButtonGroup.addOnButtonCheckedListener { toggleButtonGroup, checkedId, isChecked ->

            if (isChecked) {
                val diceImage : ImageView = findViewById(R.id.dice)
                when (checkedId) {
                    R.id.d4 -> {
                        rollDice(4)
                        rollButton.setOnClickListener { rollDice(4) }
                    }
                    R.id.d6 -> {
                        rollDice(6)
                        rollButton.setOnClickListener { rollDice(6) }
                    }
                    R.id.d8 -> {
                        rollDice(8)
                        rollButton.setOnClickListener { rollDice(8) }
                    }
                    R.id.d10 -> {
                        rollDice(10)
                        rollButton.setOnClickListener { rollDice(10) }
                    }
                    R.id.d12 -> {
                        rollDice(12)
                        rollButton.setOnClickListener { rollDice(12) }
                    }
                    else -> {
                        rollDice(20)
                        rollButton.setOnClickListener { rollDice(20) }
                    }
                }
            } else {
                if (toggleButtonGroup.checkedButtonId == View.NO_ID) {
                    // Joga os dados quando o aplicativo inicia
                    Toast.makeText(this, "Selecione uma opção", Toast.LENGTH_SHORT).show()
                }
            }
        }
        // Joga os dados quando o aplicativo inicia
        rollButton.setOnClickListener { rollDice(4) }
        rollDice(4)
    }

    /**
     * Jogue os dados e atualize a tela com o resultado.
     */
    private fun rollDice(sides: Int) {
        // Cria um novo objeto Dice com 6 lados e rola
        val dice = Dice(sides)
        val diceRoll = dice.roll()

        val diceImage : ImageView = findViewById(R.id.dice)

        // Determina qual ID de recurso drawable usar com base na jogada de dados
        if(sides == 4){
            when (diceRoll) {
                1 -> diceImage.setImageResource(R.drawable.ic_d4_1)
                2 -> diceImage.setImageResource(R.drawable.ic_d4_2)
                3 -> diceImage.setImageResource(R.drawable.ic_d4_3)
                else -> diceImage.setImageResource(R.drawable.ic_d4_4)
            }
        } else if (sides == 6) {
            when (diceRoll) {
                1 -> diceImage.setImageResource(R.drawable.ic_dice1)
                2 -> diceImage.setImageResource(R.drawable.ic_dice2)
                3 -> diceImage.setImageResource(R.drawable.ic_dice3)
                4 -> diceImage.setImageResource(R.drawable.ic_dice4)
                5 -> diceImage.setImageResource(R.drawable.ic_dice5)
                else -> diceImage.setImageResource(R.drawable.ic_dice6)
            }
        } else if (sides == 8) {
            when (diceRoll) {
                1 -> diceImage.setImageResource(R.drawable.ic_d8_1)
                2 -> diceImage.setImageResource(R.drawable.ic_d8_2)
                3 -> diceImage.setImageResource(R.drawable.ic_d8_3)
                4 -> diceImage.setImageResource(R.drawable.ic_d8_4)
                5 -> diceImage.setImageResource(R.drawable.ic_d8_5)
                6 -> diceImage.setImageResource(R.drawable.ic_d8_6)
                7 -> diceImage.setImageResource(R.drawable.ic_d8_7)
                else -> diceImage.setImageResource(R.drawable.ic_d8_8)
            }
        } else if (sides == 10) {
            when (diceRoll) {
                1 -> diceImage.setImageResource(R.drawable.ic_d10_1)
                2 -> diceImage.setImageResource(R.drawable.ic_d10_2)
                3 -> diceImage.setImageResource(R.drawable.ic_d10_3)
                4 -> diceImage.setImageResource(R.drawable.ic_d10_4)
                5 -> diceImage.setImageResource(R.drawable.ic_d10_5)
                6 -> diceImage.setImageResource(R.drawable.ic_d10_6)
                7 -> diceImage.setImageResource(R.drawable.ic_d10_7)
                8 -> diceImage.setImageResource(R.drawable.ic_d10_8)
                9 -> diceImage.setImageResource(R.drawable.ic_d10_9)
                else -> diceImage.setImageResource(R.drawable.ic_d10_10)
            }
        } else if (sides == 12) {
            when (diceRoll) {
                1 -> diceImage.setImageResource(R.drawable.ic_d12_1)
                2 -> diceImage.setImageResource(R.drawable.ic_d12_2)
                3 -> diceImage.setImageResource(R.drawable.ic_d12_3)
                4 -> diceImage.setImageResource(R.drawable.ic_d12_4)
                5 -> diceImage.setImageResource(R.drawable.ic_d12_5)
                6 -> diceImage.setImageResource(R.drawable.ic_d12_6)
                7 -> diceImage.setImageResource(R.drawable.ic_d12_7)
                8 -> diceImage.setImageResource(R.drawable.ic_d12_8)
                9 -> diceImage.setImageResource(R.drawable.ic_d12_9)
                10 -> diceImage.setImageResource(R.drawable.ic_d12_10)
                11 -> diceImage.setImageResource(R.drawable.ic_d12_11)
                else -> diceImage.setImageResource(R.drawable.ic_d12_12)
            }
        } else {
            when (diceRoll) {
                1 -> diceImage.setImageResource(R.drawable.ic_d20_1)
                2 -> diceImage.setImageResource(R.drawable.ic_d20_2)
                3 -> diceImage.setImageResource(R.drawable.ic_d20_3)
                4 -> diceImage.setImageResource(R.drawable.ic_d20_4)
                5 -> diceImage.setImageResource(R.drawable.ic_d20_5)
                6 -> diceImage.setImageResource(R.drawable.ic_d20_6)
                7 -> diceImage.setImageResource(R.drawable.ic_d20_7)
                8 -> diceImage.setImageResource(R.drawable.ic_d20_8)
                9 -> diceImage.setImageResource(R.drawable.ic_d20_9)
                10 -> diceImage.setImageResource(R.drawable.ic_d20_10)
                11 -> diceImage.setImageResource(R.drawable.ic_d20_11)
                12 -> diceImage.setImageResource(R.drawable.ic_d20_12)
                13 -> diceImage.setImageResource(R.drawable.ic_d20_13)
                14 -> diceImage.setImageResource(R.drawable.ic_d20_14)
                15 -> diceImage.setImageResource(R.drawable.ic_d20_15)
                16 -> diceImage.setImageResource(R.drawable.ic_d20_16)
                17 -> diceImage.setImageResource(R.drawable.ic_d20_17)
                18 -> diceImage.setImageResource(R.drawable.ic_d20_18)
                19 -> diceImage.setImageResource(R.drawable.ic_d20_19)
                else -> diceImage.setImageResource(R.drawable.ic_d20_20)
            }
        }

        // Atualiza a descrição do conteúdo
        diceImage.contentDescription = diceRoll.toString()

        // Atualiza a tela com o lançamento de dados
        val resultText : TextView = findViewById(R.id.result)
        val resultString: String = getString(R.string.result)
        "$resultString $diceRoll".also { resultText.text = it }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}