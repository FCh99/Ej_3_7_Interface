package udemy.fausto.com.ej_3_7_interface

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myTriang = Recinto("myTriang", NombreFigura.TRIANGULO_RECTANGULO)
        myTriang.calcularPerimetro(2.00, 3.00, 4.00)
        myTriang.calcularArea(2.00,3.00)


    }
}

enum class NombreFigura {
    CUADRADO,
    RECTANGULO,
    TRIANGULO,
    TRIANGULO_RECTANGULO,
    CIRCUNFERENCIA,
    OTHER

}


interface Figura {
    val nombreFigura: NombreFigura
    fun calcularPerimetro(l1: Double, l2: Double, l3: Double)
    fun calcularArea(l1: Double, l2: Double)

}

class Recinto(val nombre: String, override val nombreFigura: NombreFigura) : Figura {

    override fun calcularPerimetro(l1: Double, l2: Double, l3: Double){
        var perimetro = 0.00
        perimetro = when (nombreFigura) {
            NombreFigura.CUADRADO -> l1 + l2 + l1 + l2
            NombreFigura.RECTANGULO -> l1 + l2 + l1 + l2
            NombreFigura.TRIANGULO -> l1 + l2 + l3
            NombreFigura.TRIANGULO_RECTANGULO -> l1 + l2 + l3
            NombreFigura.CIRCUNFERENCIA -> 2 * Math.PI * l1
            else -> 0.00
        }
        println("---->>El perímetro de ${this.nombre} es ${perimetro.toString()}")

    }
    override fun calcularArea(l1: Double, l2: Double){
        var area = 0.00
        area = when (nombreFigura) {
            NombreFigura.CUADRADO -> l1 * l2
            NombreFigura.RECTANGULO -> l1 * l2
            NombreFigura.TRIANGULO_RECTANGULO -> (l1 * l2) / 2
            NombreFigura.CIRCUNFERENCIA -> Math.PI * l1 * l1
            else -> 0.00
        }
        println("----> El area de ${this.nombre} es ${area.toString()}")

    }


}
