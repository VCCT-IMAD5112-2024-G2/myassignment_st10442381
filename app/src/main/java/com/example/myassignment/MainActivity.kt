package com.example.myassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    enum class HistoricalFigures(val age: Int, val description: String) {
        Figure_1(20, "Cameron Boyce was a talented American actor and dancer known for his roles in Disney Channel productions"),
        Figure_2(25, "Shawn Mendes , gained recognition on YouTube and Vine through his affiliation with the popular Vine group."),
        Figure_3(30, "Eazy-E he is an influential West Coast rapper and producer who is known for being a part of the late 80's rap group" ),
        Figure_4(35, "Anne Boleyn died at the age of 35, she was a English royalty who served as the Queen of England from 1533 to 1536"),
        Figure_5(40,"paul walker Died at 40 Actor who won the 2001 Hollywood Breakthrough Award for New Male Style maker for his performance in The Fast and the Furious."),
        Figure_6(45, "ian Somerhalder became Known to television drama audiences for playing the heartthrob Damon Salvatore. "),
        Figure_7(50, " michael jackson died at 50 The King of Pop who became the most successful singer in American history for releasing award-winning hits."),
        Figure_8(55, "Celine Dion is a pop and artist known for singing the theme from Titanic etc. "),
        Figure_9(60, "michelle obama Former First Lady of the United States of America who married Barack Obama, the 44th President of the United States of America, in 1992"),
        Figure_10(65, "Walt Disney is an Animator, voice actor, producer and entertainer who founded The Walt Disney Company and created the iconic character Mickey Mouse"),
        Figure_11(70, "oprah winfrey Television host and producer who was named the most influential woman in the world by TIME magazine and hosted The Oprah Winfrey Show."),
        Figure_12(75, "King Carles III Became King of the United Kingdom in September 2022, following the death of his mother"),
        Figure_13(80, " Wallace Shawn is a comedic actor and writer best known for his roles in My Dinner with Andre and The Princess Bride."),
        Figure_14(85,"James Madison died at the age 85, who was the fourth president of America and the father of the constitution,who notably authored America's Bill of Rights"),
        Figure_15(90,"Winston Churchill died at the age of 90, he was the British Prime Minister during World War II who encouraged bravery and endurance."),
        Figure_16(95, "Nelson Mandela died at the age of 95, he radically changed the conditions of the apartheid state of South Africa, He also became south Africa's first black president"),
        Figure_17(100, "Gloria Stuart died at the age 100, she became an actress in the 1930s and later played Rose in the film Titanic"),

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val numberAge = findViewById<EditText>(R.id.numberAge)
        val information = findViewById<TextView>(R.id.information)

        btn1?.setOnClickListener {
            val birthYear = numberAge.text.toString().toInt()

            if(birthYear != null && birthYear in 20..100) {
                val figuresAge = HistoricalFigures.values().map { it.age }

                val descriptions = when (birthYear)
                {
                    in figuresAge -> {
                        val description = HistoricalFigures.values().find { it.age == birthYear}
                        listOf(" $birthYear:${description?.description ?: "description"}")
                    }
                    in figuresAge.map { it - 1} ->{
                        val description = HistoricalFigures.values().find { it.age == birthYear + 1}
                        listOf("your age is one year before  Historical Figure which is " +
                                "${description?.description ?: "figure"}")
                    }

                    in figuresAge.map { it + 1} -> {
                        val description = HistoricalFigures.values().find { it.age == birthYear - 1}
                        listOf("your age is one year after  Historical Figure which is " +
                                "${description?.description ?: "figure"}")
                    }

                    in figuresAge.map { it + 2} ->{
                        val description = HistoricalFigures.values().find { it.age == birthYear - 2}
                        listOf("your age is two years after  Historical Figure which is " +
                                "${description?.description ?: "figure"}")
                    }

                    in figuresAge.map { it - 2} ->{
                        val description = HistoricalFigures.values().find { it.age == birthYear + 2}
                        listOf("your age is two years before Historical Figure which is " +
                                "${description?.description ?: "figure"}")
                    }

                    else -> listOf(" No historical Figures found for $birthYear.")
                }
                information.text = descriptions.joinToString( "\n")
            } else {
                information.text = "No Figure has been found from the input of your age."
            }

        }
        btn2?.setOnClickListener {
            numberAge.text.clear()
            information.text = ""
        }




    }
}















