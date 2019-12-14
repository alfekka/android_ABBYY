fun main() {
    val a = arraylist<Int>();

    a.add(0)
    a.add(1)
    a.add(2)
    a.add(3)
    a.add(4)
    a.add(6)
    a.add(7)
    a.add(8)
    a.add(9)
    a.add(10)
    a.add(11)

    a.insert(4)
    a.insert(17)
    a.delete(4)
    a.delete(17)

    println(a[3])
}