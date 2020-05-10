package main

fun main(args: Array<String>){

    var id: Char by StorageDelegate("id_char", 'x')
    println(id)
    id = 'y'
    println(id)
}