package com.example.app10dias.model

import com.example.app10dias.R

class RepositorioLibros {
    companion object {
        val libros = listOf(
            Libro(
                titulo = R.string.libro1,
                autor = R.string.autor1,
                imageRes = R.drawable.mistborn,
                descripcion = R.string.descripcion1
            ),
            Libro(
                titulo = R.string.libro2,
                autor = R.string.autor2,
                imageRes = R.drawable.fundacion,
                descripcion = R.string.descripcion2
            ),
            Libro(
                titulo = R.string.libro3,
                autor = R.string.autor3,
                imageRes = R.drawable._0000_leguas,
                descripcion = R.string.descripcion3
            ),
            Libro(
                titulo = R.string.libro4,
                autor = R.string.autor4,
                imageRes = R.drawable.amanecer_rojo,
                descripcion = R.string.descripcion4
            ),
            Libro(
                titulo = R.string.libro5,
                autor = R.string.autor5,
                imageRes = R.drawable.camino_reyes,
                descripcion = R.string.descripcion5
            ),
            Libro(
                titulo = R.string.libro6,
                autor = R.string.autor6,
                imageRes = R.drawable.chrysalis,
                descripcion = R.string.descripcion6
            ),
            Libro(
                titulo = R.string.libro7,
                autor = R.string.autor7,
                imageRes = R.drawable.libro_basico,
                descripcion = R.string.descripcion7
            ),
            Libro(
                titulo = R.string.libro8,
                autor = R.string.autor8,
                imageRes = R.drawable.mort,
                descripcion = R.string.descripcion8
            ),
            Libro(
                titulo = R.string.libro9,
                autor = R.string.autor9,
                imageRes = R.drawable.lovecraft,
                descripcion = R.string.descripcion9
            ),
            Libro(
                titulo = R.string.libro10,
                autor = R.string.autor10,
                imageRes = R.drawable.tres_cuerpos,
                descripcion = R.string.descripcion10
            ),
        )
    }
}