package com.example.exaula

import java.util.*

class Hour {

    var hours : String? = null

    constructor(hours: String?) {
        this.hours = hours
    }

    constructor(){

    }


    companion object{

        fun newDate() : String{
            return Calendar.getInstance().time.toString()
        }

        fun addHour(string: String): Hour{

            val hour = Hour()
            hour.hours = string


            return hour
        }

    }

}