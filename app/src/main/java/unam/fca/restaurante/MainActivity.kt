package unam.fca.restaurante


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var check: CheckBox
    private lateinit var radio: RadioGroup
    private lateinit var checkenti: CheckBox
    private lateinit var radioenin: RadioGroup
    private lateinit var checkpf: CheckBox
    private lateinit var radiopf: RadioGroup
    private lateinit var checkbe: CheckBox
    private lateinit var radiobe: RadioGroup
    private lateinit var boton: Button
    private lateinit var botonordenes: Button
    private lateinit var ordenes: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        check = findViewById(R.id.ckbEntrada)
        radio = findViewById(R.id.rdgGrupo)
        checkenti = findViewById(R.id.ckbEntretiempo)
        radioenin = findViewById(R.id.rdgGrup)
        checkpf = findViewById(R.id.ckbPlato_fuerte)
        radiopf = findViewById(R.id.rdgGru)
        checkbe = findViewById(R.id.ckbBebida)
        radiobe = findViewById(R.id.rdgGruppp)
        boton = findViewById(R.id.btnOrdenar)
        botonordenes= findViewById(R.id.btnVer_ordenes)
        ordenes = ArrayList()

        check.setOnCheckedChangeListener { _, isChecked ->
            radio.visibility = if (isChecked) View.VISIBLE else View.GONE
        }
        checkenti.setOnCheckedChangeListener { _, isChecked ->
            radioenin.visibility = if (isChecked) View.VISIBLE else View.GONE
        }
        checkpf.setOnCheckedChangeListener { _, isChecked ->
            radiopf.visibility = if (isChecked) View.VISIBLE else View.GONE
        }
        checkbe.setOnCheckedChangeListener { _, isChecked ->
            radiobe.visibility = if (isChecked) View.VISIBLE else View.GONE
        }



        boton.setOnClickListener {

            val nuevaOrden = ArrayList<String>()
            if (check.isChecked) {
                val entradaRadio = findViewById<RadioButton>(radio.checkedRadioButtonId)
                nuevaOrden.add("Entrada: ${entradaRadio.text}")
            }
            if (checkenti.isChecked) {
                val entremesRadio = findViewById<RadioButton>(radioenin.checkedRadioButtonId)
                nuevaOrden.add("Entretiempo: ${entremesRadio.text}")
            }
            if (checkpf.isChecked) {
                val platoFuerteRadio = findViewById<RadioButton>(radiopf.checkedRadioButtonId)
                nuevaOrden.add("Plato fuerte: ${platoFuerteRadio.text}")
            }
            if (checkbe.isChecked) {
                val bebidas = findViewById<RadioButton>(radiobe.checkedRadioButtonId)
                nuevaOrden.add("Bebida: ${bebidas.text}")
            }

            if (nuevaOrden.isNotEmpty()) {
                ordenes.add(nuevaOrden.joinToString(", "))
                val builder = AlertDialog.Builder(this)
                builder.setMessage( "Se agregó la siguiente orden:\n${nuevaOrden.joinToString("\n")}")
                val dialog = builder.create()
                dialog.show()
            }
                botonordenes.setOnClickListener {
                val mensaje = if (ordenes.isEmpty()) {
                    "No hay órdenes registradas"
                } else {

                    ordenes.joinToString("\n")
                }
               // Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
                val builder = AlertDialog.Builder(this)
                builder.setMessage( mensaje )
                val dialog = builder.create()
                dialog.show()

            }

        }

    }

}





