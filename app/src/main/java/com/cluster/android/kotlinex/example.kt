package com.cluster.android.kotlinex

//En kotlin el archivo es un modelo.

//VARIABLES
//variable
var num = 3

//inmutable
val pi = 3.141516

//con las variables inmutables se mejora el rendimiento, pues reserva solo el espacio de memoria requerido, y no espacio adicional como
//si lo hace con variables.

var edad: Int = 28
var nombre: String = "Ale"

//Variable que puede tener un valor, asi como puede ser nula tambien.
var apellido: String? = ""
var subApellido: String? = apellido?.substring(0, 1)

//Operador elvi en Kotlin
var subApellido2: String = apellido?.substring(0, 1) ?: "Sin Apellido"

//inicializar una variable en un momento posterior
lateinit var color: String

//Conversiones de un valor opcional a un valor no opcional
var subApellido3: String = apellido!!.substring(0, 1)

//en java
//fun funcion(){
//if(apellido != null)
//var sub = apellido.substring(0,2)
//}

//Delegados, id es nulo, y cuando lo uso se le asigna el 1,2,3 como en el siguiente ejemplo, de hay en adelante sigo con este valor
val id: String by lazy { "1,2,3" }

//FUNCIONES
fun operar(n1: Int, n2: Int): Int {
    return n1 + n2
}

//El segundo parametro se vuelve un parametro por defecto, es decir es opcional, pues se le ha asignado un valor
//desde la definicion de la funcion.
fun sumar2(n1: Int, n2: Int = 0): Int = n1 + n2

var ans1 = sumar2(3)
var ans2 = sumar2(n1 = 2, n2 = 4)

//Extensiones en Kotlin. Cual es la diferencia con la herencia?
fun Int.mul(n:Int):Int = this*n

var ans3 = 4.mul(6)

infix fun Int.div(n:Int):Int = this / n
var ans4 = 4 div 2

var sub: (n1:Int, n2:Int)->Int={n1, n2 ->n1- n2}
var ans6 = sub(7,6)

//Palabra reservada para no retorno. Unit
fun operar (n1:Int, n2:Int, callback:(rta:Int) -> Unit){
    callback(n1 + n2)
}

fun testOperar(){
    operar(1,2,{rta -> println("Resultado: $rta")})

    operar(1,2){rta -> println("resultado")}
    operar(2,4){println("Resultado $it")}
    //Lo que este en esta porcion de codigo que se ejecutara en background

}

//class Thr(val callback:() -> Unit): Runnable{

//Clases
//Utilizo val or var keyword para convertir la variable en una propiedad de clase
class Usuario(val nombre:String, var email:String)

val user1 = Usuario("Alejandro", "alejo@gmail.com")
val n = user1.nombre

fun TestUsuario(){
    user1.email = "alejo_pro@gmail.com"
}

open class Mascota(val edad:Int, val raza:String){
    var edadHumana:Int = 0

    init{
        edadHumana = 7 * edad
    }
}

var pet = Mascota(1, "bloodhod")





class Conejo(val nombre:String, edad:Int):Mascota(edad, "conejo"){
    constructor():this("", 0)

    fun comer(comida:Int){

    }

    operator fun plus(conejo:Conejo):Conejo{
        return Conejo(conejo.nombre, this.edad)
    }
}

val a = Conejo("a", 2)
val b = Conejo("b", 3)
val c = a + b

