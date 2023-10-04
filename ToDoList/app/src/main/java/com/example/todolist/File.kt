package com.example.todolist

import android.content.Context
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class File {
    val FILENAME="listinfo.dat"
    fun write_data(item:ArrayList<String>,context:Context){
        var fos:FileOutputStream=context.openFileOutput(FILENAME,Context.MODE_PRIVATE)
        var ous:ObjectOutputStream= ObjectOutputStream(fos)
        ous.writeObject(item)
        ous.close()
    }
    fun readdata(context:Context):ArrayList<String>{
    try{
        var itemlist:ArrayList<String>
        var fis:FileInputStream=context.openFileInput(FILENAME)
        var ois=ObjectInputStream(fis)
        itemlist= ois.readObject() as ArrayList<String>
    } catch(e:FileNotFoundException){
        itemlist=ArrayList()
    }



    return itemlist
    }
}