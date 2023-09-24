package com.alansalgadosalas.crea_una_cuadricula

import android.content.ClipData
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alansalgadosalas.crea_una_cuadricula.ui.theme.CreaunacuadriculaTheme
import com.alansalgadosalas.crea_una_cuadricula.DataSource
import com.alansalgadosalas.crea_una_cuadricula.model.Topic
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            trazarCuadricula()
        }
    }
}

@Preview
@Composable
fun trazarCuadricula(){
    Cuadricula()
}


@Composable
fun Cuadricula(){
    //Tarjeta(DataSource.topics[0].nombre, DataSource.topics[0].cantidad , DataSource.topics[0].imagen)
    //Tarjeta(DataSource.topics[1].nombre, DataSource.topics[1].cantidad , DataSource.topics[1].imagen)
    val arr = DataSource.topics.toList()
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 132.dp),
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(arr) {
            item -> Tarjeta(nombre = item.nombre, cantidad = item.cantidad, imagen = item.imagen)
        }
    }
}

@Composable
fun Tarjeta(nombre: Int, cantidad: Int, imagen: Int){
    Box(
        Modifier
            .background(Color(0xffe6e0eb), shape = RoundedCornerShape(12.dp))
            .size(200.dp, 68.dp)
    ){
       Row {
           Image(
               painter = painterResource(id = imagen),
               contentDescription = stringResource(id = nombre),
               modifier = Modifier
                   .size(68.dp)
                   .fillMaxSize()
                   .clip(
                       RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp)
                   )
           )
           Column(
               modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp)
           ){
               Text(
                   text = stringResource(id = nombre),
                   style = MaterialTheme.typography.bodyMedium,
                   modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
               )
               Row {
                   Image(
                       painter = painterResource(id = R.drawable.ic_grain),
                       contentDescription = stringResource(id = nombre),
                       modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp)
                   )
                   Text(
                       text = cantidad.toString(),
                       style = MaterialTheme.typography.labelMedium,
                       modifier = Modifier.padding(0.dp, 2.dp, 0.dp, 0.dp)
                   )
               }
           }
       } 
    }
}