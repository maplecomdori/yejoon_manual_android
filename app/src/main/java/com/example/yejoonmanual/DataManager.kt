package com.example.yejoonmanual

import java.util.*
import kotlin.collections.HashMap

object DataManager {

    val juboTasks:Array<String> = arrayOf(
        INST_SHORTCUT, INST_CRED, INST_SERVICE_ORDER, INST_QT,
        INST_FOLDING_MACHINE, INST_PRINT, INST_REVIEW)
    val serviceTasks:Array<String> = arrayOf(INST_YEBEDANG, INST_COMMUNION, INST_SEATING_TIP)
    val keyValueTasks:Set<String> = setOf(INST_SHORTCUT, INST_CRED)
    val imageTasks:Set<String> = setOf(INST_QT, INST_FOLDING_MACHINE, INST_PRINT,
        INST_YEBEDANG, INST_COMMUNION)

    val keyValueTaskDataMap:TreeMap<String, Map<String, Map<String, String>>> = TreeMap()
    private val shortcutMap = TreeMap<String, Map<String, String>>()
    private val credMap = TreeMap<String, Map<String, String>>()

    val foldingMachineInstructions:Array<Instruction> = prepareFoldingMachineInstructions()

    init {
        prepareShortcuts()
        prepareCredentials()
    }

    private fun prepareFoldingMachineInstructions(): Array<Instruction> {
        val handle = Instruction("핸들 내리기", "images/folding_machine/folding_machine_handle.jpg", "손잡이를 내려 종이를 넣을 공간을 만들어요")
        val paper = Instruction("종이 넣기", "images/folding_machine/folding_machine_paper.jpg", "민들레 포커스가 오른쪽에 놓이도록 종이를 넣고 손잡이를 다시 올려서 종이를 고정시켜 주세요")
        val topScale = Instruction("위에 눈금 조절", "images/folding_machine/folding_machine_top.jpg", "상단 금속 부분의 밑 부분을 빨간선에 맞춰 주세요")
        val bottomScale = Instruction("아래 눈금 조절", "images/folding_machine/folding_machine_bottom.jpg", "오른쪽은 '주보'라고 쓰여진 스티커와 금속에 붙은 화살표를 맞춰주세요. 왼쪽은 빨간선에 맞춰주세요.")
        val testPrint = Instruction("테스트 프린트", "images/folding_machine/folding_machine_button.jpg", "TEST 버튼을 누르면 두 장이 접혀서 나와요. 잘 접혔으면 START 버튼을 눌러서 나머지를 접어주세요")
        val cleanUp = Instruction("정리", "images/folding_machine/folding_machine_cleanup.jpg", "비닐을 덮고 전원을 끄고 전등을 끄고 나오세요")
        return arrayOf(handle, paper, topScale, bottomScale, testPrint, cleanUp)
    }

    private fun prepareCredentials() {
        prepareLaptopCredentials()
        prepareHomePageCredentials()
        prepareEmailCredentials()
        prepareQTCredentials()
        keyValueTaskDataMap.put(INST_CRED, credMap)
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
        map.put("ID", "youngnakwprep")
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
        keyValueTaskDataMap.put(INST_SHORTCUT, shortcutMap)
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