package com.example.yejoonmanual

import java.util.*
import kotlin.collections.HashMap

object DataManager {
    val sectionTaskMap = HashMap<String, Array<String>>()
    val shortcutMap = TreeMap<String, TreeMap<String, String>>()


    init {
        val juboTasks = arrayOf("단축키", "아이디 & 비번", "예배 순서", "큐티",
            "종이 접는 기계", "프린트", "리뷰 리스트")
        val serviceTasks = arrayOf("예배당 셋업", "성찬식", "자리 안내 요령", "a", "b", "c")

        sectionTaskMap.set("주보", juboTasks)
        sectionTaskMap.set("예배", serviceTasks)

        prepareShortcuts()
    }

    private fun prepareShortcuts() {
        prepareTextSelectionShortcuts()
        prepareCopyPasteShortcuts()
        prepareFontShortcuts()
    }

    private fun prepareTextSelectionShortcuts() {
        val textMap = TreeMap<String, String>()
        textMap.put("전체 선택", "Ctrl + A")
        textMap.put("저장", "Ctrl + S")
        textMap.put("키보드로 텍스트 선택", "Shift + 방향키 / Home / End")
        textMap.put("광고 댓글 전체 선택", "마우스 세 번 클릭")
        textMap.put("전체 선택", "Ctrl + A")
        textMap.put("전체 선택", "Ctrl + A")
        shortcutMap.put("텍스트 선택", textMap)
    }

    private fun prepareCopyPasteShortcuts() {
        val copyPasteMap = TreeMap<String, String>()
        copyPasteMap.put("복사", "Ctrl + C")
        copyPasteMap.put("붙이기", "Ctrl + V")
        copyPasteMap.put("Paste Special\nUnformatted Text", "Ctrl + Alt + V")
        shortcutMap.put("복사 & 붙이기", copyPasteMap)
    }

    private fun prepareFontShortcuts() {
        val fontMap = TreeMap<String, String>()
        fontMap.put("Bold", "Ctrl + B")
        fontMap.put("Underline", "Ctrl + U")
        shortcutMap.put("폰트", fontMap)
    }

    private fun prepareParagraphShortcuts() {
        val paragraphMap = TreeMap<String, String>()
        paragraphMap.put("양쪽 맞춤 (Justify)", "Ctrl + J")
        shortcutMap.put("문단 정렬", paragraphMap)
    }

}