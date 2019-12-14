package com.example.yejoonmanual

import java.util.*
import kotlin.collections.HashMap

object DataManager {

    val juboTasks = arrayOf("단축키", "아이디 & 비번", "예배 순서", "큐티",
        "종이 접는 기계", "프린트", "리뷰 리스트")
    val serviceTasks = arrayOf("예배당 셋업", "성찬식", "자리 안내 요령")
    val keyValueTasks = setOf("단축키", "아이디 & 비번")

    val keyValueTaskDataMap = TreeMap<String, TreeMap<String, TreeMap<String, String>>>()

    val shortcutMap = TreeMap<String, TreeMap<String, String>>()
    val credMap = TreeMap<String, TreeMap<String, String>>()


    init {
        prepareShortcuts()
        prepareCredentials()
    }

    private fun prepareCredentials() {
        prepareLaptopCredentials()
        prepareHomePageCredentials()
        prepareEmailCredentials()
        prepareQTCredentials()
        keyValueTaskDataMap.put("아이디 & 비번", credMap)

    }

    private fun prepareLaptopCredentials() {
        var map = TreeMap<String, String>()
        map.put("비밀번호 (한글)", "찬방팀13")
        map.put("비밀번호 (Eng)", "cksqkdxla13")
        credMap.put("Dell 노트북", map)
    }

    private fun prepareHomePageCredentials() {
        var map = TreeMap<String, String>()
        map.put("ID", "yejoon")
        map.put("비밀번호 (한글)", "예준팀8")
        map.put("비밀번호 (Eng)", "dPwnsxla8")
        credMap.put("홈페이지", map)
    }

    private fun prepareEmailCredentials() {
        var map = TreeMap<String, String>()
        map.put("ID", "youngnakwprep@gmail.com")
        map.put("비밀번호 (한글)", "예준팀8")
        map.put("비밀번호 (Eng)", "dPwnsxla8")
        credMap.put("이메일", map)
    }

    private fun prepareQTCredentials() {
        var map = TreeMap<String, String>()
        map.put("ID", "yntoronto")
        map.put("비밀번호 (한글)", "예준팀8")
        map.put("비밀번호 (Eng)", "dPwnsxla8")
        credMap.put("duranno.com", map)
    }

    private fun prepareShortcuts() {
        prepareTextSelectionShortcuts()
        prepareCopyPasteShortcuts()
        prepareFontShortcuts()
        prepareParagraphShortcuts()
        keyValueTaskDataMap.put("단축키", shortcutMap)
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