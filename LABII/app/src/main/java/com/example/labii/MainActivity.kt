package com.example.labii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
   private lateinit var etnNombre:EditText
   private lateinit var  etEdad:EditText
   private lateinit var  etnDepartamento:EditText

    private var tv_MostrarDatos:TextView? =null
    private var lvl_Datos:ListView? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        etnNombre =findViewById(R.id.etn_Nombre)
        etEdad =findViewById(R.id.et_Edad)
        etnDepartamento=findViewById(R.id.etn_Departamento)

        lvl_Datos = findViewById(R.id.lvl_Datos)
        tv_MostrarDatos= findViewById(R.id.tv_MostrarDatos)


    }
    //Creando Listas
    private var nombres = ArrayList<String>()
    private var edades = ArrayList<Int>()
    private var departamentos =ArrayList<String>()


 fun Agregar(V: View){

     var nombre = etnNombre.text.toString()
     var  edad = etEdad.text.toString().toInt()
     var departamento = etnDepartamento.text.toString()

     //Agregando datos al arreglo
     nombres.add(nombre)
     edades.add(edad)
     departamentos.add(departamento)


     var adaptador:ArrayAdapter<String> = ArrayAdapter<String>(this,R.layout.list_item_programacion, nombres)

     lvl_Datos?.adapter=adaptador

     lvl_Datos?.onItemClickListener = object:AdapterView.OnItemClickListener{
         override fun onItemClick(p0: AdapterView<*>?, p1: View?, posicion: Int, p3: Long) {
             tv_MostrarDatos?.setText("Mostrando infomación de ${nombres[posicion]}: ${edades[posicion]} de edad, perteneciente al departamento de ${departamentos[posicion]}")
         }


     }


     //Limpiando las cajas
     etnNombre.setText("")
     etEdad.setText("")
     etnDepartamento.setText("")


     nombre = ""
     edad = 0
     departamento = ""















 }

}