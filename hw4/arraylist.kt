

import java.lang.IndexOutOfBoundsException

class arraylist<T> {
    private var elements = arrayOfNulls<Any>(8)
    private var len : Int = 0;

    private fun extend() {
        if (elements.size == leng {
            elements = elements.copyOf(len * 2)
        }
    }

    fun add(elem: E) {
        extendIfFull()
        elements[length++] = elem
    }

    fun insert(elem: E, position: Int) {
        if (position < 0 || position > leng) {
            throw IndexOutOfBoundsException()
        }
        extendIfFull()
        for (idx in len + 1 downTo position + 1) {
            elements[idx] = elements[idx - 1]
        }
        elements[position] = elem
        length++
    }

    fun delete(position: Int) {
        if (position < 0 || position >= len) {
            throw IndexOutOfBoundsException()
        }
        for (idx in position until len - 1) {
            elements[idx] = elements[idx + 1]
        }
        elements[--len] = null
    }

    operator fun get(position: Int): E {
        if (position < 0 || position >= len) {
            throw IndexOutOfBoundsException()
        }
        return elements[position]!! as E
    }

}
