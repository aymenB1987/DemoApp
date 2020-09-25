package com.example.domain.model

interface Test {
    fun t() :Int
    fun tt() :String
}

data class TestModel(
    val t:Int,
    val tt:String
):Test {
    override fun t(): Int {
        return t
    }

    override fun tt(): String {
        return tt
    }
}
class testTest(){
    val test :ArrayList<Test> = arrayListOf()
    val testt : ArrayList<TestModel> = arrayListOf()
    fun tesst(){
        test.addAll(testt)
    }
}