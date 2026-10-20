package com.example.fragments
fun cifrarCesar(texto: String, desplazamiento: Int): String =
    texto.map { c ->
        when (c) {
            in 'a'..'z' -> desplazar(c, 'a', desplazamiento)
            in 'A'..'Z' -> desplazar(c, 'A', desplazamiento)
            else -> c // espacios, signos y cifras no se tocan
        }
    }.joinToString("")
private fun desplazar(c: Char, base: Char, d: Int): Char {
    val posicion = (c - base + d).mod(26)
    return base + posicion
}
fun descifrarCesar(texto: String, desplazamiento: Int): String =
    cifrarCesar(texto, -desplazamiento)
