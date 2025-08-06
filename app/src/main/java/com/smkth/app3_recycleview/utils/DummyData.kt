package com.smkth.app3_recycleview.utils

import com.smkth.app3_recycleview.model.Student

object DummyData{
    fun getStudentList(): List<Student> {
        return listOf(
            Student("Andi", "123456", "XII TJKT 1"),
            Student("Okta", "123456", "XII TJKT 1"),
            Student("Soli", "123456", "XII TJKT 1"),
            Student("Andika", "123456", "XII TJKT 1"),
            Student("Andromeda", "123456", "XII TJKT 1"),
            Student("Bramasta", "123456", "XII TJKT 1"),
            Student("Marga", "123456", "XII TJKT 1"),
            Student("Pangukuh", "123456", "XII TJKT 1"),
            Student("Galang", "123456", "XII TJKT 1"),
            Student("Surya", "123456", "XII TJKT 1"),
            Student("Admaja", "123456", "XII TJKT 1"),
            Student("Joko", "123456", "XII TJKT 1"),
            Student("Widodo", "123456", "XII TJKT 1")
        )
    }
}