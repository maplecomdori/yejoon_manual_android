package com.example.yejoonmanual

object DataManager {
    val sectionTaskMap = HashMap<String, Array<String>>()


    init {
        val juboTasks = arrayOf("단축키", "아이디 & 비번", "예배 순서", "큐티",
            "종이 접는 기계", "프린트", "리뷰 리스트")
        val serviceTasks = arrayOf("예배당 셋업", "성찬식", "자리 안내 요령", "a", "b", "c")

        sectionTaskMap.set("주보", juboTasks)
        sectionTaskMap.set("예배", serviceTasks)

    }
}