package com.geermank.programacinavanzada111120

interface OnMyButtonInteractListener {
    fun onButtonClick(button: MyButton)
}

class MyButton {

    companion object {
        val text = "Hace click aca"

        fun getInstance(): MyButton {
            return MyButton()
        }
    }

    fun decorateButton() {

    }

}